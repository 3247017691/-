package com.mooring.schedule.controller;

import com.mooring.schedule.common.Result;
import com.mooring.schedule.common.ResultCodeEnum;
import com.mooring.schedule.pojo.SysUser;
import com.mooring.schedule.service.SysUserService;
import com.mooring.schedule.service.impl.SysUserServiceImpl;
import com.mooring.schedule.util.MD5Util;
import com.mooring.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class UserController extends BaseController{
    private SysUserService userService =new SysUserServiceImpl();


    /**
     * 注册时校验用户名是否被占用的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser inputUser = WebUtil.readJson(req, SysUser.class);
        String username = inputUser.getUsername();

        SysUser registUser = userService.findByUsername(username);

        //封装结果对象
        Result result=null;
        if(null ==registUser){
            // 未占用,创建一个code为200的对象
            result= Result.ok(null);
        }else{
            // 占用, 创建一个结果为505的对象
            result= Result.build(null, ResultCodeEnum.USERNAME_USED);

        }
        // 将result对象转换成JSON并响应给客户端
        WebUtil.writeJson(resp,result);

    }

    /**
     * 用户注册的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收要注册的用户信息
        SysUser registUser = WebUtil.readJson(req, SysUser.class);
        // 调用服务层方法,将用户注册进入数据库
        int rows =userService.regist(registUser);
        Result result =null;
        if(rows>0){
            result=Result.ok(null);
        }else{
            result =Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 用户登录的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收用户请求参数
        // 获取要登录的用户名密码
        SysUser inputUser = WebUtil.readJson(req, SysUser.class);
        // 调用服务层方法,根据用户名查询数据库中是否有一个用户
        SysUser loginUser =userService.findByUsername(inputUser.getUsername());

        Result result = null;

        if(null == loginUser){
            // 没有根据用户名找到用户,说明用户名有误
            result=Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }else if(! loginUser.getUserPwd().equals(MD5Util.encrypt(inputUser.getUserPwd()))){
            // 用户密码有误,
            result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }else{
            Map data = new HashMap();
            loginUser.setUserPwd("");
            data.put("loginUser",loginUser);
            // 登录成功
            result=Result.ok(data);
        }

        WebUtil.writeJson(resp,result);

    }
}