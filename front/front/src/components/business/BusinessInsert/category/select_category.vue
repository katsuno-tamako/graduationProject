<template>
  <div>
    <el-card>
      <div>
        <el-select v-model="categories.category" clearable filterable placeholder="选择要添加的商品">
          <el-option
            v-for="item in categories"
            :key="item.category"
            :label="item.category"
            :value="item.category">
          </el-option>
        </el-select>


      </div>
    </el-card>


    <div v-if="categories.category === '图书'">
      <el-card>
        <insert-book/>
      </el-card>
    </div>
    <div v-else-if="categories.category === '电脑'">
      <el-card>
        <insert-computer/>
      </el-card>
    </div>
    <div v-else-if="categories.category === '手机'">
      <el-card>
        <insert-phone/>
      </el-card>
    </div>


  </div>
</template>

<script>
import axios from "axios";
import insertBook from "../insertCommodity/insertBook";
import insertComputer from "../insertCommodity/insertComputer";
import insertPhone from "../insertCommodity/insertPhone";
export default {
  name: 'select_category',
  data() {
    return {
      categories : ''
    }
  },
  components : {
    insertBook,
    insertComputer,
    insertPhone
  },
  created() {
    axios.get('/Categories/selectAllCategories').then(
      (response) => {this.categories = response.data}
    );
  },
  methods : {
    dis(){
      alert(this.categories.category);
    }
  }
}
</script>
<style scoped>
</style>
