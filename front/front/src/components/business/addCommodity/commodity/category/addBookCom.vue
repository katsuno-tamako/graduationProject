<template>
  <div>
    <div>
      添加图书
      <el-divider></el-divider>

      <el-form :model="book" label-width="80px" :rules="rules" ref="book">
        <el-form-item label="书籍名称">
          <el-input v-model="book.book_name" maxlength="20" show-word-limit></el-input>
        </el-form-item>

        <el-form-item label="价钱">
          <el-input v-model="book.book_price" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" ></el-input>
        </el-form-item>


        <el-form-item label="作者">
          <el-input v-model="book.author"></el-input>
        </el-form-item>

        <el-form-item label="出版社">
          <el-input v-model="book.publishing"  maxlength="20" show-word-limit></el-input>
        </el-form-item>

<!--        <el-form-item label="图书类型">-->
<!--&lt;!&ndash;          <el-input v-model="book.book_type"></el-input>&ndash;&gt;-->
<!--          {{book_category_type}}-->
<!--          <el-select v-model="book.book_type" placeholder="请选择">-->
<!--            <el-option-->
<!--              v-for="type in book_type"-->
<!--              :key="type.id"-->
<!--              :label="type.book_type"-->
<!--              :value="type.book_type">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->

        <el-form-item label="图书分区">
          <el-select v-model="book_category_type" multiple filterable  placeholder="请选择" style="width: 100%">
            <el-option
              v-for="type in category_type"
              :key="type.id"
              :label="type.category_type"
              :value="type.category_type">
            </el-option>
          </el-select>

        </el-form-item>

        <el-form-item label="ISBN">
          <el-input v-model="book.book_isbn"></el-input>
        </el-form-item>

        <el-form-item label="出版日期">
          <div class="block">
            <el-date-picker
              v-model="book.publishing_date"
              type="date"
              placeholder="选择日期"
              format="yyyy-MM-dd"
            ></el-date-picker>
          </div>
        </el-form-item>

        <el-form-item label="出版公司">
          <el-input v-model="book.book_brand"></el-input>
        </el-form-item>



        <el-form-item label="页数">
          <el-input v-model="book.number_of_pages" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" ></el-input>
        </el-form-item>

        <el-form-item label="商品介绍">
          <el-input
            type="textarea"
            :rows="5"
            placeholder="请输入内容"
            v-model="book.commodity.introduce"
          >
          </el-input>
        </el-form-item>

        <el-form-item>
          <el-upload
            ref="upload"
            action="http://localhost:8906/book/receiveBookImg"
            :auto-upload="false"
            list-type="picture"
            :limit="1"
            :data="{commodity_id : commodity_id}"
          >
            <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
          </el-upload>
        </el-form-item>



        <el-form-item>
          <el-button @click="subBook"
            :disabled="!book.book_name || !book.book_price ||
                        !book.publishing ||
                        !book.book_isbn || !book.publishing_date ||
                        !book.book_brand || !book.author || !book.number_of_pages ||
                        !book.commodity.introduce
                      "
          >提交</el-button>
        </el-form-item>

      </el-form>

      <div>
        <el-dialog
          title="确认一下"
          :visible.sync="dialogVisible"
        >
          <div>
            确认一下
          </div>
          <el-divider></el-divider>
          <div>
            <div>商品名称:{{book.book_name}}</div>
            <div>商品价钱:{{book.book_price}}</div>
              <div>出版社:{{book.publishing}}</div>
            <div>类型:{{book.book_type}}</div>
            <div>ISBN:{{book.book_isbn}}</div>
            <div>出版日期:{{book.publishing_date}}</div>
            <div>公司:{{book.book_brand}}</div>
            <div>作者:{{book.author}}</div>
            <div>页数:{{book.number_of_pages}}</div>
            <div>商品介绍:{{book.commodity.introduce}}</div>
            <div>{{book_category_type}</div>
          </div>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitInfo">确 定</el-button>
        </span>
        </el-dialog>
      </div>

      <div>
        <el-dialog
          :visible.sync="dialogSuc">
          <div>提交成功！

          </div>
          <el-divider></el-divider>
          <el-button type="primary" @click="subSuc">返回我的商品</el-button>
        </el-dialog>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'addBookCom',
  inject : ['reload'],
  created() {
    axios.get("/type/selectAllBookType").then(
      (response) => {
        this.book_type = response.data;
      }
    );

    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'图书'}}).then(
      (res) => {
        this.category_type = res.data;
      }
    )

  },
  data(){
    return {
      category_type : [],
      addBookVO : {
        commodity_categories_books : '',
        categoryTypes : []
      },
      book_category_type : [],
      book : {
        book_name : '',
        book_price : '',
        book_type : '',
        publishing : '',
        book_isbn : '',
        publishing_date : '',
        book_brand : '',
        number_of_pages : '',
        author : '',
        commodity : {}
      },
      commodity_id : '',
      dialogVisible : false,
      dialogSuc : false,
      url_head : 'http://localhost:8906//',
      book_type : ''
    }
  },
  methods : {
    subBook(){
      this.dialogVisible = true;
    },
    submitInfo(){
      let _this = this;
      this.dialogVisible = false;
      this.addBookVO.commodity_categories_books = this.book;
      this.addBookVO.categoryTypes = this.book_category_type;
      axios.post('/book/insertBook',this.addBookVO).then(
        (response) => {
          setTimeout( ()=> {
            this.commodity_id = response.data;
            console.log(this.commodity_id)
          },100);

          setTimeout(function () {
            _this.subImg();
          },200);

        }
      );
    },
    subSuc(){
      this.dialogSuc = false;
      this.$router.push("/AllCommodityPage");
    },
    subImg(){
      console.log("subImg function")
      this.$refs.upload.submit();
      this.dialogSuc = true;
    }
  }
}
</script>
<style scoped>
</style>
