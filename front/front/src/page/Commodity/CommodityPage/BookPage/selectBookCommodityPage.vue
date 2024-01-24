<template>
  <div>
    <div style="width: auto;margin: 0 5%">
      <el-divider></el-divider>
    </div>
    <div style="margin:10px 10%;width: auto" v-if="keyword!='no key'">
      <span @click="goBack" style="margin-right:20px;font-size: 20px"><i class="el-icon-back"></i>返回</span>|<span  style="margin: 0 20px">{{keyword}}</span>
    </div>
    <div style="width: auto;">
      <div style="height100px;width: auto;margin: 0 11%">
        <el-button @click="re" size="mini" icon="el-icon-refresh-right"></el-button>

        <el-button @click="sortI" v-if="sor != 'down' && sor!='up'" size="mini">价钱排序</el-button>
        <el-button @click="sortI" v-if="sor==='up'" size="mini" type="primary"><i class="el-icon-top"></i>价钱排序</el-button>
        <el-button @click="sortI" v-if="sor==='down'" size="mini" type="primary"><i class="el-icon-bottom"></i>价钱排序</el-button>

        <el-button @click="sortN" v-if="sor != 'nDown' && sor!='nUp'" size="mini">销量</el-button>
        <el-button @click="sortN" v-if="sor === 'nDown'" size="mini" type="primary">销量<i class="el-icon-bottom"></i></el-button>
        <el-button @click="sortN" v-if="sor === 'nUp'" size="mini" type="primary">销量<i class="el-icon-top"></i></el-button>

        <el-button @click="sortS" v-if="sor != 'sDown' && sor!='sUp'" size="mini">评分</el-button>
        <el-button @click="sortS" v-if="sor === 'sDown'" size="mini" type="primary">评分<i class="el-icon-bottom"></i></el-button>
        <el-button @click="sortS" v-if="sor === 'sUp'" size="mini" type="primary">评分<i class="el-icon-top"></i></el-button>
      </div>
    </div>

    <div style="width: auto;margin: 0 10%;">
      <el-col :span="6" v-for="b in book" :key="b.id" style="padding: 10px">

          <div style="border:1px gainsboro solid ;height: 330px">
            <router-link target="_blank" :to="{path : '/buyBookPage' , query : {id : b.commodityID}}" style="text-decoration:none">
            <div style="text-align: center;padding-top: 10px">
              <el-image
                :src="url_head+b.commodity.main_img"
                style="height: 180px"
              ></el-image>
            </div>

            <div style="margin-top10px;margin-left:10px;height: 25px;color:red;font-size: 20px" class="view-text">
              {{b.commodity.price}}￥
            </div>
            <div style="font-size:16px;margin-left:10px;color: #475669" class="view-text">
              {{b.commodity.name}}
            </div>
              <div style="color: #475669;;font-size: 10px;margin-left: 10px">
                <div>
                  <span style="font-size: 15px">销量：
                    {{b.commodity.sales_commodity.sales_num}}
                  </span>
                </div>
                <div style="font-size: 15px">
                  <div v-if="b.commodity.sales_commodity.ave_grade!='no'">
                    <span>评分：
                  {{b.commodity.sales_commodity.ave_grade}}
                  </span>
                  </div>
                  <div v-else>
                    暂无评分
                  </div>
                </div>
              </div>
            </router-link>
            <div style="margin-top: 10px;margin-left: 10px">
              <add-shop-cart :commodity="b.commodity"/>
            </div>

          </div>

        </el-col>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import addShopCart from "../../../otherPage/addShopCart/addShopCart";
export default {
  name: 'selectBookCommodityPage',
  props : ['keyword','ord'],
  inject : ['reload'],
  components : {
    addShopCart
  },
  created() {
    axios.get('/book/selectAllBook').then(
      (res) => {
        this.book = res.data;
      }
    )
  },
  methods : {
    goBack(){
      this.reload()
    },
    sortN(){
      if(this.sor != 'nDown' && this.sor!='nUp'){
        this.sor = 'nDown'
      }else if(this.sor === 'nDown'){
        this.sor = 'nUp'
      }else if(this.sor === 'nUp'){
        this.sor = 'nDown'
      }
      axios.get('/book/receiveBookInfo',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.book = res.data;
        }
      );
    },
    sortS(){
      if(this.sor != 'sDown' && this.sor!='sUp'){
        this.sor = 'sDown'
      }else if(this.sor === 'sDown'){
        this.sor = 'sUp'
      }else if(this.sor === 'sUp'){
        this.sor = 'sDown'

      }
      axios.get('/book/receiveBookInfo',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.book = res.data;
        }
      );
    },
    sortI(){
      if(this.sor != 'down' && this.sor!='up'){
        this.sor = 'down'
      }else if(this.sor === 'down'){
        this.sor = 'up'
      }else if(this.sor === 'up'){
        this.sor = 'down'
      }
      axios.get('/book/receiveBookInfo',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.book = res.data;
        }
      );
    },
    re(){
      this.sor = 'no';
      axios.get('/book/receiveBookInfo',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.book = res.data;
        }
      );
    }
  },
  data(){
    return{
      url_head : 'http://localhost:8906//',
      book : {
        commodity : {
          sales_commodity : {
            sales_num : '',
            ave_grade : ''
          }
        }
      },
      sor : 'no'
    }
  },
  watch : {
    keyword: function () {
      axios.get('/book/selectByBookType', {params: {commodity_type: this.keyword}}).then(
        (res) => {
          this.book = res.data;
        }
      )
      this.sor = 'no'
    }
  }

}
</script>
<style scoped>

  .view-text{
    display: inline-block;
    white-space: nowrap;
    width: 100%;
    overflow: hidden;
    text-overflow:ellipsis;
  }
  a{
    color: black;
    text-decoration:none}



</style>
