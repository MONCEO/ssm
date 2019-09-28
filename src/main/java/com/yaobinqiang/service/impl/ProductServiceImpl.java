package com.yaobinqiang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.ProductDaoImpl;
import com.yaobinqiang.entity.Product;
import com.yaobinqiang.service.ProductSevice;
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductSevice {

	@Resource
	private ProductDaoImpl productDao;
	@Override
	public int getTotals(Class<?> cls, int cid) {
		
		return productDao.getTotals(cls,cid);
	}

}
