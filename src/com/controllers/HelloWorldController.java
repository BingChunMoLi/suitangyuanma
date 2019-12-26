package com.controllers;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloWorldController.do")
public class HelloWorldController extends HttpServlet {
    private String message;

    public void init() {
        message = "hello world";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {


        //        表示返回的html文档
        response.setContentType("text/html");
//        PrintWriter不能new
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destory() {
        message = "";
    }

}
