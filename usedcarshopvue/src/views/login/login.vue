<template>
  <div class="login_text">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="账号:">
        <el-input v-model="form.usernanme"></el-input>
      </el-form-item>
      <el-form-item label="密码:">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <div>
        <el-button type="primary" @click="onSubmit">登录</el-button>
        <el-button type="info">重置</el-button>
      </div>
    </el-form>
  </div>
</template>

<script>
import {getRequest} from '@/utils/service'
export default {
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    onSubmit() {
      getRequest("/user/select").then(res =>{
          console.log(res.data)
      });
    }
  }
};
</script>

<style>
.login_text {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border: solid 1px lightgray;
  border-radius: 4px;
  padding: 20px;
  width: 300px;
  margin: 300px auto;
}

</style>