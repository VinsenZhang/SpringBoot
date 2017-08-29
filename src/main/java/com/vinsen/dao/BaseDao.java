package com.vinsen.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface BaseDao<T> {

    public T get(Serializable id);

    public List<T> getList(Map condition);

    public void insert(T entity);

    public void update(T entity);

    public void delete(Serializable id);

    public void delete(Serializable[] ids);

}
