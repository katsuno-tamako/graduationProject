<template>
  <div>
    <div>
      <el-card>显示所以有图片，商品id:{{commodity_id}}</el-card>
      <el-divider></el-divider>
      <el-card style="height: 300px">
        <el-row :gutter="10">
          <el-col :span="12">
            <div style="padding:10px">选择一张图片为商品封面</div>
            <el-upload
              ref="upload"
              action="http://localhost:8906/phone/receivePhoneImg"
              :auto-upload="false"
              list-type="picture"
              :limit="1"
              :on-success="succ"
              :data="{commodity_id : commodity_id}"
            >
              <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
              <el-button size="small" @click="upL" type="success">确定上传</el-button>
            </el-upload>
          </el-col>
          <el-col :span="12" >
              <el-image
                :src="url_head+img_url"
                style="width: 175px;height: 250px"
              >
              </el-image>
          </el-col>
        </el-row>

      </el-card>
      <el-divider></el-divider>
      <el-card>
        <commodity-img-group :commodity_id="commodity_id"/>
      </el-card>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import CommodityImgGroup from "../../../components/Commodity/CommodityImg/CommodityImgGroup";
export default {
  name: 'CommodityImgPage',
  inject : ['reload'],
  components : {CommodityImgGroup},
  data(){
    return{
      commodity_id : '',
      url_head : 'http://localhost:8906//',
      img_url : '',
      commodity :  ''
    }
  },
  created() {
    this.commodity_id = this.$route.query.commodity_id;
    axios.get('/selectCommodityById',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.img_url = response.data.main_img;
      }
    );
  },
  methods : {
    succ(){
      this.reload();
    },
    upL(){
      this.$refs.upload.submit();
      this.reload();
    }
  }
}
</script>
<style scoped>
</style>
