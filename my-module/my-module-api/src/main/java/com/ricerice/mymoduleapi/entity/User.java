package com.ricerice.mymoduleapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class User {
	@TableId(value = "user_id", type = IdType.ASSIGN_ID)
	private Long userId;
	private String ehrNo;
	private String name;
	private String brNo;
	private String ehrStatus;
	private String delFlag;
}
