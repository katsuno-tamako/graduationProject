<template>
  <div>
    <Header/>
    <Header2/>
    <div>


      <div style="height: 50px"></div>
      <div style="padding:0px 100px">
        <el-row :gutter="20">
          <el-col :span="8">
            <el-card>
              <el-carousel :interval="4000" type="card" height="300px">
                <el-carousel-item v-for="img in imgOther" :key="img.path">
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
            <div>
              <el-card>
                <div style="color: #475669;font-size: 30px;margin-bottom: 5px">{{other.commodity_name}}</div>
                <div style="height: 10px"></div>
                <div style="width: auto;background-color: antiquewhite;padding: 5px;font-size: 20px">价格：<span style="font-weight:bolder;color: brown">{{other.price}}￥</span></div>
                <div style="height: 10px"></div>
                <div @click="linkMerchant">店铺：{{merchant_info.merchant_name}}</div>
                <div style="height: 10px"></div>
                <div style="border: 1px solid rosybrown;padding: 10px">{{other.commodity.introduce}}</div>
                <div style="height: 10px"></div>
                <div>类型：{{other.commodity_type}}</div>
                <div style="height: 10px"></div>
                <div style="font-size: 13px;color: rosybrown">
                  {{other.commodity_intro}}
                </div>
                <el-divider></el-divider>
                <add-shop-cart-button :commodity="other.commodity"/>


              </el-card>
            </div>
          </el-col>
        </el-row>
      </div>
      <el-divider></el-divider>
<!--      <comment :commodity_id="commodity_id" :user_id="this.$store.state.user_id"/>-->
      <el-divider></el-divider>
      <comment-content :commodity_id="commodity_id" :num="1"/>
    </div>
  </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import addShopCartButton from "../../components/index/shopping_cart/shopCom/addShopCartButton";
import commentContent from "../../components/index/comment/commentContent";
import comment from "../../components/index/comment/comment";
import axios from 'axios'
export default {
  name: 'buyOtherPage',
  components : {Header,Header2,addShopCartButton,commentContent,comment},
  created() {
    this.commodity_id = this.$route.query.id;
    axios.get('/other/selectOtherCommodityById',{params:{commodity_id:this.commodity_id}}).then(
      (response) => {
        this.other = response.data;
        axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.other.commodity.merchant_id}}).then(
          (response) => {
            this.merchant_info = response.data;
          }
        );
      }
    );

    axios.get('/getImg',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.imgOther = response.data;
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
      other : {
        commodity_name : '',
        commodity_intro : '',
        price : '',
        commodity : ''
      },
      commodity_id : '',
      imgOther : '',
      url_head : 'http://localhost:8906//',
      merchant_info : {}
    }
  }
}
</script>
<style scoped>
</style>
