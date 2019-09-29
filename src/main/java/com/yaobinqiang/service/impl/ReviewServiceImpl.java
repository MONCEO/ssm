package com.yaobinqiang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.ReviewDao;
import com.yaobinqiang.dao.impl.ReviewDaoImpl;
import com.yaobinqiang.entity.Review;
import com.yaobinqiang.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService {
	@Resource
	private ReviewDaoImpl reviewDao;

	@Override
	public List<Review> queryByPid(Class<?> cls, int pid) {

		return reviewDao.queryByPid(cls, pid);
	}

	@Override
	public int getTotals(Class<?> cls, int pid) {
		
		return reviewDao.getTotals(cls,pid);
	}

}
