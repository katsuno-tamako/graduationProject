<template>
  <div>
    <h1>个人信息</h1>
    <el-card class="box-card">
      <p>显示个人的信息</p>
      <p>商家ID:{{merchant_info.merchant_id}}</p>
      <p>店铺名字:{{merchant_info.merchant_name}}</p>
      <p>店铺地址:{{merchant_info.merchant_address}}</p>
      <p>店铺电话:{{merchant_info.merchant_number}}</p>
      <p>店铺邮箱:{{merchant_info.merchant_email}}</p>
    </el-card>


  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'businessInfo',
  data () {
    return {
      mid : '',
      merchant_info : ''
    }
  },
  created() {
    axios.get('/merchant/selectMerchantByMerchantID').then(
      (response) => {
        this.merchant_info = response.data;
        console.log(response.data);
      }
    );
  }
}
</script>
<style scoped>
</style>
