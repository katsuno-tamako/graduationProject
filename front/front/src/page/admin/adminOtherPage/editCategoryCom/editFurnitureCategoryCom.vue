<template>
  <div>
    <div>
      <span style="font-size: 18px">家具房间</span>
      <el-input type="text" style="width: 300px" v-model="type"></el-input>
      <el-button type="primary" @click="addCategory">提交</el-button>
    </div>
    <el-divider></el-divider>
    <div>
      <el-col :span="4" v-for="r in room" :key="r.id">
        <el-card shadow="never" style="text-align: center;font-size: 15px">
          <span style="margin: 0 10px">{{r.category_type}}</span>
          <el-button size="mini" @click="del(r)" icon="el-icon-delete" circle></el-button>

        </el-card>
      </el-col>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'editFurnitureCategoryCom',
  created() {
    axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '家具房间'}}).then(
      (res)=>{
        this.room = res.data;
      }
    )
  },
  methods : {
    addCategory(){
      this.categoryType.category = '家具房间';
      this.categoryType.category_type = this.type;
      axios.post('/category/insertCategoryType',this.categoryType).then(
        (res)=>{
          axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '家具房间'}}).then(
            (res)=>{
              this.room = res.data;
            }
          )
        }
      );
      this.type = ''
    },

    del(categoryType){
      axios.post('/category/deleteCategoryType',categoryType).then(
        (res) => {
          axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '家具房间'}}).then(
            (res)=>{
              this.room = res.data;
            }
          )
        }
      )
    }

  },
  data(){
    return{
      room : '',
      categoryType : {
        category : '',
        category_type : ''
      },
      type : ''

    }
  }
}
</script>
<style scoped>
</style>
