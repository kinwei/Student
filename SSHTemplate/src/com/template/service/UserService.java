package com.template.service;

import com.template.model.User;



public interface UserService extends BaseService<User> {
		public User login(User user);
}
