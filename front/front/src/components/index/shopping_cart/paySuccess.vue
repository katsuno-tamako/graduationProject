<template>
  <div>
    <Header/>
    <Header2/>

    <el-card shadow="never" style="width: auto;margin: 10% 10%;text-align: center;height: 100px">
      <span style="font-size: 40px">支付成功</span>
    </el-card>
    <el-card shadow="never" style="width: auto;margin:30px 10%;text-align: center">
      <el-button @click="returnIndex">返回首页</el-button>
    </el-card>


  </div>
</template>

<script>
import Header from "../Header";
import Header2 from "../Header2";
export default {
  name: 'paySuccess',
  components : {
    Header,Header2
  },
  methods : {
    returnIndex(){
      this.$router.push('/')
    }
  }
}
</script>
<style scoped>
</style>
