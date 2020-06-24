export default [
    {
        path: "/",
        name: "Home",
        component: () => import('@/views/home/home.vue'),
        meta: {
            keepAlive: false,
        }
    },
    {
        path: '*',
        redirect: '/'
    }
]