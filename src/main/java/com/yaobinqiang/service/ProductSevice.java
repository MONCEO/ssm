package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.Product;

public interface ProductSevice extends BaseService<Product>{

	public int getTotals(Class<?> cls,int cid);
	public List<Product> queryByCid(Class<?> cls,int cid);
}
