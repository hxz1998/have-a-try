<template>
  <el-menu class="el-menu-demo" mode="horizontal" router="router">
    <el-menu-item index="/">首页</el-menu-item>
    <el-menu-item index="/about">关于</el-menu-item>
    <el-menu-item class="login" index="/admin">登录</el-menu-item>
  </el-menu>
</template>

<script>
  export default {
    name: "NavMenu",
  }
</script>

<style scoped>
  .login{
    float: right;
  }
</style>
