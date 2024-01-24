<template>
  <div>
    <div>编辑服装</div>
    <el-divider></el-divider>
    <el-form :model="cloth" >

      <el-form-item label="名称">
        <el-input v-model="cloth.commodity_name" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="品牌">
        <el-input v-model="cloth.brand" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="价格">
        <el-input v-model="cloth.price" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="服装类型">
        <el-input v-model="cloth.cloth_type" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="使用季节">
        <el-input v-model="cloth.apply_to_session" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="服装重量">
        <el-input v-model="cloth.commodity_weight" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="适用人群">
        <el-input v-model="cloth.suitable" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="服装风格">
        <el-input v-model="cloth.clothing_style" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-form-item label="上市时间">
        <el-input v-model="cloth.market_time" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>

      <el-divider></el-divider>
      <el-form-item label="产品介绍">
        <el-input
          type="textarea"
          :rows="5"
          maxlength="100"
          placeholder="请输入内容"
          v-model="cloth.commodity.introduce">
        </el-input>

      </el-form-item>


      <el-form-item>
        <el-button @click="subCloth">提交</el-button>
        <el-button @click="delCloth">删除</el-button>
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
        <div>{{cloth}}</div>
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
        <el-button type="primary" @click="subSuc">进入图片管理</el-button>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'editCloth',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/cloth/selectClothById',{params:{commodity_id: this.commodity_id}}).then(
      (response) => {
        this.cloth = response.data
      }
    );
  },
  methods : {
    subCloth(){
      this.dialogVisible=true;
    },
    submitInfo(){
      this.dialogVisible=false;
      this.dialogSuc=true;
      axios.post('/cloth/updateCloth',this.cloth).then(
        (response) => {
          this.commodity_id = response.data;
        }
      );
    },
    subSuc(){
      this.dialogSuc=false;
      this.$router.push('/businessCommodity');
    },
    delCloth(){
      axios.get('/cloth/deleteClothById',{params:{commodity_id: this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
      this.reload();
    }
  },
  data(){
    return {
      cloth : {
        commodity_name : '',
        market_time : '',
        brand : '',
        price : '',
        cloth_type : '',
        apply_to_session : '',
        commodity_weight : '',
        suitable : '',
        clothing_style : ''
      },
      dialogVisible : false,
      dialogSuc : false,
    }
  }
}
</script>
<style scoped>
</style>
