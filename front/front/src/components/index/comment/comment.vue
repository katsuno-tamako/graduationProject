<template>
  <div></div>
<!--  <div>-->
<!--    {{commodity_id}}-->
<!--    {{user_id}}-->
<!--    <div v-if="equCom==='No'">-->
<!--      <el-card>-->
<!--        你没有购买该物品，无法评论-->
<!--      </el-card>-->
<!--    </div>-->
<!--    <div v-if="equCom==='Yes'">-->
<!--      <el-input-->
<!--        type="textarea"-->
<!--        :rows="2"-->
<!--        placeholder="请输入内容"-->
<!--        v-model="comment.content">-->

<!--      </el-input>-->
<!--      <el-rate v-model="comment.grade"></el-rate>-->
<!--      <el-button @click="subCom">提交</el-button>-->
<!--    </div>-->


<!--  </div>-->
</template>

<script>
import axios from 'axios'
export default {
  name: 'comment',
  inject : ['reload'],
  props : ['commodity_id','user_id'],
  data(){
    return {
      comment : {
        commodity_id : '',
        user_id : '',
        grade : '',
        user_name : '',
        content : '',
        likeNum : ''
      },
      value1 : '',
      equCom : '',
    }
  },
  created() {
    this.comment.commodity_id = this.commodity_id;
    this.comment.user_id = this.user_id;

    axios.get('/user/getUserSession').then(
      (response) => {
        this.comment.user_id = response.data;
      }
    );

    axios.get('/comment/eqCom',{params:{commodity_id: this.commodity_id,user_id: this.user_id}}).then(
      (response) => {
        this.equCom = response.data;
      }
    );

  },
  methods : {
    subCom(){
     if(this.$store.state.user_id=='null'){
       this.$router.push('/login');
     }else{
       axios.post('/comment/insertComment',this.comment).then();
      this.reload();
     }

    }
  }
}
</script>
<style scoped>
</style>
