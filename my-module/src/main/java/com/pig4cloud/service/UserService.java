package com.pig4cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.entity.User;

import java.util.List;

public interface UserService {
	public IPage selectUserList(Page page, User user);

	Boolean updateUser(User user);
}
