package com.mooring.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
/*
增加日程的请求 /schedule/add
查询日程的请求 /schedule/find
修改日程的请求 /schedule/update
删除日程的请求 /schedule/remove
... ...
*/

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    protected void schedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 可以重定向到日程列表页面
        resp.sendRedirect("/showSchedule.html");
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
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
