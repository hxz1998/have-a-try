import Vue from 'vue'
import Router from 'vue-router'
import Home from '../pages/Home'
import About from '../pages/About'
import Login from '../components/Login'
import Admin from '../pages/Admin'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/about',
      component:About
    },
    {
      path:'/admin',
      component:Login
    },
    {
      path:'/admin/edit',
      component:Admin
    }
  ]
})
