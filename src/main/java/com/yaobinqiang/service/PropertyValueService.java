package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.PropertyValue;

public interface PropertyValueService extends BaseService<PropertyValue> {

	public List<PropertyValue> queryByPid(Class<?>cls,int pid);
}
