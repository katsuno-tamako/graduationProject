<template>
  <div>
    <div style="width: auto;margin: 50px 10%">
      <el-row :gutter="100">
        <el-col :span="8"><router-link to="/businessIndex"><el-card shadow="hover">主页</el-card></router-link></el-col>
        <el-col :span="8"><router-link to="/AllCommodityPage"><el-card shadow="hover">我的商品</el-card></router-link></el-col>
        <el-col :span="8"><router-link to="/orderMainPage"><el-card shadow="hover">我的订单</el-card></router-link></el-col>
      </el-row>
      <el-divider></el-divider>
    </div>

  </div>
</template>

<script>
export default {
    name: 'businessMenuCom'
}
</script>
<style scoped>
  a{text-decoration:none}
</style>
