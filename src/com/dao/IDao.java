package com.dao;

import com.beans.Websites;

import java.sql.SQLException;

public interface IDao {
    void Insert(Websites websites);

    void Delete(Websites id);

    void Update(Websites websites);

    Websites getWebsitesByID(Integer id) throws SQLException;
}
