import request from '../utils/request'

const loginUrl='/user/token'
export function authLogin(data){
    return request({
        url:loginUrl,
        method: 'post',
        data: data,  
    })
}
export function getRequest(url){
    return request({
        url:url,
        method: 'get'
    })
}
export function postRequest(url,params) {
    return request({
        url:url,
        method: 'post',
        data: params,  
    })
}
export function deleteRequest(url) {
    return request({
        url:url,
        method: 'delete'
    })
}
export function putRequest(url,params) {
    return request({
        url:url,
        method: 'put',
        data: params,
    })
}