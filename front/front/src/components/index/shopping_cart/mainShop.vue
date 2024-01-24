<template>
  <div>
    <div style="width: auto;margin: 0 5%">
      <el-divider></el-divider>
      <el-row :gutter="5">
        <el-col :span="1">
        </el-col>

        <el-col :span="23">

          <div v-for="mer in shop_mer" :key="mer.id">

            <el-card shadow="never">
              <div>{{mer.merchant_info.merchant_name}}店铺</div>
              <el-divider></el-divider>
              <el-card shadow="never">
                <div v-for="s in shop" :key="s.id">
                  <div v-if="s.merchant_id===mer.merchant_info.merchant_id">
                    <el-row :gutter="10">
                      <el-col :span="1" style="margin-top: 60px">
                        <el-checkbox-group v-model="choice">
                        <el-checkbox :label="s">&nbsp;</el-checkbox>
                        </el-checkbox-group>
                      </el-col>
                      <el-col :span="3" style="text-align: center">
                        <el-image
                          :src="url_head+s.commodity.main_img"
                          style="height: 120px"
                        ></el-image>
                      </el-col>
                      <el-col :span="6">
                        <div>{{s.commodity.name}}</div>
                      </el-col>
                      <el-col :span="3" style="text-align: center">
                        单价：{{s.commodity.price}}￥
                      </el-col>
                      <el-col :span="5">
                        <div>
                          <el-input-number v-model="s.num" :min="1" @change="handleChange(s.num,s.commodity.commodity_id)" label=""></el-input-number>
                        </div>
                      </el-col>
                      <el-col :span="3">
                        {{s.commodity.price*s.num}}￥
                      </el-col>
                      <el-col :span="1">
                        <el-button @click="removeS(s.commodity.commodity_id)">移除</el-button>

                      </el-col>
                    </el-row>
                  </div>
                </div>
              </el-card>
            </el-card>
          </div>
        </el-col>
      </el-row>
      <el-divider></el-divider>

      <div>
        <span style="font-size: 20px">总价：</span>
        {{all_price}}￥
      </div>
      <el-divider></el-divider>
      <div>
        <el-button @click="sub" :disabled="choice.length===0">下一步</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'mainShop',
  data () {
    return {
      all_price : 0,
      shop : {
        num : '',
        commodity : {
          name : '',
          price : '',
          main_img : ''
        }
      },
      url_head : 'http://localhost:8906//',
      choice : [],
      c : '',
      user_id : '',
      shop_mer : ''
    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        this.user_id = response.data;
        axios.get('/order/selectShoppingCartByUserId',{params : {commodity_id : this.user_id}}).then(
          (response) => {
            console.log("status"+response.status)
            this.shop = response.data;

          }

        );
      }
    );

    axios.get('/order/selectShopMerchant').then(
      (res) => {
        console.log(res.data)
        this.shop_mer = res.data;
      }
    )

  },
  methods : {
    handleChange(value,commodity_id){
      axios.get('/order/updateNum',{params : {
          commodity_id : commodity_id,
          num : value
        }}).then();
    },
    sub(){
      this.$router.push({path: '/paymentPage',query : {choice : this.choice}});
    },
    removeS(commodity_id){
      axios.get('/order/deleteShoppingByCommodityId',{params : {commodity_id : commodity_id}}).then();
      location.reload();
    }
  },
  watch : {
    choice : function () {
      let s = 0;
      console.log(this.choice)
      for(let i = 0;i<this.choice.length;i++){
        s = s + this.choice[i].commodity.price*this.choice[i].num
        console.log(s);
        console.log(this.choice[i].commodity.price*this.choice[i].num)
      }
      this.all_price = s;
    },
    shop : function () {
      console.log("--")
    }
  }

}
</script>
<style scoped>

  .check_css{
    display: block;
    text-align: left;
    margin-top: 20px;
  }

  .el-checkbox {
    display: block;
    text-align: left;
  }


</style>
