<template>
  <div>
    <Header/>
    <Header2/>

    <div style="width: auto;margin: 0 10%">
      <el-collapse accordion>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">食品类型</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="ct in type" :key="ct">
              <el-link  @click="goBack(ct)">
                <span style="font-size: 18px">
                  {{ct}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>




      </el-collapse>
    </div>

    <selectFoodIndexPage :keyword="keyword" :ord="ord"/>

  </div>
</template>

<script>
import axios from 'axios'
import Header from "../../../../components/index/Header";
import Header2 from "../../../../components/index/Header2";
import selectFoodIndexPage from "./selectFoodIndexPage";
export default {
  name: 'FoodIndexPage',
  components : {Header,Header2,selectFoodIndexPage},
  created() {
    axios.get('/food/selectFoodType').then((res)=>{this.type = res.data})
  },
  methods : {
    goBack(key){
      this.keyword = key;
    }
  },
  data(){
    return{
      function_type : '',
      keyword : 'no key',
      ord : 'normal',
      type : ''
    }
  }
}
</script>
<style scoped>
</style>
