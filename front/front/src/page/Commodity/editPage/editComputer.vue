<template>
  <div>
    <div>编辑信息</div>

    <el-form :model="computer" label-width="80px">
      <el-form-item label="电脑名称">
        <el-input v-model="computer.computer_name"></el-input>
      </el-form-item>

      <el-form-item label="价钱">
        <el-input v-model="computer.price"></el-input>
      </el-form-item>

      <el-form-item label="电脑类型">
        <el-input v-model="computer.computer_type"></el-input>
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
        <el-input v-model="computer.system"></el-input>
      </el-form-item>

      <el-form-item label="分辨率">
        <el-input v-model="computer.resolution"></el-input>
      </el-form-item>

      <el-form-item label="品牌">
        <el-input v-model="computer.brand"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="subComputer()">确定</el-button>
        <el-button @click="deleteComputer">删除</el-button>
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
        <div>{{computer}}</div>
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
        <el-button type="primary" @click="subSuc">提交</el-button>
      </el-dialog>
    </div>


  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'editComputer',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/computer/selectComputerById',{params:{commodity_id:this.commodity_id}}).then(
      (response) => {
        this.computer = response.data
      }
    );
  },
  methods : {
    subComputer(){
      this.dialogVisible = true;

    },
    submitInfo(){
      this.dialogVisible = false;
      this.dialogSuc=true;
      axios.post('/computer/updateComputerById',this.computer).then(
        (response) => {
          console.log(response.data)
          this.commodity_id = response.data;
        }
      );

    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push('/businessCommodity');
      this.reload();
    },
    deleteComputer(){

      axios.get('/computer/deleteComputerById',{params:{commodity_id:this.commodity_id}}).then();
    }
  },
  data(){
    return{
      computer : {
        commodity : ''
      },
      dialogVisible : false,
      dialogSuc : false
    }
  }

}
</script>
<style scoped>
</style>
