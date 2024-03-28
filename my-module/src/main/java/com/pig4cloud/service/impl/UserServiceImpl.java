package com.pig4cloud.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

	public IPage selectUserList(Page page, User user) {
		return userMapper.selectUserList(page, user);
	}
}
