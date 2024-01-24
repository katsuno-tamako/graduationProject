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
                <el-carousel-item v-for="img in computer_img" :key="img.path">
                  <div class="medium">
                    <el-image
                      style="width: 100%"

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
            <div>
              <el-card>
                <div style="color: #475669;font-size: 30px;margin-bottom: 5px">{{computer.computer_name}}</div>
                <div style="font-size: 15px">{{computer.computer_type}}</div>
                <div style="height: 10px"></div>
                <div style="width: auto;background-color: antiquewhite;padding: 5px;font-size: 20px">价格：<span style="font-weight:bolder;color: brown">{{computer.price}}￥</span></div>
                <div style="height: 10px"></div>
                <div @click="linkMerchant">店铺：{{merchant_info.merchant_name}}</div>
                <div style="height: 10px"></div>
                <div style="border: 1px solid rosybrown;padding: 10px">{{computer.commodity.introduce}}</div>
                <div style="height: 10px"></div>
                <div style="font-size: 13px;color: rosybrown">
                  <div>内存：{{computer.memory}}</div>
                  <div>硬盘大小：{{computer.disk}}</div>
                  <div>处理器：{{computer.cpu}}</div>
                  <div>操作系统：{{computer.system}}</div>
                  <div>分辨率：{{computer.resolution}}</div>
                  <div>公司：{{computer.brand}}</div>
                  <div>分辨率：{{computer.system}}</div>
                </div>
                <el-divider></el-divider>
<!--                <el-input-number v-model="num" :min="1" :max="10" style="width: 150px"></el-input-number>-->
<!--                <el-button @click="insertShoppingCart" style="background-color: red;color: white;font-weight: bold"><i class="el-icon-shopping-cart-1"></i> 添加购物车</el-button>-->
                <add-shop-cart-button :commodity="computer.commodity"/>

              </el-card>
            </div>
          </el-col>
        </el-row>
      </div>



    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import addShopCartButton from "../../components/index/shopping_cart/shopCom/addShopCartButton";
export default {
  name: 'buyComputerPage',
  components : {Header,Header2,addShopCartButton},
  data () {
    return {
      fit : 'fill',
      computer : {
        computer_memory : '',
        computer_disk : ''
      },
      url_head : 'http://localhost:8906//',
      commodity_id : '',
      computer_img : '',
      all_url : '',
      num : 1,
      merchant_info : ''
    }
  },
  created() {
    this.commodity_id = this.$route.query.id;
    axios.get('/computer/selectComputerById',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.computer = response.data;
        axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.computer.commodity.merchant_id}}).then(
          (response) => {
            this.merchant_info = response.data;
          }
        );
      }
    );

    axios.get('/getImg',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.computer_img = response.data;
        this.all_url = this.url_head + this.computer_img;
      }
    );

  },
  methods : {
    insertShoppingCart(){
      if(this.$store.state.user_id == 'null'){
        this.$router.push('/login');
      }else{
        axios.get('/order/insertCommodityInShoppingCart',{params : {commodity_id : this.commodity_id,user_id : this.$store.state.user_id,num : this.num}}).then();
      }
    },
    linkMerchant(){
      this.$router.push({path : '/merchantIndex',query:{merchant_id:this.merchant_info.merchant_id}});
    }
  }
}
</script>
<style scoped>
</style>
