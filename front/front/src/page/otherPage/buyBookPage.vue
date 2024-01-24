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
             <el-carousel-item v-for="img in book_img" :key="img.path">
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
            <div style="color: #475669;font-size: 30px;margin-bottom: 5px">{{book.book_name}}</div>
           <div style="font-size: 15px">{{book.author}}著</div>
           <div style="height: 10px"></div>
           <div style="width: auto;background-color: antiquewhite;padding: 5px;font-size: 20px">价格：<span style="font-weight:bolder;color: brown">{{book.book_price}}￥</span></div>
           <div style="height: 10px"></div>
           <div @click="linkMerchant">店铺：{{merchant_info.merchant_name}}</div>
           <div style="height: 10px"></div>
           <div>出版社：{{book.publishing}}</div>
           <div style="height: 10px"></div>
           <div style="border: 1px solid rosybrown;padding: 10px">{{book.commodity.introduce}}</div>
           <div style="height: 10px"></div>
           <div style="font-size: 13px;color: rosybrown">
             <div>发布日期{{book.publishing_date}}</div>
             <div style="height: 10px"></div>
             <div>ISBN:{{book.book_isbn}}</div>
             <div style="height: 10px"></div>
             <div>品牌 ： {{book.book_brand}}</div>
           </div>

           <el-divider></el-divider>

<!--           <el-input-number v-model="num" :min="1" :max="10" style="width: 150px"></el-input-number>-->

<!--           <el-button @click="insertShoppingCart" style="background-color: red;color: white;font-weight: bold">-->
<!--             <i class="el-icon-shopping-cart-1"></i> 添加购物车-->
<!--           </el-button>-->

            <addShopCartButton :commodity="book.commodity"/>

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
import addShopCart from "./addShopCart/addShopCart";
import addShopCartButton from "../../components/index/shopping_cart/shopCom/addShopCartButton";
export default {
  name: 'buyBookPage',
  props : ['cid'],
  components: {
    Header,Header2,comment,commentContent,addShopCart,addShopCartButton
  },
  data () {
    return {
      fit : 'fill',
      book : {
        commodity : ''
      },
      commodity_id : '',
      book_img : '',
      url_head : 'http://localhost:8906//',
      all_url : '',
      num : '',
      activeNames : '',
      ret : '',
      merchant_info : {
        merchant_name : ''
      }
    }
  },
  created() {

    this.commodity_id = this.$route.query.id;


    axios.get('/book/selectBookCommodityByMerchant',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.book = response.data;
          axios.get('/merchant/selectMerchantByMerchantID',{params:{merchant_id:this.book.commodity.merchant_id}}).then(
            (response) => {
              this.merchant_info = response.data;
            }
          );
      }
    );
    axios.get('/getImg',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.book_img = response.data;
        this.all_url = this.url_head + this.book_img;
      }
    );

    axios.get('/order/JudgeShop',{params : {commodity_id : this.commodity_id,user_id : this.$store.state.user_id}}).then(
      (response) => {
        this.ret=response.data;
      }
    );

  },
  methods : {
    insertShoppingCart(){
      if(this.$store.state.user_id == 'null'){
        this.$router.push('/login');
      }else{
        axios.get('/order/insertCommodityInShoppingCart',{params : {commodity_id : this.commodity_id,user_id : this.$store.state.user_id, num : this.num}}).then();
        this.$router.push('/addSuccess');
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
