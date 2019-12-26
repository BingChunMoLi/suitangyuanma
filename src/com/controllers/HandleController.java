package com.controllers;

import com.utils.Computer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//处理前端提交的数据
@WebServlet("/HandleController")
public class HandleController
        extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取参数
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String calc = req.getParameter("calc");

        double n1 = 0;
        double n2 = 0;
        n1 = Double.parseDouble(num1);
        n2 = Double.parseDouble(num2);
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        Computer computer = new Computer(n1, n2, calc);
        double result = computer.getResult();
        HttpSession session = req.getSession();
//        session是键值对形式
//        result：是key
        session.setAttribute("result", result);

        resp.sendRedirect("/pages/showResult.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
