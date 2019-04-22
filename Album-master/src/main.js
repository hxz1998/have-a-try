import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router/index'
import 'jquery/dist/jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import VueResource from 'vue-resource'
import * as qiniu from 'qiniu-js'

Vue.use(VueResource);
Vue.use(ElementUI);
Vue.config.productionTip = false;
Vue.http.options.emulateJSON = true;
Vue.http.options.crossOrigin = true;

var logged = false;

router.beforeEach(function (to, from, next) {
  if (!logged && to.path == '/admin/edit') {
    next('/admin');
    console.log('main' + logged);
  } else {
    console.log('main' + logged);
    next();
  }
});

export default {
  changeLogged:function () {
    logged = true;
  }
}

var vm = new Vue({
  el: '#app',
  router: router,
  components: {App},
  template: '<App/>',
});


