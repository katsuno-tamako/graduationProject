<template>
  <div>
    <div>我的商品</div>
    <el-input
      v-model="search"
      size="mini"
      placeholder="输入关键字搜索"/>
    <div>
      <el-table
        :data="commodities

          .filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) || data.category.toLowerCase().includes(search.toLowerCase()))
          .slice((curPage-1)*pageSize,curPage*pageSize)
        "
        border
        style="width: 100%;height: 650px">
        <el-table-column
          fixed
          prop="commodity_id"
          label="货物编号"
          width="200">
        </el-table-column>

        <el-table-column
          prop="name"
          label="货物名称"
          width="300">
        </el-table-column>


        <el-table-column
          sortable
          prop="price"
          label="价钱"
          width="120">
        </el-table-column>
        <el-table-column
          prop="category"
          label="种类"
          width="120">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">

            <el-button type="text" size="small" @click="editPic(scope.row.commodity_id)">管理图片</el-button>
            <el-button type="text" size="small" @click="goEditPage(scope.row.category,scope.row.commodity_id,scope.row.commodity_id)">编辑信息</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-card>
        <el-pagination
          background
          :current-page.sync="curPage"
          :page-size="pageSize"
          :pager-count="7"
          :total="commodities.length"
          layout="prev, pager, next"
        >
        </el-pagination>
      </el-card>


    </div>

  </div>
</template>

<script>
import axios from "axios";
import commodityInfo from "./Commodity/commodityInfo";
export default {
  name: 'businessCommodity',
  inject : ['reload'],
  props : ['text'],
  components : {
    commodityInfo
  },
  data () {
    return {
      num : '',
      commodities : '',
      commodities_all : '',
      url_head : 'http://localhost:8906//',
      fit : 'contain',
      pageSize : 10,
      curPage: 1,
      search : ''

    }
  },
  methods : {
    edit(category,commodity_id){
      if(category == "图书"){
        this.$router.push({path : '/editBookCommodities', query:{commodity_id : commodity_id , category : category}});
      }else if(category == "电脑"){
        this.$router.push({path : '/editComputerCommodities', query:{commodity_id : commodity_id}});
      }
    },
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
  created() {
      axios.get('/selectCommodityByMerchant',
        {params : {'merchantId' : this.$store.state.merchant_id}}).then(
        (response) => {
          this.commodities = response.data;
          console.log(this.commodities)
        }
      );
  },
  watch:{

  }

}
</script>
<style scoped>
</style>
