<template>
  <div>
    <form>
      <el-row>
        <el-input v-model="title" placeholder="随便来点什么吧..."></el-input>
      </el-row>
      <el-row :gutter="12" class="space">
        <el-col :span="12">
          <el-input id="content"
                    v-model="content"
                    type="textarea"
                    placeholder="记下现在想的..."
                    :autosize="{ minRows: 30}"
                    resize="none"
                    v-on:input="parse"
          >
          </el-input>
        </el-col>
        <el-col :span="12">
          <el-card class="content-card" shadow="hover">
            <div slot="header" class="clearfix">
              <span>{{ title }}</span>
            </div>
            <div id="html" style="overflow-wrap: break-word">
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row class="space">
        <el-col>
          <div style="border-bottom: lightskyblue solid 0.1em; border-radius: 0.05em"></div>
        </el-col>
      </el-row>
      <el-row type="flex" class="space" justify="center">
        <el-button @click="submit" type="primary">提交<i class="el-icon-upload el-icon--right"></i></el-button>
      </el-row>
    </form>
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
    name: "PageEditor",
    data: function () {
      return {
        title: '',
        content: '',
        htmlValue: '',
      }
    },
    methods: {
      parse: function () {
        $("#content").on("keyup", function () {
          this.htmlValue = marked($("#content").val())
          $("#html").html(marked($("#content").val()))
        });
      },
      submit: function () {
        var that = this;
        $.ajax({
          type: "post",
          url: "http://www.happyzhong.cn/article/add",
          data: this.$data,
          success: function (result) {
            if (result.state === 200) {
              that.$message.success("提交成功咯~");
              store.router.push('/');
            }
          }
        })
      }
    }
  }
</script>

<style scoped>
  .space {
    margin-top: 10px
  }
</style>
