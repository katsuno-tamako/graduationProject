<template>
    <div>
      <el-card shadow="never">
        <div style="text-align: center">
          <span>分类</span>
          <el-divider></el-divider>
<!--          <router-link to="/bookPage">图书区</router-link>-->
<!--          <el-divider></el-divider>-->
          <router-link to="/BookIndexPage">图书区</router-link>
          <el-divider></el-divider>
          <router-link to="/ComputerIndexPage">电脑区</router-link>
          <el-divider></el-divider>

          <router-link to="/FurnitureIndexPage">
            家具区
          </router-link>

          <el-divider></el-divider>
          <router-link to="/ClothIndexPage">
            服装区
          </router-link>
          <el-divider></el-divider>
          <router-link to="/PhoneIndexPage">手机区</router-link>
          <el-divider></el-divider>
            <router-link to="/FoodIndexPage">食品区</router-link>
          <el-divider></el-divider>
        </div>
      </el-card>
    </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Menus',
  data () {
    return {
      categories : ''
    }
  },
  created() {
  }
}
</script>
<style scoped>
  a:link { text-decoration: none;}
  a:hover{text-decoration:none}
</style>
