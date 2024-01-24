<template>
  <div>
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
</template>

<script>
import axios from 'axios';
export default {
  name: 'orderReceiveCom',
  created() {
    axios.get('/order/selectOrderByReceiveByMerchantId').then(
      (res) => {
        this.order = res.data;
      }
    );
  },
  data(){
    return {
      url_head : 'http://localhost:8906//',
      order : {
        commodity : {},
        num : '',
        sum : '',
      },
    }
  }
}
</script>
<style scoped>
</style>
