package com.ricerice.mymodulebiz.controller;

import com.pig4cloud.pig.common.core.util.R;
import com.ricerice.mymodulebiz.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author boc
 * @description
 * @create 2024/3/29 9:31
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

	@Resource
	private DeptService deptService;

	/**
	 * 返回树形菜单集合
	 * @param deptName 部门名称
	 * @return 树形菜单
	 */
	@GetMapping(value = "/tree")
	public R getTree(String deptName) {
		return R.ok(deptService.selectTree(deptName));
	}
}
