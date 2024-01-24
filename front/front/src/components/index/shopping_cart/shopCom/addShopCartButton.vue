<template>
  <div>
    <el-input-number v-model="shopCartVO.num" :min="1" :max="10" style="width: 150px"></el-input-number>

    <el-button @click="insertShoppingCart" style="background-color: red;color: white;font-weight: bold">
      <i class="el-icon-shopping-cart-1"></i> 添加购物车
    </el-button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'addShopCartButton',
  props : ['commodity_id','commodity'],
  data(){
      return{
        shopCartVO : {
          commodity : {
            merchant_id : ''
          },
          num : 1,

        }
      }
  },
  methods : {
    insertShoppingCart(){
      this.shopCartVO.commodity = this.commodity;
      this.shopCartVO.commodity.merchant_id = this.commodity.merchant_id;

      if(this.$store.state.user_id === 'null'){
        this.$router.push('/login');
      }else{
        axios.post('/shopCart/insertIntoShopCart',this.shopCartVO).then();
        this.$router.push('/addSuccess');
      }

    }
  }
}
</script>
<style scoped>
</style>
