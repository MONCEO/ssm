package com.yaobinqiang.entity;

import java.sql.Date;
import java.util.List;

public class Product {

	private int id;
	private String name;
	private String subTitle;
	private float orignalPrice;
	private float promotePrice;
	private int stock;
	private int cid;
	private Date createDate;
	private Category category;
	private int productImage;
	private ProductImage firstProductImage;
	private List<ProductImage> productsImage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public float getOrignalPrice() {
		return orignalPrice;
	}
	public void setOrignalPrice(float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}
	public float getPromotePrice() {
		return promotePrice;
	}
	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ProductImage getFirstProductImage() {
		return firstProductImage;
	}
	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}
	
	public int getProductImage() {
		return productImage;
	}
	public void setProductImage(int productImage) {
		this.productImage = productImage;
	}
	
	public List<ProductImage> getProductsImage() {
		return productsImage;
	}
	public void setProductsImage(List<ProductImage> productsImage) {
		this.productsImage = productsImage;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", subTitle=" + subTitle + ", orignalPrice=" + orignalPrice
				+ ", promotePrice=" + promotePrice + ", stock=" + stock + ", cid=" + cid + ", createDate=" + createDate
				+ ", category=" + category + ", productImage=" + productImage + ", firstProductImage="
				+ firstProductImage + ", productsImage=" + productsImage + "]";
	}

	
}
