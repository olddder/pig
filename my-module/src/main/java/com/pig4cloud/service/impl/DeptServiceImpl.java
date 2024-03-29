package com.pig4cloud.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pig4cloud.entity.Dept;
import com.pig4cloud.mapper.DeptMapper;
import com.pig4cloud.service.DeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author boc
 * @description
 * @create 2024/3/29 9:32
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptMapper deptMapper;

	@Override
	public List<Tree<String>> selectTree(String deptName) {
		// 查询全部部门
		List<Dept> deptAllList = deptMapper
				.selectList(Wrappers.<Dept>lambdaQuery().like(StrUtil.isNotBlank(deptName), Dept::getName, deptName));

		// 权限内部门
		List<TreeNode<String>> collect = deptAllList.stream()
				.filter(dept -> !dept.getDeptId().equals(dept.getParentId()))
				.sorted(Comparator.comparingInt(Dept::getSortOrder))
				.map(dept -> {
					TreeNode<String> treeNode = new TreeNode();
					treeNode.setId(dept.getDeptId());
					treeNode.setParentId(dept.getParentId());
					treeNode.setName(dept.getName());
					treeNode.setWeight(dept.getSortOrder());
					// 有权限不返回标识
					Map<String, Object> extra = new HashMap<>(8);
					extra.put("createTime", dept.getCreateTime());
					treeNode.setExtra(extra);
					return treeNode;
				})
				.collect(Collectors.toList());

		// 模糊查询 不组装树结构 直接返回 表格方便编辑
		if (StrUtil.isNotBlank(deptName)) {
			return collect.stream().map(node -> {
				Tree<String> tree = new Tree<>();
				tree.putAll(node.getExtra());
				BeanUtils.copyProperties(node, tree);
				return tree;
			}).collect(Collectors.toList());
		}

		return TreeUtil.build(collect, "0");
	}
}
