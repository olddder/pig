package com.ricerice.mymodulebiz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import com.pig4cloud.pig.admin.api.entity.SysUserRole;
import com.pig4cloud.pig.common.core.constant.CommonConstants;
import com.ricerice.mymoduleapi.dto.UserDTO;
import com.ricerice.mymoduleapi.entity.UserRole;
import com.ricerice.mymodulebiz.mapper.RoleMapper;
import com.ricerice.mymodulebiz.mapper.UserMapper;
import com.ricerice.mymodulebiz.mapper.UserRoleMapper;
import com.ricerice.mymodulebiz.service.UserService;
import com.ricerice.mymoduleapi.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Resource
	private UserMapper userMapper;

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private UserRoleMapper userRoleMapper;

	public IPage selectUserList(Page page, UserDTO user) {
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
	@Transactional
	public Boolean addUser(UserDTO userDto) {
		System.out.println("in");
		// 插入用户表
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setDelFlag(0);
		System.out.println("user" + user);
		baseMapper.insert(user);
		// 插入用户角色关系表
		userDto.getRole().stream().map(role -> {
			UserRole userRole = new UserRole();
			userRole.setEhrNo(userDto.getEhrNo());
			userRole.setRoleCode(role);
			userRole.setActive(1);
			return userRole;
		}).forEach(userRoleMapper::insert);
		return Boolean.TRUE;
	}

	@Override
	public User selectUserById(String id) {
		return userMapper.getUserById(id);
	}
}
