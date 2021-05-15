<template>
    <div class="container">
        <div class="p_top">
            <div>
                <img :src='info.head_img || defaultHeadImg' alt="头像"/>
                <p v-if = "this.isShow === false" @click="toLogin">立刻登录</p>
                <p v-else>{{info.name}} </p>
            </div>
        </div>
        <button v-if="this.isShow !== false" class="green" @click="logout">退出登录</button>
    </div>
</template>

<script>
    import defaultHeadImg from "@/assets/logo.png";
    import {getUserInfo} from "@/api/user";
    export default {
        name: "Personal",
        data(){
            return{
                info: {},
                isShow: false,
                defaultHeadImg: defaultHeadImg
            }
        },
        computed:{
            getToken(){
                return this.$store.state.user.token !== undefined;
            }
        },
        methods:{
            toLogin(){
                this.$router.push({path:'/login'})
            },
            getUserInfo(){
                return new Promise((resolve, reject) => {
                    getUserInfo(this.getToken).then(res =>{
                        if (res.status === 2000){
                            this.isShow = true;
                            this.info = res.data;
                        }
                    });

                });
            },
            logout() {
                this.$store.dispatch("user/logoutUser").then(() => {
                    //刷新页面
                    location.reload();
                });
            }
        },
        mounted() {
            if (this.getToken) {
                this.getUserInfo();
            }
        }
    }
</script>

<style lang="scss" scoped>
    .container {
        // 顶部头像区域
        .p_top {
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px 0;
            background-color: #2c3f54;
            div {
                text-align: center;
                img {
                    width: 60px;
                    height: 60px;
                    border-radius: 50px;
                }
                p {
                    font-size: 16px;
                    color: #fff;
                    margin-top: 10px;
                }
            }
        }
    }
    // 退出登录
    .green {
        display: block;
        background-color: #3bb149;
        border: none;
        outline: none;
        width: 80%;
        height: 40px;
        margin: 20px auto 0;
        color: #fff;
        border-radius: 20px;
    }
</style>
