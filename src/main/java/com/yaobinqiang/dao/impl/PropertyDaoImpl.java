package com.yaobinqiang.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.PropertyDao;
import com.yaobinqiang.entity.Property;
@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao {
}
