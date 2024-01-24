// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from "axios"
import Vuex from 'vuex'
import store from './store'
import  mavonEditor  from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
Vue.use(ElementUI);
Vue.use(Vuex);
Vue.use(mavonEditor);
Vue.prototype.$axios = axios;

axios.defaults.baseURL = "/api";

Vue.config.productionTip = false;


router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  store,
  data () {
    return {
      url : 'http://localhost:8906//'
    }
  },
  render: h => h(App)
});
