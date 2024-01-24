<template>
    <div>
      <div>插入家具</div>
      <el-divider></el-divider>
      <div>
        <el-form :model="furniture" label-width="80px">
          <el-form-item label="家具名称">
            <el-input v-model="furniture.name"></el-input>
          </el-form-item>

          <el-form-item label="家具价钱">
            <el-input v-model="furniture.price"></el-input>
          </el-form-item>

          <el-form-item label="家具材料">
            <el-input v-model="furniture.furniture_material"></el-input>
          </el-form-item>


          <el-form-item label="家具类型">
            <el-input v-model="furniture.function_type"></el-input>
          </el-form-item>

          <el-form-item label="家具重量">
            <el-input v-model="furniture.furniture_weight"></el-input>
          </el-form-item>

          <el-form-item label="占地面积">
            <el-input v-model="furniture.furniture_area"></el-input>
          </el-form-item>

          <el-form-item label="家居风格">
          <el-input v-model="furniture.furniture_style"></el-input>
        </el-form-item>

          <el-form-item label="品牌">
            <el-input v-model="furniture.brand"></el-input>
          </el-form-item>

          <el-form-item label="使用场景">
<!--            <el-input v-model="furniture.room"></el-input>-->
            <el-select v-model="furniture.room" clearable allow-create filterable="true">
              <el-option v-for="c in room"
                         :key="c.id"
                         :label="c.category_type"
                         :value="c.category_type"
              ></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="商品介绍">
            <el-input
              type="textarea"
              :rows="5"
              placeholder="请输入内容"
              v-model="furniture.commodity.introduce"
            >
            </el-input>
          </el-form-item>


          <el-form-item>
            <el-upload
              ref="upload"
              action="http://localhost:8906/furniture/receiveFurnitureImg"
              :auto-upload="false"
              list-type="picture"
              :limit="1"
              :data="{commodity_id : commodity_id}"
            >
              <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
            </el-upload>
          </el-form-item>


          <el-form-item>
            <el-button @click="subPhone">提交</el-button>
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
            <div>名称：{{furniture.name}}</div>
            <div>价钱：{{furniture.price}}</div>
            <div>家具材料：{{furniture.furniture_material}}</div>
            <div>适用类型：{{furniture.function_type}}</div>
            <div>家具重量：{{furniture.furniture_weight}}</div>
            <div>占地面积：{{furniture.furniture_area}}</div>
            <div>家居风格：{{furniture.furniture_style}}</div>
            <div>家具品牌{{furniture.brand}}</div>
            <div>适用房间{{furniture.room}}</div>
            <div>商品介绍：{{furniture.commodity.introduce}}</div>
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
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'addFurnitureCom',
  created() {
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:"家具房间"}}).then(
      (res) => {
        this.room = res.data;
      }
    )
  },
  methods : {
    subPhone(){
      this.dialogVisible = true;
    },
    submitInfo(){
      let _this = this;
      axios.post('/furniture/insertFurniture',this.furniture).then(
        (response) => {
          console.log(response.data)
          setTimeout(()=>{
            this.commodity_id = response.data;
          },100);
          setTimeout(function () {
            _this.subImg();
          },200);
        }
      );
      this.dialogVisible = false;
      this.dialogSuc=true;
    },
    subImg(){
      let _this = this;
      console.log("subImg function")
      _this.$refs.upload.submit();
      this.dialogSuc = true;
    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push("/AllCommodityPage");
    }
  },
  data(){
    return {
      furniture : {
        name : '',
        price : '',
        furniture_material : '',
        scene : '',
        function_type : '',
        furniture_weight : '',
        furniture_area : '',
        furniture_style : '',
        brand : '',
        room : '',
        commodity : {}
      },
      commodity_id : '',
      dialogVisible : false,
      dialogSuc : false,
      furniture_category : {
      },
      room : ''
    }
  }
}
</script>
<style scoped>

</style>
