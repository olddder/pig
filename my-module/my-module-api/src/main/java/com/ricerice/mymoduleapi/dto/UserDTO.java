package com.ricerice.mymoduleapi.dto;

import com.ricerice.mymoduleapi.entity.Role;
import com.ricerice.mymoduleapi.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author ricerice
 * @create 2024/3/30 23:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends User {
	private List<Role> roleList;
	private List<String> role;
	private String deptName;
}
