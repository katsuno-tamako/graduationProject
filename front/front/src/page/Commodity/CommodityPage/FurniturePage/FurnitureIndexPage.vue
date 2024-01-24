<template>
  <div>
    <Header/>
    <Header2/>
    <div style="width: auto;margin: 0 10%">
      <el-collapse accordion>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">家具种类</span>
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

        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">家具风格</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="ct in style" :key="ct">
              <el-link  @click="goBack(ct)">
                <span style="font-size: 18px">
                  {{ct}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">家具厂商</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="ct in brand" :key="ct">
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


  <select-furniture-index-page :keyword="keyword" :ord="ord"/>

  </div>
</template>

<script>
import axios from 'axios'
import Header from "../../../../components/index/Header";
import Header2 from "../../../../components/index/Header2";
import selectFurnitureIndexPage from "./selectFurnitureIndexPage";
export default {
  name: 'FurnitureIndexPage',
  components : {Header,Header2,selectFurnitureIndexPage},
  created() {
    axios.get('/furniture/selectFurnitureType').then((res)=>{this.type = res.data})
    axios.get('/furniture/selectFurnitureStyle').then((res)=>{this.style = res.data})
    axios.get('/furniture/selectFurnitureBrand').then((res)=>{this.brand = res.data})
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
      type : '',
      brand : '',
      style : ''
    }
  }
}
</script>
<style scoped>
</style>
