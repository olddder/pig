package com.ricerice.mymoduleapi.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author ricerice
 * @create 2024/3/30 22:56
 */
@Data
public class UserRole extends Model<UserRole> {
	private String ehrNo;
	private String roleCode;
	private String active;
}
