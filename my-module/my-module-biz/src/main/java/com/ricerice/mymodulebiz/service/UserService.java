package com.ricerice.mymodulebiz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ricerice.mymoduleapi.entity.User;

public interface UserService {
	public IPage selectUserList(Page page, User user);

	Boolean updateUser(User user);

	User selectUserById(String id);
}
