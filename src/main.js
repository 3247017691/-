import { createApp } from 'vue'
import App from './App.vue'
import router from './routers/router.js'
import pinia from './pinia.js'


let app = createApp(App)
app.use(pinia)
app.use(router)
app.mount('#app')
