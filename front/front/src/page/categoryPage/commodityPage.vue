<template>
  <div>
    {{commodity}}
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'commodityPage',
  data () {
   return {
     commodity : {},
     url_head : 'http://localhost:8906//',
   }
  },
  props : ['id'],
  created() {
    this.commodity = this.$route.query.commodity;
    if(this.commodity.category == '图书'){
      this.$router.push({path : '/buyBookPage', query:{cid : this.commodity.commodity_id}});
    }
  }
}
</script>
<style scoped>
</style>
