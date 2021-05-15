<template>
    <div class="main">
        <cube-form :model="model" @submit="submitHandler">

            <cube-form-group>

                <!--手机号-->
                <cube-form-item :field="fields[0]"></cube-form-item>
                <!--密码-->
                <cube-form-item :field="fields[1]"></cube-form-item>
            </cube-form-group>

            <cube-form-group>
                <cube-button type="submit">登录</cube-button>
            </cube-form-group>

        </cube-form>
        <router-link to="/register" class="reg">注册</router-link>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
            return {
                model: {
                    phone: '',
                    pwd: ''
                },
                fields: [
                    {
                        type: 'input',
                        modelKey: 'phone',
                        label: '手机号',
                        props: {
                            placeholder: '请输入手机号'
                        },
                        rules: {
                            required: true
                        },
                        messages: {
                            required: '手机号不能为空！！！'
                        }
                    },
                    {
                        type: "input",
                        modelKey: "pwd",
                        label: "密码",
                        props: {
                            placeholder: "请输入密码",
                            type: "password",
                            eye: {
                                open: false
                            }
                        },
                        rules: {
                            required: true
                        },
                        messages: {
                            required: "密码不能为空"
                        }
                    }
                ]
            }
        },
        methods: {
            submitHandler(e, model) {
                e.preventDefault();
                this.$store.dispatch("user/login", {phone:model.phone,pwd:model.pwd}).then(res =>{
                    this.$router.push({ path: this.redirect || "/personal" });
                });
            }
        }
    }
</script>

<style lang="scss" scoped>
    .main {
        padding: 50px 5% 0;
        text-align: center;
    }
    // 登录
    .cube-btn {
        margin-top: 20px;
    }
    //注册
    .reg {
        display: inline-block;
        margin-top: 30px;
        font-size: 18px;
    }
</style>
