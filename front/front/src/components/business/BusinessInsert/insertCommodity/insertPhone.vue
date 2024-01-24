<template>
  <div>
    <span>插入手机</span>
    <el-divider></el-divider>
    <el-form :model="phone" label-width="80px">

      <el-form-item label="手机名称">
        <el-input v-model="phone.phone_name"></el-input>
      </el-form-item>

      <el-form-item label="CPU">
        <el-input v-model="phone.phone_cpu"></el-input>
      </el-form-item>

      <el-form-item label="价钱">
        <el-input v-model="phone.phone_price"></el-input>
      </el-form-item>

      <el-form-item label="内存">
        <el-input v-model="phone.phone_memory"></el-input>
      </el-form-item>


      <el-form-item label="手机系统">
        <el-input v-model="phone.phone_system"></el-input>
      </el-form-item>

      <el-form-item label="存储容量">
        <el-input v-model="phone.phone_storage"></el-input>
      </el-form-item>

      <el-form-item label="品牌">
        <el-input v-model="phone.phone_brand"></el-input>
      </el-form-item>

      <el-form-item label="重量">
        <el-input v-model="phone.phone_weight"></el-input>
      </el-form-item>

      <el-form-item label="前置像素">
        <el-input v-model="phone.main_pixel"></el-input>
      </el-form-item>

      <el-form-item label="长度">
        <el-input v-model="phone.phone_length"></el-input>
      </el-form-item>

      <el-form-item label="分辨率">
        <el-input v-model="phone.phone_resolution"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="insertPhone()">添加</el-button>
        <el-button>取消</el-button>
      </el-form-item>


    </el-form>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'insertPhone',
  data () {
    return {
      phone : {
        phone_name : '',
        commodity_id : '',
        phone_cpu : '',
        phone_price : '',
        phone_memory : '',
        phone_system : '',
        phone_storage : '',
        phone_brand : '',
        phone_length : '',
        phone_weight : '',
        main_pixel : '',
        phone_resolution : ''
      }
    }
  },
  methods : {
    insertPhone(){
      axios.post('/phone/insertPhone',this.phone).then();
    }
  }
}
</script>
<style scoped>
</style>
