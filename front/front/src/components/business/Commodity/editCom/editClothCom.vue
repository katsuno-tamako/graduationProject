<template>
  <div>
    编辑服装
    <el-form :model="cloth" >

      <el-form-item label="名称">
        <el-input v-model="cloth.commodity_name" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="品牌">
        <el-input v-model="cloth.brand" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="价格">
        <el-input v-model="cloth.price" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="服装类型">
<!--        <el-input v-model="cloth.cloth_type" maxlenght="15" minlenght="1"></el-input>-->

        <el-select v-model="cloth.cloth_type" placeholder="请选择">
          <el-option v-for="type in cloth_style" :key="type.id"
            :label="type.category_type"
                     :value="type.category_type"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="使用季节">
<!--        <el-input v-model="cloth.apply_to_session" maxlenght="15" minlenght="1"></el-input>-->
        <el-select v-model="cloth.apply_to_session" placeholder="请选择">
          <el-option v-for="session in cloth_session" :key="session.id"
                      :label="session.category_type"
                     :value="session.category_type"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="服装重量">
        <el-input v-model="cloth.commodity_weight" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="适用人群">
<!--        <el-input v-model="cloth.suitable" maxlenght="15" minlenght="1"></el-input>-->
        <el-select v-model="cloth.suitable" placeholder="请选择">
          <el-option v-for="s in suitable" :key="s.id"
                      :label="s.category_type"
                     :value="s.category_type"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="服装风格">
<!--        <el-input v-model="cloth.clothing_style" maxlenght="15" minlenght="1"></el-input>-->
        <el-select v-model="cloth.clothing_style" placeholder="请选择">
          <el-option v-for="style in cloth_style" :key="style.id"
                      :label="style.category_type"
                     :value="style.category_type"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="上市时间">
        <el-input v-model="cloth.market_time" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>



      <el-form-item label="选择商品封面的图片：">
        <el-upload
          ref="upload1"
          action="http://localhost:8906/cloth/receiveClothImage"
          :auto-upload="false"
          list-type="picture"
          :limit="1"
          :data="{commodity_id : cloth.commodity.commodity_id}"
        >
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        </el-upload>
      </el-form-item>

      <el-form-item label="其他图片">
        <el-upload
          ref="upload2"
          action="http://localhost:8906/uploadCommodity"
          :auto-upload="false"
          list-type="picture"
          :data="{commodity_id : cloth.commodity.commodity_id}"
          :file-list="fileList"
        >
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        </el-upload>

        <el-card style="">
          <div>选中图片后删除</div>
          <el-checkbox-group v-model="selectImg">

            <el-checkbox-button :label="img" v-for="img in cloth_img" :key="img.id">
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
</template>

<script>
import axios from 'axios'
export default {
  name: 'editClothCom',
  props : ['c_info'],
  inject : ['reload'],
  created() {
    axios.get('/cloth/selectClothById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.cloth = response.data
      }
    );
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装类型'}}).then((res)=>{this.cloth_type=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装风格'}}).then((res)=>{this.cloth_style=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'适用人群'}}).then((res)=>{this.suitable=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res)=>{this.cloth_session=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res)=>{this.cloth_brand=res.data});

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.cloth_img = response.data;
      }
    );
  },
  methods : {
    sub(){
      axios.post('/cloth/updateCloth',this.cloth).then();
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
      cloth : '',
      cloth_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      fileList : [],
      cloth_type: '',
      cloth_style : '',
      suitable : '',
      cloth_session : '',
      cloth_brand : ''
    }
  }

}
</script>
<style scoped>
</style>
