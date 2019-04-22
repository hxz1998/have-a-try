<template>
  <div>
    <el-row>
      <h1 style="text-align: center;">随便来点什么吧</h1>
      <h5 style="text-align: right;">写于： 2018年10月20日 <el-icon class="el-icon-edit-outline"></el-icon></h5>
    </el-row>
    <el-row>
      <div>
        <p>其实，我也不知道该来点什么...</p>
        <p>遵循惯例，这里一般是写一点关于这个软件的说明和解释，但是这次并不想说那么多。可能是有点懒了 <strong>:)</strong> </p>
        <p>不管怎么说，还是要来点，比如说下面的致谢列表：</p>
        <el-table
          :data="tableData">
          <el-table-column
            prop="name"
            label="项目名">
          </el-table-column>
          <el-table-column
            prop="cond"
            label="贡献">
          </el-table-column>
          <el-table-column
            prop="addr"
            label="地址">
          </el-table-column>
        </el-table>
        <p>同时也感谢来自老师的帮助和朋友们的支持。</p>
        <div class="footer">
          <address class="center-block text-center">
            <br>
            For <strong>PigWriter.</strong> &copy; <strong>Xiaozhong</strong>
            <a href="mailto:helloprofessor@outlook.com">helloprofessor@outlook.com</a>
          </address>
        </div>
      </div>
    </el-row>
  </div>
</template>

<script>
    export default {
        name: "PageAbout",
      data:function () {
        return {
          tableData:[
            {
              name:'Linux发行版Ubuntu',
              cond:'操作系统',
              addr:'https://cn.ubuntu.com/'
            },
            {
              name:'marked',
              cond:'灵活的编辑器插件',
              addr:'https://github.com/markedjs/marked/'
            },
            {
              name:'vue',
              cond:'前端框架',
              addr:'https://cn.vuejs.org/'
            },
            {
              name:'element-ui',
              cond:'基于vue的UI组件框架',
              addr:'http://element-cn.eleme.io/'
            },
            {
              name:'来自热心网友的帖子',
              cond:'提供了良好的参考手册',
              addr:'http://www.cnblogs.com/djtao/p/6224399.html'
            },
          ]
        }
      }
    }
</script>

<style scoped>
  i, address{
    font-style: normal;
  }
  a{
    text-decoration: none;
    color: #337ab7;
  }
  .footer{
    font-size: 14px;
    text-align: center;
    padding-top: 1em;
    padding-bottom: 1em;
  }
</style>
