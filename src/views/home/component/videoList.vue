<template>
    <div class="list-content">
        <div class="list">
            <div class="course" v-show="VList !== undefined  &&  VList.length !== 0" v-for="(item) in VList" @click="toDetail(item.id)">
                <div class="item_img"><img :src="item.coverImg" /></div>
                <div class="video_info">
                    <div class="c_title">{{item.title}}</div>
                    <div class="price">￥ {{ item.price / 100 }}</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "videoList",
        props:{
            VList:{
                type:Array,
                required:true
            }
        },
        methods:{
            toDetail(id){
                this.$router.push({path:'/coursedetail',query:{video_id:id}})
            }
        }
    }
</script>

<style lang="scss" scoped>
    //列列表包裹层边距
    .list-content {
        margin-top: 20px;
        padding: 50px 0 13px;
    }
    //视频包括层
    .list {
        display: flex; //设置flex布局
        flex-wrap: wrap; //换⾏行行排列列
        justify-content: space-between; //两端对⻬齐
        padding-bottom: 55px;
    }
    //视频个体层
    .course {
        width: 48%;
        margin-bottom: 17px;
    }
    //视频图⽚片
    .item_img {
        font-size: 0; //消除图⽚片元素产⽣生的间隙
        box-shadow: 0 4px 11px 0 rgba(43, 51, 59, 0.6); //设置图⽚片阴影，rgba前三个参数是
        // 颜⾊色编码，最后⼀一个是透明度
        border-radius: 8px; //设置图⽚片圆⻆角
        img {
            width: 100%;
            border-radius: 8px;
        }
    }
    .c_title {
        //设置超过两⾏行行隐藏 start
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
        word-break: break-all;
        //设置超过两⾏行行隐藏 end
        font-size: 11px;
        height: 26px;
        line-height: 13px;
        margin-top: 10px;
        color: #2b333b;
    }
    //价格
    .price {
        margin-top: 8px;
        font-size: 12px;
        color: #d93f30;
    }
</style>
