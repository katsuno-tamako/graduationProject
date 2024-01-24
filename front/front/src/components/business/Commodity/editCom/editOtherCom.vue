<template>
  <div>
    <div>添加商品</div>
    <el-divider></el-divider>
    <div>
      <el-form :model="other">

        <el-form-item label="名称">
          <el-input v-model="other.commodity_name"></el-input>
        </el-form-item>

        <el-form-item label="商品类型">
          <el-input v-model="other.commodity_type"></el-input>
        </el-form-item>

        <el-form-item label="价格">
          <el-input v-model="other.price"></el-input>
        </el-form-item>

        <el-form-item label="商品简介">
          <el-input v-model="other.commodity_intro"></el-input>
        </el-form-item>

        <el-form-item label="商品介绍">
          <el-input v-model="other.commodity.introduce"></el-input>
        </el-form-item>


        <el-form-item>
          <template slot="label">
            更改封面图片
          </template>
          <el-upload
            ref="upload1"
            action="http://localhost:8906/other/receiveOtherImg"
            :auto-upload="false"
            list-type="picture"
            :limit="1"
            :data="{commodity_id : other.commodity.commodity_id}"
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
            :data="{commodity_id : other.commodity.commodity_id}"
            :file-list="fileList"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>

          <el-card style="">
            <div>选中图片后删除</div>
            <el-checkbox-group v-model="selectImg">

              <el-checkbox-button :label="img" v-for="img in other_img" :key="img.id">
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
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: 'editOtherCom',
  props : ['c_info'],
  inject : ['reload'],
  created() {
    axios.get('/other/selectOtherCommodityById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.other = response.data
      }
    );

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.other_img = response.data;
      }
    );
  },
  methods : {
    sub(){
      axios.post('/other/updateOtherCommodity',this.other).then();
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
      other : '',
      other_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      fileList : [],
    }
  }
}
</script>
<style scoped>
</style>
