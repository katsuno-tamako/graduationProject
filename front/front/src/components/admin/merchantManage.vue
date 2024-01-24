<template>
  <div>
    <div>查询所有商家</div>
    <div>
      {{merchants}}
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'merchantManage',
  data(){
    return {
      merchants : ''
    }
  },
  created() {
    axios.get('/merchant/selectAllMerchant').then(
      (response) => {
        this.merchants = response.data;
      }
    );
  }
}
</script>
<style scoped>
</style>
