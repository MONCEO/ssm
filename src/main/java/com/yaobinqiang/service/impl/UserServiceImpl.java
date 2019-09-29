package com.yaobinqiang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaobinqiang.dao.impl.UserDaoImpl;
import com.yaobinqiang.entity.User;
import com.yaobinqiang.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource
	private UserDaoImpl userDao;
	@Override
	public User login(Class<?> cls, User user) {
		
		return userDao.login(cls, user);
	}

}
