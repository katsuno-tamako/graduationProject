<template>
    <div>
      <div>编辑</div>
      <el-divider></el-divider>
      <el-form :model="computer" label-width="80px">
        <el-form-item label="电脑名称">
          <el-input v-model="computer.computer_name"></el-input>
        </el-form-item>

        <el-form-item label="价钱">
          <el-input v-model="computer.price"></el-input>
        </el-form-item>

        <el-form-item label="电脑类型">
          <el-input v-model="computer.computer_type"></el-input>
        </el-form-item>

        <el-form-item label="CPU型号">
          <el-input v-model="computer.cpu"></el-input>
        </el-form-item>

        <el-form-item label="内存">
          <el-input v-model="computer.memory"></el-input>
        </el-form-item>

        <el-form-item label="硬盘容量">
          <el-input v-model="computer.disk"></el-input>
        </el-form-item>

        <el-form-item label="操作系统">
          <el-input v-model="computer.system"></el-input>
        </el-form-item>

        <el-form-item label="分辨率">
          <el-input v-model="computer.resolution"></el-input>
        </el-form-item>

        <el-form-item label="品牌">
          <el-input v-model="computer.brand"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="update()">修改</el-button>
          <el-button>取消</el-button>
          <el-button type="danger" @click="deleteCommodity">删除</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'editComputerCommodities',
  data () {
    return {
      computer : '',
      commodity_id : ''
    }
  },
  created() {
    this.commodity_id = this.$route.query.commodity_id;
    axios.get('/computer/selectComputerById',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.computer = response.data;
      }
    );
  },
  methods : {
    update(){
      axios.post('/computer/updateComputerById',this.computer).then();
      this.$router.push('/businessCommodity');
    },
    deleteCommodity(){
      axios.get('/book/deleteBookCommodity',{params : {'commodity_id' : this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
    }
  }
}
</script>
<style scoped>
</style>
