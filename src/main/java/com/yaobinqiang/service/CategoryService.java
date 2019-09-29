package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.Category;

public interface CategoryService extends BaseService<Category> {

	public List<Category> queryAll(Class<?> cls);
}
