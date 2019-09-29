package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.ProductDao;
import com.yaobinqiang.entity.Product;
@Repository("productDaoImpl")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public int getTotals(Class<?> cls,int cid) {
		
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals",cid);
	}

	@Override
	public List<Product> queryByCid(Class<?> cls, int cid) {
		
		return getSqlSession().selectList(cls.getSimpleName()+".queryByCid",cid);
	}

}
