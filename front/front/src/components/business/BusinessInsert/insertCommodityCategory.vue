<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12">
        <header>选择要添加的类型</header>
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
        <div>
          <template>
            <div v-if="categories.category === '图书'">
              <router-link to="/insertCommodity_Book">
              <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
                点我打开
              </el-button>
              </router-link>
            </div>
            <div v-else-if="categories.category === '电脑'">
              <router-link to="/insertCommodity_Computer">

              <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
                点我打开
              </el-button>
              </router-link>
            </div>
            <div v-else-if="categories.category === '视频'">
              确定
            </div>
            <div v-else-if="categories.category === '服装'">
              确定
            </div>
            <div v-else>
              确定
            </div>
          </template>


        </div>
      </el-col>
      <el-col :span="12">

      </el-col>
    </el-row>



    <el-drawer
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose" size="50%">
      <div class="draw_c">
        <el-card class="box-card">
          <router-view/>
        </el-card>

      </div>

    </el-drawer>

  </div>
</template>

<script>
import axios from 'axios';


export default {
  name: 'insertCommodityCategory',
  data () {
    return {
      categories : '',
      value : '',
      category : '',
      drawer: false,
      direction: 'rtl',
    }
  },
  created() {
    this.getCategories();
    alert(this.$refs.businessIndex.merchant.merchantId);
  }
  ,
  methods : {
    getCategories () {
      axios.get('/Categories/selectAllCategories')
        .then(response =>{
          if(response.status === 200){
            this.categories = response.data;
            console.log("正确");
          }
        }).catch(error => console.log("错误"))
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    }
  }
}
</script>
<style scoped>
  .draw_c{
    margin: 20px;
  }
</style>
