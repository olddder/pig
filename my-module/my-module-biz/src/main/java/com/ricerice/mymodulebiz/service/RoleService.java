package com.ricerice.mymodulebiz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ricerice.mymoduleapi.entity.Role;

/**
 * @author boc
 * @description
 * @create 2024/3/29 13:51
 */
public interface RoleService extends IService<Role> {
	/**
	 * 通过角色ID，删除角色
	 * @param ids
	 * @return
	 */
	Boolean removeRoleByIds(Long[] ids);
}
