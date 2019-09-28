package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.PropertyValueDao;
import com.yaobinqiang.entity.PropertyValue;
@Repository("propertyValueDao")
public class PropertyValueDaoImpl extends BaseDaoImpl<PropertyValue> implements PropertyValueDao{

	@Override
	public List<PropertyValue> queryByPid(Class<?> cls, int pid) {
		
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPid",pid);
	}

}
