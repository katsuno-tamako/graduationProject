<template>
  <div>
    <h3>添加{{computer.category}}</h3>
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
        <el-button type="primary" @click="insertComputer()">添加</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'insertCommodity_Computer',
  data () {
    return  {
      computer : {
        computer_name : '',
        price : '',
        computer_type : '',
        cpu : '',
        memory : '',
        disk : '',
        system : '',
        resolution : '',
        brand : '',
        category : '电脑'
      }
    }
  },
  methods : {
    insertComputer(){
      console.log(this.computer.price);
      console.log(this.computer.cpu);
      axios.post('/computer/insertComputer',this.computer).then(
        function (response) {
          console.log(response.data);
        }
      );
    }
  }
}
</script>
<style scoped>
</style>
