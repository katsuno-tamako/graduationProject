<template>
  <div>
    <div style="text-align: center;height: 50px;font-size: 20px;background-color: deepskyblue">
      简陋的物流管理系统
    </div>
    <div>
      <div v-for="l in logistics" :key="l.id">
        <el-card shadow="never">
          <div>快递单号：{{l.logistics_id}}</div>
          <el-row :gutter="10">
            <el-col :span="4">
              <div>{{l.dispatch}}</div>
              <div>{{l.dispatch_people}}</div>
            </el-col>
            <el-col :span="4">
              <div>{{l.receive}}</div>
              <div>{{l.receive_people}}</div>
            </el-col>
            <el-col :span="4">
              状态：{{l.logistics_status}}
            </el-col>
            <el-col :span="4">
              company:{{l.logistics_company}}
            </el-col>
            <el-col :span="4">
              <div v-if="l.logistics_status === '已送达'">
                <el-button disabled>已送达</el-button>
              </div>
              <div v-else>
                <el-button @click="updateStatus(l.logistics_id)">更改状态</el-button>
              </div>
            </el-col>
            <el-col :span="4"></el-col>
          </el-row>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'logisticsIndex',
  created() {
    axios.get('/logistics/selectAllLogistics').then(
      (res) => {
        this.logistics = res.data;
      }
    )
  },
  methods : {
    updateStatus(id){
      axios.get('/logistics/editLogisticsStatus',{params:{logistics_id:id}}).then(
        (res)=>{
          axios.get('/logistics/selectAllLogistics').then(
            (res) => {
              this.logistics = res.data;
            }
          )
        }
      )
    }
  },
  data(){
    return{
      logistics : {
        logistics_id : ''
      }
    }
  }

}
</script>
<style scoped>
</style>
