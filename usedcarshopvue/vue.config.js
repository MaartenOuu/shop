
module.exports = {
    lintOnSave: true,
   
    devServer: {
      host: '127.0.0.1',
      port: 8888,
      https: false,
      hotOnly: false,
      proxy: {
        // proxy all requests starting with /api to jsonplaceholder
        '/api': {
          target: 'http://localhost:9001',   //代理接口
          changeOrigin: true,
          pathRewrite: {
            '^/api': ''    //代理的路径
          }
        },
        '/pic': {
          target: 'http://localhost:9001',   //代理接口
          changeOrigin: true,
          pathRewrite: {
            '^/pic': ''    //代理的路径
          }
        }
      }
    },
    lintOnSave: false
}