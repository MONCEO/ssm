package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.CategoryDao;
import com.yaobinqiang.entity.Category;
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@Override
	public List<Category> queryAll(Class<?> cls) {
	
		return getSqlSession().selectList(cls.getSimpleName()+".queryAll");
	}

}
