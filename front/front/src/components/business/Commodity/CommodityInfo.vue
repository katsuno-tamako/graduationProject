<template>
  <div style="font-size: 14px">
    <div v-if="category=='图书'">
      <div><span>作者:{{info.author}}</span></div>
      <div><span>出版社:{{info.publishing}}</span></div>
      <div><span>类型:{{info.book_type}}</span></div>
      <div><span>ISBN:{{info.book_isbn}}</span></div>
      <div><span>出版日期:{{info.publishing_date}}</span></div>
      <div><span>公司:{{info.book_brand}}</span></div>
    </div>
    <div v-if="category === '电脑'">
      <div><span>电脑类型：{{info.computer_type}}</span></div>
      <div><span>CPU：{{info.cpu}}</span></div>
      <div><span>内存：{{info.memory}}</span></div>
      <div><span>硬盘容量：{{info.disk}}</span></div>
      <div><span>操作系统：{{info.system}}</span></div>
      <div><span>商家：{{info.brand}}</span></div>
      <div><span>分辨率： {{info.resolution}}</span></div>
    </div>
    <div v-if="category === '手机'">
      <el-row>
        <el-col :span="12">厂商：{{info.brand}}</el-col>
        <el-col :span="12">CPU：{{info.phone_cpu}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">操作系统：{{info.operating_system}}</el-col>
        <el-col :span="12">容量：{{info.storage}}</el-col>
      </el-row>

      <el-row>
        <el-col :span="12">宽度：{{info.phone_width}}</el-col>
        <el-col :span="12">厚度：{{info.phone_thick}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">长度：{{info.phone_length}}</el-col>
        <el-col :span="12">重量：{{info.phone_weight}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">内存：{{info.internal_storage}}</el-col>
        <el-col :span="12">屏幕尺寸：{{info.screen_size}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">屏幕材料：{{info.screen_material}}</el-col>
        <el-col :span="12">电池是否可以移：{{info.battery_removable}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">无线网：{{info.wireless_charging}}</el-col>
        <el-col :span="12">SIM：{{info.number_of_sim}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">后置摄像头：{{info.backshot_main_pixel}}</el-col>
        <el-col :span="12">前置摄像头：{{info.foreshot_main_pixel}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">分辨率：{{info.resolution}}</el-col>
      </el-row>

    </div>
    <div v-if="category === '家具'">
      <div><span>家具材料：{{info.furniture_material}}</span></div>
      <div><span>使用房间：{{info.room}}</span></div>
      <div><span>家具类型：{{info.function_type}}</span></div>
      <div><span>家具重量：{{info.furniture_weight}}</span></div>
      <div><span>家居风格：{{info.furniture_style}}</span></div>
      <div><span>家具商家：{{info.brand}}</span></div>
      <div><span>占地面具：{{info.furniture_area}}</span></div>
    </div>
    <div v-if="category === '服装'">
      <div><span>品牌：{{info.brand}}</span></div>
      <div><span>上市时间：{{info.market_time}}</span></div>
      <div><span>服装类型{{info.cloth_type}}</span></div>
      <div><span>使用季节：{{info.apply_to_session}}</span></div>
      <div><span>服装重量：{{info.commodity_weight}}</span></div>
      <div><span>适用人群：{{info.suitable}}</span></div>
      <div><span>服装风格：{{info.clothing_style}}</span></div>
    </div>
    <div v-if="category==='食品'">
      <div><span>食物类型：{{info.food_type}}</span></div>
      <div><span>食物重量：{{info.food_weight}}</span></div>
      <div><span>食物来源：{{info.origin}}</span></div>
      <div><span>生产许可号：{{info.production_license_number}}</span></div>
      <div><span>产品标准号：{{info.product_standard_number}}</span></div>
    </div>
    <div v-if="category==='其他'">
      <div><span>商品类型：{{info.commodity_type}}</span></div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'CommodityInfo',
  props : ['category','commodity_id'],
  created() {
    if(this.category == '图书'){
      axios.get('/book/selectBookById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info = response.data});
    }
    if(this.category==='电脑'){
      axios.get('/computer/selectComputerById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info = response.data});
    }
    if(this.category==='手机'){
      axios.get('/phone/selectPhoneById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info=response.data});
    }
    if(this.category==='家具'){
      axios.get('/furniture/selectFurnitureById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info=response.data});
    }
    if(this.category==='服装'){
      axios.get('/cloth/selectClothById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info=response.data});
    }
    if(this.category==='食品'){
      axios.get('/food/selectFoodById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info=response.data});
    }
    if(this.category==='其他'){
      axios.get('/other/selectOtherCommodityById',{params:{commodity_id:this.commodity_id}}).then((response)=>{this.info=response.data});
    }
  },
  data(){
    return{
      info : {},
      comp : {
        computer_cpu: ''
      }
    }
  }
}
</script>
<style scoped>
</style>
