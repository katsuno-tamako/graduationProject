<template>
  <div>
    <div>

      <div>添加图书种类</div>
      {{ins_type}}<el-input v-model="ins_type" style="width: 200px"/> <el-button @click="subBTy">确定</el-button>
    </div>
    <el-card shadow="never">
      <el-row :gutter="20">
        <el-col v-for="type in book_type" :key="type.id" :span="4">
          {{type.book_type}} <el-button @click="delType(type.book_type)">删除</el-button>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ManBookTypeCom',
  methods : {
    subBTy(){
      axios.get('/type/insertBookType',{params:{ins_type:this.ins_type}}).then(
        (response) => {
          axios.get("/type/selectAllBookType").then(
            (response) => {
              this.book_type = response.data;
            }
          );
        }
      );
    },
    delType(type){
      axios.get('/type/deleteBookType',{params:{book_type:type}}).then(
        (response) => {
          axios.get("/type/selectAllBookType").then(
            (response) => {
              this.book_type = response.data;
            }
          );
        }
      );
    }
  },
  created() {
    axios.get("/type/selectAllBookType").then(
      (response) => {
        this.book_type = response.data;
      }
    );
  },
  data(){
    return{
      ins_type : '',
      book_type : ""
    }
  }
}
</script>
<style scoped>
</style>
