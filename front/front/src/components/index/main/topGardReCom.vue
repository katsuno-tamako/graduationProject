<template>
  <div>
    <div style="text-align: center">评分前十</div>
    <el-divider></el-divider>
    <div v-for="t in top_gard" :key="t.id">
      <div>

      <div style="height: 40px;font-size: 15px" class="view-text" @click="goUrl(t)">
        <div>
          {{t.name}}
        </div>
        <div style="text-align: right">
<!--          <span>评分</span>{{t.sales_commodity.ave_grade}}-->
        </div>
      </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'topGardReCom',
  created() {
    axios.get('/topGrade').then((res)=>{this.top_gard = res.data})
  },
  methods:{
    goUrl(r){
      if(r.category == '图书'){this.$router.push({path:'/buyBookPage', query:{id : r.commodity_id}})}
      if(r.category == '电脑'){this.$router.push({path:'/buyComputerPage', query:{id : r.commodity_id}})}
      if(r.category == '手机'){this.$router.push({path:'/buyPhonePage', query:{id : r.commodity_id}})}
      if(r.category == '家具'){this.$router.push({path:'/buyFurniturePage', query:{id : r.commodity_id}})}
      if(r.category == '服装'){this.$router.push({path:'/buyClothPage', query:{id : r.commodity_id}})}
      if(r.category == '食品'){this.$router.push({path:'/buyFoodPage', query:{id : r.commodity_id}})}
      if(r.category == '其他'){this.$router.push({path:'/buyOtherPage', query:{id : r.commodity_id}})}
    }
  },
  data(){
    return {
      top_gard : '',
      url_head : 'http://localhost:8906//'
    }
  }
}
</script>
<style scoped>
  .view-text{
    display: inline-block;
    white-space: nowrap;
    width: 100%;
    overflow: hidden;
    text-overflow:ellipsis;
  }
</style>
