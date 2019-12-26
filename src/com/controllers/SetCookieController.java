package com.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/SetCookieController")
public class SetCookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String contetType = req.getContentType();
//       Map是一个字典，属于键值对结构的数据
//       String：就是键的类型
//       Object：就是值的类型
        Map<String, Object> params = new HashMap<>();
        params.put("name", "宋江");
        Cookie name = new Cookie("name",
                URLEncoder.encode(params.get("name").toString(), "utf-8"));
//        过期1天
        name.setMaxAge(60 * 60 * 24);
        resp.addCookie(name);
        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String title = "设置 Cookie 实例";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>姓名：</b>："
                + req.getParameter("name") + "\n</li>" +
                "  <li><b>年龄：</b>："
                + req.getParameter("age") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");

    }
}
