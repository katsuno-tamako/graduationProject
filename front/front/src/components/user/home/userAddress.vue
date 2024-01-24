<template>
  <div>
    <el-card  shadow="never">
      <div v-for="address in user_address" :key="address" style="margin: 10px 0">
        <el-card  shadow="never">
          <el-row :gutter="20">
            <el-col :span="20">
              <div><span>收货人:{{address.user_name}}</span></div>
              <div><span>收货地址:{{address.address}}</span></div>
              <div><span>手机号:{{address.phone}}</span></div>
            </el-col>
            <el-col :span="4">
              <div style="text-align: right">
<!--                <span @click="openUpdateAddress(address)">编辑</span>-->
<!--                <span @click="deleteUpdate(address.id)">删除</span>-->
                <el-button icon="el-icon-setting" @click="openUpdateAddress(address)" circle></el-button>
                <el-button icon="el-icon-delete" @click="deleteUpdate(address.id)" circle></el-button>
              </div>

            </el-col>
          </el-row>


          <el-dialog title="编辑地址" :visible.sync="dialogFormVisible">
            {{ac.id}}
            <el-form :model="ac">
              <el-form-item label="收货人">
                <el-input v-model="ac.user_name"></el-input>
              </el-form-item>

              <el-form-item label="地址">
                <el-input v-model="ac.address"></el-input>
              </el-form-item>

              <el-form-item label="电话">
                <el-input v-model="ac.phone"></el-input>
              </el-form-item>

              <el-form-item>
                <el-button @click="cancelUp">取 消</el-button>
                <el-button type="primary" @click="updateAddress">确 定</el-button>
              </el-form-item>

            </el-form>
          </el-dialog>

        </el-card>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'userAddress',
  inject : ['reload'],
  data () {
    return {
      user_address : {
        user_name : '',
        address : '',
        tag : '',
        default_address : ''
      },
      dialogFormVisible: false,
      ac : ''
    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        axios.get('/user/selectUserAddress',{params : {user_id : response.data}}).then(
          (response) => {
            this.user_address = response.data;
          }
        );
      }
    );
  },
  methods : {
    openUpdateAddress(address){
      this.dialogFormVisible=true;
      this.ac = address
    },
    updateAddress(){
      axios.post('/user/updateAddress',this.ac).then();
      this.dialogFormVisible = false;
      this.reload();
    },
    deleteUpdate(aid){
      alert("删除成功");
      axios.get('/user/deleteAddress',{params : {id : aid}}).then();
      this.reload();
    },
    cancelUp(){
      this.dialogFormVisible = false;
      this.reload();

    }
  }

}
</script>
<style scoped>
</style>
