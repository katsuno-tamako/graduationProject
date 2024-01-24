<template>
  <div>
    <div>
      <Header/>
    </div>
    <div>
      <Header2/>
    </div>
    <div style="padding: 0 50px">

      <el-divider></el-divider>
      <div style="width: auto;">
        <div style="height100px;width: auto;margin: 0 11%">
          <el-button @click="re" size="mini" icon="el-icon-refresh-right"></el-button>

          <el-button @click="sortI" v-if="sor != 'down' && sor!='up'" size="mini">价钱排序</el-button>
          <el-button @click="sortI" v-if="sor==='up'" size="mini" type="primary"><i class="el-icon-top"></i>价钱排序</el-button>
          <el-button @click="sortI" v-if="sor==='down'" size="mini" type="primary"><i class="el-icon-bottom"></i>价钱排序</el-button>

          <el-button @click="sortN" v-if="sor != 'nDown' && sor!='nUp'" size="mini">销量</el-button>
          <el-button @click="sortN" v-if="sor === 'nDown'" size="mini" type="primary">销量<i class="el-icon-top"></i></el-button>
          <el-button @click="sortN" v-if="sor === 'nUp'" size="mini" type="primary">销量<i class="el-icon-bottom"></i></el-button>

          <el-button @click="sortS" v-if="sor != 'sDown' && sor!='sUp'" size="mini">评分</el-button>
          <el-button @click="sortS" v-if="sor === 'sDown'" size="mini" type="primary">评分<i class="el-icon-bottom"></i></el-button>
          <el-button @click="sortS" v-if="sor === 'sUp'" size="mini" type="primary">评分<i class="el-icon-top"></i></el-button>
        </div>
      </div>

      <el-divider></el-divider>

      <el-row>

          <div v-for="com in commodity" :key="com">
            <el-col :span="6" style="padding: 10px 0">
              <search-commodity :com="com"/>
            </el-col>
          </div>

      </el-row>
    </div>
  </div>
</template>

<script>
import Header from "../../components/index/Header";
import Header2 from "../../components/index/Header2";
import searchCommodity from "../../components/search/searchCommodity";
import axios from 'axios';
export default {
  name: 'searchPage',
  components : {
    Header,
    Header2,
    searchCommodity
  },
  data () {
    return {
      keyword : '',
      commodity : {
        sales_commodity : {
          sales_num : '',
          ave_grade : ''
        }
      },
      sor : 'no',
    }
  },

  methods : {
    goBack(){
      this.reload();
    },
    sortN(){
      if(this.sor != 'nDown' && this.sor!='nUp'){
        this.sor = 'nUp'
      }else if(this.sor === 'nDown'){
        this.sor = 'nUp'
      }else if(this.sor === 'nUp'){
        this.sor = 'nDown'
      }
      axios.get('/selCommodity',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.commodity = res.data;
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
      axios.get('/selCommodity',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.commodity = res.data;
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
      axios.get('/selCommodity',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.commodity = res.data;
        }
      );
    },
    re(){
      this.sor = 'no';
      axios.get('/selCommodity',{params:{keyword:this.keyword,sort:this.sor}}).then(
        (res) => {
          this.commodity = res.data;
        }
      );
    }
  },
  created() {
    this.keyword = this.$route.query.keyword;
    axios.get('/searchCommodity',{params : {keyword : this.keyword}}).then(
      (response) => {
        this.commodity = response.data;
      }
    )
  }

}
</script>
<style scoped>
</style>
