<template>
  <div>
    <div>
      <span style="font-size: 18px">手机品牌</span>
      <el-input type="text" style="width: 300px" v-model="type"></el-input>
      <el-button type="primary" @click="addCategory">提交</el-button>
    </div>
    <el-divider></el-divider>
    <div>
      <el-col :span="4" v-for="brand in phone_brand" :key="brand.id">
          <el-card shadow="never" style="text-align: center;font-size: 15px">
            <span style="margin: 0 10px">{{brand.category_type}}</span>
            <el-button size="mini" @click="del(brand)" icon="el-icon-delete" circle></el-button>
          </el-card>


      </el-col>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'editPhoneCategoryCom',
  created() {
    axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '手机品牌'}}).then(
      (res)=>{
        this.phone_brand = res.data;
      }
    )
  },
  methods : {
    addCategory(){
      this.categoryType.category = '手机品牌';
      this.categoryType.category_type = this.type;

      axios.post('/category/insertCategoryType',this.categoryType).then(
        (res)=>{
          axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '手机品牌'}}).then(
            (res)=>{
              this.phone_brand = res.data;
            }
          )
        }
      );

      this.type = ''
    },

    del(categoryType){
      axios.post('/category/deleteCategoryType',categoryType).then(
        (res) => {
          axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '手机品牌'}}).then(
            (res)=>{
              this.phone_brand = res.data;
            }
          )
        }
      )
    }

  },
  data(){
    return{
      phone_brand : '',
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
