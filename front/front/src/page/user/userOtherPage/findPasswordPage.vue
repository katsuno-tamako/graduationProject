<template>
  <div>
    <div style="width: auto;padding: 20px 20px">
      <span style="font-size: 35px">找回密码</span>
    </div>

    <el-divider></el-divider>
    <div style="width: auto;margin: 0 25%">
    <el-steps :active="active" finish-status="success">
      <el-step title="步骤 1"></el-step>
      <el-step title="步骤 2"></el-step>
      <el-step title="步骤 3"></el-step>
      <el-step title="完成"></el-step>
    </el-steps>

    <div >
      <div v-if="active===1" style="width: auto;margin: 20px 10%">
        <el-form>
          <el-form-item>
            <el-input placeholder="请输入你的账号" v-model="account"></el-input>
            <div style="margin-top: 20px" v-if="ac_1_tip==='error'">

                <el-alert
                  title="未找到账号或该账号未设置密保"
                  center
                  show-icon
                  style="height: 50px"
                  type="warning">
                </el-alert>
            </div>
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%" @click="next">下一步</el-button>
          </el-form-item>

        </el-form>
      </div>
    </div>

    <div v-if="active===2" style="width: auto;margin: 20px 10%">
      <el-form>
        <el-form-item>
          <el-select v-model="anw" placeholder="请选择密保问题">
            <el-option
              v-for="q in question"
              :key="q.id"
              :value="q.que_id"
              :label="q.security_question.question">
            </el-option>
          </el-select>
        </el-form-item>

        <div v-if="ac_2_tip==='error'">
          <el-alert
            title="密保问题错误，请重复输入"
            center
            show-icon
            style="height: 50px"
            type="warning">
          </el-alert>
        </div>

        <el-form-item v-if="anw!=''">
          <el-input  v-model="req_que"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button style="width: 100%" @click="next_act_2">下一步</el-button>
        </el-form-item>

      </el-form>
    </div>

    <div v-if="active===3" style="width: auto;margin: 20px 10%">


      <el-form>
        <el-form-item label="更改密码">
          <el-input v-model="new_password"></el-input>
        </el-form-item>

        <el-form-item label="确认重复密码">
          <el-input v-model="re_new_password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button @click="next_act_3" :disabled="re_stu!='success'|| !new_password || !re_new_password">提交</el-button>
        </el-form-item>

      </el-form>
    </div>

    <div v-if="active===4" style="width: auto;margin: 20px 10%">
      <el-card style=" text-align: center;width: auto;margin: 100px 30%;font-size: 20px">
        <div style="color: orange"><i class="el-icon-check"></i>更改成功</div>
        <el-divider></el-divider>
        <div><router-link to="/"><i class="el-icon-right"></i> 返回主页</router-link></div>
      </el-card>
    </div>

    <div style="width: auto;margin: 20px 25%">
    </div>


    </div>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'findPasswordPage',
  created() {

  },
  methods : {
    next(){
      if(this.account === ''){

      }else{
        axios.get('/security_q/haveAccountSelectQ',{params:{account:this.account}}).then(
          (res) => {
            console.log(res.data)
            if(res.data==="SUCCESS"){
              this.active++;
            }else{
              this.ac_1_tip = "error";
            }
          }
        );
      }
    },
    next_act_2(){
      this.send_info.que_id = this.anw;
      this.send_info.user_id = this.account;
      this.send_info.ans = this.req_que;
      axios.post('/security_q/equSucQue',this.send_info).then(
        (res) => {
          this.send_status = res.data;
          if(res.data==="ERROR"){
            console.log("error");
              this.ac_2_tip = 'error';
          } else{
            this.active++;
          }
        }
      )
    },
    next_act_3(){
      this.active++;
      axios.get('/user/findPassEditPass',{params:{user_id:this.account,password:this.new_password}}).then();
    }
  },
  data(){
    return{
      ac_1_tip : '',
      ac_2_tip : '',
      send_status : '',
      send_info : {
        que_id : '',
        user_id : '',
        ans : ''
      },
      active : 1,
      account : '',
      question : '',
      anw : '',
      new_password : '',
      req_que : '',
      ac_2_status : '',
      re_new_password : '',
      re_stu : ''
    }
  },
  watch : {
    active : function () {
      if(this.active===2){
        axios.get('/security_q/selectQuestionByAccount',{params:{account:this.account}}).then(
          (res) => {
            this.question = res.data;
          }
        );
      }
    },
    re_new_password : function () {
      if(this.re_new_password === this.new_password){
        this.re_stu = 'success';
      }else{
        this.re_stu = 'error';
      }
    }
  }
}
</script>
<style scoped>
</style>
