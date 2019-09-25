package com.yaobinqiang.dao.impl;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.PropertyDao;
import com.yaobinqiang.entity.Property;
@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao {

	@Override
	public int getTotals(Class<?> cls, int cid) {

		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals", cid);
	}
}
