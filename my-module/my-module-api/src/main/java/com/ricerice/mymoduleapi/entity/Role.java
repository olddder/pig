package com.ricerice.mymoduleapi.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ricerice
 * @create 2024/3/28 22:05
 */
@Data
public class Role {
	private Long roleId;
	private String roleCode;
	private String roleName;
	private String roleDesc;
	private LocalDateTime createTime;
}
