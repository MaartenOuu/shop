import Vue from "vue";
import VueRouter from "vue-router";
import menu from "./menu.js";
import home from "./home.js";
import login from "./login.js";

Vue.use(VueRouter);

const routes = [...menu,,...login,...home];
// {
//   path: "/about",
//   name: "About",
//   // route level code-splitting
//   // this generates a separate chunk (about.[hash].js) for this route
//   // which is lazy-loaded when the route is visited.
//   component: () =>
//     import(/* webpackChunkName: "about" */ "../views/About.vue")
// },
// {
//   path: '/login',
//   name: "login",
//   component: () => import(),
// },


const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
