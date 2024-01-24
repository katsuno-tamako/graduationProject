<template>
  <div>
    <div style="width: auto;text-align: center">
      <span style="font-size: 30px">管理员登录</span>
    </div>
    <el-divider></el-divider>
    <div style="width: auto;margin: 10% 30%">
      <el-card shadow="never">
        <el-form @keyup.enter.native="logAdmin">
          <el-form-item>
            <el-input v-model="admin.account">
              <template slot="prepend"><i class="el-icon-user-solid"></i> </template>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="admin.password" show-password>
              <template slot="prepend"><i class="el-icon-lock"></i> </template>
            </el-input>
          </el-form-item>
          <el-button @click="logAdmin" style="width: 100%" type="success">登录</el-button>
        </el-form>
      </el-card>
    </div>


    <el-dialog
      title="提示"
      width="300px"
      :visible.sync="dia_error"
    >
      <div style="text-align: center">
      <el-card shadow="never">
        <div style="margin: 10px;font-size: 20px">
          密码错误
        </div>
        <el-button type="warning" @click="dia_error=false">确定</el-button>
      </el-card>

      </div>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'adminLogin',
  data(){
    return {
      admin : {
        account : '',
        password : ''
      },
      dia_error : false
    }
  },
  methods : {
    logAdmin(){
      axios.post('/admin/adminLogin',this.admin).then(
        (response) => {
          if(response.data=='error'){

            this.dia_error = true;
          }else{
            this.$router.push('/adminHome');
          }
        }
      );
    }
  }
}
</script>
<style scoped>
</style>
