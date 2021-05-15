import request from '@/utils/request'

/**
 * 获取全部分类数据
 * */
export function getBList() {
    return request({
        url: '/banner/list',
        method: 'get'
    })
}
