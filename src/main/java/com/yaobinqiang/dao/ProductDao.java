package com.yaobinqiang.dao;

import com.yaobinqiang.entity.Product;

public interface ProductDao extends BaseDao<Product> {

	public int getTotals(Class<?> cls,int cid);
	
}
