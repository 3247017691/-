package com.mooring.schedule.dao;
/*
Data access Object  数据访问对象
该类用于定义针对表格的CRUD的方法
DAO层一般要定义接口和实现类


*/

import com.mooring.schedule.pojo.SysUser;

public interface SysUserDao {

    /**
     * 向数据库中增加一个用户记录的方法
     * @param sysUser   要增加的记录的username和user_pwd字段以SysUser实体类对象接收
     * @return  增加成功返回1，增加失败返回0
     */

    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整信息的方法
     * @param username  要查询的用户名
     * @return  返回SysUser对象，找不到返回NULL
     */
    SysUser findByUsername(String username);
}
