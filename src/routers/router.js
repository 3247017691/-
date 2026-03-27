import {createRouter,createWebHashHistory} from 'vue-router'

import Login from '../components/Login.vue'
import ShowSchedule from '../components/ShowSchedule.vue'
import Regist from '../components/Regist.vue'

import pinia from '../pinia.js'
import {defineUser} from '../store/userStore.js'

let sysUser = defineUser(pinia)

let router = createRouter({
    history:createWebHashHistory(),
    routes:[{
        path:"/",
        component:Login
    },
    {
        path:"/login",
        component:Login
    },
    {
        path:"/showSchedule",
        component:ShowSchedule
    },
    {
        path:"/regist",
        component:Regist
    }]
})

//路由的全局前置守卫 判断是否可以访问showschedule
router.beforeEach((to,from,next)=>{ 
    if(to.path =='/showSchedule'){
        if(sysUser.username == ''){
            alert("您尚未登录,请登录后再查看日程")
            next("/login")
        }else{
            return next()
        }
    }else{ 
        return next()
    }
})

export default router