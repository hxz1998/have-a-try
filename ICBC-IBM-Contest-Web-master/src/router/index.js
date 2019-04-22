import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import Library from '../components/Library'
import About from '../components/About'
import Starter from '../components/Starter'
import EPayPanel from '../components/EPayPanel'
import TransferPanel from '../components/TransferPanel'
import Result from '../components/ResultPanel'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: Starter
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/library',
      component: Library
    },
    {
      path: '/epay',
      component: EPayPanel
    },
    {
      path: '/transfer',
      component: TransferPanel
    },
    {
      path: '/about',
      component: About
    },
    {
      path: '/result/:id',
      component: Result
    }
  ]
})
