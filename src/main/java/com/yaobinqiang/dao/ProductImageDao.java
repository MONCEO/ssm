package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.until.Page;

public interface ProductImageDao extends BaseDao<ProductImage> {

	public  List<ProductImage> queryTypeBySingle(Class<?> cls,int pid); 
	public  List<ProductImage> queryTypeByDetail(Class<?> cls,int pid); 
	public  ProductImage queryByPid(Class<?> cls,int pid); 

}
