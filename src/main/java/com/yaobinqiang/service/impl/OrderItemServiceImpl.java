package com.yaobinqiang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.OrderItemDaoImpl;
import com.yaobinqiang.entity.OrderItem;
import com.yaobinqiang.service.OrderItemService;
@Service("orderItemService")
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {
	@Resource
	private OrderItemDaoImpl orderItemDao;
	@Override
	public List<OrderItem> queryByOid(Class<?> cls, int oid) {
	
		return orderItemDao.queryByOid(cls,oid);
	}
	@Override
	public int getCount(Class<?> cls, int pid) {
		
		return orderItemDao.getCount(cls, pid);
	}

}
