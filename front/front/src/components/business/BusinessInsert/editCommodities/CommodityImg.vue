<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="8" v-for="u in url" :key="u.url_head" style="padding: 10px">

        <el-card>
          <el-image
            style="width: 150px;height: 200px"
            :src="url_head+u.path"
            :preview-src-list="[url_head+u.path]"
            v-if="update"
          >
          </el-image>
          <el-divider></el-divider>
          <el-button type="primary" @click="setMainImg(u)">设置封面</el-button>
          <el-button type="danger"  @click="deleteImg(u.path)">删除图片</el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'CommodityImg',
  props : ['commodity_id'],
  data () {
    return {
      url : '',
      url_head : 'http://localhost:8906//',
      urlList : '',
      update : true,
      imgURL : ''
    }
  },
  created() {
    axios.get('/getImg',{params : {'commodity_id' : this.commodity_id}}).then(
      (response) => {

        this.url = response.data;
      }
    );

    axios.get('selectCommodityById',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.imgURL = response.data.main_img;
      }
    );

  },
  methods : {
    deleteImg(imgUrl){
      axios.get('/deleteImgByPath',{params : {'url' : imgUrl}}).then();
      this.update = false;
      this.$nextTick(()=>this.update = true);
    },
    setMainImg(commodity){
      axios.get('/updateMainImg', {params :
          {
            commodity_id : commodity.commodity_id,
            path : commodity.path
          }
      }).then();
      alert("设置成功")
      location.reload();

    }
  }
}
</script>
<style scoped>
</style>
