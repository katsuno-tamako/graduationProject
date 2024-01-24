<template>
  <div>
    <div>
      <Header/>
      <header2/>
    </div>
    <div>
<!--      <book-menus/>-->
    </div>
    <div >

      <el-row :gutter="20">
        <el-col :span="4">
          <el-card style="text-align: center">
            <div style="background-color:black;font-size:20px;color:white;height: 30px;width: auto;padding: 5px">
              <span @click="rel">图书首页</span>
            </div>
          </el-card>

          <el-card>
            <el-collapse>
              <el-collapse-item title="图书分类">
                <div v-for="type in book_type" :key="type" @click="sendKey(type.book_type)">
                  <el-card>{{type.book_type}}</el-card>
                </div>
              </el-collapse-item>
            </el-collapse>
          </el-card>

          <el-card>
            <el-collapse>
              <el-collapse-item title="热门出版社">
                <div v-for="p in publishing" :key="p" @click="sendKey(p)">
                  <el-card>{{p}}</el-card>
                </div>
              </el-collapse-item>
            </el-collapse>
          </el-card>



        </el-col>
        <el-col :span="16">

          <book-com :keyword="keyword"/>
        </el-col>
        <el-col :span="4"></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import bookMenus from "../../components/index/categoryBook/bookMenus";
import bookCom from "../../components/index/categoryBook/bookCom";
export default {
  name: 'bookPage',
  inject : ['reload'],
  components : {
    Header,
    bookMenus,
    bookCom,
    Header2
  },
  methods : {
    sendKey(key){
      this.keyword = key;
    },
    rel(){
      this.reload();
    }
  },
  created() {
    axios.get('/book/authorOrderBy').then(
      (response) => {
        this.authors = response.data;
      }
    );
    axios.get("/type/selectAllBookType").then(
      (response) => {
        this.book_type = response.data;
      }
    );

    axios.get('/book/selectBookGroupByPublishing').then(
      (response) => {this.publishing = response.data;}
    );
  },
  data () {
    return {
      commodity_id : '',
      keyword : 'blank',
      authors : '',
      book_type : '',
      publishing : ''
    }
  }
}
</script>
<style scoped>
</style>
