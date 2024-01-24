<template>
  <div>
    <el-button @click="addMd">提交</el-button>
    <mavon-editor  :ishljs = "true" v-model="value" ref=md @save="save" @imgAdd="imgAdd" />

    <div>

    </div>

  </div>

</template>

<script>
import axios from 'axios'
export default {
  name: 'testMarkdown',
  components :{

  },
  methods : {
     save(){
        axios.post('/test/testMd',{
          name : '123',
          id : '456',
          content : '789'
        })
     },
    imgAdd(){

    }
  },
  data(){
    return{
      value : ''
    }
  }
}
</script>
<style scoped>
</style>
