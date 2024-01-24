<template>
  <div>
    <el-header style="height: 100px">
      <div style="margin: 80px 0 0 50px;font-size: 30px">
        用户注册
      </div>
    </el-header>
    <el-card>
      <div style="width: 700px;padding: 0 30%">
        <el-form ref="from" :model="user">
          <el-form-item label="账号" style="width: 100px">
            <el-input v-model="user.account" style="width: 500px" maxlength="12" show-word-limit></el-input>
            <span v-if="accountUse === false">该账号已经存在</span>
          </el-form-item>
          <el-form-item label="密码" style="width: 100px">
            <el-input v-model="user.password" style="width: 500px" show-password maxlength="16"></el-input>
          </el-form-item>

          <el-form-item label="确认密码" style="width: 100px">
            <el-input v-model="rePassword" style="width: 500px" show-password maxlength="16"></el-input>{{rePasswordInfo}}
          </el-form-item>

          <el-form-item label="邮箱" style="width: 100px"
                        prop="email"
                        :rules="[
                              { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                              { type: 'email', message: '请输入正确的邮箱', trigger: ['blur', 'change'] }
                                ]"
          >
            <el-input v-model="user.email" style="width: 500px" ></el-input>
          </el-form-item>
          <el-form-item label="手机号" style="width: 100px">
            <el-input v-model="user.phone" style="width: 500px" oninput="value=value.replace(/^\.+|[^\d.]/g,'')"></el-input>
          </el-form-item>

<!--          <el-form-item label="密保问题" style="width: 500px">-->
<!--            <el-select v-model="question" clearable  placeholder="请选择密保问题">-->
<!--              <el-option v-for="que in que_value" :key="que.id" :label="que.question" :value="que.que_id">-->
<!--              </el-option>-->
<!--            </el-select>-->
<!--            <div v-if="question != ''">-->
<!--              <el-input v-model="que_an" style="width: 500px"></el-input>-->
<!--            </div>-->
<!--          </el-form-item>-->

          <el-form-item>
            <el-button @click="registerUser" :disabled="!user.account || !user.password || !user.phone || !user.email ||user.password!=rePassword || !accountUse">立即注册</el-button>
          </el-form-item>

        </el-form>
      </div>

      <el-dialog
        :visible.sync="dialogVisible">
        <span>注册成功,前往主页</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="regSuc">确定</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'registerUser',
  created() {
    axios.get('/security_q/selectAllQuestion').then(
      (res)=>{
        this.que_value = res.data;
      }
    );
  },
  data () {
    return {
      que_value : {
        que_id : ''
      },
      question : '',
      que_an : '',
      user : {
        account : '',
        password : '',
        email : '',
        phone : ''
      },
      rePassword : '',
      rePasswordInfo : '',
      user_acc : {
        account : '',
        password : ''
      },
      dialogVisible : false,
      butSta : false,
      accountUse : ''
    }
  },
  watch : {
    rePassword : function () {
      if(this.user.password != this.rePassword) {
          this.rePasswordInfo = "输入密码不同";
      }else{
        this.rePasswordInfo = '';
      }
    },
    'user.account':function(){
      this.user.account=this.user.account.replace(/[\W]/g,'');
      axios.get('/user/selectUserByAccount',{params:{account: this.user.account}}).then(
        (response) => {
          this.accountUse = response.data;
        }
      );

    },
    'user.email' : function(){
      // this.user.email=this.user.email.replace(/[\W]/g,'');

    }
  },
  methods : {
    registerUser(){
      this.user_acc.account = this.user.account;
      this.user_acc.password = this.user.password;
      axios.get('/user/registerUser',{params : {
            account : this.user.account,
            password : this.user.password,
            email : this.user.email,
            phone : this.user.phone
        }}).then(
        (res) => {
          axios.get('/security_q/insertSecQueByUser')
        }
      );

      axios.post('/user/userLogin',this.user_acc).then(
        (response) => {console.log(response.status);}
      );

      this.dialogVisible=true;
    },
    regSuc(){
      this.dialogVisible=false;
      this.$router.push('/index');
    }
  }
}
</script>
<style scoped>
</style>
