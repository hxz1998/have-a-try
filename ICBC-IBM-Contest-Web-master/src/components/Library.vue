<template>
  <div>
    <el-row class="section_card" :span="20" :gutter="20" type="flex" justify="center">
      <el-col>
        <router-link to="/epay">
          <el-card id="epay" class="section_card" shadow="hover">
            <el-header>
              线上账户服务
            </el-header>
            <img src="../assets/epay.jpg" style="width: 100%;">
          </el-card>
        </router-link>
      </el-col>
      <el-col>
        <router-link to="/transfer">
          <el-card id="icbcepay" shadow="hover">
            <el-header>
              工银e缴费
            </el-header>
            <img src="../assets/icbcepay.jpg" style="width: 100%;">
          </el-card>
        </router-link>
      </el-col>
    </el-row>
  </div>

</template>

<script>

  export default {
    name: "Library",
    mounted: function () {
      var that = this;
      this.$store.commit("read_content", "您可使用的功能有线上账户服务，工银e缴费");
      $('#epay').hover(function () {
        that.$store.commit("read_content", "您现在要选择的是线上账户服务")
      });
      $('#icbcepay').hover(function () {
        that.$store.commit("read_content", "您现在要选择的是工银e缴费")
      })
    }
  }
</script>

<style scoped>
  .section_card {
    height: 100%;
  }

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
