<template>
  <el-row>
    <el-col :span="3" class="col-color">
      <el-menu
        class="el-menu-vertical-demo menu-css"
        background-color="#06355c"
        text-color="#ffffff"
        active-text-color="#0aafa1"
      >
        <h5>菜单</h5>
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>汽车管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/menu/type">
              <el-menu-item index="1-1">轿车管理</el-menu-item>
            </router-link>
            <router-link to="/menu/type">
              <el-menu-item index="1-2">suv管理</el-menu-item>
            </router-link>
            <router-link to="/menu/brand">
              <el-menu-item index="1-3">品牌管理</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>信息管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/menu/article">
              <el-menu-item index="2-1">发布管理</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-col>
    <el-col :span="21">
      <router-view></router-view>
    </el-col>
  </el-row>
</template>

<style >
a {
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}
.el-col {
  height: 870px;
}
.col-color {
  background-color: #06355c;
}
.menu-css{
  border-right: 0;
  text-align: center;
}
.el-submenu__title {
  padding-right: 40px;
}
.el-menu-item-group__title {
  padding-right: 40px;
}
.el-submenu .el-menu-item {
  padding-right: 40px;
}
h5 {
  color: #ffffff;
}
</style>