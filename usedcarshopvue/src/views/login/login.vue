<template>
  <div class="background">
    <div class="login_text">
      <h1>登录</h1>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="账号:">
          <el-input v-model="form.account"></el-input>
        </el-form-item>
        <el-form-item label="密码:">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <div class="errormessage" v-if="disable">
          <el-alert :title="errmessage" type="error" @close="cleanError()"></el-alert>
        </div>
        <div>
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="cleanForm()">重置</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { authLogin } from "@/api/api";
import cookie from "js-cookie";
export default {
  data() {
    return {
      form: {
        account: "",
        password: ""
      },
      errmessage: "",
      disable: false
    };
  },
  methods: {
    login() {
      let logindata = this.form;
      authLogin(logindata).then(res => {
        if (res.data.code == 200) {
          let logintoken = res.data.data.token;
          cookie.set("Authorization", logintoken);
          this.$router.push("/menu");
        } else {
          this.errmessage = res.data.data.errmessage;
          this.disable = true;
        }
      });
    },
    cleanError() {
      this.disable = false;
    },
    cleanForm() {
      this.form = this.$options.data().form;
    }
  }
};
</script>

<style>
.login_text {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border: solid 1px lightgray;
  border-radius: 4px;
  padding: 20px ;
  width: 500px;
  height: 300px;
  margin: 200px 0 0 1200px;
  background-color: aliceblue;
}
.background {
  background-image: url("../../assets/images/login.jpg");
  background-size: 100% 100%;
  position: fixed;
  height: 100%;
  width: 100%;
}
.errormessage {
  margin: 20px 0 20px 0;
}
</style>