<template>
  <div>
    <el-tabs type="border-card">
      <el-tab-pane label="上传图片">
        <el-upload
          class="upload-demo"
          action="http://upload.qiniup.com"
          multiple
          :file-list="fileList"
          :headers="headers"
          :data="this.$data">
        </el-upload>
      </el-tab-pane>
      <el-tab-pane label="删除图片">
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import Login from "../components/Login";
  import EditResource from '../components/EditResource'
  import * as qiniu from 'qiniu-js'

  export default {
    name: "Admin",
    components: {Login, EditResource},
    data: function () {
      return {
        token: '',
        fileList: [],
        headers: {
          headers: {'Content-Type': 'multipart/form-data'}
        }
      }
    },
    created: function () {
      this.$http.post("http://localhost:8080/photo/v1/file/getToken", {}, {
        'headers': {
          'Access-Control-Allow-Origin': '*'
        }
      }).then(function (response) {
        if (response.body.status === '200') {
          console.log(response.body.msg);
          console.log(response.body);
          this.token = response.body.data;
          console.log(this.token);
        } else {
          console.log(response.body);
        }
      })
    },
    methods: {
      upLoad: function () {
        this.$http.post("http://upload.qiniup.com", {
          file: this.file,
          token: this.token,
        }, {
          'headers': {'Content-Type': 'multipart/form-data'}
        }).then(function (response) {
          console.log(response);
        })
      },
      targetFile: function (event) {
        this.file = event.target.files[0];
      }
    }

  }
</script>

<style scoped>
</style>
