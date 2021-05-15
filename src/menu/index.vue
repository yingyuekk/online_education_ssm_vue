<template>
    <div>
        <div class="menu">
            <cube-tab-bar v-model="selectedLabelSlots" @click="changHandler">
                <cube-tab
                        v-for="(item) in levelList"
                        :icon="item.icon"
                        :label="item.title"
                        :key="item.path"
                        :value="item.path"></cube-tab>
            </cube-tab-bar>
        </div>
        <div class="app-main">
            <router-view :key='this.$route.path'/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Menu",
        data() {
            return {
                selectedLabelSlots: '/',
                levelList: []
            }
        },
        created() {
            this.getMenu();
            this.routeIntercept();
        },
        methods: {
            getMenu(){
                /** 使用meta.title显示路由 */

                /** 获取所有菜单 children[0].meta */
                let matched = [];
                this.$router.options.routes.filter(function (item) {

                    if (item.children !== undefined && item.children[0].name !== undefined){
                        matched.push(item.children[0].meta);
                    }
                });
                this.levelList = matched;
            },
            changHandler(path){
                if (path !== this.$route.path){
                    this.$router.push({path: path});
                }
            },
            routeIntercept(){
                this.$store.dispatch("user/routeIntercept");
            }
        }
    }
</script>

<style lang="scss" scoped>
.menu{
    position: fixed;
    bottom: 0;
    z-index: 999;
    background-color:#fff;
    width: 100%;
    border-top: 1px solid rgba($color: #000000, $alpha: 0.1);
}
.cube-tab_active {
    color: #3bb149;
}
.app-main {
    /* 50= navbar  50  */
    min-height: calc(100vh - 50px);
    width: 100%;
    position: relative;
    overflow: hidden;
}
</style>
