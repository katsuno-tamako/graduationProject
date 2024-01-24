<template>
  <div>

    <div style="text-align: center">
      <el-row :gutter="20">
        <el-col :span="8">
          <div @click="stu=0">
          <el-card shadow="hover">
           所有订单
          </el-card></div></el-col>
        <el-col :span="8"><div @click="stu=1"><router-link to="/orderDeliverPage"><el-card shadow="hover">    未送达订单
        </el-card></router-link></div></el-col>
        <el-col :span="8"> <div @click="stu=1"> <router-link to="/orderReceivePage" @click="stu=1"><el-card shadow="hover">  用户未接受的商品
        </el-card></router-link></div></el-col>
      </el-row>
    </div>
    <div v-if="stu === 0">
        <div v-for="info in order" :key="info.id"  style="width: auto;margin: 20px 0;border:1px solid gainsboro">
          <div style="height: 25px;width: 100%;background-color: #f5f5f5">
            <span style="font-size: 13px;margin: 10% 15px;color: #475669">{{info.order_date}}</span>
            <span style="font-size: 13px;margin: 10% 15px;color: #475669">
            订单号：
            {{info.order_id}}
          </span>
          </div>

          <el-row :gutter="20" style="">
            <el-col :span="4" style="text-align: center">
              <el-image
                style=" height:150px"
                :src="url_head+info.commodity.main_img"
              ></el-image>
            </el-col>
            <el-col :span="8" style="padding: 40px 0">
              {{info.commodity.name}}
            </el-col>

            <el-col :span="6" style="padding: 40px 0;text-align: center">
            </el-col>
            <el-col :span="2" style="text-align: center;padding: 30px 0">
              <div style="font-size: 15px;color: #475669">
                x{{info.num}}
              </div>
              <div style="font-size: 15px;color: #475669">
                {{info.commodity.price*info.num}}￥
              </div>
            </el-col>
            <el-col :span="2" style="padding: 40px 0;text-align: center" >
              <div v-if="info.order_delivered=='未送达'">
                {{info.order_delivered}}
                <div style="margin: 10px 0">
                  <el-button size="mini" @click="editRs(info.order_id)"  type="primary">确认已送达</el-button>
                </div>

              </div>
              <div v-if="info.order_delivered=='已送达' && info.order_wait_receive=='未接收'">
                {{info.order_wait_receive}}
              </div>
              <div v-if="info.order_delivered=='已送达' && info.order_wait_receive=='已接收'">
                买家已收货
              </div>
              <div>
              </div>
            </el-col>
            <el-col :span="2"></el-col>
          </el-row>

        </div>
    </div>
    <div v-else>
      <router-view/>
    </div>

    <el-divider></el-divider>


  </div>
</template>

<script>
import axios from 'axios';
import orderDeliverCom from "./otOrder/orderDeliverCom";
import orderReceiveCom from "./otOrder/orderReceiveCom";
export default {
  name: 'orderPage',
  inject : ['reload'],
  components : {orderDeliverCom,orderReceiveCom},
  data () {
    return {
      stu : 0,
      panel : 'AllOrder',
      url_head : 'http://localhost:8906//',
      merchant_id : '',
      order : {
        commodity : {},
        num : '',
        sum : '',
      },
      pageSize : 10,
      curPage: 1,
      subOr : {
        order_id : '',
        order_delivered : ''
      }
    }
  },
  methods : {
    editRs(id){
      console.log(id);
      this.subOr.order_id = id;
      this.subOr.order_delivered = "已送达";
      axios.post('/order/updateOrderStatusDe',this.subOr).then();
      this.reload();
    }
  },
  created() {
    axios.get('/merchant/getMerchantId').then(
      (response) => {
        this.merchant_id = response.data;
        axios.get('/order/selectOrderByMerchant',{params : {merchant_id : this.merchant_id}}).then(
          (response) => {
            this.order = response.data;
          }
        );
      }
    );
  }
}
</script>
<style scoped>
  a{
    text-decoration:none

  }
</style>
