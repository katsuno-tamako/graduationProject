<template>
  <div>
    <div style="width: auto;height: 50px;background-color: #99a9bf">
      <div style="width: auto;text-align: right">
        <div style="padding: 2px 20px">
          <el-button type="text" @click="logout">
            <div style="color: black;font-size: 20px">
              <i class="el-icon-back"></i>
              注销
            </div>
          </el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'adminHead',
  created() {

  },
  methods: {
    logout(){
      axios.get('/admin/logoutAdmin').then();
      this.$router.push('/adminLogin').then();
    }
  }
}
</script>
<style scoped>
</style>
