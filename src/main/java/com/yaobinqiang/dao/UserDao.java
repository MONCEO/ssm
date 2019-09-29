package com.yaobinqiang.dao;

import com.yaobinqiang.entity.User;

public interface UserDao extends BaseDao<User> {

	public User login( Class<?>cls,User user);
}
