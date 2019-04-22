import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import $ from 'jquery'

Vue.config.productionTip = false;
Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  mounted:function () {
    router.beforeEach(function (to, from, next) {
      if (!store.logged_in && (to.path === '/edit') || (to.path === '/read/edit')) {
        next('/login')
      } else {
        next()
      }
    })
  }
});

var store = {
  logged_in : false,
};

export default {
  store,
  router
}
