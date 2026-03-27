/* 
存储日程信息的pinia
*/
import { defineStore } from "pinia";

export const defindSchedule = defineStore(
    "scheduleList",
    {
        state:()=>{
            return {
                itemList:[
                ]
            }
        },
        getters:{

        },
        actions:{

        }
    }
)