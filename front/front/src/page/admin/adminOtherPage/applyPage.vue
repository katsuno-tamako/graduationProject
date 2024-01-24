<template>
  <div>
    <div>商家申请管理</div>
    <el-divider></el-divider>
    <div v-for="merchant in apply_merchant" :key="merchant.id">
      <div style="margin-top: 10px">
        <div style="width: auto;background-color: #00ffe5;font-size: 13px">
          申请日期：{{merchant.apply_date}}
        </div>
        <el-card shadow="never">
          <el-row :gutter="10">
            <el-col :span="8">
              <div>申请账号：
                <span>{{merchant.account}}</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div>邮箱：
                <span>{{merchant.merchant_email}}</span>
              </div>
            </el-col>
            <el-col :span="4">
              申请状态:
                <span>{{merchant.status}}</span>
            </el-col>
            <el-col :span="4">
              <div v-if="merchant.status==='Yes'">
                <el-button size="mini" disabled>已批准</el-button>
              </div>
              <div v-else>
                <el-button size="mini" @click="suc(merchant)">批准</el-button>
              </div>
            </el-col>
          </el-row>
        </el-card>
      </div>
    </div>
    <div></div>


  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'applyPage',
  inject : ['reload'],
  created() {

    axios.get('/admin/getAdminSession').then(
      (res) => {
        this.stu = res.data;
        if(this.stu ==='NoLog'){
          console.log(res.data);
          this.$router.push('/adminLogin');
        }
      }
    )

    axios.get('/admin/selectAllApplyMerchant').then(
      (response) => {
        console.log(response.data)
        this.apply_merchant = response.data;
      }
    );
  },
  methods:{
    suc(apply_merchant){
      axios.post('/admin/updateApplyStatus',apply_merchant).then();
      this.reload();
    }
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
