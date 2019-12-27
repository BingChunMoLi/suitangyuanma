package com.controllers;

import com.alibaba.fastjson.JSON;
import com.beans.AjaxResult;
import com.beans.Websites;
import com.dao.IDao;
import com.dao.WebSiteDao;
import com.utils.AjaxHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/DataProviderController")
public class DataProviderController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        IDao webSiteDao = new WebSiteDao();
        Websites webSite = null;
        try {
            webSite = webSiteDao.getWebsitesByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AjaxHelper.SendAjaxResult(webSite, resp);
    }
}
