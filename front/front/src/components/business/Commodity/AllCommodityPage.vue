<template>
    <div>
      <div><businessHeader/></div>
      <div><businessMenuCom/></div>
      <div style="width: auto;margin: 0 10%">
      <router-link to="/addCommodityPage">
        <el-button icon="el-icon-plus" size="small">添加商品</el-button>
      </router-link>
      <el-tabs v-model="pri">
        <el-tab-pane label="所有商品" name="all">
          <div v-for="c in commodities" :key="c.id" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
            <div style="margin: 0">
              <div style="height: 25px;width: 100%;background-color: #f5f5f5">
                <span style="font-size: 13px;margin: 10% 15px;color: #475669">
                商品编号:{{c.commodity_id}}
                </span>
              </div>
              <el-row :gutter="5">
                <el-col :span="4" style="text-align: center">
                  <el-image
                    style="height: 80px"
                    :src="url_head+c.main_img"
                  ></el-image>
                </el-col>
                <el-col :span="4" style="text-align: center">
                  {{c.name}}
                </el-col>
                <el-col :span="4" style="text-align: center">
                  {{c.price}}
                </el-col>
                <el-col :span="8">
                  <commodity-info :category="c.category" :commodity_id="c.commodity_id"/>
                </el-col>
                <el-col :span="4" style="text-align: center">
                  <div style="margin: 20px 0">
                    <i class="el-icon-edit" @click="editInfo(c)">编辑</i>
                    <i class="el-icon-delete" @click="deleteC(c)">删除</i>
                  </div>

                </el-col>
              </el-row>
            </div>
          </div>
          <el-dialog
            :visible.sync="dialogVisible"
          >
            <edit-commodity :c_info="c_info"/>
          </el-dialog>

          <el-dialog
            :visible.sync="addDialog">
          </el-dialog>
        </el-tab-pane>

<!--        <el-tab-pane v-for="category in have_category" :key="category" :label="category" :name="category" :lazy="true">-->
<!--          <CommodityInfoByCategoryCom  :category="category"/>-->
<!--        </el-tab-pane>-->
      </el-tabs>
      </div>


      <el-divider></el-divider>

    </div>
</template>

<script>
import axios from 'axios'
import editCommodity from "./editCommodity";
import CommodityInfo from "./CommodityInfo";
import CommodityInfoByCategoryCom from "./CommodityInfoByCategoryCom";
import businessHeader from "../../../page/business/theme/businessHeader";
import businessMenuCom from "../../../page/business/theme/businessMenuCom";
export default {
  name: 'AllCommodityPage',
  inject : ['reload'],
  components : {
    CommodityInfo,editCommodity,CommodityInfoByCategoryCom,businessHeader,businessMenuCom
  },
  methods : {
    editInfo(c){
      this.c_info = c;
      this.dialogVisible = true;
    },
    deleteC(commodity){
      axios.post('/delCom',commodity).then();
      this.reload();
    },
    addD(){
      this.addDialog = true;
    }
  },
  created() {
    axios.get('/selectCommoditiesByMID').then(
      (response) => {
        this.commodities = response.data;
      }
    );

    axios.get('/merchant/merchantHaveCategory').then(
      (response) => {
        this.have_category = response.data;
      }
    )

  },
  data(){
    return {
      pri : 'all',
      have_category : '',
      dialogVisible: false,
      addDialog : false,
      c_info : {},
      url_head : 'http://localhost:8906//',
      commodities : {}
    }
  },
  watch : {
    dialogVisible : function () {
      if(this.dialogVisible==false){
        this.reload();
      }

    }
  }
}
</script>
<style scoped>
</style>
