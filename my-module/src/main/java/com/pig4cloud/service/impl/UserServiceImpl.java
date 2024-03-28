package com.pig4cloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.entity.User;
import com.pig4cloud.mapper.UserMapper;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import com.pig4cloud.pig.admin.api.entity.SysUserPost;
import com.pig4cloud.pig.admin.api.entity.SysUserRole;
import com.pig4cloud.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	public IPage selectUserList(Page page, User user) {
		return userMapper.selectUserList(page, user);
	}

	@Override
	@Transactional
	public Boolean updateUser(User user) {
		// 更新用户表信息
		userMapper.updateById(user);
		return Boolean.TRUE;
	}
}
