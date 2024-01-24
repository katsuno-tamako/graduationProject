<template>
  <div>
    <Header/>
    <div>
      <main-shop/>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import mainShop from "../../components/index/shopping_cart/mainShop";
export default {
  name: 'shopCartPage',
  components : {
    Header,
    mainShop
  }
}
</script>
<style scoped>
</style>
