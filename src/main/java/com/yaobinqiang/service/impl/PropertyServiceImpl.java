package com.yaobinqiang.service.impl;

import java.util.List;

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
		
		return propertyDao.getTotals(cls,cid);
	}
	@Override
	public List<Property> queryByCid(Class<?> cls, int cid) {
		
		return propertyDao.queryByCid(cls, cid);
	}


	
}
