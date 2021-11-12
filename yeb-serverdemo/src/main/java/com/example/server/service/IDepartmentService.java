package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Department;
import com.example.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface IDepartmentService extends IService<Department> {

	/**
	 * 获取所有部门
	 * @return
	 */
	List<Department> getAllDepartments();

	/**
	 * 添加部门
	 * @param dep
	 * @return
	 */
	RespBean addDep(Department dep);

	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	RespBean deleteDep(Integer id);
}
