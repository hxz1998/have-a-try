<template>
  <div id="app">
    <el-container>
      <el-header>
        <NavMenu></NavMenu>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import Home from "./pages/Home";
  import NavMenu from "./components/NavMenu";

  export default {
    name: 'App',
    components: {NavMenu, Home},
  }
</script>

<style>
</style>
