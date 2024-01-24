<template>
  <div>
    <div style="height: 50px;background-color: orange">
      <el-row :gutter="20">
        <el-col :span="21">
          <span style="visibility: hidden;">-</span>
        </el-col>
        <el-col :span="3">
          <el-button @click="logout" style="margin: 5px 0 0 0">注销</el-button>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'businessHeader',
  methods :{
    logout(){
      this.$store.state.merchant_id = "";
      axios.get('/merchant/merchantLogout').then();
      this.$router.push('/businessLogin');
    },
  }
}
</script>
<style scoped>

</style>
