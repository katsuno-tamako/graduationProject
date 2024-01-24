<template>
  <div>
    <div>添加商品</div>
    <el-divider></el-divider>
    <div>
      <el-form :model="other" label-width="80px">

        <el-form-item label="名称">
          <el-input v-model="other.commodity_name"></el-input>
        </el-form-item>

        <el-form-item label="商品类型">
          <el-input v-model="other.commodity_type"></el-input>
        </el-form-item>

        <el-form-item label="价格">
          <el-input v-model="other.price"></el-input>
        </el-form-item>

        <el-form-item label="商品简介">
          <el-input v-model="other.commodity_intro"></el-input>
        </el-form-item>

        <el-form-item label="商品介绍">
          <el-input v-model="other.commodity.introduce"></el-input>
        </el-form-item>

        <el-form-item>
          <el-upload
            ref="upload"
            action="http://localhost:8906/other/receiveOtherImg"
            :auto-upload="false"
            list-type="picture"
            :limit="1"
            :data="{commodity_id : commodity_id}"
          >
            <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
          </el-upload>
        </el-form-item>

        <el-form-item>
          <el-button @click="subInfo">提交</el-button>
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
          <div>名称:{{other.commodity_name}}</div>
          <div>名称:{{other.commodity_type}}</div>
          <div>名称:{{other.price}}</div>
          <div>名称:{{other.commodity_intro}}</div>
          <div>名称:{{other.commodity.introduce}}</div>
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
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'addOtherCom',
  methods : {
    subInfo(){
      this.dialogVisible = true;
    },
    submitInfo(){
      let _this = this;

      axios.post('/other/insertOtherCommodity',this.other).then(
        (response) => {
          console.log(response.data)
          setTimeout(()=>{
            this.commodity_id = response.data;
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
      let _this = this;
      console.log("subImg function")
      _this.$refs.upload.submit();
      this.dialogSuc = true;
    },
  },
  data(){
    return {
      other : {
        commodity_name : '',
        commodity_type : '',
        price : '',
        commodity_intro : '',
        commodity : {
          introduce : ''
        },

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
