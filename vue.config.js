const path = require('path');
const defaultSettings = require('./src/settings.js');

function resolve(dir) { // https://www.webpackjs.com/configuration/resolve/#resolve-alias
  return path.join(__dirname, dir)
}

const name = defaultSettings.title || '在线教育' // page title
// vue.config.js https://cli.vuejs.org/zh/config/
module.exports = {

  publicPath: '/', // 部署应用包时的基本 URL
  outputDir: 'dist', // 生成的生产环境构建文件的目录
  assetsDir: 'static', //放置生成的静态资源 (js、css、img、fonts)
  lintOnSave: process.env.NODE_ENV !== 'production', // https://cli.vuejs.org/zh/config/#lintonsave
  productionSourceMap: false, // https://cli.vuejs.org/zh/config/#productionsourcemap
  devServer: { // https://cli.vuejs.org/zh/config/#devserver
    port: 8090, // https://webpack.js.org/configuration/dev-server/#devserverport
    open: false, // https://webpack.js.org/configuration/dev-server/#devserveropen
    overlay: { // https://webpack.js.org/configuration/dev-server/#devserveroverlay
      warnings: true,
      errors: true
    },
    proxy: 'http://localhost:8080'
  },
  configureWebpack: {
    // 在webpack的name字段中提供应用的标题，
    // 这样它就可以在index.html中访问，以注入正确的标题。
    name: name,
    resolve: { // https://www.webpackjs.com/configuration/resolve/
      alias: {
        '@': resolve('src')
      }
    }
  },
  css: {
    loaderOptions: {
      stylus: {
        'resolve url': true,
        'import': [
          './src/theme'
        ]
      }
    }
  },
  pluginOptions: {
    'cube-ui': {
      postCompile: true,
      theme: true
    }
  }
}
