package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.OrderItem;

public interface OrderItemDao extends BaseDao<OrderItem>{

	public List<OrderItem> queryByOid(Class<?>cls,int oid);
}
