package com.ricerice.mymodulebiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ricerice.mymodulebiz.service.UserService;
import com.ricerice.mymoduleapi.entity.User;
import com.pig4cloud.pig.common.core.util.R;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springdoc.api.annotations.ParameterObject;
import javax.annotation.Resource;
import javax.validation.Valid;

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
	 * 通过ID查询用户信息
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/details/{id}")
	public R user(@PathVariable String id) {
		return R.ok(userService.selectUserById(id));
	}

	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @return R
	 */
	@PutMapping
	public R updateUser(@Valid @RequestBody User user) {
		return R.ok(userService.updateUser(user));
	}
}
