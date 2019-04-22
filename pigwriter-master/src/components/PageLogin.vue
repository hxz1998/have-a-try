<template>
  <div class="space">
    <el-row type="flex" justify="center">
      <el-col :xs="24" :sm="24" :md="16" :lg="10">
        <el-input v-model="username" type="text" class="space">
          <template slot="prepend">username</template>
        </el-input>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-col :xs="24" :sm="24" :md="16" :lg="10">
        <el-input v-model="password" type="password" class="space">
          <template slot="prepend">password</template>
        </el-input>
      </el-col>
    </el-row>
    <el-row type="flex" class="space" justify="center">
      <el-button type="primary" class="space" @click="login">登录<i class="el-icon-upload el-icon--right"></i></el-button>
    </el-row>
  </div>
</template>

<script>
  import store from '../main'

  export default {
    name: "PageLogin",
    data: function () {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      login: function () {
        $.post("http://www.happyzhong.cn/login", this.$data, function (result) {
          console.log(result);
          if (result.state === 200) {
            //验证密码，登录系统
            store.store.logged_in = true;
            store.router.push('/edit');
          }
        })
      }
    }
  }
</script>

<style scoped>
  .space {
    margin-top: 10px;
  }
</style>
