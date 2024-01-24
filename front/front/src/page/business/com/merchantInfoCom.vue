<template>
  <div>
    <div>显示商家信息</div>
    <div>
      <div style="width: auto;text-align: right">
        <el-button @click="editI" circle icon="el-icon-setting"></el-button>
      </div>
      <el-row :gutter="20">
        <el-col :span="4" style="text-align: center">
          <div>
            <el-avatar :size="100" :src="squareUrl"></el-avatar>
          </div>
          <div style="text-align: center;margin-top: 10px">
          </div>
        </el-col>
        <el-col :span="18">
          <div>基本信息</div>
          <div>
            <div><span>店铺名：</span>{{merchant_info.merchant_name}}</div>
            <div><span>店铺地址：</span>{{merchant_info.merchant_address}}</div>
            <div><span>店铺手机：</span>{{merchant_info.merchant_number}}</div>
            <div><span>店铺邮箱：</span>{{merchant_info.merchant_email}}</div>
            <div><span>店铺介绍：</span>{{merchant_info.mer_intro}}</div>
          </div>
        </el-col>
        <el-col :span="6"></el-col>
      </el-row>


    </div>



    <el-dialog
      :visible.sync="diaEdit"
    >
      <el-divider></el-divider>
      <el-form>
        <el-form-item label="商店昵称">
          <el-input v-model="editMerchant.merchant_name"></el-input>
        </el-form-item>
        <el-form-item label="店铺地址">
          <el-input v-model="editMerchant.merchant_address"></el-input>
        </el-form-item>
        <el-form-item label="商店电话">
          <el-input v-model="editMerchant.merchant_number"></el-input>
        </el-form-item>
        <el-form-item label="商店邮箱">
          <el-input v-model="editMerchant.merchant_email"></el-input>
        </el-form-item>
        <el-form-item label="商店介绍">
          <el-input v-model="editMerchant.mer_intro"></el-input>
        </el-form-item>

        <el-form-item label="上传头像">
          <el-upload
            ref="upload"
            :limit="1"
            :data="{merchant_id : merchant_info.merchant_id}"
            action="http://localhost:8906/merchant/upHeadImg"
            :auto-upload="false"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>
        </el-form-item>

      </el-form>
      <el-divider></el-divider>
      <el-button @click="subEditInfo()">确定</el-button>
      <el-button @click="falseDig">取消</el-button>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'merchantInfoCom',
  inject : ['reload'],
  created() {
    axios.get('/merchant/getMerchantInfo').then(
      (res) => {
        this.merchant_info = res.data;
        this.squareUrl = this.url_head+this.merchant_info.img;
      }
    )
  },
  methods:{
    editI(){
      this.editMerchant = this.merchant_info;
      this.diaEdit = true;
    },
    subEditInfo(){
      this.$refs.upload.submit();
      axios.post('/merchant/updateMerchantInfo',this.editMerchant).then();
      this.diaEdit = false;
      this.reload();
    },
    falseDig(){
      this.diaEdit = false;
      this.reload();
    }
  },
  data(){
    return{
      url_head : 'http://localhost:8906//',
      merchant_info : {
        merchant_name : '',
        merchant_address : '',
        merchant_number : '',
        merchant_email : '',
        mer_intro : ''
      },
      editMerchant : '',
      diaEdit : false,
      squareUrl : ''
    }
  }
}
</script>
<style scoped>
</style>
