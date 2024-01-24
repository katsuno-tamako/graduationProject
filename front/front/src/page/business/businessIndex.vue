<template>
   <div>

     <div>
       <business-header/>
       <businessMenuCom/>
       <div>
         <div>
           <div  style="margin: 0 10%">
             <el-divider></el-divider>
             <el-card>
               <div v-if="status == 0">
                 <merchantInfoCom/>
               </div>
               <div v-else>
                 <router-view/>
               </div>
             </el-card>
           </div>
         </div>
       </div>
     </div>

   </div>
</template>

<script>
import axios from 'axios';
import insertCommodityPage from "../../components/business/BusinessInsert/insertCommodity/insertCommodityPage";
import merchantInfoCom from "./com/merchantInfoCom";
import businessHeader from "./theme/businessHeader";
import businessMenuCom from "./theme/businessMenuCom";
export default {
  name: 'businessIndex',
  components : {
    insertCommodityPage,merchantInfoCom,businessHeader,businessMenuCom
  },
  data () {
    return {
      status : 0,
      test : 'test',
      merchant : {
        id : ''
      }
    }
  },
  methods : {
    logout(){
      this.$store.state.merchant_id = "";
      axios.get('/merchant/merchantLogout').then();
      this.$router.push('/businessLogin');
    },
    com(i){
      this.status = i;
      console.log(this.status);
    }
  },
  created() {
      axios.get('/merchant/getMerchantId')
        .then((response) => {
          this.merchant.id = response.data;
          console.log("ID:"+this.merchant.id);
          this.$store.state.merchant_id = response.data;
          if(response.data == null){
            this.$router.push('/businessLogin');
          }
        });

    }

}
</script>
<style scoped>
  a:link { text-decoration: none;}
  a:hover{text-decoration:none}
  body{
    margin: 0;
    padding: 0;
  }
</style>
