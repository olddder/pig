package com.ricerice.mymodulebiz.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.SysRoleMenu;
import com.ricerice.mymodulebiz.mapper.RoleMapper;
import com.ricerice.mymodulebiz.service.RoleService;
import com.ricerice.mymoduleapi.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author boc
 * @description
 * @create 2024/3/29 13:51
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean removeRoleByIds(Long[] ids) {
		return this.removeBatchByIds(CollUtil.toList(ids));
	}
}
