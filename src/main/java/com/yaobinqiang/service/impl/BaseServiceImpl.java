package com.yaobinqiang.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.BaseDaoImpl;
import com.yaobinqiang.service.BaseService;
import com.yaobinqiang.until.Page;
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{

	@Resource
	private BaseDaoImpl<T> baseDao;
	@Override
	public void add(T t) {

		baseDao.add(t);
	}

	@Override
	public void update(T t) {

		baseDao.update(t);
	}

	@Override
	public void deleteById(Class<?> cls, Serializable id) {

		baseDao.deleteById(cls, id);
		
	}

	@Override
	public T queryById(Class<?> cls, Serializable id) {

		return baseDao.queryById(cls, id);
	}

	@Override
	public List<T> queryByPage(Class<?> cls, Page<T>page) {
		
		
		return baseDao.queryByPage(cls, page);
	}

	@Override
	public int getTotals(Class<?> cls) {
		return baseDao.getTotals(cls);
	}

}
