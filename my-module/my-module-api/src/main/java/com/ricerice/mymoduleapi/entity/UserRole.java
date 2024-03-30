package com.ricerice.mymoduleapi.entity;

import lombok.Data;

/**
 * @author ricerice
 * @create 2024/3/30 22:56
 */
@Data
public class UserRole {
	private Integer id;
	private String ehrNo;
	private String roleCode;
	private Integer active;
}
