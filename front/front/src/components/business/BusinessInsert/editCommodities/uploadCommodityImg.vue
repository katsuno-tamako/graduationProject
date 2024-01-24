<template>

  <div>
    <el-card>
      {{id}}
      <el-upload
        action="http://localhost:8906/uploadCommodity"
        list-type="picture-card"
        :data="{commodity_id:id}"
        :on-preview="handlePictureCardPreview"
        close-on-press-escape="true"
        :on-success="upSuccess"
        :on-remove="handleRemove">
        <i class="el-icon-plus"></i>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>
    </el-card>

  </div>

</template>

<script>
import axios from 'axios';
import CommodityImg from "./CommodityImg";
export default {
  name: "uploadCommodityImg",
  props : ['id'],
  data () {
    return {
      dialogImageUrl: '',
      dialogVisible: false
    }
  },
  components : {
    CommodityImg
  },
  methods : {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    upSuccess(){

    },
    clearFiles(){

    }
  },

}
</script>



