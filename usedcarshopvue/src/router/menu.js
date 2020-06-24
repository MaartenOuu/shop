export default [
    {
        path: "/menu",
        name: "Menu",
        component: () => import('@/views/sys/menu.vue'),
        meta: {
            keepAlive: true,
        },
        children: [
            {
                path: "/menu/brand",
                name: "brand",
                component: () => import('@/views/car/brand.vue'),
                meta: {
                    keepAlive: true,
                },
            },
            {
                path: "/menu/type",
                name: "type",
                component: () => import('@/views/car/type.vue'),
                meta: {
                    keepAlive: true,
                },
            },
            {
                path: "/menu/article",
                name: "article",
                component: () => import('@/views/car/article.vue'),
                meta: {
                    keepAlive: true,
                },
            }
        ]
    }
]