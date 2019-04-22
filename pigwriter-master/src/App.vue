<template>
  <div>
    <el-row type="flex" justify="center">
      <el-col :xs="24" :sm="24" :md="14" :lg="13">
        <el-container id="app">
          <el-header>
            <PageHeader></PageHeader>
          </el-header>
          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </el-col>

    </el-row>
    <div class="footer">
      <address class="center-block text-center">
        <br>
        <a href="http://www.miitbeian.gov.cn">豫ICP备18043439号</a><br>
        For <strong>PigWriter.</strong> &copy; <strong>Xiaozhong</strong>
        <a href="mailto:xiaozhong@happyzhong.cn">xiaozhong@happyzhong.cn</a>&nbsp;&nbsp;
      </address>
    </div>
  </div>


</template>

<script>
  import PageHeader from "@/components/PageHeader";

  export default {
    name: 'App',
    components: {PageHeader}
  }
</script>

<style>
  i, address {
    font-style: normal;
  }

  a {
    text-decoration: none;
    color: #337ab7;
  }

  .footer {
    font-size: 14px;
    text-align: center;
    padding-top: 1em;
    padding-bottom: 1em;
  }
</style>
