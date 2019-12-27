package com.dao;

import com.beans.Websites;
import com.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebSiteDao implements IDao {
    @Override
    public void Insert(Websites g) {
        //获取连接
        Connection conn = DbUtils.getConnection();
//sql
        String sql = "INSERT into websites(name,url,country)"
                + "values(" + "?,?,?)";
//预编译
        PreparedStatement ptmt = null; //预编译SQL，减少sql执行
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, g.getName());
            ptmt.setString(2, g.getUrl());
            ptmt.setString(3, g.getCountry());

            //执行
            ptmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void Delete(Websites id) {

    }

    @Override
    public void Update(Websites websites) {

    }

    @Override
    public Websites getWebsitesByID(Integer id) throws SQLException {

//获取连接
        Connection conn = DbUtils.getConnection();
//sql, 每行加空格
        String sql = "SELECT * from websites where id=?";
//预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
//传参
        ptmt.setInt(1, id);
//执行
        ResultSet rs = ptmt.executeQuery();
        Websites g = null;
        while (rs.next()) {
            g = new Websites();
            g.setId(rs.getInt("id"));
            g.setName(rs.getString("name"));
            g.setUrl(rs.getString("url"));
        }
        return g;


    }
}
