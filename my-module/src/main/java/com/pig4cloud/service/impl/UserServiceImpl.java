package com.pig4cloud.service.impl;

import com.pig4cloud.entity.User;
import com.pig4cloud.mapper.UserMapper;
import com.pig4cloud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	public List<User> selectUserList(User user) {
		return userMapper.selectUserList(user);
	}
}
