package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.until.Page;

public interface ProductImageService extends BaseService<ProductImage>{

	public  List<ProductImage> queryTypeBySingle(Class<?> cls,int pid); 
	public  List<ProductImage> queryTypeByDetail(Class<?> cls,int pid); 
	public  ProductImage queryByPid(Class<?> cls,int pid); 
	
}
