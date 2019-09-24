package com.yaobinqiang.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	public  void add(T t);
	public void update(T t);
	public void deleteById(Class<?> cls,Serializable id);
	public T queryById(Class<?> cls,Serializable id);
	public List<T> queryByPage(Class<?> cls,Map<String, Integer>map);
	public int getTotals(Class<?> cls);
}
