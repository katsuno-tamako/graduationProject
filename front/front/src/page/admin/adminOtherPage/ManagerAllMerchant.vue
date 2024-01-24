<template>
  <div>
    查询所有商家
    <el-divider></el-divider>
    <div>

      <div style="text-align: center;height: 25px;width: 100%;background-color: #f5f5f5;border:1px solid gainsboro">
        <el-row :gutter="20">
          <el-col :span="4">店铺名称</el-col>
          <el-col :span="4">店铺地址</el-col>
          <el-col :span="4">店铺电话</el-col>
          <el-col :span="4">店铺邮箱</el-col>
          <el-col :span="4">店铺介绍</el-col>
          <el-col :span="4">操作</el-col>
        </el-row>
      </div>

      <div v-for="merchant in merchants" :key="merchant.id" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
        <el-row :gutter="20">

          <el-col :span="4" style="text-align: center">
            <div>
              <el-image
                style="height: 100px"
                :src="url_head+merchant.img"
              ></el-image>
            </div>
            <div>{{merchant.merchant_name}}</div>
          </el-col>
          <el-col :span="4">
            <div>{{merchant.merchant_address}}</div>
          </el-col>
          <el-col :span="4">
            <div>{{merchant.merchant_number}}</div>
          </el-col>
          <el-col :span="4">
            <div>{{merchant.merchant_email}}</div>
          </el-col>
          <el-col :span="4">
              <div>{{merchant.mer_intro}}</div>
          </el-col>
          <el-col :span="4">
            操作
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ManagerAllMerchant',
  created() {
    axios.get('/merchant/selectAllMerchant').then(
      (response) => {
        this.merchants = response.data;
      }
    );

    axios.get('/admin/getAdminSession').then(
      (res) => {
        this.stu = res.data;
        if(this.stu ==='NoLog'){
          console.log(res.data);
          this.$router.push('/adminLogin');
        }
      }
    )
  },
  data(){
    return {
      merchants : '',
      url_head : 'http://localhost:8906//'
    }
  }
}
</script>
<style scoped>
</style>
