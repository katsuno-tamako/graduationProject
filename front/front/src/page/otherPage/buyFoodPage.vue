<template>
  <div>
    <Header/>
    <Header2/>

    <div style="height: 50px"></div>
    <div style="padding:0px 100px">
      <el-row :gutter="20">
        <el-col :span="8">
          <el-card>
            <el-carousel :interval="4000" type="card" height="300px">
              <el-carousel-item v-for="img in food_img" :key="img.path">
                <div class="medium">
                  <el-image
                    style=""
                    :src="url_head+img.path"
                    :preview-src-list="[url_head+img.path]"
                  >
                  </el-image>
                </div>
              </el-carousel-item>

            </el-carousel>
          </el-card>
        </el-col>
        <el-col :span="16">
          <el-card>
            <div style="color: #475669;font-size: 30px;margin-bottom: 5px">{{food.name}}</div>
            <div style="height: 10px"></div>
            <div style="width: auto;background-color: antiquewhite;padding: 5px;font-size: 20px">价格：<span style="font-weight:bolder;color: brown">{{food.price}}￥</span></div>
            <div style="height: 10px"></div>
            <div @click="linkMerchant">店铺：{{merchant_info.merchant_name}}</div>
            <div style="height: 10px"></div>
            <div style="border: 1px solid rosybrown;padding: 10px">{{food.commodity.introduce}}</div>
            <div style="height: 10px"></div>
            <div style="font-size: 13px;color: rosybrown">

            </div>

            <el-divider></el-divider>

            <add-shop-cart-button :commodity="food.commodity"/>


          </el-card>
        </el-col>
      </el-row>
      <div>

        <el-divider></el-divider>
        <comment :commodity_id="commodity_id" :user_id="this.$store.state.user_id"/>
        <el-divider></el-divider>
        <comment-content :commodity_id="commodity_id" :num="1"/>
      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import comment from "../../components/index/comment/comment";
import commentContent from "../../components/index/comment/commentContent";
import addShopCartButton from "../../components/index/shopping_cart/shopCom/addShopCartButton";
export default {
  name: 'buyFoodPage',
  components: {Header2, Header,comment,commentContent,addShopCartButton},
  created() {
    this.commodity_id = this.$route.query.id;
    axios.get('/food/selectFoodById',{params:{commodity_id:this.commodity_id}}).then(
      (response) => {
        this.food = response.data;
        axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.food.commodity.merchant_id}}).then(
          (response) => {
            this.merchant_info = response.data;
          }
        );
      }
    );
    axios.get('/getImg',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.food_img = response.data;
      }
    );

  },
  methods : {
    linkMerchant(){
      this.$router.push({path : '/merchantIndex',query:{merchant_id:this.merchant_info.merchant_id}});
    }
  },
  data(){
    return{
      food : '',
      url_head : 'http://localhost:8906//',
      commodity_id : '',
      food_img : '',
      merchant_info : {}
    }
  }
}
</script>
<style scoped>
</style>
