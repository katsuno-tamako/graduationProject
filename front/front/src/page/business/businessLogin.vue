<template>
  <div>
    <div style="padding: 100px 30%">
    <el-container>
      <el-header class="header_login">
        <div style="padding-left: 200px">
          <h1>
            商家登录
          </h1>
        </div>
      </el-header>
      <el-main>
        <el-row :gutter="20">
          <el-col :span="12">
            <div style="text-align: center">
              <el-card shadow="always" style="width: 500px">
                <el-form @keyup.enter.native="login">
                  <el-form-item>
                    <div>
                      <el-input v-model="merchant.account" placeholder="其请输入用户名">
                        <template slot="prepend"><i class="el-icon-user-solid"></i> </template>
                      </el-input>
                    </div>
                  </el-form-item>

                  <el-form-item>
                    <div>
                      <el-input show-password v-model="merchant.password" placeholder="请输入密码">
                        <template slot="prepend"><i class="el-icon-lock"></i> </template>
                      </el-input>
                    </div>
                  </el-form-item>

                  <el-form-item>
                    <div>
                      <el-button type="primary" @click.prevent="login" style="width: 450px">登录</el-button>
                      <div><router-link to="/businessRegister">申请商家</router-link> </div>
                    </div>
                  </el-form-item>
                </el-form>
              </el-card>
            </div>
          </el-col>
          <el-col :span="12">
            <div>
            </div>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'businessLogin',
  data () {
    return {
      merchant : {
        account : '',
        password : ''
      }
    }
  },
  methods : {
    login(){

      axios.post('/merchant/merchantLogin',this.merchant)
        .then(response => {
          console.log(response.data);
          this.merchant.account='';
          this.merchant.password='';
          if(response.data == 'success'){
            this.$router.push('/businessIndex');
          }else{
            alert("密码错误")
          }

        }
      )
    }
  }
}
</script>
<style scoped>

  .header_login{
    height: 50px;
  }


</style>
