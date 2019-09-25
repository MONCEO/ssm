package com.yaobinqiang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.PropertyDaoImpl;
import com.yaobinqiang.entity.Property;
import com.yaobinqiang.service.PropertyService;
@Service("propertyService")
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService {
	@Resource
	private PropertyDaoImpl propertyDao ;
	@Override
	public int getTotals(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return propertyDao.getTotals(cls,cid);
	}


	
}
