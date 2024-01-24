<template>
  <div>添加电脑
  <el-form :model="computer" label-width="80px">
    <el-form-item label="电脑名称">
      <el-input v-model="computer.computer_name"></el-input>
    </el-form-item>

    <el-form-item label="价钱">
      <el-input v-model="computer.price"></el-input>
    </el-form-item>

    <el-form-item label="电脑类型">
      <el-select v-model="computer.computer_type" clearable allow-create filterable="true">
        <el-option v-for="c in computer_type"
                   :key="c.id"
                   v-if="c.first_type==='电脑类型'"
                   :label="c.second_type"
                   :value="c.second_type"
        ></el-option>
      </el-select>
<!--      <el-input v-model="computer.computer_type"></el-input>-->

    </el-form-item>

    <el-form-item label="CPU型号">
      <el-input v-model="computer.cpu"></el-input>
    </el-form-item>

    <el-form-item label="内存">
      <el-input v-model="computer.memory"></el-input>
    </el-form-item>

    <el-form-item label="硬盘容量">
      <el-input v-model="computer.disk"></el-input>
    </el-form-item>

    <el-form-item label="操作系统">
      <el-select v-model="computer.system" clearable allow-create filterable="true">
        <el-option v-for="c in computer_type"
                   :key="c.id"
                   v-if="c.first_type==='操作系统'"
                   :label="c.second_type"
                   :value="c.second_type"
        ></el-option>
      </el-select>
<!--      <el-input v-model="computer.system"></el-input>-->
    </el-form-item>

    <el-form-item label="分辨率">
      <el-input v-model="computer.resolution"></el-input>
    </el-form-item>

    <el-form-item label="品牌">
      <el-select v-model="computer.brand" clearable allow-create filterable="true">
        <el-option v-for="c in computer_type"
                  :key="c.id"
                  v-if="c.first_type==='品牌'"
                   :label="c.second_type"
                   :value="c.second_type"
        ></el-option>
      </el-select>
<!--      <el-input v-model="computer.brand"></el-input>-->
    </el-form-item>

    <el-form-item label="商品介绍">
      <el-input
        type="textarea"
        :rows="5"
        placeholder="请输入内容"
        v-model="computer.commodity.introduce"
      >
      </el-input>
    </el-form-item>

    <el-form-item>
      <el-upload
        ref="upload"
        action="http://localhost:8906/computer/receiveComputerImg"
        :auto-upload="false"
        list-type="picture"
        :limit="1"
        :data="{commodity_id : commodity_id}"
      >
        <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
      </el-upload>
    </el-form-item>


    <el-form-item>
      <el-button type="primary" @click="subComputer()">添加</el-button>
      <el-button>取消</el-button>
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
        <div>
          <div>商品名词:{{computer.computer_name}}</div>
          <div>商品价钱:{{computer.price}}</div>
          <div>电脑类型:{{computer.computer_name}}</div>
          <div>CPU型号:{{computer.cpu}}</div>
          <div>内存:{{computer.memory}}</div>
          <div>硬盘容量:{{computer.disk}}</div>
          <div>操作系统:{{computer.system}}</div>
          <div>分辨率:{{computer.resolution}}</div>
          <div>品牌:{{computer.brand}}</div>
        </div>
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
  name: 'addComputerCom',
  created() {
      axios.get('/computer/selectAllComputerType').then(
        (res)=>{
          this.computer_type = res.data;
        }
      )
    },
  methods : {
    subComputer(){
      this.dialogVisible = true;

    },
    submitInfo(){
      this.dialogVisible = false;
      this.dialogSuc=true;
      let _this = this;
      axios.post('/computer/insertComputer',this.computer).then(
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
    return{
      computer : {
        commodity : {}
      },
      commodity_id : '',
      dialogVisible : false,
      dialogSuc : false,
      computer_type : {
        first_type : '',
        second_type : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
