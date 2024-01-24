<template>
  <div>

    <div v-for="order in order_info" :key="order.id" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
      <div v-if="order">
        <el-row :gutter="10" style="">
          <el-col :span="3" style="text-align: center">
            <el-image
              style="height: 80px"
              :src="url_head+order.commodity.main_img"
            ></el-image>
          </el-col>
          <el-col :span="8" style="padding-top: 20px">
            <span>
              {{order.commodity.name}}
            </span>
          </el-col>
          <el-col :span="8" style="padding-top: 20px">
            <span>收货人:{{order.user_address.user_name}}</span>
          </el-col>
          <el-col :span="5" style="padding-top: 20px">
            <i class="el-icon-truck"></i>配送中
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'UserDelivered',
  created() {
    axios.get('/order/selectOrderByDelivered',{params:{delivered:this.de}}).then(
      (response) => {
        this.order_info = response.data;
      }
    );
  },
  data(){
    return{
      de : '未送达',
      url_head : 'http://localhost:8906//',
      order_info : {
        order_delivered : '',
        commodity : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
