package com.ricerice.mymoduleapi.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author ricerice
 * @create 2024/3/28 22:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends Model<Role> {
	@TableId(value = "role_id", type = IdType.ASSIGN_ID)
	private Long roleId;
	private String roleCode;
	private String roleName;
	private String roleDesc;
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
}
