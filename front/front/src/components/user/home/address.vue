<template>
  <div>
    <div>
      <el-button size="mini" style="margin-bottom: 20px" @click="dialogFormVisible = true">添加收获地址</el-button>
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
</template>

<script>
import axios from 'axios';
import userAddress from "./userAddress";
export default {
  name: "address",
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
  components : {
    userAddress

  },
  methods : {
    insertAddress(){
      this.user_address.user_id = this.$store.state.user_id;
      console.log(this.user_address.user_id)
      axios.post('/user/insertAddress',this.user_address).then();
     this.dialogFormVisible = false;
      this.reload();
    }
  }
}
</script>
<style scoped>

</style>




