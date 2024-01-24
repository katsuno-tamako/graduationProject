<template>
  <div>
    <Header/>
    <Header2/>
    <div>
      <el-row :gutter="20">
        <el-col :span="5">
          <el-card style="text-align: center">
            <div style="background-color:black;font-size:20px;color:white;height: 30px;width: auto;padding: 5px">
              <span @click="lod"><b>手机分类</b></span>
            </div>
            <el-divider>热门品牌</el-divider>
              <el-row :gutter="10">
                <el-col :span="8" ><span @click="sendKey('华为')">华为</span></el-col>
                <el-col :span="8"><span @click="sendKey('苹果')">苹果</span></el-col>
                <el-col :span="8"><span @click="sendKey('小米')">小米</span></el-col>
                <el-col :span="8"><span @click="sendKey('vivo')">vivo</span></el-col>
                <el-col :span="8"><span @click="sendKey('OPPO')">OPPO</span></el-col>
                <el-col :span="8"><span @click="sendKey('荣耀')">荣耀</span></el-col>
              </el-row>
            <el-divider>手机配件</el-divider>
            <el-row :gutter="10">
              <el-col :span="8">充电器</el-col>
              <el-col :span="8">数据线</el-col>
              <el-col :span="8">手机壳</el-col>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="14">
          <el-card>
            <phone-com :keyword="keyword"/>
          </el-card>
        </el-col>
        <el-col :span="5"></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import phoneCom from "../../components/index/categoryPhone/phoneCom";
import axios from 'axios'
export default {
  name: 'phonePage',
  inject : ['reload'],
  components: {Header,Header2,phoneCom},
  data(){
    return {
      phone_brand : '',
      phone : {},
      keyword : 'nullBrand'
    }
  },
  created() {

  },
  methods : {
    sendKey(k){
      this.keyword = k;
    },
    lod(){
      this.reload();
    }
  }

}
</script>
<style scoped>
</style>
