<template>
  <div>
    <div>编辑家具信息</div>
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
          <el-input v-model="furniture.room"></el-input>
        </el-form-item>

        <el-divider></el-divider>

        <el-form-item label="产品介绍">
          <el-input
            type="textarea"
            :rows="5"
            placeholder="请输入内容"
            v-model="furniture.commodity.introduce">
          </el-input>

        </el-form-item>

        <el-form-item>
          <el-button @click="subPhone">提交</el-button>
          <el-button @click="delFurniture">删除</el-button>
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
          <div>{{furniture}}</div>
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
          <el-button type="primary" @click="subSuc">确定</el-button>
        </el-dialog>
      </div>


    </div>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'editFurniture',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/furniture/selectFurnitureById',{params:{commodity_id:this.commodity_id}}).then(
      (response) => {
        this.furniture = response.data;
      }
    );
  },
  methods : {
    subPhone(){
      this.dialogVisible = true;
    },
    submitInfo(){
      axios.post('/furniture/updateFurniture',this.furniture).then();
      this.dialogVisible = false;
      this.dialogSuc=true;
    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push('/businessCommodity');

    },
    delFurniture(){
      axios.get('/furniture/deleteFurnitureById',{params:{commodity_id: this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
      this.reload();
    }
  },
  data(){
      return{
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
          commodity : {
            introduce : ''
          }
        },
        dialogVisible : false,
        dialogSuc : false
      }
  }
}
</script>
<style scoped>
</style>
