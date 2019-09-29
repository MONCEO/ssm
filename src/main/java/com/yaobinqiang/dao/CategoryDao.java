package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.Category;

public interface CategoryDao  extends BaseDao<Category>{

	 public List<Category> queryAll(Class<?> cls);
}
