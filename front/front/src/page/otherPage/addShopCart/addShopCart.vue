<template>
  <div>
    <el-button @click="insertShoppingCart" size="mini" style="">
      <i class="el-icon-shopping-cart-1"></i> 添加购物车
    </el-button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: 'addShopCart',
  props : ['commodity_id','num','commodity'],
  data () {
    return {
      shopCartVO : {
        commodity : '',
        num : ''
      }
    }
  },
  methods : {
    insertShoppingCart(){
      this.shopCartVO.num = this.num;
      this.shopCartVO.commodity = this.commodity;
      this.num = 1;
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
