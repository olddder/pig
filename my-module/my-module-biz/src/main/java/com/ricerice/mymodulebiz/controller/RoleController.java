package com.ricerice.mymodulebiz.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.entity.SysRole;
import com.pig4cloud.pig.common.core.constant.CacheConstants;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.ricerice.mymodulebiz.service.RoleService;
import com.ricerice.mymoduleapi.entity.Role;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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

	/**
	 * 添加角色
	 * @param role 角色信息
	 * @return success、false
	 */
	@SysLog("添加角色")
	@PostMapping
	@CacheEvict(value = CacheConstants.ROLE_DETAILS, allEntries = true)
	public R save(@Valid @RequestBody Role role) {
		return R.ok(roleService.save(role));
	}

	/**
	 * 通过ID查询角色信息
	 * @param id ID
	 * @return 角色信息
	 */
	@GetMapping("/details/{id}")
	public R getById(@PathVariable Long id) {
		return R.ok(roleService.getById(id));
	}

	/**
	 * 修改角色
	 * @param role 角色信息
	 * @return success/false
	 */
	@SysLog("修改角色")
	@PutMapping
	@CacheEvict(value = CacheConstants.ROLE_DETAILS, allEntries = true)
	public R update(@Valid @RequestBody Role role) {
		return R.ok(roleService.updateById(role));
	}

	/**
	 * 删除角色
	 * @param ids
	 * @return
	 */
	@SysLog("删除角色")
	@DeleteMapping
	@CacheEvict(value = CacheConstants.ROLE_DETAILS, allEntries = true)
	public R removeById(@RequestBody Long[] ids) {
		return R.ok(roleService.removeRoleByIds(ids));
	}

}
