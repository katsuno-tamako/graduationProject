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
                <el-carousel-item v-for="img in imgFurniture" :key="img.path">
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
                <div style="color: #475669;font-size: 30px;margin-bottom: 5px">{{furniture.name}}</div>
                <div style="height: 10px"></div>
                <div style="width: auto;background-color: antiquewhite;padding: 5px;font-size: 20px">价格：<span style="font-weight:bolder;color: brown">{{furniture.price}}￥</span></div>
                <div style="height: 10px"></div>
                <div @click="linkMerchant">店铺：{{merchant_info.merchant_name}}</div>
                <div style="height: 10px"></div>
                <div style="border: 1px solid rosybrown;padding: 10px">{{furniture.commodity.introduce}}</div>
                <div style="height: 10px"></div>
                <div>家具类型：{{furniture.function_type}}</div>
                <div style="height: 10px"></div>
                <div style="font-size: 13px;color: rosybrown">
                  <div>家具材料：{{furniture.furniture_material}}</div>
                  <div>家具重量：{{furniture.furniture_weight}}</div>
                  <div>适用房间：{{furniture.room}}</div>
                  <div>适用风格：{{furniture.room}}</div>
                  <div>适用品牌：{{furniture.brand}}</div>
                  <div>占地面积：{{furniture.area}}</div>
                </div>
                <el-divider></el-divider>
                <add-shop-cart-button :commodity="furniture.commodity"/>


              </el-card>
            </div>
          </el-col>
        </el-row>
      </div>
      <el-divider></el-divider>
      <comment :commodity_id="commodity_id" :user_id="this.$store.state.user_id"/>
      <el-divider></el-divider>
      <comment-content :commodity_id="commodity_id" :num="1"/>


    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import addShopCartButton from "../../components/index/shopping_cart/shopCom/addShopCartButton";
import commentContent from "../../components/index/comment/commentContent";
import comment from "../../components/index/comment/comment";
export default {
  name: 'buyFurniturePage',
  components : {
    Header,Header2,addShopCartButton,commentContent,comment
  },
  created() {
    this.commodity_id = this.$route.query.id;
    axios.get('/furniture/selectFurnitureById',{params : {commodity_id: this.commodity_id}}).then(
      (response) => {
        this.furniture = response.data
        axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.furniture.commodity.merchant_id}}).then(
          (response) => {
            this.merchant_info = response.data;
          }
        );
      }
    );

    axios.get('/getImg',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.imgFurniture = response.data;
      }
    );

  },
  methods : {
    linkMerchant(){
      this.$router.push({path : '/merchantIndex',query:{merchant_id:this.merchant_info.merchant_id}});
    }
  },
  data(){
    return {
      furniture : '',
      commodity_id : '',
      url_head : 'http://localhost:8906//',
      imgFurniture : '',
      merchant_info : {
        merchant_name : ''
      }

    }
  }
}
</script>
<style scoped>
</style>
