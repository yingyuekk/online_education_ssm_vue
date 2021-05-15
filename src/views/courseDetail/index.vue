<template>
    <div>
        <!--顶部返回组件-->
        <detail-header :videoInfo="videoInfo"></detail-header>
        <!--视频介绍组件-->
        <detail-course :videoInfo="videoInfo"></detail-course>
        <!--视频tab简介组件-->
        <detail-tab :videoInfo="videoInfo" :chapterList="chapterList"></detail-tab>
        <!--底部立刻购买-->
        <footer>
            <button class="user_buy" @click="videoBuy">立即购买</button>
        </footer>
    </div>
</template>

<script>
    import DetailHeader from "./components/Header";
    import { getInfoById,getChapterList } from "@/api/video";
    import DetailCourse from "@/views/courseDetail/components/Course";
    import DetailTab from "@/views/courseDetail/components/Tab";
    export default {
        name: "CourseDetail",
        components: {DetailTab, DetailCourse, DetailHeader},
        data(){
            return {
                videoInfo: {},
                chapterList: []
            }
        },
        methods:{
            getVideoInfo(){
                return new Promise((resolve, reject) => {
                    getInfoById(this.$route.query.video_id).then(res =>{
                        if (res.status === 2000){
                            this.videoInfo = res.data;
                        }
                    });

                });
            },
            getChapterListData(){
                return new Promise((resolve, reject) => {
                    getChapterList(this.$route.query.video_id).then(res =>{
                        if (res.status === 2000){
                            this.chapterList = res.data;
                        }
                    });

                });
            },
            videoBuy(){
                this.$router.push({path: '/pay',query:{video_id:this.$route.query.video_id}});
            }
        },
        mounted() {
            this.getVideoInfo();
            this.getChapterListData();
        }
    }
</script>

<style lang="scss" scoped>
    //底部
    footer {
        // fixed固定在底部
        position: fixed;
        bottom: 0;
        width: 100%;
        padding: 8px 0;
        background-color: #fff;
        z-index: 999;
        box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
    }
    //设置购买按钮样式
    button {
        display: block;
        color: #fff;
        margin: 0 auto;
        background-color: #d93f30;
        height: 34px;
        line-height: 34px;
        border-radius: 17px;
        width: 80%;
        border: none;
        font-size: 15px;
        text-align: center;
    }
</style>
