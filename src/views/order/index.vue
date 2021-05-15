<template>
    <div class="main">
        <!-- 订单列表 -->
        <div class="list" v-if="orderList.length >0">
            <div class="box" v-for="(item,index) of orderList" :key="index">
                <div @click="toOrderDetail(item.videoId)" class="smallbox">
                    <div class="imgdiv"><img :src="item.videoImg" alt="课程订单图片"/></div>
                    <div class="textdiv">
                        <p class="title">{{item.videoTitle}}</p>
                        <p class="price">{{(item.totalFee / 100).toFixed(2)}}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="no_order" v-else><p>暂未购买教程</p></div>
    </div>
</template>

<script>
    import {getOrderList} from "@/api/video";
    export default {
        name: "Order",
        data (){
            return {
                orderList: []
            }
        },
        methods: {
            getOrderListData(){
                return new Promise((resolve, reject) => {
                    getOrderList().then(res =>{
                        if (res.status === 2000){
                            this.orderList = res.data;
                        }
                    });
                });
            },
            toOrderDetail(videoId){
                this.$router.push({path:'/coursedetail',query:{video_id:videoId}})
            }
        },
        mounted(){
            this.getOrderListData()
        }
    }
</script>

<style lang="scss" scoped>
    .list {
        padding: 0 20px;
    }
    // 视频个体
    .box {
        padding: 20px 0;
        background-color: #fff;
        border-bottom: 1px solid #ddd;
        // 标题
        .title {
            font-size: 14px;
            margin-bottom: 15px;
        }
        // 订单详情
        .smallbox {
            //flex左右排列列，两端对⻬齐
            display: flex;
            justify-content: space-between;
            .imgdiv {
                width: 90px;
                height: 60px;
                flex-shrink: 0;
                img {
                    width: 100%;
                    height: 100%;
                    border-radius: 10px;
                }
            }
            .textdiv p {
                margin-top: 10px;
                padding-left: 10px;
            }
        }
    }
    .no_order {
        margin-top: 50px;
        text-align: center;
    }
</style>
