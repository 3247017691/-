package com.mooring.schedule.dao;

import com.mooring.schedule.pojo.SysSchedule;

import java.util.List;
/*
介绍一下当前类 ... ...
作者:Mooning
时间:2026.3
*/

public interface SysScheduleDao {

    /**
     * 向数据库中增加一个日程记录
     * @param schedule  日常数据以SysSchedule实体类对象形式入参
     * @return  返回影响数据库记录的行数，行数为0说明增加失败，函数大于0说明增加成功
     */
    int addSchedule(SysSchedule schedule);

/*
    查询所有用户的所有日程
    @return 将所有日程放入一个：List<SysSchedule>集合返回
    */
    List<SysSchedule> finALL();

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateScheduel(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
