package com.ricerice.mymodulebiz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricerice.mymodulebiz.mapper.RoleMapper;
import com.ricerice.mymodulebiz.mapper.UserMapper;
import com.ricerice.mymodulebiz.service.UserService;
import com.ricerice.mymoduleapi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Resource
	private UserMapper userMapper;

	@Resource
	private RoleMapper roleMapper;

	public IPage selectUserList(Page page, User user) {
		return userMapper.selectUserList(page, user);
	}

	@Override
	@Transactional
	public Boolean updateUser(User user) {
		System.out.println(user);
		// 更新用户表信息
		userMapper.updateUserByEhrNo(user);

		// 更新用户角色表
//		roleMapper.delete(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, userDto.getUserId()));
//		user.getRoleList().stream().map(roleId -> {
//			SysUserRole userRole = new SysUserRole();
//			userRole.setUserId(sysUser.getUserId());
//			userRole.setRoleId(roleId);
//			return userRole;
//		}).forEach(SysUserRole::insert);
		return Boolean.TRUE;
	}

	@Override
	public User selectUserById(String id) {
		return userMapper.getUserById(id);
	}
}
