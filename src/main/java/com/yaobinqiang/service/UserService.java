package com.yaobinqiang.service;

import org.springframework.stereotype.Service;

import com.yaobinqiang.entity.User;

public interface UserService extends BaseService<User> {
	
	public User login( Class<?>cls,User user);

}
