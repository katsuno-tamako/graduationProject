<template>
  <div>
    <Header/>
    <Header2/>

    <el-row :gutter="20">
      <el-col :span="5">
        <el-card style="text-align: center">
          <div @click="sel('男装')">男装</div>
          <div @click="sel('女装')">女装</div>
        </el-card>
      </el-col>
      <el-col :span="14">
        <cloth-com :clothType="ty"/>
      </el-col>
      <el-col :span="5"></el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import clothCom from "../../components/index/categoryCloth/clothCom";
export default {
  name: 'clothPage',
  components : {
    Header,Header2,clothCom
  },
  methods : {
    sel(type){
      this.ty = type;
    }
  },
  data(){
    return {
      ty : ''
    }
  }
}
</script>
<style scoped>
</style>
