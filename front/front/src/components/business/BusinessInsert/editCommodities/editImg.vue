<template>
  <div>
    <div>
      <span>封面图片</span>
      <div>
        <main-img v-bind:id="commodity_id"/>
      </div>
    </div>
    <div>
      <div>插入图片</div>
      <uploadCommodityImg v-bind:id="commodity_id"/>
    </div>
    <div>
      <div>已经上传的图片</div>
      <span >刷新</span>
      <el-button @click="rel" icon="el-icon-refresh" circle></el-button>
      <CommodityImg v-bind:commodity_id="commodity_id" v-if="update"/>
    </div>
  </div>
</template>

<script>
import uploadCommodityImg from "./uploadCommodityImg";
import CommodityImg from "./CommodityImg";
import mainImg from "./mainImg";
export default {
  name: 'editImg',
  data () {
    return {
      commodity_id : '',
      update : true
    }
  },
  components : {
    uploadCommodityImg,
    CommodityImg,
    mainImg
  },
  created() {
    this.commodity_id = this.$route.query.commodity_id;
  },
  methods : {
    rel(){
      this.update = false;
      this.$nextTick(()=>this.update = true);
    }
  }
}
</script>
<style scoped>
</style>
