package com.yaobinqiang.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaobinqiang.entity.Category;
import com.yaobinqiang.entity.Property;
import com.yaobinqiang.service.CategoryService;
import com.yaobinqiang.service.PropertyService;
import com.yaobinqiang.until.Page;

@Controller
public class PropertyController {
	@Resource
	private PropertyService propertyService;
	@Resource
	private CategoryService categoryService;

	@RequestMapping("/admin_property_list/{cid}")
	public String admin(@PathVariable String cid) {

		return "forward:/admin_property_list/" + cid + "/" + 1;
	}

	@RequestMapping("/admin_property_list/{cid}/{currentPage}")
	public String list(@PathVariable String cid, @PathVariable String currentPage,HttpServletRequest request) {
		Category category = categoryService.queryById(Category.class, Integer.parseInt(cid));
		System.out.println(category);
		int total= propertyService.getTotals(Property.class,Integer.parseInt(cid));
		Page<Property> page = new Page<>(currentPage,total);
		String url = "admin_property_list/"+cid;
		page.setUrl(url);
		page.setParam(cid);
		List<Property> list =propertyService.queryByPage(Property.class,page);
		page.setList(list);
		System.out.println(page);
		request.setAttribute("page", page);
		request.setAttribute("category",category);
		
		return "/admin/listProperty";
	}
	@RequestMapping("/admin_property_add")
	public String add(Property property) {
		propertyService.add(property);
		return "forward:/admin_property_list/"+property.getCid()+"/1";
	}
	
	@RequestMapping("/admin_property_delete/{id}/{cid}/{currentPage}")
	public String delete(@PathVariable String id,@PathVariable String cid,@PathVariable String currentPage) {
		propertyService.deleteById(Property.class,Integer.parseInt(id));
		return "forward:/admin_property_list/"+cid+"/"+currentPage;
	}
	@RequestMapping("/admin_property_edit/{id}/{currentPage}")
	public String queryById(@PathVariable String id,@PathVariable String currentPage,HttpServletRequest request) {
		Property p = propertyService.queryById(Property.class, Integer.parseInt(id));
		Category category = categoryService.queryById(Category.class, p.getCid());
		request.setAttribute("p", p);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("category",category);
		
		return "/admin/editProperty";
	}
	@RequestMapping("/admin_property_update")
	public String update(Property property,String currentPage) {
		System.out.println(property);
		propertyService.update(property);
		System.out.println(property.getCid());
		return "forward:/admin_property_list/"+property.getCid()+"/"+currentPage;
	}
}

