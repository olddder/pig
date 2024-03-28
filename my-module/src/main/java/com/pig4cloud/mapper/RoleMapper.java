package com.pig4cloud.mapper;

import com.pig4cloud.entity.Role;
import com.pig4cloud.pig.admin.api.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ricerice
 * @create 2024/3/28 22:18
 */
@Mapper
public interface RoleMapper {
	List<Role> listRolesByUserId(String userId);
}
