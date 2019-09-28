package com.yaobinqiang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.PropertyValueDaoImpl;
import com.yaobinqiang.entity.PropertyValue;
import com.yaobinqiang.service.PropertyValueService;
@Service("propertyValueService")
public class PropertyValueServiceImpl extends BaseServiceImpl<PropertyValue> implements PropertyValueService{
	@Resource
	private PropertyValueDaoImpl  propertyValueDao;
	@Override
	public List<PropertyValue> queryByPid(Class<?> cls, int pid) {
		
		return  propertyValueDao.queryByPid(cls, pid);
	}

}
