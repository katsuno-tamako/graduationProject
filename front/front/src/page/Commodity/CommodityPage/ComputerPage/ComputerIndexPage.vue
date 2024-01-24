<template>
  <div>
    <Header/>
    <Header2/>
    <div style="width: auto;margin: 0 10%">
      <el-collapse accordion>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">电脑分类</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="ct in computer_type" :key="ct">
              <el-link  @click="getKey(ct)">
                <span style="font-size: 18px">
                  {{ct}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">CPU</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="c in cpu" :key="c">
              <el-link  @click="getKey(c)">
                <span style="font-size: 18px">
                  {{c}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">品牌</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="c in brand" :key="c">
              <el-link  @click="getKey(c)">
                <span style="font-size: 18px">
                  {{c}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div>
      <selectComputerCommodityPage :keyword="keyword" :ord="ord"/>
    </div>

  </div>
</template>

<script>
import Header2 from "../../../../components/index/Header2";
import Header from "../../../../components/index/Header";
import selectComputerCommodityPage from "./selectComputerCommodityPage";
import axios from 'axios'
export default {
  name: 'ComputerIndexPage',
  inject : ['reload'],
  created() {
    axios.get('/computer/selectComputerDisByType').then((res)=>{this.computer_type = res.data});
    axios.get('/computer/selectComputerDisByCPU').then((res)=>{this.cpu = res.data});
    axios.get('/computer/selectComputerDisByBrand').then((res)=>{this.brand = res.data});
  },
  components : {
    Header,Header2,selectComputerCommodityPage
  },
  methods : {
    getKey(key){
      this.keyword = key;
    }
  },
  data(){
    return{
      cpu : '',
      brand : '',
      computer_type : '',
      keyword : 'no key',
      ord : 'normal'
    }
  }
}
</script>
<style scoped>
</style>
