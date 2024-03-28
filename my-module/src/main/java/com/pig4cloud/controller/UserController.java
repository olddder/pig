package com.pig4cloud.controller;

import com.pig4cloud.entity.User;
import com.pig4cloud.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author boc
 * @description
 * @create 2024/3/28 15:02
 */
@RestController
@AllArgsConstructor
//@RequestMapping("/my")
@Tag(description = "my", name = "自建模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("/user/list")
	public List<User> getUserList(User user){
		System.out.println("my controller in");
		return userService.selectUserList(user);
	}
}
