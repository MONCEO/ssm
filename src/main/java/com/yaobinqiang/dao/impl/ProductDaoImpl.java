package com.yaobinqiang.dao.impl;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.ProductDao;
import com.yaobinqiang.entity.Product;
@Repository("productDaoImpl")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public int getTotals(Class<?> cls,int cid) {
		
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals",cid);
	}

}
