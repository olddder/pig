package com.ricerice.mymoduleapi.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author boc
 * @description
 * @create 2024/3/29 9:35
 */
@Data
public class Dept {
	private static final long serialVersionUID = 1L;

	@TableId(value = "dept_id", type = IdType.ASSIGN_ID)
	@Schema(description = "部门id")
	private String deptId;

	/**
	 * 部门名称
	 */
	@NotBlank(message = "部门名称不能为空")
	@Schema(description = "部门名称")
	private String name;

	/**
	 * 排序
	 */
	@NotNull(message = "排序值不能为空")
	@Schema(description = "排序值")
	private Integer sortOrder;

	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	@Schema(description = "创建人")
	private String createBy;

	/**
	 * 修改人
	 */
	@TableField(fill = FieldFill.UPDATE)
	@Schema(description = "修改人")
	private String updateBy;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@Schema(description = "修改时间")
	@TableField(fill = FieldFill.UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 父级部门id
	 */
	@Schema(description = "父级部门id")
	private String parentId;

	/**
	 * 是否删除 1：已删除 0：正常
	 */
	@TableLogic
	@Schema(description = "删除标记,1:已删除,0:正常")
	@TableField(fill = FieldFill.INSERT)
	private String delFlag;
}
