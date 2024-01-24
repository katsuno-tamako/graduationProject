<template>
  <div>
    <el-card shadow="never">
      <div>主页轮播图片</div>
      <el-divider></el-divider>
      <el-upload
        ref="upload"
        action="http://localhost:8906/home/insertHomeImg"
        :auto-upload="false"
        :on-success="sucRe"
      >
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
      </el-upload>

      <el-divider></el-divider>
      <div style="text-align: center">
        <el-row :gutter="20">
          <el-col :span="8">
            轮播图片
          </el-col>
          <el-col :span="12">
            <span style="visibility: hidden;">1</span>
          </el-col>
          <el-col :span="4">
            操作
          </el-col>
        </el-row>

        <el-row :gutter="20" v-for="img in imgList" :key="img.id">
          <el-col :span="8">
            <div>
              <el-image
                style="height: 100px"
                :src="url_head+img.img"
                :preview-src-list="[url_head+img.img]"
              ></el-image>
            </div>
          </el-col>
          <el-col :span="12">
            <span style="visibility: hidden;">1</span>
<!--            <el-input></el-input>-->
          </el-col>
          <el-col :span="4">
            <el-button @click="deleteImg(img.img)" icon="el-icon-delete" circle></el-button>

          </el-col>
        </el-row>

      </div>
    </el-card>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'adminManagerIndexPage',
  inject : ['reload'],
  created() {

    axios.get('/admin/getAdminSession').then(
      (res) => {
        this.stu = res.data;
        console.log(res.data);
        if(this.stu ==='NoLog'){
          console.log(res.data);
          this.$router.push('/adminLogin');
        }
      }
    );

    axios.get('/home/selectCarouselImg').then(
      (response) => {
        this.imgList = response.data;
      }
    );
  },
  methods : {
    deleteImg(path){
      axios.get('/home/deleteHomeImg',{params : {img : path}}).then(
        (res)=>{
          axios.get('/home/selectCarouselImg').then(
            (response) => {
              this.imgList = response.data;
            }
          );
        }
      );
    },
    submitUpload(){
      this.$refs.upload.submit();

    },

    sucRe(){
      axios.get('/home/selectCarouselImg').then(
        (response) => {
          this.imgList = response.data;
        }
      );
    }

  },
  data(){
    return{
      imgList : '',
      url_head : 'http://localhost:8906//',
    }
  }
}
</script>
<style scoped>
</style>
