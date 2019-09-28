package com.yaobinqiang.controller.fore;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaobinqiang.entity.Product;
import com.yaobinqiang.entity.Property;
import com.yaobinqiang.entity.PropertyValue;
import com.yaobinqiang.service.ProductSevice;
import com.yaobinqiang.service.PropertyService;
import com.yaobinqiang.service.PropertyValueService;

@Controller
public class ProductValueController {

	@Resource
	private PropertyValueService propertyValueService;
	@Resource
	private ProductSevice productService;

	@RequestMapping("/admin_propertyValue_edit/{pid}")
	public String list(@PathVariable String pid, Map<String, Object> map) {
		Product product = productService.queryById(Product.class, Integer.parseInt(pid));
		List<PropertyValue> pv = propertyValueService.queryByPid(PropertyValue.class,Integer.parseInt(pid));
		System.out.println(pv);
		map.put("product", product);
		map.put("pvs", pv);

		
		return "/admin/editPropertyValue";
	}
	@RequestMapping("/admin_propertyValue_update")
	public String update(String id,String value) {
		PropertyValue p =new PropertyValue();
		p = propertyValueService.queryById(PropertyValue.class,Integer.parseInt(id));
		p.setId(Integer.parseInt(id));
		p.setPid(p.getPid());
		p.setValue(value);
		propertyValueService.update(p);
		return "forward:/admin_propertyValue_edit/"+p.getPid();
	}
}
