<template>
  <div>
    <div v-for="c in commodities" :key="c.id" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
      <div style="margin: 0" >
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

    <div style="display: none">
      {{commodities}}
    </div>

    </div>

</template>

<script>
import editCommodity from "./editCommodity";
import CommodityInfo from "./CommodityInfo";
import axios from "axios";
export default {
  name: "CommodityInfoByCategoryCom",
  props : ['category'],
  components : {
    editCommodity,CommodityInfo
  },
  methods : {
    editInfo(c){
      this.c_info = c;
      this.dialogVisible = true;
      console.log()
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
    this.ca = this.category;
  },
  watch : {
    ca : function () {
      console.log("--"+this.ca)
      axios.get('/selectCommodityByMerchantAndCategory',{params:{category:this.category}}).then(
        (response) => {
          this.commodities = response.data;
        }
      );
    }
  },
  data(){
    return {
      url_head : 'http://localhost:8906//',
      addDialog : false,
      c_info : {},
      commodities : {},
      dialogVisible: false,
      ca : ''

    }
  }
}
</script>



