<template>
    <div>
      <header>
        <h1>查看货物</h1>
        <h2>商家ID:
          <span v-bind:style="merchantId">{{mid}}</span>
        </h2>
        <span @click="selectAll">test</span>
        <span @click="getImg">get image</span>
        <div>
          {{file}}
        </div>
      </header>
      <div>
        <ul>
          <li v-for="commodity in commodities" :key="commodity.id">
            {{commodity.name}}
          </li>
        </ul>
      </div>

      <el-upload
        action="https://jsonplaceholder.typicode.com/posts/"
        :file-list="fileList"
        :http-request="getFile"
      >
      <el-button size="small" type="primary">选择图片</el-button>
      </el-upload>
      <el-button size="small" type="success" @click="upload">确认上传</el-button>

      <el-table
        :data="commodities"
        border
        style="width: 100%">
        <el-table-column
          fixed
          prop="commodity_id"
          label="货物编号"
          width="200">
        </el-table-column>
        <el-table-column
          prop="name"
          label="货物名词"
          width="200">
        </el-table-column>
        <el-table-column
          prop="price"
          label="价钱"
          width="120">
        </el-table-column>
        <el-table-column
          prop="category"
          label="种类"
          width="120">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button type="text" size="small">查看</el-button>
            <el-button type="text" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div>
        <upload/>
      </div>

      <div>
        <img :src='url'>
      </div>


    </div>
</template>
<script>

import axios from 'axios';
import upload from "./editCommodities/uploadCommodityImg";

export default {
  name: 'checkCommodity',
  data () {
    return {
      merchantId : '',
      commodities : '',
      fileList : '',
      tableData : '',
      url : 'http://localhost:8906/img/img29012021161656.gif',
      file : ''
    }
  },
  components : {
    upload
  },
  created() {
    axios.get('/merchant/getMerchantId').then(
      (response) => {
        this.merchantId = response.data;
      }
    );
  },
  methods : {
    selectAll(){
      axios.get('/selectCommodityByMerchant',
        {params : {'merchantId' : this.merchantId}}).then(
        (response) => {
          console.log(this.merchantId)
          this.commodities = response.data;
          this.tableData = response.data;
          console.log(this.commodities)
        }
      );
    },
    getFile(item) {
      console.log(item.file)
      this.file = item.file
    },
    upload() {
      console.log(this.fileList);
      const fd = new FormData()
      fd.append('filename', this.file)
      const config = { headers: { 'Content-Type': 'multipart/form-data' }}
      axios.post('/uploadCommodity', fd, config
      ).then(response => {
        console.log(response.status)
      })
    },
    getImg(){

    }
  }
}
</script>
<style scoped>
</style>
