<template>
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods : {
    reload () {
      this.isRouterAlive = false;
      this.$nextTick(() => (this.isRouterAlive = true));
    }
  }
}
</script>

<style scoped>
  a:link { text-decoration: none;}
  a:hover{text-decoration:none}
  body{
    margin: 0;
    padding: 0;
    
  }
</style>
