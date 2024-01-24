<template>
  <div>
    <el-card>要编辑的id：{{commodity_id}}</el-card>
    <el-divider/>
    <el-card>
      <div v-if="category === '图书'">
        <edit-book :commodity_id="commodity_id"/>
      </div>
      <div v-if="category === '电脑'">2</div>
      <div v-if="category === '服装'">
        <edit-cloth :commodity_id="commodity_id"/>
      </div>
      <div v-if="category === '手机'">
        <edit-phone :commodity_id="commodity_id"/>
      </div>
      <div v-if="category === '家具'">
        <editFurniture :commodity_id="commodity_id"/>
      </div>
      <div v-if="category === '食品'">
        <editFood :commodity_id="commodity_id"/>
      </div>

      <div v-if="category === '电脑'">
        <editComputer :commodity_id="commodity_id"/>
      </div>
    </el-card>
  </div>
</template>

<script>
import editPhone from "./editPhone";
import editCloth from "./editCloth";
import editBook from "./editBook";
import editFurniture from "./editFurniture";
import editFood from "./editFood";
import editOther from "./editOther";
import editComputer from "./editComputer";
export default {
  name: 'editPage',
  components : {
    editPhone,editCloth,editBook,editFurniture,editFood,editOther,editComputer
  },
  data(){
    return {
      category : '',
      commodity_id : ''
    }
  },
  created() {
    this.category = this.$route.query.category;
    this.commodity_id = this.$route.query.commodity_id;
  }
}
</script>
<style scoped>
</style>
