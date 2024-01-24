<template>
  <div>
    <Header/>
    <Header2/>
    <div>
      <div>
        <el-row :gutter="20">
          <el-col :span="4">
            <computer-menus/>
          </el-col>
          <el-col :span="16">
            <computer-com/>
          </el-col>
          <el-col :span="4">3</el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import computerMenus from "../../components/index/categoryComputer/computerMenus";
import computerCom from "../../components/index/categoryComputer/computerCom";
export default {
  name: 'computerPage',
  components : {
    Header,Header2,computerMenus,computerCom
  }
}
</script>
<style scoped>
</style>
