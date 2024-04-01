package com.ricerice.mymodulebiz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.ricerice.mymoduleapi.dto.UserDTO;
import com.ricerice.mymodulebiz.service.UserService;
import com.ricerice.mymoduleapi.entity.User;
import com.pig4cloud.pig.common.core.util.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public R getUserList(@ParameterObject Page page, @ParameterObject UserDTO user){
		return R.ok(userService.selectUserList(page, user));
	}

	/**
	 * 添加用户
	 * @param userDTO 用户信息
	 * @return success/false
	 */
	@SysLog("添加用户")
	@PostMapping
	public R user(@RequestBody UserDTO userDTO) {
		return R.ok(userService.addUser(userDTO));
	}

	/**
	 * 通过ID查询用户信息
	 * @param userId ID
	 * @return 用户信息
	 */
	@GetMapping("/details/{userId}")
	public R user(@PathVariable Long userId) {
		return R.ok(userService.selectUserById(userId));
	}

	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @return R
	 */
	@PutMapping
	public R updateUser(@Valid @RequestBody UserDTO userDto) {
		return R.ok(userService.updateUser(userDto));
	}

	/**
	 * 删除用户信息
	 * @param ids ID
	 * @return R
	 */
	@SysLog("删除用户信息")
	@DeleteMapping
	@Operation(summary = "删除用户", description = "根据ID删除用户")
	public R userDel(@RequestBody Long[] ids) {
		return R.ok(userService.deleteUserByIds(ids));
	}

}
