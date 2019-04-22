<template>
  <div id="app" v-bind:style="{ fontSize:modelFontSize + 'em' }">
    <PageHeader></PageHeader>
    <router-view></router-view>
    <!--<PageFooter></PageFooter>-->
  </div>
</template>

<script>
  import PageHeader from "./components/PageHeader";
  import PageFooter from "./components/PageFooter";
  import './assets/js/screenfull';

  export default {
    name: 'App',
    components: {PageFooter, PageHeader},
    props: ['model-font-size'],
    data: function () {
      return {
        contentFontSize: 1
      }
    },
    mounted: function () {
      this.contentFontSize = this.$store.getters.fontSize;
    }
  }
</script>

<style>
</style>
