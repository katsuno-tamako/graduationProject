<template>
  <div>
    <div>编辑{{c_info.name}}信息</div>

    <div v-if="c_info.category === '图书'"><edit-book-com :c_info="c_info"/></div>
    <div v-if="c_info.category === '电脑'"><edit-computer-com :c_info="c_info"/></div>
    <div v-if="c_info.category === '手机'"><edit-phone-com :c_info="c_info"/></div>
    <div v-if="c_info.category === '食品'"><edit-food-com :c_info="c_info"/></div>

    <div v-if="c_info.category === '家具'"><edit-furniture-com :c_info="c_info"/></div>
    <div v-if="c_info.category === '服装'"><edit-cloth-com :c_info="c_info"/></div>
    <div v-if="c_info.category === '其他'"><edit-other-com :c_info="c_info"/></div>


  </div>
</template>

<script>
import editBookCom from "./editCom/editBookCom";
import editComputerCom from "./editCom/editComputerCom";
import editPhoneCom from "./editCom/editPhoneCom";
import editFoodCom from "./editCom/editFoodCom";
import editFurnitureCom from "./editCom/editFurnitureCom";
import editOtherCom from "./editCom/editOtherCom";
import editClothCom from "./editCom/editClothCom";
export default {
  name: 'editCommodity',
  components : {
    editBookCom,editComputerCom,editPhoneCom,editFoodCom,editFurnitureCom,editClothCom,editOtherCom
  },
  props : ['c_info'],
  created() {

  }
}
</script>
<style scoped>
</style>
