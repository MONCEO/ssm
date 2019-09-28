package com.yaobinqiang.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yaobinqiang.entity.Category;
import com.yaobinqiang.entity.Product;
import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.service.CategoryService;
import com.yaobinqiang.service.ProductImageService;
import com.yaobinqiang.service.ProductSevice;
import com.yaobinqiang.until.Constant;

@Controller
public class ProductImageController {

	@Resource
	private ProductImageService productImageService;

	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductSevice productService;

	@RequestMapping("/admin_productImage_list/{pid}")
	public String list(@PathVariable String pid, HttpServletRequest request) {

		Product product = productService.queryById(Product.class, Integer.parseInt(pid));

		List<ProductImage> pisSingle = productImageService.queryTypeBySingle(ProductImage.class, Integer.parseInt(pid));
		request.setAttribute("pisSingle", pisSingle);
		System.out.println("++" + pisSingle);
		List<ProductImage> pisDetail = productImageService.queryTypeByDetail(ProductImage.class, Integer.parseInt(pid));
		request.setAttribute("pisDetail", pisDetail);
		System.out.println("++" + pisDetail);

		request.setAttribute("product", product);

		return "/admin/listProductImage";
	}

	@RequestMapping("/admin_productImage_add")
	public String add(ProductImage pimg, MultipartFile image, HttpServletRequest request)
			throws IllegalStateException, IOException {
		productImageService.add(pimg);
		String path = "";
			if (pimg.getType().equals("type_single")) {
				path = request.getServletContext().getRealPath(Constant.productSingle_path);
			} else if(pimg.getType().equals("type_detail")) {
				path = request.getServletContext().getRealPath(Constant.productDetail_path);
			}
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
					image.transferTo(new File(path, pimg.getId() + ".jpg"));
				}
		}
		System.out.println(path+pimg.getId() + ".jpg");
		System.out.println(path);
		return "forward:/admin_productImage_list/" + pimg.getPid();
	}
	@RequestMapping("/admin_productImage_delete/{id}")
	public String deleteById(@PathVariable String id) {
		
		ProductImage pimg = productImageService.queryById(ProductImage.class,Integer.parseInt(id));
		productImageService.deleteById(ProductImage.class,Integer.parseInt(id));
		return "forward:/admin_productImage_list/"+pimg.getPid();
	}
}
