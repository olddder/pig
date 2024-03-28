package com.pig4cloud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.entity.User;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author boc
 * @description
 * @create 2024/3/28 15:02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(description = "my_user", name = "自建用户模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("/list")
	public R getUserList(@ParameterObject Page page, @ParameterObject User user){
		return R.ok(userService.selectUserList(page, user));
	}

	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @return R
	 */
	@PutMapping
	public R updateUser(@Valid @RequestBody User user) {
		System.out.println(user);
		return R.ok(userService.updateUser(user));
	}
}
