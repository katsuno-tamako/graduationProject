<template>
   <div>
     <div>添加服装</div>
     <el-divider></el-divider>
     <el-form :model="cloth" >

       <el-form-item label="名称">
         <el-input v-model="cloth.commodity_name" maxlenght="15" minlenght="1"></el-input>
       </el-form-item>

       <el-form-item label="品牌">
         <el-input v-model="cloth.brand" maxlenght="15" minlenght="1"></el-input>
       </el-form-item>

       <el-form-item label="价格">
         <el-input v-model="cloth.price" maxlenght="15" minlenght="1"></el-input>
       </el-form-item>

       <el-form-item label="服装类型">
<!--         <el-input v-model="cloth.cloth_type" maxlenght="15" minlenght="1"></el-input>-->
<!--         <el-input v-model="cloth.cloth_type" maxlenght="15" minlenght="1"></el-input>-->
         <el-select v-model="cloth.cloth_type" placeholder="请选择">
           <el-option v-for="type in cloth_type" :key="type.id"
                      :label="type.category_type"
                      :value="type.category_type"
           ></el-option>
         </el-select>
       </el-form-item>

       <el-form-item label="使用季节">
<!--         <el-input v-model="cloth.apply_to_session" maxlenght="15" minlenght="1"></el-input>-->
         <el-select v-model="cloth.apply_to_session" placeholder="请选择">
           <el-option v-for="session in cloth_session" :key="session.id"
                      :label="session.category_type"
                      :value="session.category_type"
           ></el-option>
         </el-select>
       </el-form-item>

       <el-form-item label="服装重量">
         <el-input v-model="cloth.commodity_weight" maxlenght="15" minlenght="1"></el-input>
       </el-form-item>

       <el-form-item label="适用人群">
<!--         <el-input v-model="cloth.suitable" maxlenght="15" minlenght="1"></el-input>-->
         <el-select v-model="cloth.suitable" placeholder="请选择">
           <el-option v-for="s in suitable" :key="s.id"
                      :label="s.category_type"
                      :value="s.category_type"
           ></el-option>
         </el-select>
       </el-form-item>

       <el-form-item label="服装风格">
<!--         <el-input v-model="cloth.clothing_style" maxlenght="15" minlenght="1"></el-input>-->
         <el-select v-model="cloth.clothing_style" placeholder="请选择">
           <el-option v-for="style in cloth_style" :key="style.id"
                      :label="style.category_type"
                      :value="style.category_type"
           ></el-option>
         </el-select>
       </el-form-item>

       <el-form-item label="上市时间">
         <el-input v-model="cloth.market_time" maxlenght="15" minlenght="1"></el-input>
       </el-form-item>

       <el-form-item label="商品介绍">
         <el-input
           type="textarea"
           :rows="5"
           placeholder="请输入内容"
           v-model="cloth.commodity.introduce"
         >
         </el-input>
       </el-form-item>

       <el-form-item>
         <el-upload
           ref="upload"
           action="http://localhost:8906/cloth/receiveClothImage"
           :auto-upload="false"
           list-type="picture"
           :limit="1"
           :data="{commodity_id : commodity_id}"
         >
           <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
         </el-upload>
       </el-form-item>

       <el-form-item>
         <el-button @click="subCloth">提交</el-button>
       </el-form-item>

     </el-form>

     <div>
       <el-dialog
         title="确认一下"
         :visible.sync="dialogVisible"
       >
         <div>
           确认一下
         </div>
         <el-divider></el-divider>
         <div>商品名：{{cloth.commodity_name}}</div>
         <div>上市时间：{{cloth.market_time}}</div>
         <div>服装品牌{{cloth.brand}}</div>
         <div>商品价格{{cloth.price}}</div>
         <div>服装类型：{{cloth.cloth_type}}</div>
         <div>使用季节{{cloth.apply_to_session}}</div>
         <div>服装毛重：{{cloth.commodity_weight}}</div>
         <div>适用人群：{{cloth.suitable}}</div>
         <div>服装风格{{cloth.clothing_style}}</div>
         <div>商品介绍：{{cloth.commodity.introduce}}</div>
         <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitInfo">确 定</el-button>
        </span>
       </el-dialog>
     </div>

     <div>
       <el-dialog
         :visible.sync="dialogSuc">
         <div>提交成功</div>
         <el-divider></el-divider>
         <el-button type="primary" @click="subSuc">返回我的商品</el-button>
       </el-dialog>
     </div>

   </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'addClothCom',
  created() {
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装类型'}}).then((res)=>{this.cloth_type=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装风格'}}).then((res)=>{this.cloth_style=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'适用人群'}}).then((res)=>{this.suitable=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res)=>{this.cloth_session=res.data});
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res)=>{this.cloth_brand=res.data});

  },
  data(){
    return {
      cloth : {
        commodity_name : '',
        market_time : '',
        brand : '',
        price : '',
        cloth_type : '',
        apply_to_session : '',
        commodity_weight : '',
        suitable : '',
        clothing_style : '',
        commodity : {}
      },
      dialogVisible : false,
      dialogSuc : false,
      commodity_id : '',

      cloth_type: '',
      cloth_style : '',
      suitable : '',
      cloth_session : '',
      cloth_brand : ''
    }
  },
  methods : {
    subCloth(){
      this.dialogVisible=true;
    },
    submitInfo(){
      let _this = this;
      this.dialogVisible=false;
      this.dialogSuc=true;
      axios.post('/cloth/insertCloth',this.cloth).then(
        (response) => {
          setTimeout( ()=> {
            this.commodity_id = response.data;
            console.log(this.commodity_id)
          },100);

          setTimeout(function () {
            _this.subImg();
          },200);

        }
      );
    },
    subSuc(){
      this.dialogSuc=false;
      this.$router.push("/AllCommodityPage");
    },
    subImg(){
      console.log("subImg function");
      this.$refs.upload.submit();
      this.dialogSuc = true;
    }
  }
}
</script>
<style scoped>
</style>
