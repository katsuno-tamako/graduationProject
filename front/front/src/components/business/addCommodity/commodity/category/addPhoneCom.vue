<template>
  <div>
    <div>添加手机</div>
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
<!--        <el-input v-model="phone.brand"></el-input>-->
        <el-select v-model="phone.brand">
          <el-option v-for="brand in phone_brand" :key="brand.id"  :label="brand.category_type" :value="brand.category_type"></el-option>
        </el-select>
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
<!--        <el-input v-model="phone.wireless_charging"></el-input>-->
        <el-select v-model="phone.wireless_charging">
          <el-option label="否" value="否"></el-option>
          <el-option label="是" value="是"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="后置摄像头像素">
        <el-input v-model="phone.backshot_main_pixel"></el-input>
      </el-form-item>
      <el-form-item label="前置摄像头像素">
        <el-input v-model="phone.foreshot_main_pixel"></el-input>
      </el-form-item>


      <el-form-item label="商品介绍">
        <el-input
          type="textarea"
          :rows="5"
          placeholder="请输入内容"
          v-model="phone.commodity.introduce"
        >
        </el-input>
      </el-form-item>


      <el-form-item>
        <el-upload
          ref="upload"
          action="http://localhost:8906/phone/receivePhoneImage"
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
          <div>名称：{{phone.phone_name}}</div>
          <div>价钱：{{phone.price}}</div>
          <div>上市时间：{{phone.market_time}}</div>
          <div>手机处理器：{{phone.phone_cpu}}</div>
          <div>操作系统：{{phone.operating_system}}</div>
          <div>宽度：{{phone.phone_width}}</div>
          <div>厚度：{{phone.phone_thick}}</div>
          <div>重量：{{phone.phone_weight}}</div>
          <div>长度：{{phone.phone_length}}</div>
          <div>存储容量：{{phone.storage}}</div>
          <div>内存：{{phone.internal_storage}}</div>
          <div>屏幕尺寸{{phone.screen_size}}</div>
          <div>屏幕材料{{phone.screen_material}}</div>
          <div>电源是否可移除：{{phone.battery_removable}}</div>
          <div>无线网支持：{{phone.wireless_charging}}</div>
          <div>sim类类型：{{phone.number_of_sim}}</div>
          <div>分辨率：{{phone.resolution}}</div>
          <div>后置像素：{{phone.backshot_main_pixel}}</div>
          <div>前置像素：{{phone.foreshot_main_pixel}}</div>
          <div>商品介绍：{{phone.commodity.introduce}}</div>
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
import axios from 'axios'
export default {
  name: 'addPhoneCom',
  created() {
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'手机品牌'}}).then(
      (res)=>{
        this.phone_brand = res.data;
      }
    )
  },
  data(){
    return {
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
        price : '',
        commodity : {}
      },
      commodity_id : '',
      dialogVisible : false,
      dialogSuc : false,
      phone_brand : ''
    }
  },
  methods : {
    subPhone(){
      this.dialogVisible = true;
    },
    submitInfo(){
      this.dialogVisible = false;
      this.dialogSuc = true;
      let _this = this;
      axios.post('/phone/insertPhone',this.phone).then(
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
  }
}
</script>
<style scoped>
</style>
