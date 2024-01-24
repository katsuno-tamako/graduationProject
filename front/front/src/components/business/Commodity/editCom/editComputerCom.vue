<template>
  <div>
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
<!--        <el-input v-model="computer.system"></el-input>-->
        <el-select v-model="computer.system" clearable allow-create filterable="true">
          <el-option v-for="c in computer_type"
                     :key="c.id"
                     v-if="c.first_type==='操作系统'"
                     :label="c.second_type"
                     :value="c.second_type"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="分辨率">
        <el-input v-model="computer.resolution"></el-input>
      </el-form-item>

      <el-form-item label="品牌">
<!--        <el-input v-model="computer.brand"></el-input>-->
        <el-select v-model="computer.brand" clearable allow-create filterable="true">
          <el-option v-for="c in computer_type"
                     :key="c.id"
                     v-if="c.first_type==='品牌'"
                     :label="c.second_type"
                     :value="c.second_type"
          ></el-option>
        </el-select>
      </el-form-item>


      <el-form-item label="商品介绍">
        <el-input
          type="textarea"
          :rows="5"
          placeholder="请输入内容"
          v-model="computer.commodity.introduce">
        </el-input>
      </el-form-item>

      <el-form-item >
        <el-upload
          ref="upload1"
          action="http://localhost:8906/computer/receiveComputerImg"
          :auto-upload="false"
          list-type="picture"
          :limit="1"
          :data="{commodity_id : computer.commodity.commodity_id}"
        >
          选择商品封面的图片:<el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        </el-upload>
      </el-form-item>

      <el-form-item label="其他图片">

        <el-upload
          ref="upload2"
          action="http://localhost:8906/uploadCommodity"
          :auto-upload="false"
          list-type="picture"
          :data="{commodity_id : computer.commodity.commodity_id}"
          :file-list="fileList"
        >
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        </el-upload>

        <el-card style="">
          <div>选中图片后删除</div>
          <el-checkbox-group v-model="selectImg">

            <el-checkbox-button :label="img" v-for="img in computer_img" :key="img.id">
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
import axios from 'axios'
export default {
  name: 'editComputerCom',
  props : ['c_info'],
  inject : ['reload'],
  created() {
    axios.get('/computer/selectComputerById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.computer = response.data;
      }
    );

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.computer_img = response.data;
      }
    );

    axios.get('/computer/selectAllComputerType').then(
      (res)=>{
        this.computer_type = res.data;
      }
    )

  },
  methods : {
    sub(){
      axios.post('/computer/updateComputerById',this.computer).then();
      axios.post('/deleteImgArray',this.selectImg).then();
      this.$refs.upload1.submit();
      this.$refs.upload2.submit();
      this.reload();
    },
    cal(){
      this.reload();
    }
  },
  data(){
    return{
      computer_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      computer : {
        commodity : {}
      },
      fileList : [],
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
