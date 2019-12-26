package com.dao;

import com.beans.Websites;

public interface IDao<T> {
    void Insert(T websites);

    void Delete(T id);

    void Update(T websites);

    T getWebsitesByID(Integer id);
}
