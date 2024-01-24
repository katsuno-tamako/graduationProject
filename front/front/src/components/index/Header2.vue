<template>
  <div style="margin: 20px 10% 20px 20%">

    <el-row :gutter="20">
      <el-col :span="23">
        <HeaderSearch/>
      </el-col>
      <el-col :span="1">
<!--        <el-popover-->
<!--          placement="bottom"-->
<!--          width="300"-->
<!--          trigger="hover"-->
<!--        >-->
          <div v-if="this.$store.state.user_id == 'null'">
          </div>
          <div v-else>
<!--            <mini-shop @func="getCount"/>-->
          </div>
          <el-button  @click="clickShop">
             <i v-if="count===0" class="el-icon-shopping-cart-2">购物车</i>
             <i v-else class="el-icon-shopping-cart-full">购物车</i>
           </el-button>

<!--        </el-popover>-->
      </el-col>
    </el-row>
  </div>
</template>

<script>
import HeaderSearch from "./HeaderSearch";
import miniShop from "./shopping_cart/miniShop";
import axios from "axios";
export default {
  name: "Header2",
  components : {
    miniShop,
    HeaderSearch
  },
  methods : {
    clickShop(){
      if(this.$store.state.user_id == 'null'){
        this.$router.push('/login');
      }else{
        this.$router.push('/shopCartPage');
      }

    },
    getCount(data){
      console.log("count:"+data)
    }
  },
  created() {
    axios.get('/order/getShoppingCount',{params : {commodity_id : this.$store.state.user_id}}).then(
      (response) => {
        this.count = response.data;
        console.log("response:"+this.count)
      }
    );
  },
  data(){
    return {
      count : ''
    }
  }
}
</script>
<style scoped>
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
</style>



