<template>
  <div>
    其他
    <el-card>
      添加主页轮播图片
      <el-divider>已有的图片</el-divider>
      <admin-manager-carousel/>
      <el-divider></el-divider>
      <div>
        <el-upload
          action="http://localhost:8906/home/insertHomeImg"
          list-type="picture-card"
          :on-success="suc"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios'
import adminManagerCarousel from "./adminImg/adminManagerCarousel";
export default {
  name: 'adminOther',
  inject : ['reload'],
  components : {
    adminManagerCarousel
  },
  data(){
    return {
      dialogImageUrl: '',
      dialogVisible: false
    }
  },
  methods : {
    suc(){
      this.reload();
    }
  }
}
</script>
<style scoped>
</style>
