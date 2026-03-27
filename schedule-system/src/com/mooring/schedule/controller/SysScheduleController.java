package com.mooring.schedule.controller;

import com.mooring.schedule.common.Result;
import com.mooring.schedule.pojo.SysSchedule;
import com.mooring.schedule.service.SysScheduleService;
import com.mooring.schedule.service.impl.SysScheduleServiceImpl;
import com.mooring.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
增加日程的请求 /schedule/add
查询日程的请求 /schedule/find
修改日程的请求 /schedule/update
删除日程的请求 /schedule/remove
... ...
*/

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        scheduleService.removeSchedule(sid);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule schedule = WebUtil.readJson(req, SysSchedule.class);
        scheduleService.updateSchedule(schedule);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        //调用服务层方法向数据库中增加一条空记录
        scheduleService.addDefault(uid);

        WebUtil.writeJson(resp,Result.ok(null));
        //获得增加结果

        //响应结果
    }

    private SysScheduleService scheduleService = new SysScheduleServiceImpl();
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        //查询用户的所有日程
        List<SysSchedule> itmeList = scheduleService.findItemListByUid(uid);
        //将用户所有日程放入一个Resule对象
        Map data = new HashMap();
        data.put("itemList", itmeList);
        Result result = Result.ok(data);
        //将Result对象转换为json响应给客户端
        WebUtil.writeJson(resp,result);
    }
}
/*    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
    }
    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
    }*/
