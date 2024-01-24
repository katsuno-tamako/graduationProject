<template>
  <div>
    <Header/>
    <Header2/>
    <div>
      <el-row :gutter="20">
        <el-col :span="5">
          <el-card>
            菜单
          </el-card>
        </el-col>
        <el-col :span="14">
          <food-com/>
        </el-col>
        <el-col :span="5"></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import foodCom from "../../components/index/categoryFood/foodCom";
export default {
  name: 'foodPage',
  components: {Header2, Header,foodCom}
}
</script>
<style scoped>
</style>
