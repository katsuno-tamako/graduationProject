<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="8" v-for="computer in computers" :key="computer.id" style="padding: 10px">
        <el-card>
          <router-link target="_blank" :to="{path : '/buyComputerPage' , query : {id : computer.commodity_id}}" style="text-decoration:none">
            <div>
              <div style="text-align: center">
                <el-image
                  style="width: 150px;height: 200px"
                  :src="url_head+computer.main_img"
                >
                </el-image>
                <div>{{computer.name}}</div>
              </div>
              <div>￥{{computer.price}}</div>
            </div>
          </router-link>

          <el-divider></el-divider>

          <div>
            <add-shop-cart :commodity_id="computer.commodity_id" :num="1"/>
          </div>

        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios'
import addShopCart from "../../../page/otherPage/addShopCart/addShopCart";
export default {
  name: 'computerCom',
  components : {addShopCart},
  data () {
    return {
      computers : {},
      category : '电脑',
      url_head : 'http://localhost:8906//',
    }
  },
  created() {
    axios.get('/selectCommodityByCategory',{params : {category : this.category}}).then(
      (response) => {
        this.computers = response.data;
      }
    );
  }
}
</script>
<style scoped>
</style>
