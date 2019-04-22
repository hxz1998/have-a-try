import Vue from 'vue'
import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import './assets/css/pace/pace-theme-minimal.css'
import './assets/js/pace.min'
import './assets/js/screenfull'
import $ from 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap'
import Vuex from 'vuex'
import './assets/js/screenfull';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import "./assets/js/baidu_tts_cors"

import {btts} from "./assets/js/baidu_tts_cors.js"

Vue.use(Vuex);
Vue.use(VueResource);
Vue.use(ElementUI);
Vue.config.productionTip = false;
Vue.http.options.emulateJSON = true;
Vue.http.options.crossOrigin = true;

const store = new Vuex.Store({
  state: {
    contentFontSize: 3,
    audio: null,
    is_reading: false
  },
  mutations: {

    //切换模式，一般模式or无障碍模式
    changeModel: function (state, size) {
      state.contentFontSize = size;
      screenfull.toggle();
    },

    //阅读内容
    //调用baidu语音合成API
    read_content: function (state, content) {
      if (!state.is_reading) {
        state.is_reading = true;
        let text = content;
        // 调用语音合成接口
        // 参数含义请参考 https://ai.baidu.com/docs#/TTS-API/41ac79a6
        this.audio = btts({
          tex: text,
          tok: '24.89076f69acd9fa9416eb3f5147484617.2592000.1545626449.282335-14926821',
          spd: 5,
          pit: 5,
          vol: 15,
          per: 4
        }, {
          volume: 0.3,
          autoDestory: true,
          timeout: 10000,
          hidden: false,
          onInit: function (htmlAudioElement) {
          },
          onSuccess: function (htmlAudioElement) {
            this.audio = htmlAudioElement;
            this.audio.autoplay = true;
            this.audio.controls = false;
          },
          onError: function (text) {
            alert(text)
          },
          onTimeout: function () {
            alert('timeout')
          }
        });
        setTimeout(function () {
          state.is_reading = false;
        }, 1000)
      }
    }
  },
  getters: {
    fontSize: function (state) {
      return state.contentFontSize;
    }
  }
})

new Vue({
  el: '#app',
  components: {App},
  template: '<App v-bind:model-font-size="modelFontSize" />',
  router: router,
  store: store,
  computed: {
    modelFontSize: function () {
      return this.$store.getters.fontSize;
    }
  },

});
