package com.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SessionTrackController")
public class SessionTrackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      获取session对象
        HttpSession session = req.getSession();
//        获取会话创建时间
        Date createTime = new Date(session.getCreationTime());
//   获取该页面最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        页面访问次数
        Integer visitCount = new Integer(0);
        String userId = "ID00001";
        String userName = "Ivy";

//        等于空表示当前账户没有登录过
        if (session.getAttribute(userId) == null) {
            session.setAttribute(userId, userName);
        }

//        首次访问该页面
        if (session.getAttribute("visitCount") == null) {
            session.setAttribute("visitCount", visitCount);
        }

//        检查是否是新的会话
        if (session.isNew()) {
            session.setAttribute(userId, userName);
        } else {
//            获取访问次数
            visitCount = (Integer) session.getAttribute("visitCount");
            visitCount = visitCount + 1;
            userId = (String) session.getAttribute(userId);
        }
//        更新访问次数
        session.setAttribute("visitCount", visitCount);
        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "测试session";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session 信息</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "  <th>Session 信息</th><th>值</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>创建时间</td>\n" +
                "  <td>" + df.format(createTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>最后访问时间</td>\n" +
                "  <td>" + df.format(lastAccessTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>用户 ID</td>\n" +
                "  <td>" + userId +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>访问统计：</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>");


    }
}
