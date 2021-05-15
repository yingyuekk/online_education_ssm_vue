import request from '@/utils/request'

/**
 * 获取全部分类数据
 * */
export function getVList() {
    return request({
        url: '/video/list',
        method: 'get'
    })
}

/**
 * 根据ID获取视频信息
 * */
export function getInfoById(id) {
    return request({
        url: '/video/info',
        method: 'get',
        params: {id:id}
    })
}

/**
 * 根据ID获取视频章节信息
 * */
export function getChapterList(id) {
    return request({
        url: '/video/chapter',
        method: 'get',
        params: {id:id}
    })
}

/**
 * 根据ID获取视频章节信息
 * */
export function getOrderList() {
    return request({
        url: '/video/order',
        method: 'get'
    })
}

/**
 * 根据ID获取视频章节信息
 * */
export function payVideo(data) {
    return request({
        url: '/video/pay',
        method: 'post',
        params: {videoId:data}
    })
}
