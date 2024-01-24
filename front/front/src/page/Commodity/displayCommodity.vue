<template>
  <div>
    <div><Header/></div>
    <div><Header2/></div>
    <div>

    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
export default {
  name: 'displayCommodity',
  props : ['commodityOb'],
  components: {Header,Header2},
  created() {

  }
}
</script>
<style scoped>
</style>
