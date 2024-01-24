<template>
    <div>
      <el-row>
        <el-col :span="23">
          <el-input v-model="input" placeholder="请输入内容"></el-input>
        </el-col>
        <el-col :span="1">
          <el-button icon="el-icon-search" circle @click="search"></el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
export default {
  name: 'HeaderSearch',
  data () {
    return {
      input : ''
    }
  },
  methods : {
    search(){
      this.$router.push({path : '/searchPage', query:{keyword : this.input}});
      location.reload();
    }
  }
}
</script>
<style scoped>
</style>
