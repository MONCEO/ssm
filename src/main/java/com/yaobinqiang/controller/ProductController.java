package com.yaobinqiang.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.fabric.xmlrpc.base.Array;
import com.yaobinqiang.entity.Category;
import com.yaobinqiang.entity.Product;
import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.service.CategoryService;
import com.yaobinqiang.service.ProductImageService;
import com.yaobinqiang.service.ProductSevice;
import com.yaobinqiang.until.Page;

@Controller
public class ProductController {

	@Resource
	private ProductSevice productService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductImageService productImageServicve;

	@RequestMapping("/admin_product_list/{cid}/{currentPage}")
	public String list(@PathVariable String cid, @PathVariable String currentPage, HttpServletRequest request) {
		int total = productService.getTotals(Product.class, Integer.parseInt(cid));
		System.out.println(total);
		String url = "admin_product_list/" + cid;
		Page<Product> page = new Page<>(currentPage, total);
		page.setUrl(url);
		page.setParam(cid);
		List<Product> list = productService.queryByPage(Product.class, page);
		for (Product p : list) {
			ProductImage pimg=productImageServicve.queryByPid(ProductImage.class, p.getId());
			p.setFirstProductImage(pimg);
		}
	
		page.setList(list);
		Product p = list.get(0);
		Category category = p.getCategory();

		System.out.println(page);
		request.setAttribute("page", page);
		request.setAttribute("category", category);
		return "/admin/listProduct";
	}

	@RequestMapping("/admin_product_add")
	public String add(Product t, MultipartFile image, HttpServletRequest request)
			throws IllegalStateException, IOException {

		productService.add(t);
		System.out.println(t.getCid());
		return "forward:/admin_product_list/" + t.getCid() + "/1";
	}

	@RequestMapping("/admin_product_delete/{id}/{currentPage}/{cid}")
	public String delete(@PathVariable String id, @PathVariable String currentPage, @PathVariable String cid) {
		productService.deleteById(Product.class, Integer.parseInt(id));
		return "forward:/admin_product_list/" + cid + "/" + currentPage;
	}

	@RequestMapping("/admin_product_edit/{id}/{currentPage}")
	public String edit(@PathVariable String id, @PathVariable String currentPage,HttpServletRequest request) {
		Product product = productService.queryById(Product.class, Integer.parseInt(id));
		request.setAttribute("p", product);
		request.setAttribute("currentPage", currentPage);
		return "/admin/editProduct";
	}
	@RequestMapping("admin_product_update")
	public String update(Product t,String currentPage) {
		productService.update(t);
		return "forward:/admin_product_list/" + t.getCid() + "/" + currentPage;
	}
	
}
