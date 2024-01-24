<template>
  <div>
    <div v-if="keyword==='nullBrand'">所有商品</div>
    <div v-else>{{keyword}}</div>

    <el-row :gutter="20">
      <el-col :span="8" v-for="f in furniture" :key="f.id" style="padding: 10px">
        <el-card>
          <router-link target="_blank" :to="{path : '/buyFurniturePage' , query : {id : f.commodity_id}}" style="text-decoration:none">
            <div>
              <div style="text-align: center">
                <el-image
                  style="width: 150px;height: 200px"
                  :src="url_head+f.commodity.main_img"
                >
                </el-image>
                <div style="height: 30px">{{f.name}}</div>
              </div>
              <div style="height: 20px"></div>
              <div>￥{{f.price}}</div>
            </div>
          </router-link>

          <el-divider></el-divider>

          <div>
            <add-shop-cart :commodity_id="f.commodity_id" :num="1"/>
          </div>

        </el-card>
      </el-col>
    </el-row>

    <div>
    </div>
  </div>
</template>

<script>
import addShopCart from "../../../page/otherPage/addShopCart/addShopCart";
import axios from 'axios'
export default {
  name: 'furnitureCom',
  props: ['keyword'],
  components : {
    addShopCart
  },
  created() {
    axios.get('/furniture/selectAllFurniture').then(
      (response) => {
        this.furniture = response.data
      }
    );
  },
  data() {
    return {
      furniture: '',
      url_head: 'http://localhost:8906//',
    }
  },
  watch: {
    keyword: function () {
      axios.get('/furniture/selectFurnitureById', {params: {brand: this.keyword}}).then(
        (response) => {
          this.furniture = response.data;
          console.log(response.data);

        }
      );
    }
  }
}
</script>
<style scoped>
</style>
