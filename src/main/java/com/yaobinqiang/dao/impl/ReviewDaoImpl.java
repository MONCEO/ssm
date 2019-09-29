package com.yaobinqiang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.ReviewDao;
import com.yaobinqiang.entity.Review;
@Repository("reviewDao")
public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao {

	@Override
	public List<Review> queryByPid(Class<?> cls, int pid) {
		
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPid",pid);
	}

	@Override
	public int getTotals(Class<?> cls, int pid) {
		
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals",pid);
	}

}
