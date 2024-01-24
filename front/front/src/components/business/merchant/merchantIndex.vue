<template>
  <div>
    <Header></Header>
    <el-divider></el-divider>
    <div style="margin: 0 10px">
      <el-row :gutter="20">
        <el-col :span="4">
          <el-card>
            商品分类
          </el-card>
        </el-col>
        <el-col :span="16">
          <div>
            <div>{{keyword}}</div>
            <el-row :gutter="20">
              <el-col :span="8" v-for="com in commodity" :key="com.id" style="padding: 10px">
                <el-card>
<!--                  <router-link target="_blank" :to="{path : '/buyBookPage' , query : {id : book.commodityID}}" style="text-decoration:none">-->
                    <div @click="editPath(com)">
                      <div style="text-align: center">
                        <el-image
                          style="width: 150px;height: 200px"
                          :src="url_head+com.main_img"
                        >
                        </el-image>
                        <div style="height: 30px">{{com.name}}</div>
                      </div>
                      <div style="height: 20px">￥{{com.price}}</div>
                    </div>
<!--                  </router-link>-->

                  <el-divider></el-divider>

                  <div>
                    <add-shop-cart :commodity_id="com.commodity_id" :num="1"/>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-divider></el-divider>

          </div>
        </el-col>
        <el-col :span="4"></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import Header from "../../index/Header";
import Header2 from "../../index/Header2";
import addShopCart from "../../../page/otherPage/addShopCart/addShopCart";

import axios from 'axios'
export default {
  name: 'merchantIndex',
  components:{
    Header,Header2,addShopCart
  },
  methods:{
    editPath(info){
      if(info.category==='图书'){this.$router.push({path : '/buyBookPage', query:{id : info.commodity_id}});}
      if(info.category==='电脑'){this.$router.push({path : '/buyComputerPage', query:{id : info.commodity_id}});}
      if(info.category==='手机'){this.$router.push({path : '/buyPhonePage', query:{id : info.commodity_id}});}
      if(info.category==='家具'){this.$router.push({path : '/buyFurniturePage', query:{id : info.commodity_id}});}
      if(info.category==='服装'){this.$router.push({path : '/buyClothPage', query:{id : info.commodity_id}});}
      if(info.category==='食品'){this.$router.push({path : '/buyFoodPage', query:{id : info.commodity_id}});}
      if(info.category==='其他'){this.$router.push({path : '/buyOtherPage', query:{id : info.commodity_id}});}
    }

  },
  created() {
    this.merchant_id = this.$route.query.merchant_id;;
    axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.merchant_id}}).then(
      (response) => {
        this.merchant_info = response.data;
      }
    );

    axios.get('/selectCommodityByMerchant',{params : {merchantId: this.merchant_id}}).then(
      (response) => {
        this.commodity = response.data;
      }
    )

  },
  watch : {
    merchant_id : function () {

    }
  },
  data(){
    return {
      merchant_id : '',
      merchant_info : '',
      commodity : '',
      url_head : 'http://localhost:8906//',

    }
  }
}
</script>
<style scoped>
</style>
