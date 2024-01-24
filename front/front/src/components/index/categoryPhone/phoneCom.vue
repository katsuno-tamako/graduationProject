<template>
  <div>
    <div v-if="keyword==='nullBrand'">所有商品</div>
    <div v-else>{{keyword}}</div>
    <el-row :gutter="20">
      <el-col :span="8" v-for="phone in phones" :key="phone.id" style="padding: 10px">
        <el-card>
          <router-link target="_blank" :to="{path : '/buyPhonePage' , query : {id : phone.commodity_id}}" style="text-decoration:none">
            <div>
              <div style="text-align: center">
                <el-image
                  style="width: 150px;height: 200px"
                  :src="url_head+phone.commodity.main_img"
                >
                </el-image>
                <div style="height: 30px">{{phone.commodity_name}}</div>
              </div>
              <div style="height: 20px"></div>
              <div>￥{{phone.price}}</div>
            </div>
          </router-link>

          <el-divider></el-divider>

          <div>
            <add-shop-cart :commodity_id="phone.commodity_id" :num="1"/>
          </div>

        </el-card>
      </el-col>
    </el-row>

    <div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import addShopCart from "../../../page/otherPage/addShopCart/addShopCart";
export default {
  name: 'phoneCom',
  components : {addShopCart},
  props : ['keyword'],
  created() {
    if(this.keyword=='nullBrand'){
      axios.get('/phone/selectAllPhone').then(
        (response) => {
          this.phones = response.data;
          console.log(response.data);
        }
      );
    }else{
      axios.get('/phone/selectPhoneByBand',{params:{brand: this.brand}}).then(
        (response) => {
          this.phones = response.data;
          console.log(response.data);

        }
      );
    }
  },
  data(){
    return{
      phones : '',
      url_head : 'http://localhost:8906//',
    }
  },
  watch : {
    keyword : function () {
      axios.get('/phone/selectPhoneByBand',{params:{brand: this.keyword}}).then(
        (response) => {
          this.phones = response.data;
          console.log(response.data);

        }
      );
    }
  }
}
</script>
<style scoped>
</style>
