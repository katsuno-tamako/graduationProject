<template>
  <div>
    <el-card>
<!--      {{commodity.introduce}}-->
      <el-input
        type="textarea"
        :rows="5"
        v-model="commodity.introduce">
      </el-input>
      <el-button @click="methods_test">修改</el-button>
    </el-card>
    <div>

    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'commodityInfo',
  props : ['id'],
  data () {
    return {
      commodity_id : '',
      commodity : {
        introduce : ''
      }
    }
  },
  created() {
    axios.get('/selectCommodityById',{params : {commodity_id : this.id}}).then(
      (response) => {
        this.commodity = response.data;
      }
    );
  },
  methods : {
    methods_test:function() {
      alert('修改成功');
      axios.post('/editCommodityInfo',this.commodity).then();
    }
  }

}
</script>
<style scoped>
</style>
