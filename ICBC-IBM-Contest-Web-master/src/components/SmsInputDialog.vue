<template>
  <div id="sms_input_dialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span></button>
        </div>
        <div class="modal-body">
          <div class="row center-block">
            <el-input id="sms_input" v-model="params.smsInput" placeholder="短信验证码" disabled></el-input>
            <el-input id="corp_ser_no" v-model="params.corpSerNoOriginal" placeholder="原始交易单号" disabled></el-input>
            <el-input id="sms_send_no" v-model="params.smsSendNo" placeholder="短信编号" autofocus></el-input>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: "SmsInputDialog",
    data: function () {
      return {
        message: '',
        params: {
          smsSendNo: '',
          corpSerNoOriginal: ''
        }
      }
    },
    props: {
      parent_smsSendNo: String
    },
    methods: {
      set_corpSerNoOriginal: function (corpSerNoOriginal) {
        this.params.corpSerNoOriginal = corpSerNoOriginal;
        setTimeout(this.get_focus, 3000);
      },
      toggle: function () {
        $('#sms_input_dialog').modal('toggle');
      },
      submit: function () {
        var that = this;
        $.ajax({
          type: "post",
          url: "http://118.31.62.78:8080/ifinance/verify/smsVerify",
          data: this.$data.params,
          success: function (result) {
            if (result.status === "0") {
              that.$store.commit("read_content", "账户开户成功，您的工行联名卡号为：" + result.data);
              that.toggle()
              that.$router.push("/result/" + result.data);
            } else {
              that.$store.commit("read_content", "账户开户失败");
            }
          }
        })
      },

      //获取焦点
      get_focus: function () {
        $('#sms_send_no').focus();
      }
    },

    //初始化，监听回车来进行提交
    mounted: function () {
      var that = this;
      $('#sms_send_no').bind('keyup', function (event) {
        if (event.keyCode === 13) {
          that.$store.commit("read_content", "您已提交");
          that.submit();
        }
      })
    },

  }
</script>

<style scoped>

</style>
