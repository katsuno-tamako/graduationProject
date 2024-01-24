<template>
    <div>
      <h3>添加{{book.category}}</h3>
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

        <el-form-item>
          <el-button type="primary" @click="insertBook()">添加</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'insertCommodity_Book',
  data () {
    return {
      book : {
        book_name : '',
        book_price : '',
        publishing : '',
        book_isbn : '',
        publishing_date : '',
        book_brand : '',
        number_of_pages : '',
        author : ''
      },
      price : ''
    }
  },
  methods : {
    insertBook () {
      axios.post('/book/insertBook',this.book).then(
        function(response){
          console.log(response.data);
          console.log("-----");
        }
      );
      this.$router.push('/businessIndex');
    }
  }
}
</script>
<style scoped>
</style>
