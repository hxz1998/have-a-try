<template>
  <div>
    <el-row>
      <el-col>
        <router-link to="/"><i class="el-icon-back"></i></router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-header>
          <h1 class="title">{{article.title}}</h1>
          <span style="float: right;" class="time"> <el-icon
            class="el-icon-time"></el-icon> {{article.createDate}}</span>
          <br>
        </el-header>
        <br>
        <div style="border-bottom: gray solid 0.1em; border-radius: 0.05em"></div>
        <el-main class="content" v-html="article.content">
        </el-main>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import $ from 'jquery'
  import marked from 'marked'
  import store from '../main'
  let rendererMD = new marked.Renderer();
  marked.setOptions({
    renderer: rendererMD,
    gfm: true,
    tables: true,
    breaks: true,
    pedantic: false,
    sanitize: false,
    smartLists: true,
    smartypants: false
  });
  export default {
    name: "ReadComponent",
    data: function () {
      return {
        article: {
          title: '',
          content: '',
          createDate: ''
        }
      }
    },
    mounted: function () {
      var that = this;
      $.ajax({
        url: "http://www.happyzhong.cn/article/read?id=" + that.$route.params.p,
        type: 'post',
        success: function (result) {
          result.content = marked(result.content)
          that.article = result
        }
      })
    },
    methods: {}
  }
</script>

<style scoped>
  .title {
    text-align: center;
  }

  .content {
    line-height: 2em;
  }

  .time {
    text-align: right;
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
