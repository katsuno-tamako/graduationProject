<template>
  <div>
    <div v-if="category==='book'">
      <add-book-com/>
    </div>
    <div v-if="category==='computer'">
      <add-computer-com/>
    </div>
    <div v-if="category==='phone'">
      <add-phone-com/>
    </div>
    <div v-if="category==='cloth'">
      <add-cloth-com/>
      </div>
    <div v-if="category==='furniture'">
      <add-furniture-com/>
    </div>
    <div v-if="category==='food'">
      <add-food-com/>
    </div>
    <div v-if="category==='other'">
      <add-other-com/>
    </div>
  </div>
</template>

<script>
import addBookCom from "./category/addBookCom";
import addComputerCom from "./category/addComputerCom";
import addPhoneCom from "./category/addPhoneCom";
import addClothCom from "./category/addClothCom";
import addFurnitureCom from "./category/addFurnitureCom";
import addFoodCom from "./category/addFoodCom";
import addOtherCom from "./category/addOtherCom";
export default {
  name: 'addCommodity_r',
  components : {
    addBookCom,addComputerCom,addPhoneCom,addClothCom,addFurnitureCom,addFoodCom,addOtherCom
  },
  props : ['category']
}
</script>
<style scoped>
</style>
