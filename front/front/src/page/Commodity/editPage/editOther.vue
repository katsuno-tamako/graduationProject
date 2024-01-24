<template>
  <div>
    <div>编辑信息</div>
    <el-divider></el-divider>
    <div>
      <el-form :model="other" label-width="80px">

        <el-form-item label="名称">
          <el-input v-model="other.commodity_name"></el-input>
        </el-form-item>

        <el-form-item label="商品类型">
          <el-input v-model="other.commodity_type"></el-input>
        </el-form-item>

        <el-form-item label="商品价格">
          <el-input v-model="other.price"></el-input>
        </el-form-item>

        <el-form-item label="商品简介">
          <el-input v-model="other.commodity_intro"></el-input>
        </el-form-item>

        <el-form-item label="商品介绍">
          <el-input v-model="other.commodity.introduce"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button @click="subInfo">提交</el-button>
          <el-button @click="del">删除</el-button>

        </el-form-item>

      </el-form>


      <div>
        <el-dialog
          title="确认一下"
          :visible.sync="dialogVisible"
        >
          <div>
            确认一下
          </div>
          <el-divider></el-divider>
          <div>{{other}}</div>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitInfo">确 定</el-button>
        </span>
        </el-dialog>
      </div>

      <div>
        <el-dialog
          :visible.sync="dialogSuc">
          <div>提交成功</div>
          <el-divider></el-divider>
          <el-button type="primary" @click="subSuc">确定</el-button>
        </el-dialog>
      </div>

    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'editOther',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/other/selectOtherCommodityById',{params:{commodity_id:this.commodity_id}}).then(
      (response) => {
        this.other = response.data;
      }
    );
  },
  methods : {
    subInfo(){
      this.dialogVisible = true;
    },
    submitInfo(){
      axios.post('/other/updateOtherCommodity',this.other).then();
      this.dialogVisible = false;
      this.dialogSuc=true;
    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push('/businessCommodity');
      this.reload();
    },
    del(){
      axios.get('/other/deleteOtherCommodityById',{params:{commodity_id:this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
      this.reload();
    }
  },
  data(){
    return{
      other : {
        commodity_name : '',
        commodity_type : '',
        price : '',
        commodity_intro : '',
        commodity : {
          introduce : ''
        },

      },
      dialogVisible : false,
      dialogSuc : false
    }
  }
}
</script>
<style scoped>
</style>
