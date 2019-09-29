package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.PropertyValue;

public interface PropertyValueDao extends BaseDao<PropertyValue> {

	public List<PropertyValue> queryByPid(Class<?>cls,int pid);

}
