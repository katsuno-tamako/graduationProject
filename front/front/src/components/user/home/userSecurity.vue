<template>
   <div>
     <Header/>
     <el-divider></el-divider>
     <div style="margin: 10px 15%;width: auto;text-align: center" @click="opDia">
        <el-card shadow="hover">
          <div style="font-size: 50px"><i class="el-icon-lock"></i></div>
          <div style="font-size: 25px">更改登录密码</div>
        </el-card>
     </div>

<!--     <div style="margin: 10px 15%;width: auto;text-align: center" @click="addSec">-->
<!--       <el-card shadow="hover">-->
<!--         <div style="font-size: 50px"><i class="el-icon-lock"></i></div>-->
<!--         <div v-if="stu === 0">-->
<!--           <div style="font-size: 25px">添加密保问题</div>-->
<!--         </div>-->
<!--         <div v-if="stu != 0">-->
<!--           <div style="font-size: 25px">修改密保问题</div>-->
<!--         </div>-->
<!--       </el-card>-->
<!--     </div>-->

     <el-dialog
       :visible.sync="dia_ed"
      title="编辑密码"
     >
       <el-form>
         <el-form-item label="输入旧密码"><span style="color: red">{{pass_status}}</span>
           <el-input v-model="old_password" placeholder="请输入旧密码"></el-input>
         </el-form-item>
         <el-form-item label="输入新密码">
           <el-input v-model="new_password" placeholder="请输入新密码" show-password maxlength="16" ></el-input>
         </el-form-item>
         <el-form-item label="确认新密码">{{re_info}}
           <el-input v-model="req_new_pass" placeholder="确认新密码" show-password maxlength="16"></el-input>
         </el-form-item>
       </el-form>

       <el-divider></el-divider>
       <el-button type="primary" @click="editPass" :disabled="!p_status || !re_status || !old_password || !new_password || !req_new_pass">确定修改</el-button>
     </el-dialog>

     <el-dialog
      :visible.sync="tipSuc"
     >
       <el-divider></el-divider>
       密码更改成功
       <el-divider></el-divider>
       <el-button type="primary" @click="tipSuc=false">确定</el-button>
     </el-dialog>


    <!--     密保问题窗口-->
<!--     <el-dialog-->
<!--      :visible.sync="dia_sec"-->
<!--     >-->
<!--       <el-divider></el-divider>-->
<!--       <div v-if="stu === 0">-->
<!--       <el-form>-->

<!--         <el-form-item label="选择第一个密保问题">-->
<!--            <el-select v-model="question_1" clearable  placeholder="请选择密保问题">-->
<!--              <el-option v-for="que in que_value" :key="que.id" :label="que.question" :value="que.que_id">-->
<!--              </el-option>-->
<!--            </el-select>-->
<!--           <div v-if="question_1 != ''">-->
<!--           <el-input v-model="que_an_1" style="width: 500px"></el-input>-->
<!--          </div>-->
<!--         </el-form-item>-->

<!--         <el-form-item label="选择第一个密保问题">-->
<!--           <el-select v-model="question_2" clearable  placeholder="请选择密保问题">-->
<!--             <el-option v-for="que in que_value" :key="que.id" :label="que.question" :value="que.que_id">-->
<!--             </el-option>-->
<!--           </el-select>-->
<!--           <div v-if="question_2 != ''">-->
<!--             <el-input v-model="que_an_2" style="width: 500px"></el-input>-->
<!--           </div>-->
<!--         </el-form-item>-->

<!--         <el-form-item>-->
<!--           <el-button type="primary" @click="subSec">提交</el-button>-->
<!--         </el-form-item>-->

<!--       </el-form>-->
<!--       </div>-->

<!--       <div v-else>-->
<!--         <el-form>-->

<!--           <el-form-item label="选择第一个密保问题">-->
<!--             <el-select v-model="user_question[0].que_id" clearable  placeholder="请选择密保问题">-->
<!--               <el-option v-for="que in que_value" :key="que.id" :label="que.question" :value="que.que_id">-->
<!--                 {{user_question[0].que_id = que.que_id}}-->
<!--               </el-option>-->
<!--             </el-select>-->
<!--               <el-input v-model="user_question[0].ans" style="width: 500px"></el-input>-->

<!--           </el-form-item>-->

<!--           <el-form-item label="选择第一个密保问题">-->
<!--             <el-select v-model="user_question[1].que_id" clearable  placeholder="请选择密保问题">-->
<!--               <el-option v-for="que in que_value" :key="que.id" :label="que.question" :value="que.que_id">-->
<!--                 {{user_question[1].que_id = que.que_id}}-->

<!--               </el-option>-->
<!--             </el-select>-->

<!--             <el-input v-model="user_question[1].ans" style="width: 500px"></el-input>-->

<!--           </el-form-item>-->

<!--           <el-form-item>-->
<!--             <el-button type="primary" @click="upSuc">更新问题</el-button>-->
<!--           </el-form-item>-->

<!--         </el-form>-->
<!--       </div>-->


<!--     </el-dialog>-->

<!--     <el-dialog-->
<!--      :visible.sync="dia_suc_tip"-->
<!--     >-->
<!--       修改成功-->
<!--       <el-button type="primary" @click="sucTIp">确定</el-button>-->
<!--     </el-dialog>-->

   </div>
</template>

<script>
import axios from 'axios';
import Header from "../../index/Header";
export default {
  name: 'userSecurity',
  inject : ['reload'],
  components : {Header},
  created() {
    axios.get('/user/selectPassword').then(
      (res) => {this.user_acc = res.data;}
    );
    axios.get('/security_q/selectAllQuestion').then(
      (res)=>{
        this.que_value = res.data;

      }
    );

    axios.get('/security_q/selectQuestionByUserId').then(
      (res) => {
        this.user_question = res.data;
        console.log("res.data"+res.data+'---')
        if(res.data.length === 0){
          this.stu = 0;
        }else{
          this.stu = 1
        }
        console.log("array length is "+res.data.length);
        console.log(this.stu);
      }
    )

  },
  methods:{
    opDia(){
      this.dia_ed = true;
    },
    editPass(){
      this.dia_ed = false;
      axios.get('/user/editPassword',{params:{password:this.new_password}}).then();
      this.tipSuc = true;
    },
    addSec(){
      this.dia_sec = true;
      console.log("0:"+this.user_question[0])
      console.log("1:"+this.user_question[1])
    },
    subSec(){
      axios.get('/security_q/insertSecQueByUser',{params : {que_id:this.question_1,ans:this.que_an_1}}).then()
      axios.get('/security_q/insertSecQueByUser',{params : {que_id:this.question_2,ans:this.que_an_2}}).then()
      this.dia_sec = false;
      this.dia_suc_tip = true;
    },
    sucTIp(){
      this.dia_suc_tip = false;
      this.reload();
    },
    upSuc(){
      console.log(this.user_question);

      axios.post('/security_q/updateQuestionByUser',this.user_question).then();
      // axios.post('/security_q/updateQuestionByUser',this.user_question[1]).then();
      this.dia_suc_tip = true;

    }
  },
  data(){
    return{
      stu : '',
      updateQuestion : {
        que_id : '',
        ans : ''
      },
      user_question : {
        security_question : {}
      },
      dia_suc_tip : false,
      security_question : '',
      que_value : '',
      question_1 : '',
      question_2 : '',
      que_an_1 : '',
      que_an_2 : '',
      dia_sec : false ,
      tipSuc : false,
      dia_ed : false,
      old_password : '',
      new_password : '',
      req_new_pass : '',
      pass_status : '',
      p_status : false,
      re_status : false,
      user_acc : '',
      re_info : ''
    }
  },
  watch : {
    old_password : function () {
      if(this.old_password === this.user_acc.password){
        this.pass_status = '';
        this.p_status = true;
      }else{
        this.pass_status = '旧密码不正确';
        this.p_status = false;
      }
    },
    dia_ed : function () {
      if(this.dia_ed === false){
        this.old_password = '';
        this.new_password = '';
        this.req_new_pass = '';
        this.re_status = false;
      }
    },
    req_new_pass : function () {
      if(this.req_new_pass === this.new_password){
        this.re_info = '';
        this.re_status = true;
      }else{
        this.re_info = '两次输入密码不同';
        this.re_status = false;
      }
    }
  }
}
</script>
<style scoped>
</style>
