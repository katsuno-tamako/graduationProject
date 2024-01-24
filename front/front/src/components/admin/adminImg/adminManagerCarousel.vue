<template>
  <div>

    <div style="width: 792px;height: 432px">
      <el-carousel indicator-position="outside">
        <el-carousel-item v-for="img in imgList" :key="img">

          <div style="height: 100%;width: 100%;text-align: center">
            <div>
              <el-button style="margin: 10px 0" @click="deleteImg(img.img)">删除图片</el-button>
            </div>

              <el-image
                :src="url_head+img.img"
                style="height: 80%;width: 80%"
              ></el-image>

          </div>

        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'adminManagerCarousel',
  inject : ['reload'],
  data(){
    return {
      imgList : '',
      url_head : 'http://localhost:8906//',
    }
  },
  created() {
    axios.get('/home/selectCarouselImg').then(
      (response) => {
        this.imgList = response.data;
      }
    );
  },
  methods : {
    deleteImg(path){
      axios.get('/home/deleteHomeImg',{params : {img : path}});
      this.reload()
    }
  }
}
</script>
<style scoped>
</style>
