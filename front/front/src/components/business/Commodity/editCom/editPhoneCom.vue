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

        <el-form-item label="选择商品封面的图片：">
          <el-upload
            ref="upload1"
            action="http://localhost:8906/phone/receivePhoneImage"
            :auto-upload="false"
            list-type="picture"
            :limit="1"
            :data="{commodity_id : phone.commodity.commodity_id}"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="其他图片">
          <el-upload
            ref="upload2"
            action="http://localhost:8906/uploadCommodity"
            :auto-upload="false"
            list-type="picture"
            :data="{commodity_id : phone.commodity.commodity_id}"
            :file-list="fileList"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>

          <el-card style="">
            <div>选中图片后删除</div>
            <el-checkbox-group v-model="selectImg">

              <el-checkbox-button :label="img" v-for="img in phone_img" :key="img.id">
                <el-card style="text-align: center;display:flex;overflow-x:auto;overflow-y:hidden">
                  <el-image
                    style="height: 100px"
                    :src="url_head+img.path"
                  ></el-image>
                </el-card>
              </el-checkbox-button>
            </el-checkbox-group>
          </el-card>
        </el-form-item>

        <el-form-item>
          <el-button @click="sub">确定</el-button>
          <el-button @click="cal">取消</el-button>
        </el-form-item>

      </el-form>
    </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'editPhoneCom',
  props : ['c_info'],
  inject : ['reload'],
  created() {
    axios.get('/phone/selectPhoneById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.phone = response.data
      }
    );

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.phone_img = response.data;
      }
    );
  },
  methods : {
    sub(){
      axios.post('/phone/updatePhoneInfo',this.phone).then();
      axios.post('/deleteImgArray',this.selectImg).then();
      this.$refs.upload1.submit();
      this.$refs.upload2.submit();
      this.reload();
    },
    cal(){
      this.reload();
    },
    deleteImg(path){
      axios.get('/deleteImgArray',{params : {url : path}}).then();
      this.reload();
    }
  },
  data(){
    return{
      phone : '',
      phone_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      fileList : [],
    }
  }
}
</script>
<style scoped>
</style>
