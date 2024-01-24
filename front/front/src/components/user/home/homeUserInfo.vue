<template xmlns:el-colc="http://www.w3.org/1999/html">
  <div>

    <div style="width: 500px;margin: 10px 15%">
      <div>
        <span>更改个人信息</span>

      </div>
      <el-divider></el-divider>
      <el-form>
        <el-form-item label="昵称">
          <el-input v-model="user_info.user_name" size="small" maxlength="10" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="联系电话">
          <el-input v-model="user_info.phone" size="small" maxlength="11" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user_info.email" size="small" ></el-input>
        </el-form-item>
        <el-form-item label="生日">
          <el-date-picker
            v-model="user_info.birthday"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="性别">
          <div>
            <el-radio v-model="user_info.sex" label="男">男</el-radio>
            <el-radio v-model="user_info.sex" label="女">女</el-radio>
          </div>
        </el-form-item>
        <el-form-item>
          <div class="demo-basic--circle">
            <div class="block" >
              <el-avatar shape="square" :size="100" :src="url"></el-avatar>
              <el-avatar shape="square" :size="80" :src="url"></el-avatar>
              <el-avatar shape="square" :size="60" :src="url"></el-avatar>
              <el-avatar shape="square" :size="40" :src="url"></el-avatar>
            </div>
          </div>
        </el-form-item>
        <el-form-item>
          <el-upload
            action="http://localhost:8906/user/uploadUserImg"
            :data="{user_id : user_info.user_id}"
            :auto-upload="false"
            ref="upload"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button @click="updateUserInfo">提交</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-dialog
      :visible.sync="dia">
      <div>修改成功</div>
      <el-button @click="suc" type="primary">确定</el-button>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios';
import proImg from "./proImg";
export default {
  name: 'homeUserInfo',
  inject : ['reload'],
  components : {
    proImg
  },
  data () {
    return {
      dia : false,
      first : 'first',
      user_info : {
        user_name : '',
        phone : '',
        birthday : '',
        sex : ''
      },
      url_head : 'http://localhost:8906//',
      url : '',
      user_id : ''
    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        this.user_id = response.data;
        axios.get('/user/selectUserInfoById',{params : {user_id : this.user_id}}).then(
          (response) => {
            this.user_info = response.data;
            this.url=this.url_head+this.user_info.img;
          }
        );
      }
    );

  },
  methods : {
    updateUserInfo(){
      this.dia = true;
      axios.post('/user/updateUserInfo',this.user_info).then();
      this.$refs.upload.submit();
    },
    suc(){
      this.dia=false;
      this.reload();
    },
  }
}
</script>
<style scoped>
</style>
