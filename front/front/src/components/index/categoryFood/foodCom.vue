<template>
  <div>
    <div v-if="keyword==='nullBrand'">所有商品</div>
    <div v-else>{{keyword}}</div>
    <el-row :gutter="20">
      <el-col :span="8" v-for="food in foods" :key="food.id" style="padding: 10px">
        <el-card>
          <router-link target="_blank" :to="{path : '/buyFoodPage' , query : {id : food.commodity_id}}" style="text-decoration:none">
            <div>
              <div style="text-align: center">
                <el-image
                  style="width: 150px;height: 200px"
                  :src="url_head+food.commodity.main_img"
                >
                </el-image>
                <div style="height: 30px">{{food.commodity_name}}</div>
              </div>
              <div style="height: 20px"></div>
              <div>￥{{food.price}}</div>
            </div>
          </router-link>

          <el-divider></el-divider>

          <div>
            <add-shop-cart :commodity_id="food.commodity_id" :num="1"/>
          </div>

        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import addShopCart from "../../../page/otherPage/addShopCart/addShopCart";
import axios from 'axios'
export default {
  name: 'foodCom',
  components : {addShopCart},
  props : ['keyword'],
  created() {
    axios.get('/food/selectAllFoodInfo').then(
      (response) => {
        this.foods = response.data;
      }
    );
  },
  data(){
    return {
      foods : '',
      url_head : 'http://localhost:8906//',

    }
  }
}
</script>
<style scoped>
</style>
