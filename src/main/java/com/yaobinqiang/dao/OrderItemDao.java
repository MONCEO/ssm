package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.OrderItem;

public interface OrderItemDao extends BaseDao<OrderItem>{

	public List<OrderItem> queryByOid(Class<?>cls,int oid);
	/**
	 * 通过商品id查询商品销量
	 * @param cls
	 * @param pid
	 * @return
	 */
	public int getCount(Class<?>cls,int pid);
}
