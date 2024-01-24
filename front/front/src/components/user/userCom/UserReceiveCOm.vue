<template>
  <div>
    <div v-for="order in order_info" :key="order.id">
      <div style="width: auto;margin: 20px 0;border:1px solid gainsboro" v-if="order.order_delivered=='已送达'">
      <el-row :gutter="10">
        <el-col :span="4" style="text-align: center">
          <el-image
            style="height: 80px"
            :src="url_head+order.commodity.main_img"
          ></el-image>
        </el-col>
        <el-col :span="6" style="padding-top: 20px">
          <span>
            {{order.commodity.name}}
          </span>
        </el-col>
        <el-col :span="6" style="padding-top: 20px">
          <span>收货人:{{order.user_address.user_name}}</span>
        </el-col>
        <el-col :span="4" style="padding-top: 20px">
          已送达
        </el-col>
        <el-col :span="4" style="padding-top: 20px">
          <el-button @click="subRs(order.order_id)">确认接受</el-button>
        </el-col>
      </el-row>
    </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'UserReceiveCOm',
  inject : ['reload'],
  created() {
    axios.get('/order/selectOrderByReceive',{params:{receive:this.rec}}).then(
      (response) => {
        this.order_info = response.data;
      }
    )
  },
  methods:{
    subRs(id){
      this.info.order_id = id;
      this.info.order_wait_receive = "已接收";
      axios.post('/order/updateOrderStatusRs',this.info).then();
      this.reload();
    }

  },
  data(){
    return{
      rec : '未接收',
      url_head : 'http://localhost:8906//',
      order_info : {},
      info : {
        order_id : '',
        order_wait_receive : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
