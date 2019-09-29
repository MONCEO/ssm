package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.OrderItemDao;
import com.yaobinqiang.entity.OrderItem;
@Repository("orderItemDao")
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> queryByOid(Class<?> cls, int oid) {
		
		return getSqlSession().selectList(cls.getSimpleName()+".queryByOid",oid);
	}

	@Override
	public int getCount(Class<?> cls, int pid) {
	
		return getSqlSession().selectOne(cls.getSimpleName()+".getCount",pid);
	}

}
