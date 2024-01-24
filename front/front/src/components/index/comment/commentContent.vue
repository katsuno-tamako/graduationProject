<template>
  <div>
    <div v-for="comment in comments" :key="comment" class="comment" style="margin: 20px">

      <el-card>

      <el-row :gutter="20">
        <el-col :span="3" style="text-align: center">
          <div>
                <div class="demo-basic--circle">
                  <div class="block">
                    <el-avatar :size="40" :src="url_head+comment.user_info.img"></el-avatar>
                  </div>
                </div>
            <div style="text-align: center">
                <span style="font-size: 10px">{{comment.user_info.user_name}}</span>
            </div>
          </div>
        </el-col>
        <el-col :span="4">
          <el-rate
            v-model="comment.grade"
            disabled
            show-score
            text-color="#ff9900">
          </el-rate>
          <div style="color: darkcyan;font-size: 13px">{{comment.comment_date}}</div>

        </el-col>
        <el-col :span="15">
          <div style="margin: 0 10px 0 0">{{comment.content}}</div>
        </el-col>
        <el-col :span="2">
          {{comment.likeNum}}
        </el-col>
      </el-row>
      </el-card>

    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'commentContent',
  props : ['commodity_id'],
  data(){
    return{
      comments : {
        comment_date : '',
        user_info : ''
      },
      url : '',
      url_head : 'http://localhost:8906//',
    }
  },
  created() {
      axios.get('/comment/selectCommentByCommodityId',{params : {commodity_id : this.commodity_id}}).then(
        (response) => {
          this.comments = response.data;

        }
      )
  }
}
</script>
<style scoped>

  .comment{
    height: 100px;
  }

</style>
