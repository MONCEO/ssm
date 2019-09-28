package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.OrderItem;

public interface OrderItemService extends BaseService<OrderItem>{
	public List<OrderItem> queryByOid(Class<?>cls,int oid);
}
