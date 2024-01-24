<template>
  <div>
    <div>
      <el-row :gutter="20">
        <el-col :span="8" v-for="book in books" :key="book.id" style="padding: 10px">
          <el-card>
            <router-link target="_blank" :to="{path : '/buyBookPage' , query : {id : book.commodityID}}" style="text-decoration:none">
              <div>
                  <div style="text-align: center">
                    <el-image
                      style="height: 200px"
                      :src="url_head+book.commodity.main_img"
                    >
                    </el-image>
                    <div class="name_text" style="height: 30px">{{book.commodity.name}}</div>
                  </div>
                <div style="height: 20px">￥{{book.commodity.price}}</div>
              </div>
            </router-link>

            <el-divider></el-divider>
            <div>
              <add-shop-cart :commodity_id="book.commodity.commodity_id" :num="1" :commodity="book.commodity"/>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-divider></el-divider>

    </div>
  </div>
</template>

<script>

import axios from 'axios';
import addShopCart from "../../../page/otherPage/addShopCart/addShopCart";
export default {
  name: 'bookCom',
  props : ['keyword'],
  components : {
    addShopCart
  },
  data () {
    return {
      books : {
        commodityID : '',
        commodity_id : '',
        name : '',
        price : '',
        main_img : '',
        commodity : {}
      },
      category : '图书',
      url_head : 'http://localhost:8906//',
    }
  },
  created() {
    if(this.keyword == 'blank'){
      axios.get('/book/selectAllBook').then(
        (response) => {
          this.books = response.data;
          console.log(response.data);
        }
      );
    }else{
      axios.get('/book/selectBookLike',{params:{keyword:this.keyword}}).then(
        (response) => {
          console.log(response.data);
          this.books=response.data;
        }
      );
    }

  },
  watch : {
    keyword : function () {
      axios.get('/book/selectBookLike',{params:{keyword:this.keyword}}).then(
        (response) => {
          console.log(response.data);
          this.books=response.data;
        }
      )
    }
  },
  methods : {
    goPage(book){
      // this.$router.push({path : '/buyBookPage', query:{cid : this.commodity.commodity_id}});
      alert("hi");
    }
  }
}
</script>
<style scoped>

  .name_text{
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap
  }

</style>
