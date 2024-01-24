<template>
  <div>
    <Header/>
    <Header2/>
    <div style="width: auto;margin: 0 10%">
      <el-collapse accordion>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">品牌</span>
          </template>

          <el-row :gutter="10">
            <el-col :span="4" v-for="b in brand" :key="b">
              <el-link  @click="getKey(b)">
                <span style="font-size: 18px">
                  {{b}}
                </span>
              </el-link>
            </el-col>
          </el-row>

        </el-collapse-item>
      </el-collapse>
    </div>

    <div>
      <selectPhoneCommodityPage :keyword="keyword" :ord="ord"/>
    </div>


  </div>
</template>

<script>
import axios from 'axios'
import Header2 from "../../../../components/index/Header2";
import Header from "../../../../components/index/Header";
import selectPhoneCommodityPage from "./selectPhoneCommodityPage";
export default {
  name: 'PhoneIndexPage',
  components : {Header,Header2,selectPhoneCommodityPage},
  created() {
    axios.get('/phone/selectPhoneBrand').then((res)=>{this.brand = res.data})
  },
  methods : {
    getKey(k){
      this.keyword = k;
    }
  },
  data(){
    return{
      keyword : 'no key',
      ord : 'normal',
      brand : ''
    }
  }
}
</script>
<style scoped>
</style>
