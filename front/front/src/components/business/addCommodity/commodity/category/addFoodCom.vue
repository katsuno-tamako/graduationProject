<template>
  <div>
    <div>添加食品</div>
    <el-divider></el-divider>
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
        <el-select v-model="food.ex">
          <el-option value="是" label="是"></el-option>
          <el-option value="否" label="否"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="商品介绍">
        <el-input
          type="textarea"
          :rows="5"
          placeholder="请输入内容"
          v-model="food.commodity.introduce"
        >
        </el-input>
      </el-form-item>

      <el-form-item>
        <el-upload
          ref="upload"
          action="http://localhost:8906/food/receiveFoodImg"
          :auto-upload="false"
          list-type="picture"
          :limit="1"
          :data="{commodity_id : commodity_id}"
        >
          <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
        </el-upload>
      </el-form-item>

      <el-form-item>
        <el-button @click="subPhone">提交</el-button>
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
        <div><span>食品名称：</span>{{food.name}}</div>
        <div><span>食品价钱：</span>{{food.price}}</div>
        <div><span>食品类型：</span>{{food.food_type}}</div>
        <div><span>食品重量：</span>{{food.food_weight}}</div>
        <div><span>食品源地：</span>{{food.origin}}</div>
        <div><span>生产许可证号：</span>{{food.production_license_number}}</div>
        <div><span>产品标准号：</span>{{food.product_standard_number}}</div>
        <div><span>是否为出口：</span>{{food.ex}}</div>
        <div><span>商品介绍：</span>{{food.commodity.introduce}}</div>
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
        <el-button type="primary" @click="subSuc">返回我的商品</el-button>
      </el-dialog>
    </div>




  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'addFoodCom',
  methods : {
    subPhone(){
      this.dialogVisible = true;
    },
    submitInfo(){
      let _this = this;
      axios.post('/food/insertFoodInfo',this.food).then(
        (response) => {
          setTimeout( ()=> {
            this.commodity_id = response.data;
            console.log(this.commodity_id)
          },100);

          setTimeout(function () {
            _this.subImg();
          },200);

        }
      );
      this.dialogVisible = false;
      this.dialogSuc=true;
    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push("/AllCommodityPage");
    },
    subImg(){
      console.log("subImg function");
      this.$refs.upload.submit();
      this.dialogSuc = true;
    }
  },
  data(){
    return {
      food : {
        ex : '',
        product_standard_number : '',
        production_license_number : '',
        food_weight : '',
        food_type : '',
        commodity : {}
      },
      commodity_id : '',
      dialogVisible : false,
      dialogSuc : false
    }
  }
}
</script>
<style scoped>
</style>
