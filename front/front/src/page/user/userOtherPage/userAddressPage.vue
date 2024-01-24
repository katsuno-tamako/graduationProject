<template>
  <div>
    <Header/>
    <el-divider></el-divider>
    <div style="width: auto;margin-left: 10%">
      <el-page-header @back="goBack" content="地址管理">
      </el-page-header>
      <el-divider>s</el-divider>
    </div>
    <div style="width: auto;margin: 0 20% ">
    <div>

      <el-button size="small" style="margin-bottom: 20px" @click="dialogFormVisible = true">添加收获地址</el-button>
    </div>
    <div>
      <user-address/>
    </div>
    <div>
      <el-dialog title="收货地址" :visible.sync="dialogFormVisible">

        {{this.$store.state.user_id}}

        <el-form :model="user_address">
          <el-form-item label="收货人">
            <el-input v-model="user_address.user_name"></el-input>
          </el-form-item>

          <el-form-item label="地址">
            <el-input v-model="user_address.address"></el-input>
          </el-form-item>

          <el-form-item label="电话">
            <el-input v-model="user_address.phone"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="insertAddress">确 定</el-button>
          </el-form-item>

        </el-form>
      </el-dialog>
    </div>
    </div>
  </div>
</template>

<script>
import userAddress from "../../../components/user/home/userAddress";
import Header from "../../../components/index/Header";
import axios from 'axios'
export default {
  name: 'userAddressPage',
  components : {Header,userAddress},
  inject : ['reload'],
  data () {
    return {
      user_address : {
        user_id : '',
        user_name : '',
        address : '',
        phone : '',
        tag : '',
        default_address : ''
      },
      dialogFormVisible: false
    }
  },
  methods : {
    insertAddress(){
      this.user_address.user_id = this.$store.state.user_id;
      console.log(this.user_address.user_id)
      axios.post('/user/insertAddress',this.user_address).then();
      this.dialogFormVisible = false;
      this.reload();
    },
    goBack(){
      this.$router.go(-1);
    }
  }
}
</script>
<style scoped>
</style>
