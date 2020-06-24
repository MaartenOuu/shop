import request from './request'

export const getRequest = (url) =>{
    return request({
        url:url,
        method: 'get'
    })
}