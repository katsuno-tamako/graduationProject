<template>
   <div>
     <Header/>
     <Header2/>

     <div>
       <el-row :gutter="20">
         <el-col :span="5">
           <el-card style="text-align: center">
             <div style="background-color:black;font-size:20px;color:white;height: 30px;width: auto;padding: 5px">
               <span @click="lod"><b>分类</b></span>
             </div>
             <el-divider>热门品牌</el-divider>
             <el-row :gutter="10">
               <el-col :span="8" ><span @click="sendKey('--')">分类1</span></el-col>
               <el-col :span="8" ><span @click="sendKey('--')">分类1</span></el-col>
               <el-col :span="8" ><span @click="sendKey('--')">分类1</span></el-col>
             </el-row>
           </el-card>
         </el-col>
         <el-col :span="14">
           <el-card>
             <furnitureCom :keyword="keyword"/>
           </el-card>
         </el-col>
         <el-col :span="5"></el-col>
       </el-row>
     </div>


   </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import furnitureCom from "../../components/index/categoryFurniture/furnitureCom";
import axios from 'axios'
export default {
  name: 'furniturePage',
  inject : ['reload'],
  components : {
    Header,Header2,furnitureCom
  },
  created() {
    axios.get('/furniture/selectAllFurniture').then(
      (response) => {
        this.furniture = response.data
      }
    );
  },
  methods : {
    sendKey(){

    },
    lod(){
      this.reload();
    }
  },
  data(){
    return{
      furniture : '',
      keyword : 'nullBrand'
    }
  }
}
</script>
<style scoped>
</style>
