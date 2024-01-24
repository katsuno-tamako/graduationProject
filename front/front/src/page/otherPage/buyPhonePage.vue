<template>
  <div>
    <Header/>
    <Header2/>
    <div style="height: 50px"></div>
    <div style="padding:0px 100px">
      <div style="padding:0px 100px">
        <el-row :gutter="20">
          <el-col :span="8">
            <el-card>
              <el-carousel :interval="4000" type="card" height="300px">
                <el-carousel-item v-for="img in phone_img" :key="img.path">
                  <div class="medium">
                    <el-image
                      style=""
                      :src="url_head+img.path"
                      :preview-src-list="[url_head+img.path]"
                      :fit="fit"
                    >
                    </el-image>
                  </div>
                </el-carousel-item>

              </el-carousel>
            </el-card>
          </el-col>
          <el-col :span="16">
            <el-card>
              <div style="color: #475669;font-size: 30px;margin-bottom: 5px">{{phone.commodity_name}}</div>
              <div style="height: 10px"></div>
              <div style="width: auto;background-color: antiquewhite;padding: 5px;font-size: 20px">价格：<span style="font-weight:bolder;color: brown">{{phone.price}}￥</span></div>
              <div style="height: 10px"></div>
              <div @click="linkMerchant">店铺：{{merchant_info.merchant_name}}</div>
              <div style="height: 10px"></div>
              <div style="border: 1px solid rosybrown;padding: 10px">{{phone.commodity.introduce}}</div>
              <div style="height: 10px"></div>
              <div>品牌：{{phone.brand}}</div>
              <div style="height: 10px"></div>
              <div style="font-size: 13px;color: rosybrown">
                <el-row :gutter="20">
                  <el-col :span="8"><div>操作系统：{{phone.operating_system}}</div></el-col>
                  <el-col :span="8"><div>手机容量:{{phone.storage}}</div></el-col>
                  <el-col :span="8"><div>手机内存:{{phone.internal_storage}}</div></el-col>
                  <el-col :span="8"> <div>屏幕尺寸:{{phone.screen_size}}</div></el-col>
                  <el-col :span="8"><div>屏幕材料:{{phone.screen_material}}</div></el-col>
                  <el-col :span="8"><div>手机宽度：{{phone.phone_weight}}</div></el-col>
                  <el-col :span="8"> <div>手机长度：{{phone.phone_length}}</div></el-col>
                  <el-col :span="8"><div>手机重量：{{phone.phone_thick}}</div></el-col>
                  <el-col :span="8"><div>电池是否可拆卸：{{phone.battery_removable}}</div></el-col>
                  <el-col :span="8"><div>无线充电：{{phone.wireless_charging}}</div></el-col>
                  <el-col :span="8"><div>分辨率：{{phone.resolution}}</div></el-col>
                  <el-col :span="8"><div>前置摄像头像素：{{phone.backshot_main_pixel}}</div></el-col>
                  <el-col :span="8"><div>后置摄像头像素：{{phone.foreshot_main_pixel}}</div></el-col>
                </el-row>

              </div>
              <el-divider></el-divider>


              <add-shop-cart-button :commodity="phone.commodity"/>

            </el-card>
          </el-col>
        </el-row>
      </div>

      <el-divider></el-divider>
      <comment :commodity_id="commodity_id" :user_id="this.$store.state.user_id"/>
      <el-divider></el-divider>
      <comment-content :commodity="commodity_id" :num="1"/>
    </div>
  </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import addShopCartButton from "../../components/index/shopping_cart/shopCom/addShopCartButton";
import commentContent from "../../components/index/comment/commentContent";
import comment from "../../components/index/comment/comment";
import axios from "axios";
export default {
  name: 'buyPhonePage',
  components: {Header,Header2,addShopCartButton,comment,commentContent},
  data(){
    return{
      fit : 'fill',
      phone_img : '',
      commodity_id : '',
      url_head : 'http://localhost:8906//',
      phone : '',
      merchant_info : {
        merchant_name : ''
      }
    }
  },
   methods : {
     linkMerchant(){
       this.$router.push({path : '/merchantIndex',query:{merchant_id:this.merchant_info.merchant_id}});
     }
   },
  created() {
    this.commodity_id = this.$route.query.id;
    axios.get('/getImg',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.phone_img = response.data;

      }
    );
    axios.get('/phone/selectPhoneById',{params : {commodity_id:this.commodity_id}}).then(
      (response) => {
        this.phone = response.data;
        axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.phone.commodity.merchant_id}}).then(
          (response) => {
            this.merchant_info = response.data;
          }
        );
      }
    );
  }
}
</script>
<style scoped>
</style>
