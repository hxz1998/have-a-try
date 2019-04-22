<template>
  <div style="padding: 10px;">
    <SmsInputDialog ref="sms_input_dialog" :parent_smsSendNo="this.params.corpSerno"></SmsInputDialog>
    <el-input id="first_input" class="input_space" v-model="params.corpNo" placeholder="合作方机构编号"
              @focus="read_input('合作方机构编号输入')"
    ></el-input>
    <el-input class="input_space" v-model="params.corpSerno" placeholder="合作方交易单号"
              @focus="read_input('合作方交易单号输入')"></el-input>
    <el-input class="input_space" v-model="params.outServiceCode" placeholder="外部服务代码"
              @focus="read_input('外部服务代码输入')"></el-input>
    <el-input class="input_space" v-model="params.corpCisNo" placeholder="合作方客户号"
              @focus="read_input('合作方客户号输入')"></el-input>
    <el-input class="input_space" v-model="params.corpMediumId" placeholder="合作方介质号，如微信号"
              @focus="read_input('合作方介质号')"></el-input>
    <el-input class="input_space" v-model="params.bindMedium" placeholder="绑定的I类卡号" @focus="read_input('绑定的I类卡号输入')"
    ></el-input>
    <el-input class="input_space" v-model="params.certType" placeholder="证件类型" @focus="read_input('证件类型输入')"></el-input>
    <el-input class="input_space" v-model="params.certNo" placeholder="证件号码" @focus="read_input('证件号码输入')"></el-input>
    <el-input class="input_space" v-model="params.custName" placeholder="户名" @focus="read_input('户名输入')"></el-input>
    <el-input class="input_space" v-model="params.mobileNo" placeholder="手机号" @focus="read_input('手机号输入')"></el-input>
    <el-input @focus="read_input('确认提交')" id="subBtn"></el-input>
  </div>
</template>

<script>
  import SmsInputDialog from "./SmsInputDialog";

  export default {
    name: "EPayPanel",
    components: {SmsInputDialog},
    data: function () {
      return {
        audio: null,
        params: {
          corpNo: 'IICAMP0000000809',
          corpSerno: '',
          outServiceCode: 'openaccount',
          corpCisNo: '1',
          corpMediumId: '',
          bindMedium: '6212880200000000139',
          certType: '0',
          certNo: '110110198801051116',
          custName: '测试五',
          mobileNo: '18944444444',
          notifyAddr: '',
        },
        reading: false
      }
    },
    methods: {

      //提交测试数据
      submit: function () {
        var that = this;
        $.ajax({
          type: "post",
          url: "http://118.31.62.78:8080/ifinance/create/createAccount",
          data: this.$data.params,
          success: function (result) {
            if (result.status === "0") {
              that.$store.commit("read_content", "账户受理成功，您的短信编号是：" + result.data + "，请输入您的短信验证码， 按回车提交")
              that.$refs.sms_input_dialog.toggle();
              that.$refs.sms_input_dialog.$data.params.smsSendNo = "";
              that.$refs.sms_input_dialog.set_corpSerNoOriginal(that.params.corpSerno);
              that.$refs.sms_input_dialog.get_focus();
            } else {
              that.$store.commit("read_content", "账户受理失败");
            }
          }
        })
      },
      read_input: function (content) {
        this.$store.commit("read_content", content)
      }
    },
    mounted: function () {
      var that = this;
      $('#subBtn').bind('keyup', function (event) {
        if (event.keyCode === 13) {
          that.$store.commit("read_content", "您已提交");
          that.submit();
        }
      });
      this.$store.commit("read_content", "您选择了线上账户服务，稍后开始录入信息");
      setTimeout(function () {
        $('#first_input').focus();
      }, 5000)
    }
  }
</script>

<style scoped>
  .input_space {
    margin-bottom: 10px
  }
</style>
