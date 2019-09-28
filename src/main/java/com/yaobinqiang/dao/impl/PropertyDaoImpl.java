package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.PropertyDao;
import com.yaobinqiang.entity.Property;
@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao {

	@Override
	public int getTotals(Class<?> cls, int cid) {

		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals", cid);
	}

	@Override
	public List<Property> queryByCid(Class<?> cls, int cid) {
		
		return getSqlSession().selectList(cls.getSimpleName()+".queryByCid",cid);
	}
}
