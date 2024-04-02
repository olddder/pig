package com.ricerice.mymodulebiz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import com.ricerice.mymoduleapi.dto.UserDTO;
import com.ricerice.mymoduleapi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	IPage<UserDTO> selectUserList(Page page, @Param("query") UserDTO userDto);

	User getUserById(Long userId);

}
