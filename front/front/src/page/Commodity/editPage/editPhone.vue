<template>
  <div>
    <div>编辑信息：{{commodity_id}}</div>
    <el-divider></el-divider>
    <el-form :model="phone" >
      <el-form-item label="名称">
        <el-input v-model="phone.commodity_name" maxlenght="15" minlenght="1"></el-input>
      </el-form-item>
      <el-form-item label="价钱">
        <el-input v-model="phone.price" placeholder="请输入价钱" oninput="value=value.replace(/^\.+|[^\d.]/g,'')"></el-input>
      </el-form-item>
      <el-form-item label="上市时间">
        <el-date-picker v-model="phone.market_time" type="date" placeholder="选择日期" format="yyyy-MM-dd"></el-date-picker>
      </el-form-item>
      <el-form-item label="品牌">
        <el-input v-model="phone.brand"></el-input>
      </el-form-item>
      <el-form-item label="处理器">
        <el-input v-model="phone.phone_cpu"></el-input>
      </el-form-item>
      <el-form-item label="手机操作系统">
        <el-input v-model="phone.operating_system"></el-input>
      </el-form-item>
      <el-form-item label="手机分辨率">
        <el-input v-model="phone.resolution"></el-input>
      </el-form-item>
      <el-form-item label="手机宽度">
        <el-input v-model="phone.phone_width" ></el-input>
      </el-form-item>
      <el-form-item label="手机长度">
        <el-input v-model="phone.phone_length"></el-input>
      </el-form-item>
      <el-form-item label="手机重量">
        <el-input v-model="phone.phone_weight"></el-input>
      </el-form-item>
      <el-form-item label="手机厚度">
        <el-input v-model="phone.phone_thick"></el-input>
      </el-form-item>
      <el-form-item label="存储容量">
        <el-input v-model="phone.storage"></el-input>
      </el-form-item>
      <el-form-item label="内存">
        <el-input v-model="phone.internal_storage"></el-input>
      </el-form-item>
      <el-form-item label="屏幕尺寸">
        <el-input v-model="phone.screen_size"></el-input>
      </el-form-item>
      <el-form-item label="屏幕材料">
        <el-input v-model="phone.screen_material"></el-input>
      </el-form-item>
      <el-form-item label="电池是否可拆卸">
        <el-input v-model="phone.battery_removable"></el-input>
      </el-form-item>
      <el-form-item label="SIM类型">
        <el-input v-model="phone.number_of_sim"></el-input>
      </el-form-item>
      <el-form-item label="是否支持无线充电">
        <el-input v-model="phone.wireless_charging"></el-input>
      </el-form-item>
      <el-form-item label="后置摄像头像素">
        <el-input v-model="phone.backshot_main_pixel"></el-input>
      </el-form-item>
      <el-form-item label="前置摄像头像素">
        <el-input v-model="phone.foreshot_main_pixel"></el-input>
      </el-form-item>

      <el-divider></el-divider>
      <el-form-item label="产品介绍">
        <el-input
          type="textarea"
          :rows="5"
          maxlength="100"
          placeholder="请输入内容"
          v-model="phone.commodity.introduce">
        </el-input>

      </el-form-item>

      <el-form-item>
        <el-button @click="subPhone">提交</el-button>
        <el-button @click="deletePhoneInfo">删除</el-button>
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
        <div>{{phone}}</div>
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
</template>

<script>
import axios from 'axios';
export default {
  name: 'editPhone',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/phone/selectPhoneById',{params : {commodity_id: this.commodity_id}}).then(
      (response) => {
        this.phone = response.data;
      }
    );
  },
  methods : {
    submitInfo(){
      axios.post('/phone/updatePhoneInfo',this.phone).then();
      this.dialogVisible = false;
      this.dialogSuc = true;

    },
    subPhone(){
      this.dialogVisible = true;

    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push('/businessCommodity');
    },
    deletePhoneInfo(){
      axios.get('/phone/deletePhoneInfo',{params : {commodity_id: this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
      this.reload();
    }
  },
  data(){
    return{
      phone : {
        commodity_name : '',
        market_time : '',
        brand : '',
        phone_cpu : '',
        operating_system : '',
        phone_width : '',
        phone_thick : '',
        phone_weight : '',
        phone_length : '',
        storage : '',
        internal_storage : '',
        screen_size : '',
        screen_material : '',
        battery_removable : '',
        wireless_charging : '',
        number_of_sim : '',
        resolution : '',
        backshot_main_pixel : '',
        foreshot_main_pixel : '',
        price : ''
      },
      dialogVisible : false,
      dialogSuc : false
    }
  }
}
</script>
<style scoped>
</style>
