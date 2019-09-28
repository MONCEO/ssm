package com.yaobinqiang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.ProductImageDaoImpl;
import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.service.ProductImageService;

@Service("productimageService")
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImage> implements ProductImageService{
	@Resource
	private ProductImageDaoImpl productImageDao;

	@Override
	public List<ProductImage> queryTypeBySingle(Class<?> cls, int pid) {

		return productImageDao.queryTypeBySingle(cls, pid);
	}

	@Override
	public List<ProductImage> queryTypeByDetail(Class<?> cls, int pid) {

		return productImageDao.queryTypeByDetail(cls, pid);
	}

	@Override
	public ProductImage queryByPid(Class<?> cls, int pid) {
		
		return productImageDao.queryByPid(cls, pid);
	}

}