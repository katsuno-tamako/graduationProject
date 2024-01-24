<template>
  <div>
    <Header/>
    <Header2/>
    <el-card style="margin: 100px 200px;text-align: center">
      <div style="font-size: 30px">添加成功</div>
      <div @click="goBack"><el-link type="primary" style="font-size: 25px;margin: 20px 0"><i class="el-icon-back"></i>返回继续购买</el-link></div>
      <router-link to="/shopCartPage"> <div style="font-size: 25px"><i class="el-icon-right"></i>跳转到购物车页面</div></router-link>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../../components/index/Header";
import Header2 from "../../../components/index/Header2";
export default {
  name: 'addSuccess',
  components : {
    Header,Header2
  },
  methods : {
    goBack(){
      this.$router.go(-1);
    }
  }
}
</script>
<style scoped>
</style>
