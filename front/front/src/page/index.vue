<template>
  <div>
    <div>
      <Header/>
    </div>
    <div>
      <header2/>
    </div>
    <div style="margin: 0 30px">
      <el-row :gutter="20">
        <el-col :span="5">
          <Menus/>
        </el-col>
        <el-col :span="14">
          <Main/>
        </el-col>
        <el-col :span="5">
          <el-card shadow="never">
            <topGardReCom/>
          </el-card>
        </el-col>
      </el-row>
    <under/>
    </div>
  </div>
</template>

<script>
import Header from "../components/index/Header";
import Menus from "../components/index/Menus";
import Main from "../components/index/Main";
import Header2 from "../components/index/Header2";
import under from "../components/index/under";
import topGardReCom from "../components/index/main/topGardReCom";
import axios from 'axios'
export default {
  name: 'index',
  created() {
    axios.get('/page/addPageView').then();
  },
  components : {
    Header2,
    Header,
    Menus,
    Main,
    under,
    topGardReCom
  }
}
</script>
<style>
  a{
    text-decoration:none
  }
  body{
    background-color:azure;
    padding: 0;
    margin: 0;
  }


</style>
