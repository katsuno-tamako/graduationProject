<template>
  <div>
    <div>
      <div style="text-align: center;height: 25px;width: 100%;background-color: #f5f5f5;border:1px solid gainsboro">
        <el-row :gutter="20">
          <el-col :span="12">订单详情</el-col>
          <el-col :span="2">写评论</el-col>
          <el-col :span="6">收货人</el-col>
          <el-col :span="4">价钱</el-col>
        </el-row>
      </div>
      <div v-for="info in order_info" :key="info.id" style="width: auto;margin: 20px 0;border:1px solid gainsboro">
        <div style="height: 25px;width: 100%;background-color: #f5f5f5">
          <span style="font-size: 13px;margin: 10% 15px;color: #475669">{{info.order_date}}</span>
          <span style="font-size: 13px;margin: 10% 15px;color: #475669">
            订单号：
            {{info.order_id}}
          </span>
        </div>
        <el-row :gutter="20" style="">
          <el-col :span="4">
            <el-image
              style="width: 100px; height: 100px"
              :src="url_head+info.commodity.main_img"
              ></el-image>
          </el-col>
          <el-col :span="8" style="padding: 40px 0">
            <span @click="editPath(info)">
                {{info.commodity.name}}
            </span>
          </el-col>
          <el-col :span="2" style="padding: 40px 0">
            <span @click="writeComment(info.commodity.commodity_id,info.commodity.name)">
              <i class="el-icon-edit">写评论</i>
            </span>
          </el-col>
          <el-col :span="6" style="padding: 40px 0;text-align: center">
            {{info.user_address.user_name}}
          </el-col>
          <el-col :span="4" style="text-align: center;padding: 30px 0">
            <div style="font-size: 15px;color: #475669">
              x{{info.num}}
            </div>
            <div style="font-size: 15px;color: #475669">
              {{info.commodity.price*info.num}}￥
            </div>




<!--            <div style="display: none">-->
<!--              <span v-if="info.commodity.category == '图书'">{{commodity_path = '/buyBookPage'}}</span>-->
<!--              <span v-if="info.commodity.category == '电脑'">{{commodity_path = '/buyComputerPage'}}</span>-->
<!--              <span v-if="info.commodity.category == '手机'">{{commodity_path = '/buyPhonePage'}}</span>-->
<!--              <span v-if="info.commodity.category == '家具'">{{commodity_path = '/buyFurniturePage'}}</span>-->
<!--              <span v-if="info.commodity.category == '服装'">{{commodity_path = '/buyClothPage'}}</span>-->
<!--              <span v-if="info.commodity.category == '食品'">{{commodity_path = '/buyFoodPage'}}</span>-->
<!--              <span v-if="info.commodity.category == '其他'">{{commodity_path = '/buyOtherPage'}}</span>-->
<!--            </div>-->

          </el-col>

        </el-row>
      </div>
      <div>
<!--        <el-backtop target=".page-component__scroll .el-scrollbar__wrap"></el-backtop>-->
      </div>

      <div>
        <el-dialog
          :visible.sync="dialogVisible">
          <div>要评价的商品名称：{{commodity_name}}</div>
          <el-divider></el-divider>
            <el-rate v-model="comment.grade"></el-rate>
          <el-divider></el-divider>
          <div>
                  <el-input
                    type="textarea"
                    :rows="2"
                    placeholder="请输入内容"
                    maxlength="60"
                    show-word-limit
                    v-model="comment.content">
                  </el-input>
          </div>
          <el-button type="primary" @click="subSuc" :disabled="!comment.content">提交</el-button>
        </el-dialog>


        <el-dialog
          :visible.sync="dialogSuc">
          <div>评论成功</div>
          <el-button type="primary" @click="dialogSuc=false">确定</el-button>

        </el-dialog>
      </div>


    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'userOrderInfo',

  methods : {
    writeComment(id,name){
      this.dialogVisible=true
      this.commodity_name = name;
      this.commodity_id = id

    },
    subSuc(){
      this.dialogVisible=false;
      this.comment.user_id = this.user_id;
      this.comment.commodity_id = this.commodity_id;
      axios.post('/comment/insertComment',this.comment).then();
      this.dialogSuc=true;
    },
    editPath(info){
      if(info.commodity.category==='图书'){this.$router.push({path : '/buyBookPage', query:{id : info.commodity_id}});}
      if(info.commodity.category==='电脑'){this.$router.push({path : '/buyComputerPage', query:{id : info.commodity_id}});}
      if(info.commodity.category==='手机'){this.$router.push({path : '/buyPhonePage', query:{id : info.commodity_id}});}
      if(info.commodity.category==='家具'){this.$router.push({path : '/buyFurniturePage', query:{id : info.commodity_id}});}
      if(info.commodity.category==='服装'){this.$router.push({path : '/buyClothPage', query:{id : info.commodity_id}});}
      if(info.commodity.category==='食品'){this.$router.push({path : '/buyFoodPage', query:{id : info.commodity_id}});}
      if(info.commodity.category==='其他'){this.$router.push({path : '/buyOtherPage', query:{id : info.commodity_id}});}
    }
  },
  created() {
    axios.get('/user/getUserSession').then(
      (response) => {
        this.user_id = response.data
        axios.get('/order/selectOrderByUser',{params : {user_id: response.data}}).then(
          (response) => {
            this.order_info = response.data;
          }
        );
      }
    );
  },
  watch : {
    dialogVisible : function () {
      this.comment.grade = '';
      this.comment.content = '';
    }
  },
  data () {
    return {
      url_head : 'http://localhost:8906//',
      order_info : {
        order_date : '',
        order_id : ''
      },
      commodity_id : '',
      commodity_name : '',
      dialogVisible : false,
      user_id : '',
      comment : {
        commodity_id : '',
        content : '',
        user_id : '',
        grade : ''
      },
      dialogSuc : false,
      commodity_path : ''
    }
  }
}
</script>
<style scoped>
</style>
