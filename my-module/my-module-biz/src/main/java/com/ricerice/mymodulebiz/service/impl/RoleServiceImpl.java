package com.ricerice.mymodulebiz.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricerice.mymodulebiz.mapper.RoleMapper;
import com.ricerice.mymodulebiz.service.RoleService;
import com.ricerice.mymoduleapi.entity.Role;
import org.springframework.stereotype.Service;

/**
 * @author boc
 * @description
 * @create 2024/3/29 13:51
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
