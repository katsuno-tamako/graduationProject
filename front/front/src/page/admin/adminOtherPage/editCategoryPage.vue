<template>
  <div>
    <el-collapse accordion>
      <el-collapse-item name="1">
        <template slot="title">
          <span style="font-size: 20px">图书分类</span>
        </template>
        <el-form>
          <el-form-item label="选择种类">
            <el-select v-model="categoryType.category">
              <el-option
              v-for="c in allCategory"
              :key="c.value"
              :label="c.label"
              :value="c.value"
            ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="添加">
            <el-input v-model="categoryType.category_type"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="sub">提交</el-button>
          </el-form-item>
        </el-form>
        <el-card>
          <div v-for="type in sel_category_type" :key="type.id">
            <div v-if="type.category === '图书' ">
              <el-col :span="4">
                <el-card shadow="never">
                  <el-row>
                    <el-col :span="18">{{type.category_type}}</el-col>
                    <el-col :span="6">
                      <el-button size="mini" @click="delType(type)" icon="el-icon-delete" circle></el-button>
                    </el-col>
                  </el-row>
                </el-card>
              </el-col>
            </div>
          </div>
        </el-card>

      </el-collapse-item>
      <el-collapse-item name="2">
        <template slot="title">
          <span style="font-size: 20px">电脑分类</span>
        </template>
        <el-card shadow="never">
          <el-select v-model="computer_type.first_type">
            <el-option v-for="c in computerCategory" :key="c.id"
                       :label="c.label"
                       :value="c.value"
            ></el-option>
          </el-select>

            <el-input style="width: 200px" v-model="computer_type.second_type"></el-input>


            <el-button type="primary" @click="subComputerType">提交</el-button>

          <el-divider></el-divider>
          <div>
            <el-card shadow="never"><el-divider>电脑类型</el-divider>
              <el-col :span="4" v-for="c in all_computer_type" :key="c.id">
                <el-card shadow="never" v-if="c.first_type === '电脑类型'">
                  {{c.second_type}}
                  <el-button size="mini" @click="delComputerType(c)" icon="el-icon-delete" circle></el-button>
                </el-card>
              </el-col>
            </el-card>
            <el-card shadow="never"><el-divider>操作系统</el-divider>
              <el-col :span="4" v-for="c in all_computer_type" :key="c.id">
                <el-card shadow="never" v-if="c.first_type === '操作系统'">
                  {{c.second_type}}
                  <el-button size="mini" @click="delComputerType(c)" icon="el-icon-delete" circle></el-button>
                </el-card>
              </el-col></el-card>
            <el-card shadow="never"><el-divider>品牌</el-divider>
              <el-col :span="4" v-for="c in all_computer_type" :key="c.id">
                <el-card shadow="never" v-if="c.first_type === '品牌'">
                  {{c.second_type}}
                  <el-button size="mini" @click="delComputerType(c)" icon="el-icon-delete" circle></el-button>
                </el-card>
              </el-col>
            </el-card>
          </div>
        </el-card>
      </el-collapse-item>

    <el-collapse-item >
      <template slot="title">
        <span style="font-size: 20px">服装分类</span>
      </template>
      <el-card shadow="never">
          <el-divider></el-divider>
          <el-select v-model="choice_cloth.category">
            <el-option v-for="c in clothCategory" :key="c.id"
                       :label="c.label"
                       :value="c.value"
                      >
            </el-option>
          </el-select>
          <el-input v-model="choice_cloth.category_type" style="width: 200px"></el-input><el-button type="primary" @click="subClothCategory">确定</el-button>

            <div>
              <div>
                <el-divider>服装风格</el-divider>
                <el-row>
                  <el-col v-for="c in cloth_style" :key="c.id" :span="4">
                    <el-card shadow="never" style="text-align: center">
                        {{c.category_type}}
                      <el-button size="mini" @click="delCloth(c)" icon="el-icon-delete" circle></el-button>
                    </el-card>
                  </el-col>
                </el-row>
              </div>

              <div>
                <el-divider>服装品牌</el-divider>
                <el-row>
                  <el-col v-for="c in cloth_brand" :key="c.id" :span="4">
                    <el-card shadow="never" style="text-align: center">
                      {{c.category_type}}
                      <el-button size="mini" @click="delCloth(c)" icon="el-icon-delete" circle></el-button>
                    </el-card>
                  </el-col>
                </el-row>
              </div>

              <div>
                <el-divider>服装季节</el-divider>
                <el-row>
                  <el-col v-for="c in cloth_session" :key="c.id" :span="4">
                    <el-card shadow="never" style="text-align: center">
                      {{c.category_type}}
                      <el-button size="mini" @click="delCloth(c)" icon="el-icon-delete" circle></el-button>
                    </el-card>
                  </el-col>
                </el-row>
              </div>
              <div>
                <el-divider>服装类型</el-divider>
                <el-row>
                  <el-col v-for="c in cloth_type" :key="c.id" :span="4">
                    <el-card shadow="never" style="text-align: center">
                      {{c.category_type}}
                      <el-button size="mini" @click="delCloth(c)" icon="el-icon-delete" circle></el-button>
                    </el-card>
                  </el-col>
                </el-row>
              </div>
              <div>
                <el-divider>适用类型</el-divider>
                <el-row>
                  <el-col v-for="c in cloth_suitable" :key="c.id" :span="4">
                    <el-card shadow="never" style="text-align: center">
                      {{c.category_type}}
                      <el-button size="mini" @click="delCloth(c)" icon="el-icon-delete" circle></el-button>
                    </el-card>
                  </el-col>
                </el-row>
              </div>
            </div>
          <el-divider></el-divider>
      </el-card>
    </el-collapse-item>

      <el-collapse-item>
        <template slot="title">
          <span style="font-size: 20px">手机分类</span>
        </template>

        <editPhoneCategoryCom/>

      </el-collapse-item>

      <el-collapse-item>
        <template slot="title">
          <span style="font-size: 20px">家具分类</span>
        </template>

        <editFurnitureCategoryCom/>

      </el-collapse-item>


    </el-collapse>




  </div>
</template>

<script>
import editFurnitureCategoryCom from "./editCategoryCom/editFurnitureCategoryCom";
import editPhoneCategoryCom from "./editCategoryCom/editPhoneCategoryCom";
import axios from 'axios'
export default {
  name: 'editCategoryPage',
  components : {
    editPhoneCategoryCom,editFurnitureCategoryCom
  },
  created() {
    axios.get('/admin/getAdminSession').then(
      (res) => {
        this.stu = res.data;
        if(this.stu ==='NoLog'){
          console.log(res.data);
          this.$router.push('/adminLogin');
        }
      }
    )

    axios.get('/category/selectAllCategoryType').then(
      (res) => {
        this.sel_category_type = res.data
      }
    )

    axios.get('/computer/selectAllComputerType').then(
      (res)=>{
        this.all_computer_type = res.data;
      }
    );

    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装风格'}}).then((res) => {this.cloth_style = res.data})
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装品牌'}}).then((res) => {this.cloth_brand = res.data})
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res) => {this.cloth_session = res.data})
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装类型'}}).then((res) => {this.cloth_type = res.data})
    axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'适用人群'}}).then((res) => {this.cloth_suitable = res.data})



  },
  methods: {
    sub(){
      axios.post('/category/insertCategoryType',this.categoryType).then(
        (res) => {
          axios.get('/category/selectAllCategoryType').then(
            (res) => {
              this.sel_category_type = res.data
            }
          )
        }
      )
    },
    delType(categoryType){
      axios.post('/category/deleteCategoryType',categoryType).then(
        (res) => {
          axios.get('/category/selectAllCategoryType').then(
            (res) => {
              this.sel_category_type = res.data
            }
          )
        }
      )
    },
    delCloth(categoryType){
      axios.post('/category/deleteCategoryType',categoryType).then(
        (res) => {
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装风格'}}).then((res) => {this.cloth_style = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装品牌'}}).then((res) => {this.cloth_brand = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res) => {this.cloth_session = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装类型'}}).then((res) => {this.cloth_type = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'适用人群'}}).then((res) => {this.cloth_suitable = res.data})

        }
      )
    },
    delComputerType(computer_category){
      axios.post('/computer/deleteComputerCategory',computer_category).then(
        (res) => {
          axios.get('/computer/selectAllComputerType').then(
            (res) => {
              this.all_computer_type = res.data;
            }
          )
        }
      );
    },
    subComputerType(){
      axios.post('/computer/addComputerType',this.computer_type).then(
        (res) => {
          axios.get('/computer/selectAllComputerType').then(
            (res)=>{
              this.all_computer_type = res.data;
              this.computer_type.second_type = ''
            }
          )
        }
      );
    },
   subClothCategory(){
      this.categoryType = this.choice_cloth;
      axios.post('/category/insertCategoryType',this.choice_cloth).then(
        (res)=>{
          this.categoryType = '';
          this.choice_cloth.category_type = '';
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装风格'}}).then((res) => {this.cloth_style = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装品牌'}}).then((res) => {this.cloth_brand = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装季节'}}).then((res) => {this.cloth_session = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'服装类型'}}).then((res) => {this.cloth_type = res.data})
          axios.get('/category/selectCategoryTypeTableByCategory',{params:{category:'适用人群'}}).then((res) => {this.cloth_suitable = res.data})


        }
      )
   }
  },
  data(){
    return{
      sel_category_type : '',
      categoryType : {
        category : '',
        category_type : ''
      },
      allCategory : [
        {value : '图书',label : '图书'}],
      all_computer_type : {
        first_type : '',
        second_type : ''
      },
      computer_type : {
        first_type : '',
        second_type : ''
      },
      computerCategory : [
        {value:'电脑类型',label:'电脑类型'},
        {value:'操作系统',label:'操作系统'},
        {value:'品牌',label:'品牌'},
      ],
      clothCategory : [
        {value:'服装风格',label:'服装风格'},
        {value:'服装品牌',label:'服装品牌'},
        {value:'服装季节',label:'服装季节'},
        {value:'服装类型',label:'服装类型'},
        {value:'适用人群',label:'适用人群'},
      ],
      choice_cloth : {
        category : '',
        category_type : ''
      },
      c : '',
      cloth_style:{},
      cloth_brand:{},
      cloth_session:{},
      cloth_type:{},
      cloth_suitable:{},
    }

  }
}
</script>
<style scoped>
</style>
