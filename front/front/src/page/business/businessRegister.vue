<template>
  <div>
    <div style="height: 100px;font-size: 30px">
      <span style="margin: 10px 100px">申请商家资格</span></div>
    <el-divider></el-divider>
    <div style="width: auto;margin: 0 20%">
    <el-form>
      <el-form-item label="账号" style="width: 100px">
        <el-input v-model="apply_merchant.account" style="width: 500px" maxlength="12" show-word-limit></el-input>
      </el-form-item>

      <el-form-item label="密码" style="width: 100px">
        <el-input v-model="apply_merchant.password" show-password style="width: 500px" maxlength="18"></el-input>
      </el-form-item>

      <el-form-item label="昵称" style="width: 100px">
        <el-input v-model="apply_merchant.merchant_name" style="width: 500px" maxlength="18"></el-input>
      </el-form-item>

      <el-form-item label="邮件" style="width: 100px">
        <el-input v-model="apply_merchant.merchant_email" style="width: 500px"></el-input>
      </el-form-item>

      <el-form-item label="备注" style="width: 100px">
        <el-input v-model="apply_merchant.apply_info" style="width: 500px" type="textarea"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button @click="subInfo">提交</el-button>
      </el-form-item>

    </el-form>

    <el-dialog
      :visible.sync="dialogVisible"
    >
      <div>提交成功</div>
      <el-button @click="dialogVisible=false">确定</el-button>
    </el-dialog>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'businessRegister',
  inject : ['reload'],
  methods : {
    subInfo(){
      axios.post('/merchant/registerMerchant',this.apply_merchant).then();
      this.dialogVisible = true;
      this.$router.go(-1);
    }
  },
  data(){
    return {
      apply_merchant : {
        account : '',
        password : '',
        merchant_email : '',
        merchant_name: '',
        apply_info : ''
      },
      dialogVisible : false
    }
  }
}
</script>
<style scoped>
</style>
