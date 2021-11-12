package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 */
public interface DepartmentMapper extends BaseMapper<Department> {

	/**
	 * 获取所有部门
	 * @return
	 */
	List<Department> getAllDepartments(Integer parentId);

	/**
	 * 添加部门
	 * @param dep
	 */
	void addDep(Department dep);

	/**
	 * 删除部门
	 * @param dep
	 */
	void deleteDep(Department dep);
}
