package com.yaobinqiang.controller.fore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.ls.LSInput;

import com.yaobinqiang.entity.Order;
import com.yaobinqiang.entity.OrderItem;
import com.yaobinqiang.service.OrderItemService;
import com.yaobinqiang.service.OrderService;
import com.yaobinqiang.until.Page;

@Controller
public class OrderController {

	@Resource
	private OrderService orderService;
	@Resource
	private OrderItemService orderItemService;

	@RequestMapping("/admin_order_list/{currentPage}")
	public String list(@PathVariable String currentPage, HttpServletRequest request) {
		int total = orderService.getTotals(Order.class);
		Page page = new Page<Order>(currentPage, total);
		List<Order> os = orderService.queryByPage(Order.class, page);
		String url = "admin_order_list";
		page.setUrl(url);
		System.out.println(os);
		int totals = 0;
		int totalNumbers = 0;
		for (Order o : os) {
			List<OrderItem> oi = orderItemService.queryByOid(OrderItem.class, o.getId());
			for (OrderItem i : oi) {
				totals += i.getTotal();
				totalNumbers += i.getNumber();
			}
			o.setOrderItems(oi);
			o.setTotal(totals);
			o.setTotalNumber(totalNumbers);
		}
		for (Order order : os) {
			System.out.println(order);
		}
		request.setAttribute("os", os);
		request.setAttribute("page", page);
		return "/admin/listOrder";
	}
}
