<template>
  <div>

    <businessHeader/>
    <business-menu-com/>
    <div style="width: auto;margin: 0 10%">
    <el-card shadow="never">
      <div>
        <el-collapse>
          <el-collapse-item >
            <template slot="title">
              <div style="font-size: 20px;width: auto;text-align: center"><i class="header-icon el-icon-search"></i>按照单号查询</div>
            </template>
            <div style="text-align: center">
              <el-input style="width:90%" v-model="sel_order"></el-input>
              <el-button @click="selectOrder" icon="el-icon-search" circle></el-button>
            </div>
          </el-collapse-item>
        </el-collapse>

      </div>
    </el-card>
    <el-divider></el-divider>
    <div style="text-align: center">
      <el-row :gutter="20">
        <el-col :span="6">
          <div @click="disPage(0)"><el-card shadow="never">所有订单</el-card></div>
        </el-col>
        <el-col :span="6">
          <div @click="disPage(1)">
            <router-link to="/order_noLogisticsPage">
              <el-card shadow="never">未配送</el-card>
            </router-link>
          </div>
        </el-col>
        <el-col :span="6">
          <div @click="disPage(1)">
            <router-link to="/order_deliverPage">
              <el-card shadow="never">未送达订单</el-card>
            </router-link>
          </div>
        </el-col>
        <el-col :span="6">
          <div @click="disPage(1)">
            <router-link to="/order_finishPage">
              <el-card shadow="never">已完成订单</el-card>
            </router-link>
          </div>
        </el-col>

      </el-row>
    </div>
    <el-divider></el-divider>

    <div v-if="order_page===0">

      <div v-for="order in order_info" :key="order.id" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
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
                    <div v-if="order.order_status==='待处理'">
                      <el-button size="mini" @click="openLogisticsDia(order.order_tables[0].user_address,order.order_id)">提交快递订单</el-button>
                    </div>
                    <div v-if="order.order_status==='运送中'">
                      <el-button size="mini"><i class="el-icon-truck"></i>运送中，查看物流</el-button>
                    </div>
                    <div v-if="order.order_status==='已送达'">
                      <el-button size="mini" disabled><i class="el-icon-check"></i>订单已完成</el-button>
                    </div>
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

    <div v-else>
      <router-view/>
    </div>

    <!--  所有订单  -->
    <el-dialog
      :visible.sync="dia_logistics"
      title="提交快递订单"
    >
      <el-divider></el-divider>

      <el-form label-width="100px">

        <el-form-item label="选择快递公司">
          <el-input v-model="logistics.logistics_company"></el-input>
        </el-form-item>

        <el-form-item label="发货人">
          <el-input v-model="logistics.dispatch_people"></el-input>
        </el-form-item>

        <el-form-item label="发货地">
          <el-input v-model="logistics.dispatch"></el-input>
        </el-form-item>

        <el-form-item label="收货人">
          <el-input v-model="logistics.receive_people"></el-input>
        </el-form-item>

        <el-form-item label="收货地">
          <el-input v-model="logistics.receive"></el-input>
        </el-form-item>

      </el-form>
      <el-divider></el-divider>
      <el-divider></el-divider>
      <el-button @click="subLogisticsInfo" type="primary">确定</el-button>
      <el-button @click="dia_logistics=false">取消</el-button>
    </el-dialog>
    <!--  提交快递  -->

    <el-dialog
      :visible.sync="dia_sel_order"
      title="查询订单"
    >
      <div v-if="selectOrderById!=''">
      <el-divider>订单号：{{selectOrderById.order_id}}</el-divider>
      <el-card shadow="never">
        <div style="text-align: center">
          <el-row :gutter="10">
            <el-col :span="8">
              <div>收货人：</div>
              <div>{{selectOrderById.user_address.user_name}}</div>
            </el-col>
            <el-col :span="8">
              <div>收货地址：</div>
              <div>{{selectOrderById.user_address.address}}</div>

            </el-col>
            <el-col :span="8">
              <div>联系电话：</div>
              <div>{{selectOrderById.user_address.phone}}</div>
            </el-col>
          </el-row>
        </div>
      </el-card>
      <el-row>
        <el-col :span="18">
          <el-card shadow="never" v-for="or in selectOrderById.order_tables" :key="or.id">
            <el-row :gutter="10">
              <el-col span="6" style="text-align: center">
                <el-image
                  :src="url_head+or.commodity.main_img"
                  style="height: 100px"
                ></el-image>
              </el-col>
              <el-col span="12" style="text-align: center">
                <div>
                  {{or.commodity.name}}
                </div>
              </el-col>
              <el-col span="6" style="text-align: center">
                {{or.commodity.price*or.num}}$
                <el-divider></el-divider>
                {{or.num}}个
              </el-col>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="6">
          <div style="margin: 50px 25px">
            <div v-if="selectOrderById.order_status==='待处理'">
              <el-button size="mini" @click="openLogisticsDia(selectOrderById.user_address,selectOrderById.order_id)">提交快递订单</el-button>
            </div>
            <div v-if="selectOrderById.order_status==='运送中'">
              <el-button size="mini"><i class="el-icon-truck"></i>运送中，查看物流</el-button>
            </div>
            <div v-if="selectOrderById.order_status==='已送达'">
              <el-button size="mini" disabled><i class="el-icon-check"></i>订单已完成</el-button>
            </div>
          </div>
        </el-col>
      </el-row>
      </div>
      <div v-else>
        <div>未查找到订单</div>
      </div>
      <el-button @click="dia_sel_order=false">确定</el-button>
    </el-dialog>

    <!--  查询订单  -->

    </div>
  </div>
</template>

<script>
import axios from 'axios';
import businessHeader from "../theme/businessHeader";
import businessMenuCom from "../theme/businessMenuCom";
export default {
  name: 'orderMainPage',
  components: {businessHeader,businessMenuCom},
  inject : ['reload'],
  created() {
    axios.get('/order/selectOrderMerchantTableByMerchantId').then(
      (res)=>{
        this.order_info = res.data;
      }
    );
  },
  methods : {
    selectOrder(){
      this.dia_sel_order = true;
      console.log(this.sel_order);
      axios.get('/order/selectOrderById',{params:{order_id:this.sel_order}}).then(
        (res) => {
          this.selectOrderById = res.data;
        }
      )
    },
    openLogisticsDia(address,merchant_id){
      this.logistics.receive = address.address;
      this.logistics.receive_people = address.user_name;
      this.logisticsVO.merchant_order.order_id = merchant_id;
      this.dia_logistics = true;
    },
    disPage(i){
      this.order_page = i;
    },
    subLogisticsInfo(){
      //插入订单表
      this.logisticsVO.logistics = this.logistics;
      axios.post('/logistics/insertLogisticsInfo',this.logisticsVO).then(
        (res) => {
          axios.get('/order/selectOrderMerchantTableByMerchantId').then(
            (res)=>{
              this.order_info = res.data;
              this.dia_logistics = false;
            }
          );
        }
      );
      // this.reload();
    }
  },
  data(){
    return{
      dia_sel_order : false,
      sel_order : '',
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
      },
      selectOrderById : {
        user_address : '',
        order_tables : []
      }
    }
  }
}
</script>
<style scoped>
  a {text-decoration: none}
</style>
