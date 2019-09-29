package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.Product;

public interface ProductDao extends BaseDao<Product> {

	public int getTotals(Class<?> cls,int cid);
	
	public List<Product> queryByCid(Class<?>cls,int cid);
	
}
