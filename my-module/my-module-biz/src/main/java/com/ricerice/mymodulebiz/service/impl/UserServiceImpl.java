package com.ricerice.mymodulebiz.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import com.pig4cloud.pig.admin.api.entity.SysUserRole;
import com.pig4cloud.pig.common.core.constant.CacheConstants;
import com.pig4cloud.pig.common.core.constant.CommonConstants;
import com.ricerice.mymoduleapi.dto.UserDTO;
import com.ricerice.mymoduleapi.entity.UserRole;
import com.ricerice.mymodulebiz.mapper.RoleMapper;
import com.ricerice.mymodulebiz.mapper.UserMapper;
import com.ricerice.mymodulebiz.mapper.UserRoleMapper;
import com.ricerice.mymodulebiz.service.UserService;
import com.ricerice.mymoduleapi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Resource
	private UserMapper userMapper;

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private final CacheManager cacheManager;

	@Resource
	private UserRoleMapper userRoleMapper;

	public IPage selectUserList(Page page, UserDTO userDto) {
		return userMapper.selectUserList(page, userDto);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean updateUser(UserDTO userDto) {
		// 更新用户表信息
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		System.out.println(userDto);
		System.out.println(user);
		this.updateById(user);
		// 更新用户角色表
		userRoleMapper.delete(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getEhrNo, userDto.getEhrNo()));
		userDto.getRole().stream().map(roleCode -> {
			UserRole userRole = new UserRole();
			userRole.setEhrNo(user.getEhrNo());
			userRole.setRoleCode(roleCode);
			return userRole;
		}).forEach(UserRole::insert);
		return Boolean.TRUE;
	}

	@Override
	@Transactional
	public Boolean addUser(UserDTO userDto) {
		// 插入用户表
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setDelFlag("0");
		baseMapper.insert(user);
		// 插入用户角色关系表
		userDto.getRole().stream().map(role -> {
			UserRole userRole = new UserRole();
			userRole.setEhrNo(user.getEhrNo());
			userRole.setRoleCode(role);
			userRole.setActive("1");
			return userRole;
		}).forEach(userRoleMapper::insert);
		return Boolean.TRUE;
	}

	@Override
	public Boolean deleteUserByIds(Long[] ids) {
		// 删除 spring cache
		List<User> userList = baseMapper.selectBatchIds(CollUtil.toList(ids));
		Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
		List<String> ehrs = userList.stream()
				.map(User::getEhrNo) // 将每个User对象映射为其ehrNo
				.collect(Collectors.toList()); // 收集结果到新的List中
		for (User user : userList) {
			// 立即删除
			cache.evictIfPresent(user.getName());
		}
		System.out.println(ehrs);
		userRoleMapper.delete(Wrappers.<UserRole>lambdaQuery().in(UserRole::getEhrNo, ehrs));
		this.removeBatchByIds(CollUtil.toList(ids));
		return Boolean.TRUE;
	}

	@Override
	public User selectUserById(Long userId) {
		return userMapper.getUserById(userId);
	}
}
