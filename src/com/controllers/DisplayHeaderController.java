package com.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/DisplayHeaderController")
public class DisplayHeaderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration headersNames = req.getHeaderNames();
//        循环枚举header中的所有值
        PrintWriter out = resp.getWriter();
        out.print("<html><body><table>");
        while (headersNames.hasMoreElements()) {
            String paramName = (String) headersNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>");
            String paramValue = req.getHeader(paramName);
            out.print("<td> " + paramValue + "</td></tr>");
        }
        out.println("</table></body></html>");
    }
}
