<template>
  <div>
    <div>编辑图书:{{commodity_id}}</div>
    <el-divider></el-divider>

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

      <el-divider></el-divider>
      <el-form-item label="产品介绍">
        <el-input
          type="textarea"
          :rows="5"
          placeholder="请输入内容"
          v-model="book.commodity.introduce">
        </el-input>

      </el-form-item>

      <el-form-item>
        <el-button @click="subBook">提交</el-button>
        <el-button @click="delBook">删除</el-button>
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
        <div>{{book}}</div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitInfo">确 定</el-button>
        </span>
      </el-dialog>
    </div>

    <div>
      <el-dialog
        :visible.sync="dialogSuc">
        <div>提交成功</div>
        <el-divider></el-divider>
        <el-button type="primary" @click="subSuc">确定</el-button>
      </el-dialog>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'editBook',
  props : ['commodity_id'],
  inject : ['reload'],
  created() {
    axios.get('/book/selectBookById',{params:{commodity_id: this.commodity_id}}).then(
      (response) => {
        this.book = response.data;
      }
    );
  },
  methods : {
    subBook(){
      this.dialogVisible=true;

    },
    submitInfo(){
      this.dialogVisible=false;
      this.dialogSuc=true;

      axios.post('/book/updateBookCommodity',this.book).then();

    },
    subSuc(){
      this.dialogSuc=false;
      this.$router.push('/businessCommodity');
    },
    delBook(){
      axios.get('/book/deleteBookCommodity',{params:{commodity_id:this.commodity_id}}).then();
      this.$router.push('/businessCommodity');
      this.reload();
    }
  },
  data(){
    return {
      book : {
        book_name : '',
        book_price : '',
        book_type : '',
        publishing : '',
        book_isbn : '',
        publishing_date : '',
        book_brand : '',
        number_of_pages : '',
        author : ''
      },
      dialogVisible : false,
      dialogSuc : false
    }
  },
}
</script>
<style scoped>
</style>
