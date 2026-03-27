package com.mooring.schedule.test;

import com.mooring.schedule.dao.SysScheduleDao;
import com.mooring.schedule.dao.impl.SysScheduleDaoImpl;
import com.mooring.schedule.pojo.SysSchedule;
import com.mooring.schedule.pojo.SysUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class TestSysScheduleDao {
    private static SysScheduleDao scheduleDao;
    @BeforeAll
    public static void initScheduleDao(){
        scheduleDao = new SysScheduleDaoImpl();
    }
    @Test
    public void testAddSchedule(){
        int rows = scheduleDao.addSchedule(new SysSchedule(null, 2, "学习数据库", 1));
        System.out.println(rows);

    }
    @Test
    public void testFinAll(){
        List<SysSchedule> scheduleList = scheduleDao.finALL();
        scheduleList.forEach(System.out::println);
    }
}
