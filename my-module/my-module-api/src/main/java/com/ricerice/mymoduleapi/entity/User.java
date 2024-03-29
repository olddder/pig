package com.ricerice.mymoduleapi.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
	private Integer id;
	private String ehrNo;
	private String name;
	private String brNo;
	private Integer ehrStatus;
	private List<Role> roleList;
	private String deptName;
	private Integer delFlag;
}
