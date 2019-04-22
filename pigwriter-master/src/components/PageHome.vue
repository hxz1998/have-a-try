<template>
  <div>
    <el-row v-for="article in this.articles" :key="article.id" >
      <el-col>
        <!--模板-->
        <el-card class="content-card" shadow="hover">
          <div slot="header" class="clearfix">
            <router-link tag="a" :to="'/read/' + article.id">{{article.title}}</router-link>
            <span style="float: right;font-size: 0.8em;"><el-icon class="el-icon-time"></el-icon> {{article.createDate}} </span>
          </div>
          <div style="overflow-wrap: break-word" v-html="article.contentAbstract">
          </div>
        </el-card>
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
  var data;
  export default {
    name: "PageShowArticles",
    data: function () {
      return {
        articles: []
      }
    },
    mounted: function () {
      this.init()
    },
    methods: {
      init: function () {
        var that = this;
        $.ajax({
          type: "post",
          url: "http://www.happyzhong.cn/article/list",
          success: function (result) {
            that.articles = result
            for(var i = 0; i < result.length; i++) {
              result[i].contentAbstract = marked(result[i].contentAbstract)
            }
          }
        });
      }
    }
  }
</script>

<style scoped>
  .content-card {
    margin-bottom: 12px;
  }

  a {
    text-decoration: none;
  }

  a:visited {
    color: #000;
  }
  
  a:link{
    color: #000;
  }
</style>
