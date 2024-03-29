package com.pig4cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.entity.Role;
import com.pig4cloud.mapper.RoleMapper;
import com.pig4cloud.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author boc
 * @description
 * @create 2024/3/29 13:51
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
