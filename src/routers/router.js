import {createRouter,createWebHashHistory} from 'vue-router'

import Login from '../components/Login.vue'
import ShowSchedule from '../components/ShowSchedule.vue'
import Regist from '../components/Regist.vue'

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

export default router