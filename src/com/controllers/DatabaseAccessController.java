package com.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/DatabaseAccessController")
public class DatabaseAccessController extends HttpServlet {
    //设置jdbc的驱动
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    //    用户名密码
    static final String USER = "root";
    static final String PASS = "123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;

        PrintWriter out = resp.getWriter();
        String title = "测试连接Mysql";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

        try {
//            注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,
                    USER, PASS);
//            使用stmt对象来执行sql语句
            stmt = conn.createStatement();
            String sql = "SELECT * from websites";
//            查询的数据就返回到 rs这个对象中
            ResultSet rs = stmt.executeQuery(sql);


//            调用next方法获取数据
            while (rs.next()) {
//                getInt参数接收列的名字
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
// 输出数据
                out.println("ID: " + id);
                out.println(", name: " + name);
                out.println(",  url: " + url);
                out.println("<br />");

            }

            out.println("</body></html>");

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
