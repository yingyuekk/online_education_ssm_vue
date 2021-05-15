import axios from 'axios'
import router from "@/router";
import {getToken} from "@/utils/auth";
import {Toast} from 'cube-ui'

/** 创建一个axios实例 */
const service = axios.create({
    /** 请求地址 url */
    baseURL: '/',
    /** 超时时间 */
    timeout: 5000
});

/** 请求拦截器 */
service.interceptors.request.use(
    config =>{
        /** 在发送请求之前先把token写到header中 */
        config.headers['web-Token'] = getToken();
        return config;
    },
    error => {
        /** 处理请求错误 */
        Toast.$create({txt: error, type: "error", time: 3500}).show();
        /** 返回处理对象 */
        return Promise.reject(error);
    }
);

/** 响应拦截器 */
service.interceptors.response.use(
    /**
     * 如果想要获得http信息，例如头或状态
     * return  response => response
     * */

    /**
     * 自定义代码确定请求状态
     * */
    response => {
        const  res = response.data;
        if (res.status < 0){
            router.push({path: '/error',query:{msg:res.msg}}).then(r => {});
            return Promise.reject(new Error(res.msg || 'Error'));
        }else if (res.status !== 2000){
            Toast.$create({txt: res.msg, type: "error", time: 3500}).show();
            return Promise.reject(new Error(res.msg || 'Error'));
        }else {
            return res;
        }
    },
    error => {
        Toast.$create({txt: error, type: "error", time: 3500}).show();
        return Promise.reject(error);
    }
);
export default service
