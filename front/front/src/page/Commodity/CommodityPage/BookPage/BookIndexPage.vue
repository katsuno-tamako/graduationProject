<template>
  <div>
    <Header/>
    <Header2/>
    <div style="width: auto;margin: 0 10%">
      <el-collapse accordion>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">图书分类</span>
          </template>
          <el-row>
            <el-col :span="2" v-for="type in categoryType" :key="type.id" style="text-align: center;color: #475669">

              <el-link  @click="getKey(type.category_type)">
                <span style="font-size: 18px">
                  {{type.category_type}}
                </span>
                </el-link>
            </el-col>
          </el-row>
        </el-collapse-item>
        <el-collapse-item>
          <template slot="title">
            <span style="font-size: 20px">出版社</span>
          </template>
          <el-col :span="4" v-for="p in book_publishing" :key="p" style="text-align: center">
            <el-link @click="getKey(p)">
              <span style="font-size: 18px">
                {{p}}
              </span>
            </el-link>
          </el-col>
        </el-collapse-item>
      </el-collapse>
    </div>
    <div>
      <selectBookCommodityPage :keyword="keyword" :ord="ord"/>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
import Header from "../../../../components/index/Header";
import Header2 from "../../../../components/index/Header2";
import selectBookCommodityPage from "./selectBookCommodityPage";
export default {
  name: 'BookIndexPage',
  inject : ['reload'],
  components : {
    Header,Header2,selectBookCommodityPage
  },
  created() {
    axios.get('/category/selectCategoryTypeTableByCategory',{params : {category : '图书'}}).then(
      (res) => {
        this.categoryType = res.data;
      }
    )
    axios.get('/book/selectBookGroupByPublishing').then(
      (res) => {
        this.book_publishing = res.data;
      }
    )
    axios.get('/book/authorOrderBy').then(
      (res) => {
        this.book_author = res.data;
      }
    )

  },
  methods:{
    getKey(key){
      this.keyword = key;
    },
    ref(){
      this.keyword = 'no key';
      this.reload();
    },
    li(or){
      if(or === 'price'){
        if(this.ord === 'up'){
          this.ord = 'down';
        }else if(this.ord === 'down'){
          this.ord = 'up';
        }else{
          this.ord = 'down';
        }
      }
    }
  },
  data(){
    return {
      book_publishing : '',
      categoryType : '',
      keyword : 'no key',
      ord : 'normal',
      book_author : ''
    }
  }

}
</script>
<style scoped>
  .lab {

  }
  .lab:hover{
  }
  .view-text{
    display: inline-block;
    white-space: nowrap;
    width: 100%;
    overflow: hidden;
    text-overflow:ellipsis;
  }
</style>
