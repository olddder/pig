package com.ricerice.mymodulebiz.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.ricerice.mymodulebiz.service.RoleService;
import com.ricerice.mymoduleapi.entity.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author boc
 * @description
 * @create 2024/3/29 13:50
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;
	/**
	 * 获取角色列表
	 * @return 角色列表
	 */
	@GetMapping("/list")
	public R listRoles() {
		return R.ok(roleService.list(Wrappers.emptyWrapper()));
	}

	/**
	 * 分页查询角色信息
	 * @param page 分页对象
	 * @param role 查询条件
	 * @return 分页对象
	 */
	@GetMapping("/page")
	public R getRolePage(Page page, Role role) {
		return R.ok(roleService.page(page, Wrappers.<Role>lambdaQuery()
				.like(StrUtil.isNotBlank(role.getRoleName()), Role::getRoleName, role.getRoleName())));
	}
}
