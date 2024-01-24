<template>
  <div>
    <p>test axios page</p>
    <span>{{book.id}}</span>
    <div>
      <label>书名</label>
      <span>{{book.name}}</span>
    </div>
    <div>
      <label>出版社</label>
      <span>{{book.publishing}}</span>
    </div>
    <div>
      <label>价格</label>
      <span>{{book.commodity.prise}}</span>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'axios_1',
  data () {
    return {
      book : ""
    }
  },
  created() {
    this.getMessage();
  },
  methods : {
    getMessage () {
      axios.get("/selectBookByName")
        .then(response => {
          if(response.status === 200){
            this.book = response.data;
            console.log("正确")
          }
        }).catch(error => console.log("错误"))
    }
  }
}
</script>
<style scoped>
</style>
