<template>
  <div>
    订单管理
    <div>
      {{orders}}
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'orderManager',
  data () {
    return {
      orders : {
        commodity : ''
      }
    }
  },
  created() {
    axios.get('/order/selectAllOrderInfo').then(
      (response) => {
        this.orders = response.data;
      }
    );
  }
}
</script>
<style scoped>
</style>
