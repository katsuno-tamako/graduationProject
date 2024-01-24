<template>
  <div>分类管理
    <el-tabs>
      <el-tab-pane label="图书" name="first">
        <ManBookTypeCom/>
      </el-tab-pane>
      <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
import ManBookTypeCom from "./ManType/ManBookTypeCom";
export default {
  name: 'adminManType',
  components : {ManBookTypeCom}
}
</script>
<style scoped>
</style>
