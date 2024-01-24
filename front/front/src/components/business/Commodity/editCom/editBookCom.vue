<template>
  <div>
    <div>
      <div>编辑图书</div>
      <el-divider></el-divider>
      <el-form :model="book">
        <el-form-item label="书籍名称">
          <el-input v-model="book.book_name"></el-input>
        </el-form-item>

        <el-form-item label="商品价钱">
          <el-input v-model="book.book_price" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" ></el-input>
        </el-form-item>

        <el-form-item label="书籍作者">
          <el-input v-model="book.author"></el-input>
        </el-form-item>

        <el-form-item label="出版社">
          <el-input v-model="book.publishing"></el-input>
        </el-form-item>

<!--        <el-form-item label="书籍类型">-->
<!--          <el-input v-model="book.book_type"></el-input>-->
<!--        </el-form-item>-->

<!--        <el-form-item label="图书分类2">-->
<!--          插件有问题-->
<!--          <el-select v-model="book.commodity_typeList" multiple filterable  placeholder="请选择" style="width: 100%">-->
<!--            <el-option-->
<!--              v-for="type in category_type"-->
<!--              :key="type.id"-->
<!--              :label="type.category_type"-->
<!--              :value="type.category_type">-->
<!--            </el-option>-->
<!--          </el-select>-->

<!--        </el-form-item>-->

        <el-form-item label="书籍ISBN">
          <el-input v-model="book.book_isbn"></el-input>
        </el-form-item>

        <el-form-item label="出版日期">
          <el-input v-model="book.publishing_date"></el-input>
        </el-form-item>

        <el-form-item label="出版公司">
          <el-input v-model="book.book_brand"></el-input>
        </el-form-item>

        <el-form-item label="书籍页数">
          <el-input v-model="book.number_of_pages"></el-input>
        </el-form-item>

        <el-form-item label="商品介绍">
            <el-input
              type="textarea"
              :rows="5"
              placeholder="请输入内容"
              v-model="book.commodity.introduce">
            </el-input>
        </el-form-item>

        <el-divider></el-divider>

        <el-form-item>
          <el-card>
            <span>选择商品封面的图片:</span>
            <el-upload
              ref="upload1"
              action="http://localhost:8906/book/receiveBookImg"
              :auto-upload="false"
              list-type="picture"
              :limit="1"
              :data="{commodity_id : book.commodity.commodity_id}"
            >
              <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
            </el-upload>
          </el-card>
        </el-form-item>

        <el-form-item>
          <el-card>
            <span>
              选择其他图片
            </span>
          <el-upload
            ref="upload2"
            action="http://localhost:8906/uploadCommodity"
            :auto-upload="false"
            list-type="picture"
            :data="{commodity_id : book.commodity.commodity_id}"
            :file-list="fileList"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          </el-upload>
          <el-divider></el-divider>
          <div>
            <div>选中图片后删除</div>
            <el-checkbox-group v-model="selectImg">

              <el-checkbox-button :label="img" v-for="img in book_img" :key="img.id">
                <div style="text-align: center;display:flex;overflow-x:auto;overflow-y:hidden">
                  <el-image
                    style="height: 100px"
                    :src="url_head+img.path"
                  ></el-image>
                </div>
              </el-checkbox-button>
            </el-checkbox-group>
          </div>
          </el-card>
        </el-form-item>

        <el-form-item>
          <el-button @click="sub">确定</el-button>
          <el-button @click="cal">取消</el-button>
        </el-form-item>
      </el-form>



    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'editBookCom',
  props : ['c_info'],
  inject : ['reload'],
  methods : {
    sub(){
      axios.post('/book/updateBookCommodity',this.book).then();
      axios.post('/deleteImgArray',this.selectImg).then();
      this.$refs.upload1.submit();
      this.$refs.upload2.submit();
      this.reload();
    },
    cal(){
      this.reload();
    },
    deleteImg(path){
      axios.get('/deleteImgArray',{params : {url : path}}).then();
      this.reload();
    }
  },
  created() {
    axios.get('/book/selectBookById',{params:{commodity_id:this.c_info.commodity_id}}).then(
      (response) => {
        this.book = response.data
        // this.book_category_type = this.book.commodity_typeList;
      }
    );

    axios.get('/getImg',{params: {commodity_id: this.c_info.commodity_id}}).then(
      (response) => {
        this.book_img = response.data;
      }
    );

    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'图书'}}).then(
      (res) => {
        this.category_type = res.data;
      }
    )

  },
  data(){
    return{
      book_img : '',
      url_head : 'http://localhost:8906//',
      selectImg : [],
      fileList : [],
      book_type : '',
      book : {
        commodity : {},
        commodity_typeList : ''
      },
      book_category_type : [],
      category_type : ''
    }
  }

}
</script>
<style scoped>
</style>
