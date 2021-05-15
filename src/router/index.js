import Vue from 'vue'
import Router from 'vue-router'
import store ,{ getStore } from '@/store/index'

Vue.use(Router);

/** 解决编程式路由往同一地址跳转时会报错的情况 */
const originalPush = Router.prototype.push;
const originalReplace = Router.prototype.replace;

//push
Router.prototype.push = function push(location, onResolve, onReject) {
  if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject);
  return originalPush.call(this, location).catch(err => err)
};

//replace
Router.prototype.replace = function push(location, onResolve, onReject) {
  if (onResolve || onReject) return originalReplace.call(this, location, onResolve, onReject);
  return originalReplace.call(this, location).catch(err => err)
};

import menu from '@/menu/index'

export const constantRoutes = [
  {
    path: '/redirect',
    component: menu,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/coursedetail',
    component: () => import('@/views/courseDetail/index')
  },
  {
    path: '/login',
    component: () => import('@/views/login/index')
  },
  {
    path: '/register',
    component: () => import('@/views/register/index')
  },
  {
    path: '/pay',
    component: () => import('@/views/pay/index'),
    meta: {requiresAuth:true}
  },
  {
    path: '/',
    component: menu,
    redirect: '/home',
    children: [
      {
        path: 'home',
        component: () => import('@/views/home/index'),
        name: '首页',
        meta: { title: '首页', icon: 'cubeic-home',path:'/home'}
      }
    ]
  },
  {
    path: '/order',
    component: menu,
    redirect: '/order/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/order/index'),
        name: '我的订单',
        meta: { title: '我的订单', icon: 'cubeic-like',path:'/order',requiresAuth:true}
      }
    ]
  },
  {
    path: '/personal',
    component: menu,
    redirect: '/personal/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/personal/index'),
        name: '个人中心',
        meta: { title: '个人中心', icon: 'cubeic-person',path:'/personal'}
      }
    ]
  },
  {
    path: '/error',
    component: () => import('@/views/error/index')
  }
];

export const createRouter = () => new Router({
  routes: constantRoutes
});

const router = createRouter();

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter();
  router.matcher = newRouter.matcher // reset router
}

export function getRouter() {
  return router;
}
export default router
