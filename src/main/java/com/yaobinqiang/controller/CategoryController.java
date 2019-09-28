package com.yaobinqiang.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yaobinqiang.entity.Category;
import com.yaobinqiang.service.CategoryService;
import com.yaobinqiang.until.Constant;
import com.yaobinqiang.until.Page;

@Controller
public class CategoryController {
	@Resource
	private CategoryService categoryService;

	@RequestMapping("/admin")
	public String admin() {
		
		return "redirect:/admin_category_list/1";
	}
	@RequestMapping("/admin_category_list/{currentPage}")
	public String category_list(@PathVariable String currentPage,HttpServletRequest request) {

		int totals = categoryService.getTotals(Category.class);
		String url = "admin_category_list";
		Page<Category> page = new Page<Category>(currentPage, totals);
		List<Category> list = categoryService.queryByPage(Category.class,page);
		page.setList(list);
		page.setUrl(url);
		request.setAttribute("page", page);
		System.out.println(page);
		return "/admin/listCategory";
	}

	@RequestMapping("/admin_category_add")
	public String add(Category category, MultipartFile image, HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (category.getName() != null && !category.getName().equals("")) {
			categoryService.add(category);
			String path = request.getServletContext().getRealPath(Constant.category_path);
			if (image != null) {
				// 文件类型
				String contentType = image.getContentType();
				// 文件名称
				String imageName = image.getOriginalFilename();
				// 文件大小
				long size = image.getSize();
				System.out.println("文件类型：" + contentType);
				System.out.println("文件名称：" + imageName);
				System.out.println("文件大小：" + size);
				if (!"".equals(imageName) && !contentType.equals("jpg")) {
					// 上传文件
					image.transferTo(new File(path, category.getId() + ".jpg"));
				}
			}
		}
		return "forward:/admin_category_list/1";
	}
	@RequestMapping("/admin_category_delete/{id}/{currentPage}")
	public String deleteById( @PathVariable String id, @PathVariable String currentPage) {
	
		categoryService.deleteById(Category.class,Integer.parseInt(id));
		
		return"forward:/admin_category_list/"+ currentPage;
	}
	@RequestMapping("/admin_category_edit/{id}/{currentPage}")
	public String categoryEdit(@PathVariable String id,@PathVariable String currentPage, Map<String, Object> map) {
		Category c = categoryService.queryById(Category.class, Integer.parseInt(id));
		map.put("c", c);
		map.put("currentPage", currentPage);
		return "/admin/editCategory";
	}

	@RequestMapping("/admin_category_update")
	public String update(Category category, String oldName, String currentPage, MultipartFile image,
			HttpServletRequest request) throws IllegalStateException, IOException {
		if (!category.getName().equals(oldName)) {
			categoryService.update(category);
		}
		String path = request.getServletContext().getRealPath(Constant.category_path);
		if (image != null) {
			// 文件类型
			String contentType = image.getContentType();
			// 文件名称
			String imageName = image.getOriginalFilename();
			// 文件大小
			long size = image.getSize();
			System.out.println("文件类型：" + contentType);
			System.out.println("文件名称：" + imageName);
			System.out.println("文件大小：" + size);
			if (!"".equals(imageName) && !contentType.equals("jpg")) {
				// 上传文件
				image.transferTo(new File(path, category.getId() + ".jpg"));
			}
		}
		return "forward:/admin_category_list/" + currentPage;
	}
}
