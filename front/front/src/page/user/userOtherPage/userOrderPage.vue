<template>
  <div>
    <div><Header/></div>
    <el-divider></el-divider>
    <div style="width: auto;margin-left: 10%">
      <el-page-header @back="goBack" content="订单页面">
      </el-page-header>
      <el-divider></el-divider>
    </div>
    <el-card shadow="never" style="width:auto;margin: 0 10%">
      <span v-if="order_page===0"><el-button type="primary" @click="ord(0)">全部订单</el-button> </span><span v-else><el-button @click="ord(0)">全部订单</el-button></span>
      <span v-if="order_page===1"><el-button type="primary" @click="ord(1)">待收货</el-button> </span><span v-else><el-button @click="ord(1)">待收货</el-button></span>
      <span v-if="order_page===2"><el-button type="primary" @click="ord(2)">已送达</el-button> </span><span v-else><el-button @click="ord(2)">已送达</el-button></span>
    </el-card>

    <div style="margin: 10px 10%">
      <div v-if="merchant_order == ''">
        <el-card style="text-align: center">
          <span style="font-size: 20px">当前还没有订单噢</span>
        </el-card>
      </div>
    </div>

    <el-dialog
      :visible.sync="dia_sco"
      width="400px"
    >
      <template slot="title">
        <div style="width: auto;font-size: 20px;text-align: center">请评价</div>
      </template>
      <div class="block" style="width: auto;text-align: center">
        <el-rate v-model="score" ></el-rate>
        <el-divider></el-divider>
        <el-button @click="sco" type="primary">确定</el-button>
      </div>

    </el-dialog>



    <div v-if="order_page === 0">
    <div style="width: auto;margin: 0 10%">
      <div v-for="mer in merchant_order" :key="mer.id" style="margin: 20px 0">
        <div  style="width: auto;margin: 20px 0;border:1px solid gainsboro">
          <el-card shadow="never" :body-style="{ padding: '5px' }" style="background-color: #00ffe0">
            <el-row :gutter="10">
              <el-col :span="4">
                <div style="font-size: 14px;margin-top:2px;color: #475669">{{mer.order_date}}</div>
              </el-col>
              <el-col :span="8">
                <span style="font-size: 14px;color: #475669">订单编号:</span>
                <span style="font-size: 15px">{{mer.order_id}}</span>
              </el-col>
              <el-col :span="8">
                <span style="font-size: 15">
                </span>
              </el-col>
            </el-row>
          </el-card>
          <div></div>
          <el-row :gutter="10">
            <el-col :span="16">
              <div v-for="order in mer.order_tables" :key="order.id">
                    <el-row style="border: 1px solid whitesmoke">
                      <el-col :span="4" style="text-align: center">
                        <el-image
                          style="height: 100px"
                          :src="url_head+order.commodity.main_img"
                        ></el-image>
                      </el-col>
                      <el-col :span="14">
                        <div style="padding: 10px">
                          {{order.commodity.name}}
                        </div>
                      </el-col>
                      <el-col :span="3" style="margin-top: 30px">
                        <div v-if="order.status === '0' && mer.order_status==='已送达'">
                          <el-button size="mini" @click="op_dia_sco(order)">
                            请评价
                          </el-button>
                        </div>
                        <div v-if="order.status != '0'">
                          <el-button disabled size="mini">已评价</el-button>
                        </div>
                      </el-col>
                      <el-col :span="3">
                        <div style="padding: 5px;text-align: center">
                          {{order.num*order.commodity.price}}￥
                        </div>
                      </el-col>
                    </el-row>

              </div>
            </el-col>

            <el-col :span="4" style="text-align: center">

              <div style="margin-top: 30px">
                <i class="el-icon-user"></i>
                {{mer.order_tables[0].user_address.user_name}}
              </div>

            </el-col>

            <el-col :span="4">
              <div style="margin-top: 30px">
                <div v-if="mer.order_status === '待处理'"><i class="el-icon-loading"></i>商家未发货</div>
                <div v-if="mer.order_status === '运送中'"><i class="el-icon-truck"></i>{{mer.order_status}}</div>
                <div v-if="mer.order_status === '已送达'"><i class="el-icon-check"></i>{{mer.order_status}}</div>

              </div>
            </el-col>
          </el-row>

        </div>
      </div>
    </div>
    </div>
    <div v-if="order_page === 1">
      <div style="width: auto;margin: 0 10%">
        <div v-for="mer in merchant_order" :key="mer.id" style="margin: 20px 0">
          <div v-if="mer.order_status!='已送达'">
          <div  style="width: auto;margin: 20px 0;border:1px solid gainsboro">
            <el-card shadow="never" :body-style="{ padding: '5px' }" style="background-color: #00ffe0">
              <el-row :gutter="10">
                <el-col :span="4">
                  <div style="font-size: 14px;margin-top:2px;color: #475669">{{mer.order_date}}</div>
                </el-col>
                <el-col :span="8">
                  <span style="font-size: 14px;color: #475669">订单编号:</span>
                  <span style="font-size: 15px">{{mer.order_id}}</span>
                </el-col>
                <el-col :span="8">
                <span style="font-size: 15">
                </span>
                </el-col>
              </el-row>
            </el-card>
            <div></div>
            <el-row :gutter="10">
              <el-col :span="16">
                <div v-for="order in mer.order_tables" :key="order.id">
                  <el-row style="border: 1px solid whitesmoke">
                    <el-col :span="4" style="text-align: center">
                      <el-image
                        style="height: 100px"
                        :src="url_head+order.commodity.main_img"
                      ></el-image>
                    </el-col>
                    <el-col :span="16" style="padding: 10px">
                      <div>
                        {{order.commodity.name}}
                      </div>
                    </el-col>
                    <el-col :span="4" style="padding: 5px">
                      {{order.num*order.commodity.price}}￥
                    </el-col>
                  </el-row>

                </div>
              </el-col>

              <el-col :span="4" style="text-align: center">

                <div style="margin-top: 30px">
                  <i class="el-icon-user"></i>
                  {{mer.order_tables[0].user_address.user_name}}
                </div>

              </el-col>

              <el-col :span="4">
                <div style="margin-top: 30px">
                  <div v-if="mer.order_status === '待处理'"><i class="el-icon-loading"></i>商家未发货</div>
                  <div v-if="mer.order_status === '运送中'"><i class="el-icon-truck"></i>{{mer.order_status}}</div>
                  <div v-if="mer.order_status === '已送达'"><i class="el-icon-check"></i>{{mer.order_status}}</div>

                </div>
              </el-col>
            </el-row>

          </div>
          </div>
        </div>
      </div>
    </div>
    <div v-if="order_page === 2">
      <div style="width: auto;margin: 0 10%">
        <div v-for="mer in merchant_order" :key="mer.id" style="margin: 20px 0">
          <div v-if="mer.order_status ==='已送达'">
            <div  style="width: auto;margin: 20px 0;border:1px solid gainsboro">
              <el-card shadow="never" :body-style="{ padding: '5px' }" style="background-color: #00ffe0">
                <el-row :gutter="10">
                  <el-col :span="4">
                    <div style="font-size: 14px;margin-top:2px;color: #475669">{{mer.order_date}}</div>
                  </el-col>
                  <el-col :span="8">
                    <span style="font-size: 14px;color: #475669">订单编号:</span>
                    <span style="font-size: 15px">{{mer.order_id}}</span>
                  </el-col>
                  <el-col :span="8">
                <span style="font-size: 15">
                </span>
                  </el-col>
                </el-row>
              </el-card>
              <div></div>
              <el-row :gutter="10">
                <el-col :span="16">
                  <div v-for="order in mer.order_tables" :key="order.id">
                    <el-row style="border: 1px solid whitesmoke">
                      <el-col :span="4" style="text-align: center">
                        <el-image
                          style="height: 100px"
                          :src="url_head+order.commodity.main_img"
                        ></el-image>
                      </el-col>
                      <el-col :span="14" >
                        <div style="padding: 10px">
                          {{order.commodity.name}}
                        </div>
                      </el-col>
                      <el-col :span="3"  style="margin-top: 30px">
                        <div v-if="order.status === '0' && mer.order_status==='已送达'">
                          <el-button size="mini" @click="op_dia_sco(order)">
                            请评价
                          </el-button>
                        </div>
                        <div v-if="order.status != '0'">
                          <el-button disabled size="mini">已评价</el-button>
                        </div>
                      </el-col>
                      <el-col :span="3">
                        <div style="padding: 5px">
                          {{order.num*order.commodity.price}}￥
                        </div>

                      </el-col>
                    </el-row>

                  </div>
                </el-col>

                <el-col :span="4" style="text-align: center">

                  <div style="margin-top: 30px">
                    <i class="el-icon-user"></i>
                    {{mer.order_tables[0].user_address.user_name}}
                  </div>

                </el-col>

                <el-col :span="4">
                  <div style="margin-top: 30px">
                    <div v-if="mer.order_status === '待处理'"><i class="el-icon-loading"></i>商家未发货</div>
                    <div v-if="mer.order_status === '运送中'"><i class="el-icon-truck"></i>{{mer.order_status}}</div>
                    <div v-if="mer.order_status === '已送达'"><i class="el-icon-check"></i>{{mer.order_status}}</div>

                  </div>
                </el-col>
              </el-row>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../../components/index/Header";
export default {
  name: 'userOrderPage',
  created() {
    axios.get('/order/selectAllMerchantOrderByUserId').then(
      (res) => {
        this.merchant_order = res.data;
      }
    );

  },
  components : {
    Header
  },
  methods : {
    ord(id){
      this.order_page = id;
    },
    goBack(){
      this.$router.go(-1);
    },
    op_dia_sco(order){
      this.dia_sco = true;
      this.commodityScoreVO.commodity_id = order.commodity_id;
      this.commodityScoreVO.order_id = order.order_id;
    },
    sco(){
      this.commodityScoreVO.score = this.score;
      axios.post('/order/scoreCommodity',this.commodityScoreVO).then();
      this.dia_sco = false;
      this.score = 0;
      axios.get('/order/selectAllMerchantOrderByUserId').then(
        (res) => {
          this.merchant_order = res.data;
        }
      );
    }
  },
  data(){
    return{
      order_page : 0,
      url_head : 'http://localhost:8906//',
      merchant_order : {},
      evaluate : '',
      score : '',
      dia_sco : false,
      commodityScoreVO : {
        commodity_id : '',
        order_id : '',
        score : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
