<template>
    <div>
      <div v-for="order in order_info" :key="order.id" >
        <div v-if="order.order_status==='已送达'" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
          <div style="width: 100%">
            <el-row style="background-color: #f5f5f5">
              <el-col :span="8">
                <span style="font-size: 13px;margin: 10% 15px;color: #475669">商品编号{{order.order_id}}</span>
              </el-col>
              <el-col :span="8">
              </el-col>
              <el-col :span="8"></el-col>
            </el-row>
            <div>
              <el-divider></el-divider>
              <div style="margin-left:20px;text-align: center">
                <el-row :gutter="10">
                  <el-col :span="6">收件人:{{order.order_tables[0].user_address.user_name}}</el-col>
                  <el-col :span="6">收件人手机：{{order.order_tables[0].user_address.phone}}</el-col>
                  <el-col :span="6">收件人住址：{{order.order_tables[0].user_address.address}}</el-col>
                  <el-col :span="6">
                    <el-button size="mini" disabled><i class="el-icon-check"></i>订单已完成</el-button>
                  </el-col>
                </el-row>
              </div>
              <el-divider></el-divider>
            </div>
          </div>
          <div>
            <div v-for="ot in order.order_tables" :key="ot.id" style="border:1px solid  gainsboro;padding: 20px 0">
              <el-row :gutter="20">
                <el-col :span="4" style="text-align: center">
                  <el-image
                    style="height: 120px"
                    :src="url_head+ot.commodity.main_img"
                  ></el-image>
                </el-col>
                <el-col :span="1" style="float:left;padding-right:15px;border-right: 1px solid #dddddd;height: 120px ">&nbsp;</el-col>
                <el-col :span="14" style="text-align: center">
                  <div style="margin-top: 40px">{{ot.commodity.name}}</div>
                </el-col>
                <el-col :span="1" style="float:left;padding-right:15px;border-right: 1px solid #dddddd;height: 120px ">&nbsp;</el-col>
                <el-col :span="4" style="text-align: center">
                  <div style="margin-top: 10px">
                    <div>{{ot.num}}件</div>
                    <el-divider></el-divider>
                    <div>共{{ot.num*ot.commodity.price}}元</div>
                  </div>
                </el-col>
              </el-row>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'order_finishPage',
  created() {
    axios.get('/order/selectOrderMerchantTableByMerchantId').then(
      (res)=>{
        this.order_info = res.data;
      }
    );
  },
  data(){
    return{
      dia_logistics : false,
      order_page : 0,
      url_head : 'http://localhost:8906//',
      order_info : {
        order_tables : '',
        order_status : ''
      },
      logistics : {
        logistics_company : '',
        logistics_status : '',
        dispatch : '',
        dispatch_people : '',
        receive : '',
        receive_people : ''
      },
      logisticsVO : {
        logistics : '',
        merchant_order : {
          order_id : ''
        }
      }
    }
  }
}
</script>
<style scoped>
</style>
