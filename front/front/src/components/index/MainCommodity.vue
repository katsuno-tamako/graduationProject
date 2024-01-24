<template>
    <div>
      <el-card shadow="never">
      <div style="font-size: 20px">热销商品</div>
      <el-divider></el-divider>
      <div style="text-align: center">
        <el-row :gutter="10">
          <el-col :span="6" v-for="r in re" :key="r.id">
            <div style="border:1px solid gainsboro;height: 160px;padding-top: 10px" @click="goUrl(r)">
              <div style="padding-top: 10px">
                  <el-image
                    style="height: 80px"
                    :src="url_head+r.main_img"
                  ></el-image>
              </div>
              <div style="height: 10px"></div>
              <div style="font-size: 15px" class="view-text">
                {{r.name}}
              </div>
              <div style="font-size: 12px">
                <span>销售量：{{r.sales_commodity.sales_num}}</span>
              </div>

            </div>
          </el-col>
        </el-row>
      </div>

      </el-card>

    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'MainCommodity',
  created() {
    axios.get('/recommendCommodity').then(
      (res) => {
        this.re = res.data
      }
    )
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
    return{
      re : '',
      url_head : 'http://localhost:8906//',
      commodity_path : ''
    }
  }
}
</script>
<style scoped>
  .view-text{
    display: inline-block;
    white-space: nowrap;
    width: 80%;
    overflow: hidden;
    text-overflow:ellipsis;
  }

</style>
