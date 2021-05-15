<template>
    <div>
        <!-- 视频信息 -->
        <div class="info">
            <p class="info_title">商品信息</p>
            <div class="box">
                <div class="imgdiv">
                    <img alt="课程照片" :src="videoInfo.coverImg" />
                </div>
                <div class="textdiv">
                    <p class="c_title">{{videoInfo.title}}</p>
                    <p class="price">￥:&nbsp;&nbsp; {{(videoInfo.price /
                        100).toFixed(2)}}</p>
                </div>
            </div>
        </div>
        <!-- 顶部支付 -->
        <div class="footer">
            <p class="money">实付:&nbsp;&nbsp; {{(videoInfo.price / 100).toFixed(2)}}
            </p>
            <p class="submit" @click="payClick">立刻支付</p>
        </div>
    </div>
</template>

<script>
    import {getInfoById, payVideo} from "@/api/video";
    export default {
        name: "Pay",
        data(){
            return{
                videoInfo: {}
            }
        },
        methods:{
            getDetail(videoId){
                return new Promise((resolve, reject) => {
                    getInfoById(videoId).then(res =>{
                        if (res.status === 2000){
                            this.videoInfo = res.data;
                        }
                    });

                });
            },
            payClick(){
                return new Promise((resolve, reject) => {
                    payVideo(this.$route.query.video_id).then(res =>{
                        if (res.status === 2000){
                            this.$router.push({path:'/order'})
                        }
                    });
                });
            }
        },
        mounted(){
            this.getDetail(this.$route.query.video_id);
        }
    }
</script>

<style lang="scss" scoped>
    // 视频标题
    .info_title {
        padding: 10px 20px;
        background-color: #fff;
        border-bottom: 1px solid #d9dde1;
    }

    .box {
        background-color: #fff;
        box-sizing: border-box;
        padding: 20px;
        display: flex;
        margin-bottom: 15px;

        .imgdiv {
            width: 105px;
            height: 59px;
            flex-shrink: 0;

            img {
                width: 100%;
                height: 100%;
            }
        }
        .textdiv {
            margin-left: 20px;
            height: 59px;
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            .price {
                flex-shrink: 0;
            }
        }
    }
    //底部
    .footer {
        position: fixed;
        bottom: 0;
        width: 100%;
        height: 50px;
        background-color: #fff;
        display: flex;
        justify-content: space-between;
        box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.1);
        font-size: 16px;

        .money {
            height: 50px;
            line-height: 50px;
            flex: 2;
            text-align: center;
            background-color: #fff;
        }

        .submit {
            height: 50px;
            line-height: 50px;
            flex: 1;
            text-align: center;
            background-color: #ff2d50;
            color: #fff;
        }
    }
</style>
