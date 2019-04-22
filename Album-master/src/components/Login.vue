<template>
  <div>
    <el-row type="flex" justify="center">
      <el-col :span="8">
        <h3 class="page-header text-center">管理员</h3>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center" class="login-group">
      <el-col :span="8">
        <el-input
          placeholder="帐户"
          v-model="username"
          clearable>
        </el-input>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center" class="login-group">
      <el-col :span="8">
        <el-input
          placeholder="密码"
          v-model="password"
          type="password"
          clearable>
        </el-input>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center" class="login-group">
      <el-col :span="8">
        <el-button @click="login" type="primary" icon="el-icon-check" :loading="loading" circle
                   class="center-block"></el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import Router from '../router/index'
  import Logged from '../main'

  export default {
    name: "Login",
    methods: {
      login: function () {
        if (this.username === '' || this.password === '') {
          this.$message('表单内容不可为空');
          return;
        }
        this.loading = true;
        this.$http.post('http://localhost:8080/photo/v1/user/login', {
          'un': this.username,
          'pw': this.password
        }, {
          'headers': {
            'Access-Control-Allow-Origin': '*'
          }
        }).then(function (response) {
          if (response.body.status === "200") {
            Logged.changeLogged();
            Router.push('/admin/edit');
          } else {
            this.$message('密码或者账户不匹配');
            console.log(response.body.status);
          }
        });
        this.loading = false;
      }
    },
    data: function () {
      return {
        username: '',
        password: '',
        loading: false
      }
    }
  }
</script>

<style scoped>

  .login-group {
    margin: 16px;
  }
</style>
