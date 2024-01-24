<template>
  <div style="width: 740px;">
    <el-carousel indicator-position="outside">
      <el-carousel-item v-for="img in imgList" :key="img.id">
        <div style="height: 100%;width: 100%">
          <el-image
            :src="url_head+img.img"
            style="height: 100%;width: 100%"
          >
          </el-image>
        </div>
      </el-carousel-item>
    </el-carousel>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'Carousel',
  data () {
    return{
      imgList : '',
      url_head : 'http://localhost:8906//',
      f : 'fill'
    }
  },
  created() {
    axios.get('/home/selectCarouselImg').then(
      (response) => {
        this.imgList = response.data;
      }
    );
  }
}
</script>
<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
