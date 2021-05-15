import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'

Vue.use(Vuex)

/** 属性创建自己的上下文。require.context()功能。
 * https://webpack.js.org/guides/dependency-management/#requirecontext
 */
const modulesFiles = require.context('./modules', true, /\.js$/);

/**
 * 你不需要import app from ./modules/app
 * 它将自动从模块文件中要求所有的vuex模块
 * */

const modules = modulesFiles.keys().reduce((modules, modulePath) =>{
  /** 获取模块名 './user.js' => 'user' */
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, '$1');
  const value = modulesFiles(modulePath);
  modules[moduleName] = value.default;
  return modules
},{});

const store = new Vuex.Store({
  modules,
  getters
});

export default store
