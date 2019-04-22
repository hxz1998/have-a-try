<template>
  <div>
    <el-row :gutter="16">
      <el-col :body-style="{ float:'left' }" v-bind:span="8" v-for="(o, index) in imageSrc" :key="index">
        <el-card :body-style="{ padding: '0px', margin: '8px' }">
          <img v-bind:src="o" class="image">
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  export default {
    name: "PhotoDisplayList",
    data() {
      return {
        imageSrc: {
          img1: 'http://pdfhvbwuh.bkt.clouddn.com/FipTGppRRzv4aMhHTOiqqDETXpc6',
          img2: 'http://pdfhvbwuh.bkt.clouddn.com/Fp7iJYX5RU-8s17lgBDC69JxJjM_',
          img3: 'http://pdfhvbwuh.bkt.clouddn.com/FgkAn93JbjLdWXuju4mobRrF1ux1',
          img0: 'http://pdfhvbwuh.bkt.clouddn.com/FiTw_8nMdWNULmtdDdudb7-nlnv4',
          img6: 'http://pdfhvbwuh.bkt.clouddn.com/FipTGppRRzv4aMhHTOiqqDETXpc6',
          img8: 'http://pdfhvbwuh.bkt.clouddn.com/FgkAn93JbjLdWXuju4mobRrF1ux1',
          img7: 'http://pdfhvbwuh.bkt.clouddn.com/Fp7iJYX5RU-8s17lgBDC69JxJjM_',
          img5: 'http://pdfhvbwuh.bkt.clouddn.com/FiTw_8nMdWNULmtdDdudb7-nlnv4',
          img9: 'http://pdfhvbwuh.bkt.clouddn.com/FlPwVaauwuHJ9umDDly9fhjGd8Gc',
          img4: 'http://pdfhvbwuh.bkt.clouddn.com/FlPwVaauwuHJ9umDDly9fhjGd8Gc',
        }
      };
    }
  }
</script>

<style scoped>
  .image {
    width: 100%;
    display: block;
    clear: both;
    margin: 0 auto;
  }
  img{
    width: 200px;
  }
</style>
