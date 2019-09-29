package com.yaobinqiang.service;

import java.util.List;

import com.yaobinqiang.entity.Review;

public interface ReviewService extends BaseService<Review> {

	public List<Review> queryByPid(Class<?> cls, int pid);
	public int getTotals(Class<?> cls,int pid);
}
