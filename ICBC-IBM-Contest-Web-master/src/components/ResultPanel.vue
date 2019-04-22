<template>
  <div>
    <router-link to="/">
      <el-card>
        <el-alert
          title="注册成功"
          type="success"
          v-bind:description=idCard
          show-icon>
        </el-alert>
      </el-card>
    </router-link>
  </div>
</template>

<script>
  export default {
    name: "ResultPanel",
    data: function () {
      return {
        idCard: ''
      }
    },
    mounted: function () {
      this.idCard = this.$route.params.id;
    }
  }
</script>

<style scoped>
  a {
    text-decoration: none;
  }

  a:visited {
    color: #000;
  }

  a:link {
    color: #000;
  }
</style>
