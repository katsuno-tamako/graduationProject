<template>
  <div>
    <el-card>
      <div>图书分类</div>
      <div>
        <el-divider content-position="left">文学</el-divider>
            <el-row :gutter="10">
              <el-col :span="6">小说</el-col>
              <el-col :span="6">传记</el-col>
              <el-col :span="6">散文</el-col>
              <el-col :span="6">科幻</el-col>
            </el-row>
      </div>
    </el-card>




  </div>
</template>

<script>
export default {
    name: 'bookMenus'
}
</script>
<style scoped>
</style>
