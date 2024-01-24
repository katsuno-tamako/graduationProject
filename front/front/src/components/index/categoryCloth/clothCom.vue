<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="8" v-for="cloth in cloths" :key="cloth.id" style="padding: 10px">
        <el-card>
          <router-link target="_blank" :to="{path : '/buyClothPage' , query : {id : cloth.commodity_id}}" style="text-decoration:none">
            <div>
              <div style="text-align: center">
                <el-image
                  style="width: 150px;height: 200px"
                  :src="url_head+cloth.commodity.main_img"
                >
                </el-image>
                <div>{{cloth.commodity_name}}</div>
              </div>
              <div>￥{{cloth.price}}</div>
            </div>
          </router-link>

          <el-divider></el-divider>

          <div>
            <add-shop-cart :commodity_id="cloth.commodity_id" :num="1"/>
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
  name: 'clothCom',
  props : ['clothType'],
  components : {addShopCart},
  created() {
    axios.get('/cloth/selectAllClothing').then(
      (response) => {
        this.cloths = response.data;
      }
    );
  },
  data(){
    return{
      cloths : '',
      url_head : 'http://localhost:8906//',

    }
  }
}
</script>
<style scoped>
</style>
