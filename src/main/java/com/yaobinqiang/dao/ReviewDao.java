package com.yaobinqiang.dao;

import java.util.List;

import com.yaobinqiang.entity.Review;

public interface ReviewDao extends BaseDao<Review> {

	public List<Review> queryByPid(Class<?> cls, int pid);
	public int getTotals(Class<?> cls,int pid); 
	
}
