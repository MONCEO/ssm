package com.yaobinqiang.controller.fore;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaobinqiang.entity.Category;
import com.yaobinqiang.entity.OrderItem;
import com.yaobinqiang.entity.Product;
import com.yaobinqiang.entity.ProductImage;
import com.yaobinqiang.entity.PropertyValue;
import com.yaobinqiang.entity.Review;
import com.yaobinqiang.entity.User;
import com.yaobinqiang.service.CategoryService;
import com.yaobinqiang.service.OrderItemService;
import com.yaobinqiang.service.ProductImageService;
import com.yaobinqiang.service.ProductSevice;
import com.yaobinqiang.service.PropertyValueService;
import com.yaobinqiang.service.ReviewService;
import com.yaobinqiang.service.UserService;

@Controller
public class HomeController {
	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductSevice productSevice;
	@Resource
	private ProductImageService productImageService;
	@Resource
	private ReviewService reviewService;
	@Resource
	private PropertyValueService propertyValueService;
	@Resource
	private OrderItemService orderItemService;
	@Resource
	private UserService userService;
	@RequestMapping("/fore")
	public String home(HttpServletRequest request) {

		int categorycount = categoryService.getTotals(Category.class);
		List<Category> categorys = categoryService.queryAll(Category.class);
		for (Category c : categorys) {
			List<Product> pts = productSevice.queryByCid(Product.class, c.getId());
			System.out.println();
			for (Product p : pts) {
				ProductImage pimg = productImageService.queryByPid(ProductImage.class, p.getId());
				p.setProductImage(pimg.getId());
			}
			c.setProductsByRow(pts);
		}
		request.setAttribute("cs", categorys);
		request.setAttribute("categorycount", categorycount);
		System.out.println(categorys);
		return "/fore/home";
	}

	@RequestMapping("foreproduct")
	public String foreproduct(String pid,Map<String,Object>map) {
	
		Product p  = productSevice.queryById(Product.class,Integer.parseInt(pid));
		//产品缩略图
		List<ProductImage> productSingleImages = productImageService.queryTypeBySingle(ProductImage.class, Integer.parseInt(pid));
		//产品详情图
		List<ProductImage> productDetailImages = productImageService.queryTypeByDetail(ProductImage.class, Integer.parseInt(pid));
		//评论数
		int reviewCount  = reviewService.getTotals(Review.class, Integer.parseInt(pid));
		p.setReviewCount(reviewCount);
		//评论
		List<Review> reviews= reviewService.queryByPid(Review.class, Integer.parseInt(pid));
		//属性名称和属性值
		List<PropertyValue> propertyValues  =propertyValueService.queryByPid(PropertyValue.class,Integer.parseInt(pid));		
		int saleCount=0;
		try {
			saleCount = orderItemService.getCount(OrderItem.class,Integer.parseInt(pid));	
		} catch (Exception e) {
			saleCount=0;
		}
		p.setSaleCount(saleCount);
		map.put("p", p);
		map.put("productSingleImages", productSingleImages);
		map.put("productDetailImages", productDetailImages);
		map.put("reviews",reviews);
		map.put("pvs", propertyValues);
		return "/fore/product";
	}
	@RequestMapping("loginPage")
	public String loginPage() {

		return "/fore/login";
	}
	@RequestMapping("forelogin")
	public String forelogin(User user,HttpSession session,HttpServletRequest request) {
		user = userService.login(User.class,user);
		if(user!=null) {
			session.setAttribute("user", user);
			return "forward:/fore";
		}else {
			String msg = "登陆失败!账号或密码错误";
			request.setAttribute("msg", msg);
			return "forward:/loginPage";
		}
		
	}
	@RequestMapping("forelogout")
	public String forelogout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/fore";
	}
	@RequestMapping("registerPage")
	public String registerPage(){
		
		return "/fore/register";
	}
	@RequestMapping("foreregister")
	public String foreregister(User user) {
		userService.add(user);
		
		return "redirect:/loginPage";
	}
}
