<template>
  <div>
    <div>编辑食品信息</div>
    <el-divider></el-divider>
    <div>
      <el-form :model="food" label-width="80px">

        <el-form-item label="食品名称">
          <el-input v-model="food.name"></el-input>
        </el-form-item>

        <el-form-item label="食品价钱">
          <el-input v-model="food.price"></el-input>
        </el-form-item>

        <el-form-item label="食品类型">
          <el-input v-model="food.food_type"></el-input>
        </el-form-item>

        <el-form-item label="食品重量">
          <el-input v-model="food.food_weight"></el-input>
        </el-form-item>

        <el-form-item label="食品源地">
          <el-input v-model="food.origin"></el-input>
        </el-form-item>

        <el-form-item label="生产许可证号" label-width="100px">
          <el-input v-model="food.production_license_number"></el-input>
        </el-form-item>

        <el-form-item label="产品标准号" label-width="100px">
          <el-input v-model="food.product_standard_number"></el-input>
        </el-form-item>


        <el-form-item label="是否为出口" label-width="100px">
          <el-input v-model="food.ex"></el-input>
        </el-form-item>

        <el-divider></el-divider>

        <el-form-item label="产品介绍">
          <el-input
            type="textarea"
            :rows="5"
            placeholder="请输入内容"
            v-model="food.commodity.introduce">
          </el-input>

        </el-form-item>

        <el-form-item>
          <el-button @click="subPhone">提交</el-button>
          <el-button @click="delFurniture">删除</el-button>
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
          <div>{{food}}</div>
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
import axios from "axios";
export default {
  name: 'editFood',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/food/selectFoodById',{params:{commodity_id: this.commodity_id}}).then(
      (response) => {
        this.food = response.data;
      }
    )
  },
  methods : {
    subPhone(){
      this.dialogVisible = true;
    },
    submitInfo(){
      axios.post('/food/updateFoodInfo',this.food).then();
      this.dialogVisible = false;
      this.dialogSuc=true;
    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push('/businessCommodity');

    },
    delFurniture(){
      axios.get('/food/deleteFoodById',{params:{commodity_id: this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
      this.reload();
    }
  },
  data(){
    return{
      food : {
        ex : '',
        product_standard_number : '',
        production_license_number : '',
        food_weight : '',
        food_type : ''
      },
      dialogVisible : false,
      dialogSuc : false
    }
  }
}
</script>
<style scoped>
</style>
