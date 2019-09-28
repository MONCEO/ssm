package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.Property;

public interface PropertyService  extends BaseService<Property>{
	public int getTotals(Class<?>cls,int cid);
	public List<Property> queryByCid(Class<?>cls,int cid);
}
