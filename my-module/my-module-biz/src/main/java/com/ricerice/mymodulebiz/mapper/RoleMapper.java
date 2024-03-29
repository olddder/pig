package com.ricerice.mymodulebiz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ricerice.mymoduleapi.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ricerice
 * @create 2024/3/28 22:18
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	List<Role> listRolesByUserId(String userId);
}
