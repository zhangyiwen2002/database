import VueRouter from "vue-router"
import Vue from "vue"


Vue.use(VueRouter)
const routes=[
    {
        path:'/',
        component:()=>import('../components/home/index.vue'),
    },
    {
        path:'/space',
        component:()=>import('../components/space/index.vue'),
        children:[
            {
                path:"",
                redirect: "all"
            },
            {
                path:'all',
                component:()=>import('../components/space/allArticles.vue')
            },
            {
                path:'search',
                component:()=>import('../components/space/searchArticles.vue')
            }
        ]
    },
    {
        path:'/personal',
        component:()=>import('../components/personal/index.vue'),
    },
    {
        path:'/articledetails/:id',
        component:()=>import('../components/space/articleDetails.vue'),
    },
    {
        path:'/login',
        component:()=>import('../components/personal/login.vue')
    },
    {
        path:'/register',
        component:()=>import('../components/personal/register.vue')
    },
    {
        path:'/message',
        component:()=>import('../components/personal/userMessage.vue')
    },
    {
        path:'/published',
        component:()=>import('../components/personal/published.vue'),
        children:[
            {
                path:"",
                redirect:"all"
            },
            {
                path:'all',
                component:()=>import('../components/personal/userAllArticles.vue')
            },
            {
                path:'private',
                component:()=>import('../components/personal/userPrivateArticles.vue')
            }
        ]
    },
    {
        path:'/publish',
        component:()=>import('../components/space/publish.vue')
    }
]
const router=new VueRouter({
    routes,
    mode:'hash',
})
// router.beforeEach((to, from, next) => {
    
//     document.title=to.matched[0].meta.title;
//     next();
// })
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router