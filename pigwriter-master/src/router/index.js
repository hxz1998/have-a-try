import Vue from 'vue'
import Router from 'vue-router'
import PageHome from '../components/PageHome'
import PageEditor from '../components/PageEditor'
import PageAbout from '../components/PageAbout'
import PageLogin from '../components/PageLogin'
import ReadComponent from '../components/ReadComponent'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'PageHome',
      component: PageHome
    },
    {
      path: '/edit',
      name: 'PageEditor',
      component: PageEditor
    },
    {
      path: '/login',
      name: 'PageLogin',
      component: PageLogin
    },
    {
      path: '/about',
      name: 'PageAbout',
      component: PageAbout
    },
    {
      path: '/read/:p',
      name: 'read',
      component: ReadComponent
    }
  ]
})
