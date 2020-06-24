<template>
  <el-container>
    <el-aside width="15%">
      <el-row class="tac">
        <el-col :span="24">
          <h5>菜单</h5>
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>汽车管理</span>
              </template>
              <el-menu-item-group>
                <template slot="title">车型</template>
                <router-link to="/menu/type">
                  <el-menu-item index="1-1">轿车</el-menu-item>
                </router-link>
                <router-link to="/menu/type">
                  <el-menu-item index="1-2">suv</el-menu-item>
                </router-link>
              </el-menu-item-group>
              <el-menu-item-group title="品牌">
                <router-link to="/menu/brand">
                  <el-menu-item index="1-3">品牌</el-menu-item>
                </router-link>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>信息管理</span>
              </template>
              <el-menu-item-group>
                <template slot="title">信息</template>
                <router-link to="/menu/article">
                  <el-menu-item index="2-1">发布管理</el-menu-item>
                </router-link>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-col>
      </el-row>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>