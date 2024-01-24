<template>
  <div>
    <el-header>
      <Header/>
    </el-header>
    <div>
      <el-container>
        <el-aside style="width: 200px;margin: 10px">
          <div v-if="status!=0">
            <el-page-header @back="com(0)">
            </el-page-header>
          </div>

        </el-aside>
        <el-main>

          <div v-if="status==1"><home-user-info/></div>
<!--          <div v-if="status==2"><user-order-info/></div>-->
<!--          <div v-if="status==3"><user-address/></div>-->
<!--          <div v-if="status==4"><user-address/></div>-->
<!--          <div v-if="status==5"><router-link/></div>-->
          <div v-if="status==0">
            <el-divider></el-divider>
            <div style="margin-top: 100px">
              <el-row :gutter="20">
                <el-col :span="6">
                  <div style="height: 200px;width: 200px;text-align: center">
                    <div>
                      <el-avatar :size="100" :src="url"></el-avatar>
                    </div>
                    <div style="margin-top: 10px">
                      {{user_info.user_name}}
                    </div>
                  </div>
                </el-col>
                <el-col :span="16" style="text-align: center;font-size: 18px">
                  <div style="display: none"><div v-for="order in order_info" :key="order.id"></div></div>

                  <el-row :gutter="20">
                    <el-col :span="8"><div  @click="com(1)"><el-card shadow="hover"><i class="el-icon-user"></i>用户信息</el-card></div></el-col>
                    <el-col :span="8"><router-link  to="/userOrderPage" ><el-card shadow="hover"><i class="el-icon-document-copy"></i>订单信息</el-card></router-link></el-col>

                    <!--                    <el-col :span="8"><div  @click="com(2)"><el-card shadow="hover"><i class="el-icon-document-copy"></i>订单信息</el-card></div></el-col>-->
<!--                    <el-col :span="8"><div style="padding: 5px" @click="com(3)"><el-card shadow="hover"><i class="el-icon-house"></i>地址管理</el-card></div></el-col>-->
                    <el-col :span="8"><router-link  to="/shopCartPage" ><el-card shadow="hover"><i class="el-icon-shopping-cart-1"></i>购物车</el-card></router-link></el-col>
                  </el-row>
                  <el-row :gutter="20" style="margin-top: 15px">
                    <el-col :span="8"><router-link  to="/userAddressPage" ><el-card shadow="hover"><i class="el-icon-shopping-cart-1"></i>地址管理</el-card></router-link></el-col>
                    <el-col :span="8"><router-link  to="/userSecurity" ><el-card shadow="hover"><i class="el-icon-lock"></i>用户安全</el-card></router-link></el-col>
                  </el-row>

                </el-col>
              </el-row>
              <el-divider></el-divider>

<!--              <el-card shadow="never">-->
<!--                <div>我的订单</div>-->

<!--                <el-tabs>-->
<!--                  <el-tab-pane label="配送中">-->
<!--                    <UserDelivered/>-->
<!--                  </el-tab-pane>-->
<!--                  <el-tab-pane label="待收货">-->
<!--                    <UserReceiveCOm/>-->
<!--                  </el-tab-pane>-->
<!--&lt;!&ndash;                  <el-tab-pane label="已完成">已完成</el-tab-pane>&ndash;&gt;-->
<!--                </el-tabs>-->

<!--              </el-card>-->

            </div>


          </div>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import homeMenu from "../../components/user/home/homeMenu";
import homeUserInfo from "../../components/user/home/homeUserInfo";
import userOrderInfo from "../../components/user/home/userOrderInfo";
import userAddress from "../../components/user/home/userAddress";
import UserDelivered from "../../components/user/userCom/UserDelivered";
import UserReceiveCOm from "../../components/user/userCom/UserReceiveCOm";
import axios from "axios";
export default {
  name: 'userHome',
  components: {homeMenu, Header2, Header,homeUserInfo,userOrderInfo,userAddress,UserDelivered,UserReceiveCOm},
  methods : {
    com(i){
      console.log(i)
      this.status = i;
    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        this.user_id = response.data;
        axios.get('/user/selectUserInfoById',{params : {user_id : this.user_id}}).then(
          (response) => {
            this.user_info = response.data;
            this.url=this.url_head+this.user_info.img;
          }
        );

        axios.get('/order/selectOrderByUser',{params:{user_id:this.user_id}}).then(
          (response) => {
            this.order_info = response.data;
          }
        )

      }
    );
  },
  data(){
    return{
      url : '',
      url_head : 'http://localhost:8906//',
      status : 0,
      user_info : {},
      order_info : {},
      sum : 0
    }
  }
}
</script>
<style scoped>

  a{
    text-decoration: none;
  }

</style>
