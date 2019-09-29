package com.yaobinqiang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.CategoryDaoImpl;
import com.yaobinqiang.entity.Category;
import com.yaobinqiang.service.CategoryService;
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	
	@Resource
	private CategoryDaoImpl categoryDao;
	
	@Override
	public List<Category> queryAll(Class<?> cls) {
		
		return categoryDao.queryAll(cls);
	}

}
