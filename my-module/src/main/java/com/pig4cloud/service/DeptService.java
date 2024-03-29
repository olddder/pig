package com.pig4cloud.service;

import cn.hutool.core.lang.tree.Tree;

import java.util.List;

/**
 * @author boc
 * @description
 * @create 2024/3/29 9:32
 */
public interface DeptService {
	List<Tree<String>> selectTree(String deptName);
}
