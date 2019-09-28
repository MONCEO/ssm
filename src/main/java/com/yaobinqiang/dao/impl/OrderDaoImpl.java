package com.yaobinqiang.dao.impl;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.OrderDao;
import com.yaobinqiang.entity.Order;
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

}
