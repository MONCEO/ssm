package com.yaobinqiang.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaobinqiang.entity.Property;
import com.yaobinqiang.service.PropertyService;
import com.yaobinqiang.until.Page;

@Controller
public class PropertyController {
	@Resource
	private PropertyService propertyService;
	@RequestMapping("/admin_property_list/{cid}")
	public String admin(@PathVariable String cid) {
		
		return "forward:/admin_property_list/"+cid+"/"+1;
	}
	@RequestMapping("/admin_property_list/{cid}/{currentPage}")
	public String list(@PathVariable String cid,@PathVariable String currentPage) {
		int total= propertyService.getTotals(Property.class);
		Page<Property> page = new Page<>(currentPage,total);
		String url = "admin_property_list";
		page.setUrl(url);
		page.setParam(cid);
		List<Property> list =propertyService.queryByPage(Property.class,page);
		page.setList(list);
		
		
		System.out.println(page);
		return "/admin/listProperty";
	}
}
