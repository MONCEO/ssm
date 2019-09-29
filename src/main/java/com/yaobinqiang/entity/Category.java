package com.yaobinqiang.entity;

import java.util.List;

public class Category {

	private int id;
	private String name;
	private int count;
	private List<Product> productsByRow;

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

	public List<Product> getProductsByRow() {
		return productsByRow;
	}

	public void setProductsByRow(List<Product> productsByRow) {
		this.productsByRow = productsByRow;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", count=" + count + ", productsByRow=" + productsByRow + "]";
	}

}
