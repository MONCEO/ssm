package com.yaobinqiang.dao;

import com.yaobinqiang.entity.Property;

public interface PropertyDao extends BaseDao<Property> {

	public int getTotals(Class<?>cls,int cid);
}
