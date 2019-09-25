package com.yaobinqiang.service;

import com.yaobinqiang.entity.Property;

public interface PropertyService  extends BaseService<Property>{
	public int getTotals(Class<?>cls,int cid);
}
