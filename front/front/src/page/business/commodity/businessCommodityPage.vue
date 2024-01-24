<template>
  <div>
    查询所有信息
    <div>
      <el-table
        :data="commodities"
        stripe
        style="width: 100%">

        <el-table-column
          prop="commodity_id"
          label="编号"
          width="180">
        </el-table-column>

        <el-table-column
          prop="name"
          label="商品名称"
          width="180">
        </el-table-column>

        <el-table-column
          prop="price"
          label="价格"
          width="180">
        </el-table-column>

        <el-table-column
          prop="category"
          label="种类"
          width="180">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-popover
              placement="left"
              width="400"
              trigger="click"
            >
              <commodity-info v-bind:id="scope.row.commodity_id"/>
              <el-button type="text" size="small" slot="reference">查看信息</el-button>
            </el-popover>
            <el-button type="text" size="small" @click="editPic(scope.row.commodity_id)">管理图片</el-button>
            <el-button type="text" size="small" @click="goEditPage(scope.row.category,scope.row.commodity_id,scope.row.commodity_id)">编辑信息</el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import commodityInfo from "../../../components/business/BusinessInsert/Commodity/commodityInfo";
export default {
  name: 'businessCommodityPage',
  components : {commodityInfo},
  created() {
    axios.get('/selectCommodityByMerchant',
      {params : {'merchantId' : this.$store.state.merchant_id}}).then(
      (response) => {
        this.commodities = response.data;
      }
    );
  },
  methods : {
    editImg(commodity_id){
      this.$router.push({path : '/editImg', query:{commodity_id : commodity_id }});
    },
    deleteCommodity(){
      alert("删除该功能");
    },
    editPic(commodity_id){
      this.$router.push({path: '/CommodityImgPage',query : {commodity_id: commodity_id}});
    },
    goEditPage(category,commodity_id){
      this.$router.push({path: '/editPage',query : {category: category,commodity_id: commodity_id}});
    }
  },
  data(){
    return{
      commodities : ''
    }
  }
}
</script>
<style scoped>
</style>
