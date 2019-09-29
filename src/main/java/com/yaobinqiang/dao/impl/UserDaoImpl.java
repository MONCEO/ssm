package com.yaobinqiang.dao.impl;

import org.springframework.stereotype.Repository;

import com.yaobinqiang.dao.UserDao;
import com.yaobinqiang.entity.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User login(Class<?> cls, User user) {
		
		return getSqlSession().selectOne(cls.getSimpleName()+".login",user);
	}

}
