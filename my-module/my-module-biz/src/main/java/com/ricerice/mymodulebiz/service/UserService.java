package com.ricerice.mymodulebiz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ricerice.mymoduleapi.dto.UserDTO;
import com.ricerice.mymoduleapi.entity.User;

public interface UserService extends IService<User> {
	public IPage selectUserList(Page page, UserDTO user);

	Boolean updateUser(UserDTO userDto);

	User selectUserById(Long userId);

	Boolean addUser(UserDTO userDTO);

	/**
	 * 删除用户
	 * @param ids 用户
	 * @return boolean
	 */
	Boolean deleteUserByIds(Long[] ids);
}
