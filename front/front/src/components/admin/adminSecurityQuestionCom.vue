<template>
  <div>密保问题管理
    <div>{{security_question}}</div>
    <div>
      <div>添加密保问题</div>
      <div><el-input v-model="add_question"></el-input></div>
      <div><el-button @click="addQue">提交</el-button></div>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'adminSecurityQuestionCom',
  created() {
    axios.get('/security_q/selectAllQuestion').then(
      (res)=>{
        this.security_question = res.data;
      }
    );
  },
  methods : {
    addQue(){
      axios.get('/security_q/insertQuestion',{params:{qu : this.add_question}}).then(
        (res) => {
          axios.get('/security_q/selectAllQuestion').then(
            (res)=>{
              this.security_question = res.data;
            }
          );
        }
      );
    }
  },
  data(){
    return{
      security_question : '',
      add_question : ''
    }
  }
}
</script>
<style scoped>
</style>
