<template>
  <div>
    <businessHeader/>
    <businessMenuCom/>
    <div style="width: auto;margin: 5%">
      <el-row :gutter="20">
        <el-col :span="5">
          <el-card>
            <div>请选择你要添加的商品类型</div>
            <el-divider></el-divider>
            <el-select v-model="category_type" placeholder="请选择">
              <el-option v-for="category in categories"
                         :key="category.value"
                         :label="category.label"
                         :value="category.value"
              ></el-option>
            </el-select>
          </el-card>
        </el-col>
        <el-col :span="19">
          <el-card>
            <add-commodity_r :category="category_type"/>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import businessMenuCom from "../../../page/business/theme/businessMenuCom";
import businessHeader from "../../../page/business/theme/businessHeader";
import addCommodity_r from "./commodity/addCommodity_r";
export default {
  name: 'addCommodityPage',
  components : {addCommodity_r,businessMenuCom,businessHeader},
  data(){
    return {
      categories : [
        {value: 'computer',label: '电脑'},
        {value: 'book',label: '图书'},
        {value: 'phone',label: '手机'},
        {value: 'cloth',label: '服装'},
        {value: 'furniture',label: '家具'},
        {value: 'food',label: '食品'},
        {value: 'other',label: '其他'}
      ],
      category_type : ''
    }
  }
}
</script>
<style scoped>
</style>
