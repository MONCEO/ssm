package com.yaobinqiang.entity;

import java.util.List;

public class PropertyValue {

	private int id;
	private int pid;
	private int ptid;
	private String value;
	List<Property> listProperty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Property> getListProperty() {
		return listProperty;
	}
	public void setListProperty(List<Property> listProperty) {
		this.listProperty = listProperty;
	}
	@Override
	public String toString() {
		return "PropertyValue [id=" + id + ", pid=" + pid + ", ptid=" + ptid + ", value=" + value + ", listProperty="
				+ listProperty + "]";
	}
	
	
	
}
