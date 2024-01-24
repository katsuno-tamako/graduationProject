<template>
  <div>
    <el-header style="height: 100px">
      <div style="margin: 80px 0 0 50px;font-size: 30px">
        欢迎登录
      </div>
    </el-header>
    <el-divider></el-divider>
    <div>
      <el-card style="width: 400px;margin: 0 35%">
        <el-form @keyup.enter.native="login_user">

          <el-form-item label="普通用户登录"></el-form-item>

          <el-form-item>
            <el-input v-model="user_acc.account" style="width: 350px">
              <template slot="prepend"><i class="el-icon-user-solid"></i> </template>
            </el-input>
          </el-form-item>

          <el-form-item>
            <el-input v-model="user_acc.password" style="width: 350px" show-password>
              <template slot="prepend"><i class="el-icon-lock"></i> </template>
            </el-input>
          </el-form-item>

          <el-form-item>
            <el-button @click="login_user" style="width: 350px;background-color: orange">
              <span style="color: white;font-size: 20px">登录</span>
            </el-button>
          </el-form-item>
        </el-form>
        <div>
          <router-link to="/registerUser">免费注册</router-link>
<!--          <router-link to="/findPasswordPage" target="_blank">忘记密码</router-link>-->
        </div>
      </el-card>
    </div>
    <el-divider></el-divider>



    <el-dialog
      :visible.sync="dialogVisible"
      width="250px"
    >
      <div style="text-align: center">
        <el-divider></el-divider>
        <div style="margin: 20px;font-size: 20px;color: red">
          <i class="el-icon-warning-outline">密码错误</i>
        </div>
        <el-divider></el-divider>
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'login',
  data () {
    return {
      user_acc : {
        account : '',
        password : ''
      },
      dialogVisible : false
    }
  },
  methods : {
    login_user(){
      axios.post('/user/userLogin',this.user_acc).then(
        (response) => {
          if(response.data == 'ERROR'){
            this.dialogVisible = true;
          }else{
            this.$store.state.user_id = response.data;
            this.$router.go(-1);
          }
        }
      );
    }
  }
}
</script>
<style scoped>
  .el-input{
    width: 200px;
  }
  a{
    text-decoration: none;
    color: slategray;
  }
  a:hover{
    text-decoration: none;
    color: darkcyan;
  }
</style>
