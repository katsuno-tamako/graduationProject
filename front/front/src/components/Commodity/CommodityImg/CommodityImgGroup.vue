<template>
  <div>
    显示与编辑照片组
    <div>

      <div>
        <el-upload
          ref="upload"
          action="http://localhost:8906/uploadCommodity"
          list-type="picture"
          :limit="1"
          :on-success="succ"
          :data="{commodity_id : commodity_id}"
        >
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        </el-upload>
      </div>
      <el-card>
        <el-row :gutter="20">
          <el-col :span="6" v-for="img in commodity_img" :key="img.id">
            <el-card style="text-align: center">
              <el-image
                style="width: 175px;height: 250px"
                :src="url_head+img.path"
              ></el-image>
              <el-divider></el-divider>
              <div>
                <el-button @click="deleteImg(img.path)">移除该图片</el-button>
              </div>
            </el-card>
          </el-col>
        </el-row>

      </el-card>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'CommodityImgGroup',
  props : ['commodity_id'],
  inject : ['reload'],
  data(){
    return {
      commodity_img : '',
      url_head : 'http://localhost:8906//',
      img_url : '',
    }
  },
  created() {
    axios.get('/getImg',{params: {commodity_id: this.commodity_id}}).then(
      (response) => {
        this.commodity_img = response.data;
        console.log(response.data)
      }
    );
  },
  methods : {
    addImgGroup(){

    },
    succ(){
      this.reload();
    },
    deleteImg(path){
      axios.get('/deleteImgByPath',{params : {url : path}}).then();
      this.reload();

    }
  }
}
</script>
<style scoped>
</style>
