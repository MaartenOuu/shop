<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#746f6f"
    text-color="#ffffff"
  >
    <el-menu-item index="1">
      <router-link to="/">首页</router-link>
    </el-menu-item>
    <el-menu-item index="2">
      <router-link to="/menu">管理中心</router-link>
    </el-menu-item>
    <el-menu-item index="3" disabled>用户管理</el-menu-item>
    <el-submenu index="4" style="float: right">
      <template slot="title">我的工作台</template>
      <el-menu-item index="2-1">个人信息</el-menu-item>
      <el-menu-item index="2-2">选项2</el-menu-item>
      <el-menu-item index="2-3">注销</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<style>
a {
  color: #746f6f;
}
</style>

<script>
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1"
    };
  },
  methods: {}
};
</script>