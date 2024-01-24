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

<!--        <el-collapse-item>-->
<!--          <template slot="title">-->
<!--            <span style="font-size: 20px">适用季节</span>-->
<!--          </template>-->
<!--          <el-row :gutter="10">-->
<!--            <el-col :span="4" v-for="b in apply_to_session" :key="b">-->
<!--              <el-link  @click="getKey(b)">-->
<!--                <span style="font-size: 18px">-->
<!--                  {{b}}-->
<!--                </span>-->
<!--              </el-link>-->
<!--            </el-col>-->
<!--          </el-row>-->
<!--        </el-collapse-item>-->

        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">适用人群</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="b in suitable" :key="b">
              <el-link  @click="getKey(b)">
                <span style="font-size: 18px">
                  {{b}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">服装风格</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="b in style" :key="b">
              <el-link  @click="getKey(b)">
                <span style="font-size: 18px">
                  {{b}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>

        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">服装类型</span>
          </template>
          <el-row :gutter="10">
            <el-col :span="4" v-for="b in type" :key="b">
              <el-link  @click="getKey(b)">
                <span style="font-size: 18px">
                  {{b}}
                </span>
              </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>
      </el-collapse>


      <div>
        <selectClothCommodityPage :keyword="keyword" :ord="ord"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import Header2 from "../../../../components/index/Header2";
import Header from "../../../../components/index/Header";
import selectClothCommodityPage from "./selectClothCommodityPage";
export default {
  name: 'ClothIndexPage',
  components : {Header2,Header,selectClothCommodityPage},
  created() {
    axios.get('/cloth/selectClothBrand').then((res)=>{this.brand=res.data})
    axios.get('/cloth/selectClothSuitable').then((res)=>{this.suitable=res.data})
    axios.get('/cloth/selectClothStyle').then((res)=>{this.style=res.data})
    axios.get('/cloth/selectClothType').then((res)=>{this.type=res.data})
  },
  methods : {
    getKey(key){
      this.keyword = key;
    }
  },
  data(){
    return{
      keyword : 'no key',
      ord : 'normal',
      brand : '',
      style : '',
      suitable : '',
      type : ''
    }
  }
}
</script>
<style scoped>
</style>
