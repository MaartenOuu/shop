export default [
    {
        path: "/login",
        name: "Login",
        component: () => import('@/views/login/login.vue'),
        meta: {
            keepAlive: false,
        }
    }
]