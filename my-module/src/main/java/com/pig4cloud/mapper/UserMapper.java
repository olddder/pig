package com.pig4cloud.mapper;

import com.pig4cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
	List<User> selectUserList(User user);
}
