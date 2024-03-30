package com.ricerice.mymodulebiz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pig4cloud.pig.admin.api.entity.SysUserRole;
import com.ricerice.mymoduleapi.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ricerice
 * @create 2024/3/30 22:58
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
