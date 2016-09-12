package com.template.dao;

import com.template.model.User;



public interface UserDao extends BaseDao<User> {
		public User login(User user);
}
