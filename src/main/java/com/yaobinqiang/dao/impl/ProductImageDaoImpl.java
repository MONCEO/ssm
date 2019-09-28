package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.ProductImageDao;
import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.until.Page;
@Repository("productImageDao")
public class ProductImageDaoImpl  extends BaseDaoImpl<ProductImage> implements ProductImageDao{


	@Override
	public List<ProductImage> queryTypeBySingle(Class<?> cls, int pid) {
		
		return getSqlSession().selectList(cls.getSimpleName()+". queryTypeBySingle",pid);
	}

	@Override
	public List<ProductImage> queryTypeByDetail(Class<?> cls,int pid) {
		
		return  getSqlSession().selectList(cls.getSimpleName()+".queryTypeByDetail",pid);
	}

	@Override
	public ProductImage queryByPid(Class<?> cls, int pid) {
		
		return getSqlSession().selectOne(cls.getSimpleName()+".queryByPid",pid);
	}

}
