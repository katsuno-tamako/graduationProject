<template>
    <div>
      <div>编辑{{category}}</div>
      <div>
        <el-form :model="book" label-width="80px">
          <el-form-item label="书籍名称">
            <el-input v-model="book.book_name"></el-input>
          </el-form-item>

          <el-form-item label="价钱">
            <el-input v-model="book.book_price"></el-input>
          </el-form-item>

          <el-form-item label="出版社">
            <el-input v-model="book.publishing"></el-input>
          </el-form-item>

          <el-form-item label="图书类型">
            <el-input v-model="book.book_type"></el-input>
          </el-form-item>

          <el-form-item label="ISBN">
            <el-input v-model="book.book_isbn"></el-input>
          </el-form-item>

          <el-form-item label="出版日期">
            <!--          <el-input v-model="book.publishing_date"></el-input>-->
            <div class="block">
              <el-date-picker v-model="book.publishing_date" type="date" placeholder="选择日期"></el-date-picker>
            </div>
          </el-form-item>

          <el-form-item label="公司">
            <el-input v-model="book.book_brand"></el-input>
          </el-form-item>


          <el-form-item label="作者">
            <el-input v-model="book.author"></el-input>
          </el-form-item>

          <el-form-item label="页数">
            <el-input v-model="book.number_of_pages"></el-input>
          </el-form-item>

<!--          <el-form-item label="封面">-->
<!--            <div>-->
<!--              <div class="block">-->
<!--                <el-image :src="img_src"-->
<!--                          style="width: 100px;height: 100px"-->
<!--                ></el-image>-->
<!--              </div>-->
<!--            </div>-->
<!--          </el-form-item>-->

<!--          <el-form-item>-->
<!--            <uploadCommodityImg v-bind:id="commodity_id"/>-->
<!--          </el-form-item>-->
<!--          <el-form-item>-->
<!--            <span >刷新</span>-->
<!--            <el-button @click="rel" icon="el-icon-refresh" circle></el-button>-->
<!--            <CommodityImg v-bind:commodity_id="commodity_id" v-if="update"/>-->
<!--          </el-form-item>-->


          <el-form-item>
            <el-button type="primary" @click="submitEdit">修改</el-button>
            <el-button>取消</el-button>
            <el-button type="danger" @click="deleteCommodity">删除</el-button>
          </el-form-item>

        </el-form>
      </div>
    </div>
</template>

<script>
import axios from 'axios'
import uploadCommodityImg from "./uploadCommodityImg";
import CommodityImg from "./CommodityImg";
export default {
  name: 'editCommodities',
  data () {
    return {
      dialogVisible: false,
      fileList : '',
      book : {
        commodity : ''
      },
      commodity_id : '',
      category : '',
      commodity : '',
      activeNames: ['1'],
      update : true,
      img_src : '',
      url_head : 'http://localhost:8906//',
    }
  },
  components : {
    uploadCommodityImg,
    CommodityImg
  },
  created() {
    this.commodity_id = this.$route.query.commodity_id;
    this.category = this.$route.query.category;
    axios.get('/book/selectBookCommodityByMerchant',
      {params : {'commodity_id' : this.commodity_id}}
    ).then(
      (response) => {
        this.book = response.data;
        this.img_src = this.url_head + this.book.commodity.main_img;
      }
    );
  },
  methods : {
    getFile(item) {
      console.log(item.file)
      this.file = item.file
    },
    submitEdit(){
      axios.post('/book/updateBookCommodity',this.book).then();
      this.$router.push('/businessCommodity');
    },
    deleteCommodity(){
      axios.get('/book/deleteBookCommodity',{params : {'commodity_id' : this.commodity_id}}).then(
        alert("删除成功")
      );
      this.$router.push('/businessIndex');
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    rel(){
      this.update = false;
      this.$nextTick(()=>this.update = true);
    }
  }
}
</script>
<style scoped>
</style>
