package com.mooring.schedule.dao.impl;

import com.mooring.schedule.dao.BaseDao;
import com.mooring.schedule.dao.SysScheduleDao;
import com.mooring.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into Sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> finALL() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql);
        return scheduleList;
    }
}
