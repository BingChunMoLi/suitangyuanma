package com.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;

public class AjaxHelper {
    public static void SendAjaxResult(Object obj, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String resJson = JSON.toJSONString(obj);
        out.print(resJson);
    }
}
