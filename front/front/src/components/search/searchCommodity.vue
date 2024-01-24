<template>
  <div>
    <div  style="width: auto;margin: 0 10%;border:1px gainsboro solid ;padding:  0 10px;height: 350px">
      <router-link target="_blank" :to="{path : commodity_path , query : {id : com.commodity_id}}" style="text-decoration:none">
      <div  style="text-align: center;padding-top: 10px">
        <el-image
          style=" height: 180px"
          :src="url_head+com.main_img"
        >

        </el-image>
      </div>
      <div>
        <div style="display: none">
          <span v-if="com.category == '图书'">{{this.commodity_path = '/buyBookPage'}}</span>
          <span v-if="com.category == '电脑'">{{this.commodity_path = '/buyComputerPage'}}</span>
          <span v-if="com.category == '手机'">{{this.commodity_path = '/buyPhonePage'}}</span>
          <span v-if="com.category == '家具'">{{this.commodity_path = '/buyFurniturePage'}}</span>
          <span v-if="com.category == '服装'">{{this.commodity_path = '/buyClothPage'}}</span>
          <span v-if="com.category == '食品'">{{this.commodity_path = '/buyFoodPage'}}</span>
          <span v-if="com.category == '其他'">{{this.commodity_path = '/buyOtherPage'}}</span>
        </div>
        <div><span style="font-size: 20px">￥{{com.price}}</span></div>
        <div class="view-text"><span>{{com.name}}</span></div>
      </div>
        <div style="color: #475669;;font-size: 10px;margin-left: 10px">
          <div>
                  <span style="font-size: 15px">销量：
                    {{com.sales_commodity.sales_num}}
                  </span>
          </div>
          <div style="font-size: 15px">
            <div v-if="com.sales_commodity.ave_grade!='no'">
                    <span>评分：
                  {{com.sales_commodity.ave_grade}}
                    </span>
            </div>
            <div v-else>
              暂无评分
            </div>
          </div>
        </div>

      </router-link>
      <div style="margin-top: 20px">
        <add-shop-cart :commodity="com" :num="1"/>
      </div>
    </div>
  </div>
</template>

<script>
import addShopCart from "../../page/otherPage/addShopCart/addShopCart";
export default {
  name: 'searchCommodity',
  props : ['com'],
  components : {
    addShopCart
  },
  data () {
    return {
      url_head : 'http://localhost:8906//',
      commodity_path : ''
    }
  }
}
</script>
<style scoped>
  .info{
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .view-text{
    display: inline-block;
    white-space: nowrap;
    width: 100%;
    overflow: hidden;
    text-overflow:ellipsis;
  }
  a{
    color: black;
    text-decoration:none}

</style>
