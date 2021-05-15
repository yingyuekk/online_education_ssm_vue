<template>
    <div>
        <error-header></error-header>
        <div style="margin-top: 10px;text-align: center;">{{ this.$route.query.msg }}</div>
    </div>
</template>

<script>
    import ErrorHeader from "./components/Header";
    export default {
        name: "Error",
        components:{
            ErrorHeader
        }
    }
</script>

<style scoped>

</style>
