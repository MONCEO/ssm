package com.yaobinqiang.service;

import com.yaobinqiang.entity.Product;

public interface ProductSevice extends BaseService<Product>{

	public int getTotals(Class<?> cls,int cid);
}
