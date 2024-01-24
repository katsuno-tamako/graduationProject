<template>
  <div>
    <Header/>
    <div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
export default {
  name: 'buyPage',
  components: {
    Header
  },
  data () {
    return {
      commodity_id : ''
    }
  },
  created() {
    this.commodity_id = this.$route.query.id;
    axios.get()
  }
}
</script>
<style scoped>
</style>
