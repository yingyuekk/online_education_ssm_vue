import request from '@/utils/request'

/**
 * 获取用户信息
 * */
export function getUserInfo(data) {
    return request({
        url: '/user/info',
        method: 'get',
        data
    })
}

/**
* 用户登录
* */
export function login(data) {
    return request({
        url: '/user/login',
        method: 'post',
        data
    })
}

/**
 * 用户注册
 * */
export function register(data) {
    return request({
        url: '/user/register',
        method: 'post',
        data
    })
}

/**
 * 用户 注销
 * */
export function logout() {
    return request({
        url: '/user/logout',
        method: 'post'
    })
}
