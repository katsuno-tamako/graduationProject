<template>
  <div>
    <div>
      <Header/>
    </div>
    <el-divider></el-divider>
    <div style="font-size: 50px;text-align: center">
      结算页面
    </div>
    <div style="margin: 0 10%">
      <span>填写并核对信息</span>

      <el-divider></el-divider>

      <el-card style="font-size: 15px;color: #475669;margin: 0 10%">
        收货人信息:
        <el-divider></el-divider>
        <div v-for="address in user_address" :key="address.id">
          <el-radio v-model="chooseAdd" :label="address.user_address_id"  style="margin: 5px 0">
              <span>
                <span style="margin: 10px"><span style="color: black">收货人：</span>{{address.user_name}}</span>
                <span style="margin: 10px"><span style="color: black">收货地址：</span>{{address.address}}</span>
              </span>
          </el-radio>
        </div>
        <div v-if="user_address == ''">
          <el-button icon="el-icon-plus" @click="toAddAddress">添加地址</el-button>
        </div>
      </el-card>

      <el-divider></el-divider>
      <div style="font-size: 15px;color: #475669;margin: 0 10%">
        <el-card>
          <span style="font-size: 15px;color: #475669">货物清单：</span>
          <el-divider></el-divider>
          <div v-for="p in payId" :key="p.id">
            <el-row :gutter="10" style="margin: 0 10px">
              <el-col :span="6" style="text-align: center">
                <el-image
                  style="height: 100px"
                  :src="url_head+p.commodity.main_img">
                </el-image>
              </el-col>
              <el-col :span="12">
                <span>{{p.commodity.name}}</span>
              </el-col>
              <el-col :span="4">
                <span>{{p.commodity.price}}￥</span>
              </el-col>
              <el-col :span="2">
                <span>x{{p.num}}</span>
              </el-col>
            </el-row>
          </div>
          <el-divider></el-divider>
          <span>共计：{{sum}}</span>
        </el-card>
      </div>
      <div style="margin: 5px 10%">
        <el-button @click="pay2" :disabled="!chooseAdd">支付</el-button>
      </div>
    </div>
    <el-divider></el-divider>
    <div>
<!--      <el-button @click="pay2">test</el-button>-->

    </div>
  </div>
</template>

<script>
import Header from "../Header";
import axios from 'axios';
export default {
  name: "paymentPage",
  components: {
    Header
  },
  data () {
    return {
      pay_info : {
        user_address : '',
        commodities : '',
        merchant_id : '',
        num : '',
        shopping_carts : ''
      },
      order_product : [],
      payId : this.$route.query.choice,
      goods : {
        merchantID : '',
        commodity : {
          merchantID : ''
        },
        commodity_id : '',
        num : '',
      },
      user_address : {
        user_name : '',
        address : '',
        tag : '',
        user_address_id : '',
        default_address : ''
      },
      chooseAdd : '',
      url_head : 'http://localhost:8906//',
      sum : '',
      order_info : '',
      shopping_carts : this.$route.query.choice,
      order_table : {
        commodity : {},
        user_info : {},
        user_address : {},

      },
      commodities : [],
      choice_commodity : '',
      choice_merchant : [],
      new_choice_merchant : [],

    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        axios.get('/user/selectUserAddress',{params : {user_id : response.data}}).then(
          (response) => {
            console.log("1"+response.data);
            this.user_address = response.data;
          }
        );
      }
    );
    this.choice_commodity = this.$route.query.choice;
    console.log("payId"+this.payId);
    for(let i=0;i<this.payId.length;i++) {
      this.sum = Number(this.sum)+Number(this.payId[i].num*this.payId[i].commodity.price);
    }

    for(let i=0;i<this.choice_commodity.length;i++){
      console.log(this.choice_commodity[i].merchant_info.merchant_name);
      this.choice_merchant.push(this.choice_commodity[i].merchant_info.merchant_id)
    }
    //
    for(let j=0;j<this.choice_merchant.length;j++){
      if(this.new_choice_merchant.indexOf(this.choice_merchant[j])===-1){
        this.new_choice_merchant.push(this.choice_commodity[j].merchant_info.merchant_id)
      }
    }
    console.log("new_choice_merchant"+this.new_choice_merchant);
  },
  methods : {
    pay(){

      this.order_table.user_address = this.chooseAdd;
      this.shopping_cart = this.payId;
      console.log(this.commodities)
      console.log(this.order_table.user_address)
      axios.post('/order/insertOrderTable', {data:{order_table:this.order_table,shopping_cart:this.shopping_cart}}).then();

      // axios.post('/order/payOrder', this.payId,{params : {address_id : this.chooseAdd}}).then();
      this.$router.push('/');
    },
    pay2(){
      // for(let i=0;i<this.new_choice_merchant.length;i++){
      //   this.order_product[i].merchant_id = this.new_choice_merchant[i];
      // }
      this.pay_info.shopping_carts = this.payId;
      this.pay_info.merchant_id = this.new_choice_merchant;
      this.pay_info.user_address = this.chooseAdd;
      this.pay_info.commodities = this.$route.query.choice;
      axios.post('/pay/payment',this.pay_info).then();
      this.$router.push('/paySuccess');       //支付成功后跳转页面
    },
    toAddAddress(){
      this.$router.push('/userAddressPage')
    }
  }
}
</script>



