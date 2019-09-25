package com.yaobinqiang.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaobinqiang.entity.User;
import com.yaobinqiang.service.UserService;
import com.yaobinqiang.until.Page;
@Controller
public class UserContrller {
	@Resource
	private UserService userService;
	@RequestMapping("/admin_user_list/{currentPage}")
	public String list(@PathVariable String currentPage,HttpServletRequest request) {
		int total=userService.getTotals(User.class);
		String url = "admin_user_list";
		Page<User> page = new Page<>(currentPage,total);
		List<User> list = userService.queryByPage(User.class,page);
		page.setList(list);
		page.setUrl(url);
		request.setAttribute("page", page);
		return "/admin/listUser";
	}
}
