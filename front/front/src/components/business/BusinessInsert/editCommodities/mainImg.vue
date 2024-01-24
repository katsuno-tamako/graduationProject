<template>
  <div>
    <el-card>
      <el-image
        style="width: 150px; height: 200px;"
        :src="imgURL"></el-image>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'mainImg',
  props : ['id'],
  data () {
    return {
      commodity :'',
      commodity_id : '',
      url_head : 'http://localhost:8906//',
      imgURL : '',
    }
  },
  created() {
    this.commodity_id = this.$route.query.commodity_id;
    axios.get('selectCommodityById',{params : {commodity_id : this.commodity_id}}).then(
      (response) => {
        this.imgURL = this.url_head + response.data.main_img;
      }
    );


  }
}
</script>
<style scoped>
</style>
