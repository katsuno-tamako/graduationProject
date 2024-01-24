<template>
  <div>
    <div>编辑家具</div>
    <el-divider></el-divider>
    <div>
      <el-form :model="furniture">
        <el-form-item label="家具名称">
          <el-input v-model="furniture.name"></el-input>
        </el-form-item>

        <el-form-item label="家具价钱">
          <el-input v-model="furniture.price"></el-input>
        </el-form-item>

        <el-form-item label="家具材料">
          <el-input v-model="furniture.furniture_material"></el-input>
        </el-form-item>


        <el-form-item label="家具类型">
          <el-input v-model="furniture.function_type"></el-input>
        </el-form-item>

        <el-form-item label="家具重量">
          <el-input v-model="furniture.furniture_weight"></el-input>
        </el-form-item>

        <el-form-item label="占地面积">
          <el-input v-model="furniture.furniture_area"></el-input>
        </el-form-item>

        <el-form-item label="家居风格">
          <el-input v-model="furniture.furniture_style"></el-input>
        </el-form-item>

        <el-form-item label="品牌">
          <el-input v-model="furniture.brand"></el-input>
        </el-form-item>

        <el-form-item label="使用场景">
<!--          <el-input v-model="furniture.room"></el-input>-->
          <el-select v-model="furniture.room" clearable allow-create filterable="true">
            <el-option v-for="c in room"
                       :key="c.id"
                       :label="c.category_type"
                       :value="c.category_type"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-card>
          <span>选择商品封面的图片:</span>
          <el-upload
            ref="upload1"
            action="http://localhost:8906/furniture/receiveFurnitureImg"
            :auto-upload="false"
            list-type="picture"
            :limit="1"
            :data="{commodity_id : furniture.commodity.commodity_id}"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>
          </el-card>
        </el-form-item>

        <el-form-item label="其他图片">
          <el-upload
            ref="upload2"
            action="http://localhost:8906/uploadCommodity"
            :auto-upload="false"
            list-type="picture"
            :data="{commodity_id : furniture.commodity.commodity_id}"
            :file-list="fileList"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>

          <el-card style="">
            <div>选中图片后删除</div>
            <el-checkbox-group v-model="selectImg">

              <el-checkbox-button :label="img" v-for="img in furniture_img" :key="img.id">
                <el-card style="text-align: center;display:flex;overflow-x:auto;overflow-y:hidden">
                  <el-image
                    style="height: 100px"
                    :src="url_head+img.path"
                  ></el-image>
                </el-card>
              </el-checkbox-button>
            </el-checkbox-group>
          </el-card>
        </el-form-item>

        <el-form-item>
          <el-button @click="sub">确定</el-button>
          <el-button @click="cal">取消</el-button>
        </el-form-item>



      </el-form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'editFurnitureCom',
  props : ['c_info'],
  inject : ['reload'],
  created() {
    axios.get('/furniture/selectFurnitureById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.furniture = response.data
      }
    );

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.furniture_img = response.data;
      }
    );

    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:"家具房间"}}).then(
      (res) => {
        this.room = res.data;
      }
    );
  },
  methods : {
    sub(){
      axios.post('/furniture/updateFurniture',this.furniture).then();
      axios.post('/deleteImgArray',this.selectImg).then();
      this.$refs.upload1.submit();
      this.$refs.upload2.submit();
      this.reload();
    },
    cal(){
      this.reload();
    },
    deleteImg(path){
      axios.get('/deleteImgArray',{params : {url : path}}).then();
      this.reload();
    }
  },
  data(){
    return{
      furniture : '',
      furniture_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      fileList : [],
      room : ''
    }
  }
}
</script>
<style scoped>
</style>
