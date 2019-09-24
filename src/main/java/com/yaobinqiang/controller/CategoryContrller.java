package com.yaobinqiang.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yaobinqiang.entity.Category;
import com.yaobinqiang.service.CategoryService;
import com.yaobinqiang.until.Constant;
import com.yaobinqiang.until.Page;

@Controller
public class CategoryContrller {
	@Resource
	private CategoryService categoryService;
	@RequestMapping("/admin")
	public String admin() {
		
		return "redirect:admin_category_list/1";
	}
	@RequestMapping("/admin_category_list/{currentPage}")
	public String category_list(@PathVariable String currentPage,HttpServletRequest request) {
	
		int totals= categoryService.getTotals(Category.class);
		String url="/admin_category_list";
		Page<Category> page  =new Page<Category>(currentPage,totals);
		List<Category> cs = categoryService.queryByPage(Category.class,page.getSp(), page.getPageSize());
		page.setList(cs);
		page.setUrl(url);
		request.setAttribute("page", page);
		System.out.println(page);
		return "/admin/listCategory";
	}
	@RequestMapping("admin_category_edit")
	public String list_category_edit(String id,String currentPage,Map<String, Object>map) {
		Category c=categoryService.queryById(Category.class, Integer.parseInt(id));
		map.put("c", c);
		map.put("currentPage",currentPage);
		return "/admin/editCategory";
	}
	@RequestMapping("/admin_category_update")
	public String  update(Category category,String oldName,String currentPage,MultipartFile[] file,HttpServletRequest request) throws IllegalStateException, IOException {
		if(!category.getName().equals(oldName)) {
			categoryService.update(category);
		}	
			String path = request.getServletContext().getRealPath(Constant.category_path);
			if(file.length>0) {
				for(MultipartFile f:file) {
					if(f!=null) {
						//文件类型
						String contentType = f.getContentType();
						//文件名称
						String fileName = f.getOriginalFilename();
						//文件大小
						long size = f.getSize();
						System.out.println("文件类型："+contentType);
						System.out.println("文件名称："+fileName);
						System.out.println("文件大小："+size);
						if(!"".equals(fileName)) {
							//上传文件
							f.transferTo(new File(path,category.getId()+".jpg"));
						}
					}
				}
			}
		return "/admin_category_list/{currentPage}";
	}
}
