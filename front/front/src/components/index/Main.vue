<template>
    <div>
      <div style="">
        <Carousel/>
      </div>
      <div>
        <MainCommodity/>
      </div>
    </div>
</template>

<script>
import Carousel from "./Carousel";
import MainCommodity from "./MainCommodity";
export default {
  name: 'Main',
  components : {
    Carousel,
    MainCommodity
  }
}
</script>
<style scoped>
</style>
