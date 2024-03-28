package com.pig4cloud.service;

import com.pig4cloud.entity.User;

import java.util.List;

public interface UserService {
	public List<User> selectUserList(User user);
}
