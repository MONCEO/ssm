package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.Property;

public interface PropertyDao extends BaseDao<Property> {

	public int getTotals(Class<?>cls,int cid);
	public List<Property> queryByCid(Class<?>cls,int cid); 
}
