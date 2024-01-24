<template>
    <div>
      <el-row class="el_row_css">
        <el-col :span="4" style="padding: 0 50px">
          <router-link to="/">
            <img src="../../../src/assets/image/titleImage.png" style="width:70px;">
          </router-link>
        </el-col>
        <el-col :span="16" >
          <span style="visibility: hidden;">1</span>

        </el-col>
        <el-col :span="2">
<!--          <router-link target="_blank" to="/businessLogin">-->
<!--            商家-->
<!--          </router-link>-->
        </el-col>
        <el-col :span="2">

          <span v-if="$store.state.user_id == 'null'">
            <router-link to="/login">
            <el-button  icon="el-icon-user" type="primary" style="height: 50px;width: 50px" circle></el-button>
            </router-link>
          </span>
          <span v-else>
            <el-popover
              placement="right"
              trigger="hover"
              width="200">
              <user-panel/>

                <router-link to="/userHome" slot="reference">
                  <div class="block">
                    <el-avatar :size="50" :src="url_head+user_info.img" shape="square" :key="url_head+user_info.img"></el-avatar>
                  </div>
                </router-link>
            </el-popover>
          </span>


        </el-col>
      </el-row>
    </div>
</template>

<script>
import HeaderSearch from "./HeaderSearch";
import miniShop from "./shopping_cart/miniShop";
import userPanel from "../user/userInfo/userPanel";
import axios from 'axios';

export default {
  name: 'Header',
  data () {
    return {
      user_id : '',
      user_info : '',
      url_head : 'http://localhost:8906//',
    }
  },
  components : {
    HeaderSearch,
    miniShop,
    userPanel
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        if(response.data != null){
          this.$store.state.user_id = response.data;
          this.user_id = response.data;
          console.log(this.user_id);
          axios.get('/user/selectUserInfoById',{params: {user_id: response.data}}).then(
            (response) => {
              this.user_info = response.data;
              console.log(this.user_info)
            }
          );
        }
      }
    );

  },
  methods : {
    log_out(){
      alert('注销')
      axios.get('/user/userLogout').then();
      this.$router.push('/index');
      location.reload()

    },
    clickShop(){
      if(this.$store.state.user_id == 'null'){
        this.$router.push('/login');
      }else{
        this.$router.push('/shopCartPage');
      }

    }
  }
}
</script>
<style scoped>
  .el_row_css{
    background-color: deepskyblue;
    height: 50px;
  }
</style>
