import axios from 'axios'

const request = axios.create({
    baseURL:"/api",
    timeout:2000 //请求超时时间
})

// request.interceptors.request.use(
//     config => {
//         if(cookie.get('blogToken')){
//             config.headers['token'] = cookie.get('blogToken')
//         }
//         return config
//     },
//     err => {
//         return Promise.reject(err)
//     }
// )
export default request