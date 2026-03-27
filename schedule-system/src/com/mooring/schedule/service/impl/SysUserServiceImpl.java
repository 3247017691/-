package com.mooring.schedule.service.impl;

import com.mooring.schedule.dao.SysUserDao;
import com.mooring.schedule.dao.impl.SysUserDaoImpl;
import com.mooring.schedule.pojo.SysUser;
import com.mooring.schedule.service.SysUserService;
import com.mooring.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {
        //  将用户的明文密码传化成密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        //  调用DAO层的方法,将SysUser信息存入数据库
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
