<template>
    <div>
        <!-- 首页轮播图 -->
        <home-banner :banners="banners"></home-banner>
        <!-- 视频列表 -->
        <video-list :VList="videoList"></video-list>
    </div>
</template>

<script>
    import HomeBanner from "@/views/home/component/homeBanner";
    import {getBList} from "@/api/banner";
    import VideoList from "@/views/home/component/videoList";
    import {getVList} from "@/api/video";
    export default {
        name: "Home",
        components: {VideoList, HomeBanner},
        data(){
            return {
                banners: [],
                videoList: []
            }
        },
        methods:{
            getBannersData(){
                return new Promise((resolve, reject) => {
                    getBList().then(res =>{
                        if (res.status === 2000){
                            this.banners = res.data;
                        }
                    });

                });
            },
            getVideoListData(){
                return new Promise((resolve, reject) => {
                    getVList().then(res =>{
                        if (res.status === 2000){
                            this.videoList = res.data;
                        }
                    });
                });
            }
        },
        created(){
            this.getBannersData();
            this.getVideoListData();

        }
    }
</script>

<style scoped>

</style>
