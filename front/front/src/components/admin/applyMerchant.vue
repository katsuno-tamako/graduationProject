<template>
  <div>
    <div>申请管理</div>
    <el-divider></el-divider>
    <div v-for="merchant in apply_merchant" :key="merchant.id">
      账号：{{merchant.account}}
      密码：{{merchant.password}}
      生成ID:{{merchant.merchant_id}}
      邮箱:{{merchant.merchant_email}}
      日期:{{merchant.apply_date}}
      状态:{{merchant.status}}
      <el-button @click="suc(merchant)">批准</el-button>
    </div>
    <div></div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'applyMerchant',
  inject : ['reload'],
  methods : {
    suc(apply_merchant){
      axios.post('/admin/updateApplyStatus',apply_merchant).then();
      this.reload();
    }
  },
  created() {
    axios.get('/admin/selectAllApplyMerchant').then(
      (response) => {
        console.log(response.data)
        this.apply_merchant = response.data;
    }
    );
  },
  data(){
    return {
      apply_merchant : {
        apply_date : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
