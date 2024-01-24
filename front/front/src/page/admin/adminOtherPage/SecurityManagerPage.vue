<template>
  <div>
    <div>
      <div>添加密保问题</div>
      <div><el-input v-model="add_question"></el-input></div>
      <div><el-button @click="addQue">提交</el-button></div>
    </div>

    <el-table
      :data="security_question"
    >
      <el-table-column
        label="id"
        prop="que_id"
      ></el-table-column>

      <el-table-column
        label="问题"
        prop="question"
      ></el-table-column>

      <el-table-column
        label="操作"
      >
        <template slot-scope="scope">

          <el-button icon="el-icon-setting" circle @click="editQuestion(scope.row)"></el-button>
          <el-button icon="el-icon-delete" circle @click="deleteQuestion(scope.row.que_id)"></el-button>
        </template>
      </el-table-column>

    </el-table>


    <el-dialog
      title="编辑"
      :visible.sync="dia_edit"
    >
      <el-divider>{{ed.que_id}}</el-divider>
      <el-input v-model="ed.question"></el-input>
      <el-divider></el-divider>
      <el-button type="primary" @click="subEdit">确定</el-button>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SecurityManagerPage',
  inject : ['reload'],
  created() {
    axios.get('/security_q/selectAllQuestion').then(
      (res)=>{
        this.security_question = res.data;
      }
    );

    axios.get('/admin/getAdminSession').then(
      (res) => {
        this.stu = res.data;w
        if(this.stu ==='NoLog'){
          console.log(res.data);
          this.$router.push('/adminLogin');
        }
      }
    )

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
    },
    deleteQuestion(id){
      console.log(id)
      axios.get('/security_q/deleteQuestion',{params:{que_id:id}}).then()
      this.reload();
    },
    editQuestion(info){
      this.ed = info;
      this.dia_edit = true;
    },
    subEdit(){
      axios.post('/security_q/updateQuestion',this.ed).then();
      this.reload();
    }
  },
  data(){
    return{
      security_question : '',
      add_question : '',
      dia_edit : false,
      ed : ''
    }
  }
}
</script>
<style scoped>
</style>
