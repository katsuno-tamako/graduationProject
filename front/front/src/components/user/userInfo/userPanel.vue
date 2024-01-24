<template>
    <div>
      <el-row>
        <el-col :span="12">
          <div class="block"><el-avatar shape="square" :size="40" :src="squareUrl"></el-avatar></div>
        </el-col>
        <el-col :span="12">
          {{user_info.user_name}}
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <span @click="log_out">退出登录</span></el-col>
        <el-col :span="12"></el-col>
      </el-row>
    </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'userPanel',
  data(){
    return{
      squareUrl : '',
      user_name : '',
      user_info : '',
      url_head : 'http://localhost:8906//',
    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        this.user_name = response.data;
        axios.get('/user/selectUserInfoById',{params : {user_id : this.user_name}}).then(
          (response) => {
            this.user_info = response.data;
            this.squareUrl = this.url_head+this.user_info.img;
          }
        );
      }
    );
  },
  methods : {
    log_out(){
      axios.get('/user/userLogout').then();
      this.$router.push('/index');
      location.reload()
    }
  }
}
</script>
<style scoped>
</style>
