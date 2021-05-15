import { login, logout } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { resetRouter,getRouter} from '@/router'
import {Toast} from "cube-ui";

const state = {
    token: getToken()
};

const mutations = {
    SET_TOKEN: (state, token) => {
        state.token = token;
    }
};
const actions = {
    /** 用户登录 */
    login({ commit }, userInfo) {
        const { phone, pwd } = userInfo;
        return new Promise((resolve, reject) => {
            login({phone: phone,pwd:pwd}).then(res =>{
                const { data } = res;
                commit('SET_TOKEN', data);
                setToken(data);
                resolve()
            }).catch(error =>{
                reject(error)
            });
        });
    },
    logoutUser({ commit, state, dispatch }) {
        return new Promise((resolve, reject) => {
            logout(state.token).then(() => {
                commit('SET_TOKEN', '');
                sessionStorage.clear();
                removeToken();
                resetRouter();
                resolve()
            }).catch(error =>{
                reject(error);
            });
        });
    },
    routeIntercept(){
        router.beforeEach(function (to,from,next) {
            if (to.meta.requiresAuth === true){
                if (getToken() === undefined){
                    next({path:'/login'});
                }
                next();
            }
            next();
        });
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
}
