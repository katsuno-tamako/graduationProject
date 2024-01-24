<template>
  <div>
    <div>编辑食品</div>
    <el-divider></el-divider>
    <el-form :model="food" label-width="80px">

      <el-form-item label="食品名称">
        <el-input v-model="food.name"></el-input>
      </el-form-item>

      <el-form-item label="食品价钱">
        <el-input v-model="food.price"></el-input>
      </el-form-item>

      <el-form-item label="食品类型">
        <el-input v-model="food.food_type"></el-input>
      </el-form-item>

      <el-form-item label="食品重量">
        <el-input v-model="food.food_weight"></el-input>
      </el-form-item>

      <el-form-item label="食品源地">
        <el-input v-model="food.origin"></el-input>
      </el-form-item>

      <el-form-item label="生产许可证号" label-width="100px">
        <el-input v-model="food.production_license_number"></el-input>
      </el-form-item>

      <el-form-item label="产品标准号" label-width="100px">
        <el-input v-model="food.product_standard_number"></el-input>
      </el-form-item>


      <el-form-item label="是否为出口" label-width="100px">
        <el-select v-model="food.ex">
          <el-option value="是" label="是"></el-option>
          <el-option value="否" label="否"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="商品介绍">
        <el-input
          type="textarea"
          :rows="5"
          placeholder="请输入内容"
          v-model="food.commodity.introduce"
        >
        </el-input>
      </el-form-item>


      <el-form-item label="选择商品封面的图片：">
        <el-upload
          ref="upload1"
          action="http://localhost:8906/food/receiveFoodImg"
          :auto-upload="false"
          list-type="picture"
          :limit="1"
          :data="{commodity_id : food.commodity.commodity_id}"
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
          :data="{commodity_id : food.commodity.commodity_id}"
          :file-list="fileList"
        >
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        </el-upload>

        <el-card style="">
          <div>选中图片后删除</div>
          <el-checkbox-group v-model="selectImg">

            <el-checkbox-button :label="img" v-for="img in food_img" :key="img.id">
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
import axios from "axios";

export default {
  name: 'editFoodCom',
  props : ['c_info'],
  inject : ['reload'],
  created() {
    axios.get('/food/selectFoodById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.food = response.data
      }
    );

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.food_img = response.data;
      }
    );
  },
  data(){
    return{
      food : '',
      food_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      fileList : [],
    }
  },
  methods : {
    sub(){
      axios.post('/food/updateFoodInfo',this.food).then();
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
  }
}
</script>
<style scoped>
</style>
