<template>
  <div>
    <div>

      <el-upload
        action="http://localhost:8906/user/uploadUserImg"
        :data="{user_id : user_info.user_id}"
        :on-success="reloadImg"
      >
        <el-button size="small" type="primary">点击上传</el-button>
      </el-upload>

    </div>

  <el-dialog
    :visible.sync="dia">
    <div>头像修改成功</div>
    <el-button @click="suc" type="primary">确定</el-button>
  </el-dialog>


  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'proImg',
  props : ['user_info'],
  inject : ['reload'],
  data () {
    return {
      dia : false,
      user : '',
      user_name : '',
      url_head : 'http://localhost:8906//',
      url : ''
    }
  },
  created() {
    axios.get('/user/selectUserInfoById',{params : {user_id : this.user_info.user_id}}).then(
      (response) => {
        this.user = response.data;
        this.url=this.url_head+this.user.img;
      }
    );
  },
  methods : {
    suc(){
      this.dia=false;
      this.reload();
    },
    reloadImg(){
      this.dia = true;
    }

  }
}
</script>
<style scoped>
</style>
