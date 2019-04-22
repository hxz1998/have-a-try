<template>
  <div>
    <el-card>
      <router-link to="/library"><img src="../assets/start.jpg" width="100%" height="100%"></router-link>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "Starter",
    mounted: function () {
      this.$store.commit("changeModel", 1);
      this.$store.commit("read_content", "您好，欢迎使用iFinance")
    }
  }
</script>

<style scoped>

</style>
