<template>
  <div>
    <div>
      <adminHead/>
    </div>
    <div>
      <el-container>
        <el-aside style="width: 200px">
          <el-card>

            <div style="margin: 10px" @click="t2">
              <div style="font-size: 20px">主页</div>
            </div>
            <el-divider></el-divider>
            <router-link to="/applyPage">
              <div style="margin: 10px" @click="tt">
                申请管理
              </div>
            </router-link>
            <router-link to="/SecurityManagerPage">
              <div style="margin: 10px" @click="tt">
<!--                密保管理-->
              </div>
            </router-link>
            <router-link to="/adminManagerIndexPage">
              <div style="margin: 10px" @click="tt">
                管理主页信息
              </div>
            </router-link>

            <router-link to="/editCategoryPage">
              <div style="margin: 10px" @click="tt">
                分类编辑
              </div>
            </router-link>

            <div></div>
          </el-card>
        </el-aside>
        <el-main>
          <div v-if="hst === 0">
            <div style="height: 100px;font-size: 40px;padding: 10px">
              {{hoursTip}}~
            </div>
            <el-divider></el-divider>
            <div style="height: 60px;border:1px solid gainsboro;padding-top: 20px;font-size: 20px;padding-left: 10px">
              用户数量:{{userNum}}
            </div>
            <el-divider></el-divider>
            <div style="height: 60px;border:1px solid gainsboro;padding-top: 20px;font-size: 20px;padding-left: 10px">
              访问量{{pageView}}
            </div>
            <el-divider></el-divider>
            <div style="height: 60px;border:1px solid gainsboro;padding-top: 20px;font-size: 20px;padding-left: 10px">
              交易量{{orderNum}}
            </div>
          </div>
          <div v-if="hst === '1'">
            <router-view/>
          </div>


        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
import adminHead from "../../components/admin/adminHomeCom/adminHead";
import merchantManage from "../../components/admin/merchantManage";
import orderManager from "../../components/admin/orderManager";
import adminOther from "../../components/admin/adminOther";
import applyMerchant from "../../components/admin/applyMerchant";
import adminManType from "../../components/admin/adminManType";
import adminSecurityQuestionCom from "../../components/admin/adminSecurityQuestionCom";
import axios from "axios";
export default {
  name: 'adminHome',
  components : {
    merchantManage,orderManager,adminOther,applyMerchant,adminManType,adminSecurityQuestionCom,adminHead
  },
  created() {

    let date = new Date();
    if(date.getHours()>=0&&date.getHours()<12){

      this.hoursTip="上午好"

    }else if(date.getHours()>=12&&date.getHours()<18){

      this.hoursTip="下午好"

    }else{

      this.hoursTip="晚上好"

    }
    axios.get('/admin/getAdminSession').then(
      (res) => {
        this.stu = res.data;
        if(this.stu ==='NoLog'){
          console.log(res.data);
          this.$router.push('/adminLogin');
        }
      }
    );

    axios.get('/user/getUserNumber').then(
      (res)=>{
        this.userNum = res.data
      }
    );

    axios.get('/page/getPageView').then(
      (res) => {
        this.pageView = res.data
      }
    );

    axios.get('/order/getOrderNumber').then(
      (res) => {
        this.orderNum = res.data;
      }
    );

  },
  data () {
    return {
      d : '',
      st : '',
      hst : 0,
      userNum : '',
      pageView : '',
      orderNum : '',
      hoursTip : ''
    }
  },
  methods : {
    cd(i){
      this.d=i;
      console.log(this.d);
    },
    tt(){
      this.hst = '1'
    },
    t2(){
      this.hst = 0
    }
  }
}
</script>
<style scoped>
  a{
    text-decoration:none
  }
</style>
