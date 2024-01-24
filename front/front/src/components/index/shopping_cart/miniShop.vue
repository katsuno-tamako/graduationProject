<template>
  <div>
    购物车的商品：
    <div>
      <div style="height: 200px;overflow:auto">
        <div v-for="s in shop" :key="s.id" style="width: 220px">
          <div v-if="s">
            <el-row :gutter="10">
              <el-col :span="12">
                <el-image
                  style="width: 50px; height: 75px"
                  :src="url_head+s.commodity.main_img"
                >
                </el-image>
              </el-col>
              <el-col :span="12">
                <div>{{s.commodity.name}}</div>
                <div>￥{{s.commodity.price}}</div>
                <div>{{s.num}}个</div>
              </el-col>
            </el-row>
            <el-divider></el-divider>
          </div>
        </div>
      </div>
    </div>
    <el-divider></el-divider>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'miniShop',
  data () {
    return {
      shop : {
        commodity : {
          name : '',
          price : '',
          main_img : ''
        }
      },
      url_head : 'http://localhost:8906//',
      count : ''
    }
  },
  created() {
    axios.get('user/getUserSession').then(
      (res) => {
        axios.get('/order/selectShoppingCartByUserId',{params : {commodity_id : res.data}}).then(
          (response) => {
            this.shop = response.data;
          }
        );
      }
    )

  }
}
</script>
<style scoped>
</style>
