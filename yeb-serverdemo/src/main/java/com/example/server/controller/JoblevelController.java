package com.example.server.controller;


import com.example.server.service.IJoblevelService;
import com.example.server.pojo.Joblevel;
import com.example.server.pojo.RespBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

	@Autowired
	private IJoblevelService joblevelService;

	@ApiOperation(value = "获取所有职称")
	@GetMapping("/")
	public List<Joblevel> getAllJobLevels(){
		return joblevelService.list();
	}


	@ApiOperation(value = "添加职称")
	@PostMapping("/")
	public RespBean addJobLevel(@RequestBody Joblevel joblevel){
		joblevel.setCreateDate(LocalDateTime.now());
		if (joblevelService.save(joblevel)){
			return RespBean.success("添加成功!");
		}
		return RespBean.error("添加失败！");
	}

	@ApiOperation(value = "更新职位")
	@PutMapping("/")
	public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
		if (joblevelService.updateById(joblevel)){
			return RespBean.success("更新成功!");
		}
		return RespBean.error("更新失败！");
	}

	@ApiOperation(value = "删除职称")
	@DeleteMapping("/{id}")
	public RespBean deleteJobLevel(@PathVariable Integer id){
		if (joblevelService.removeById(id)){
			return RespBean.success("删除成功!");
		}
		return RespBean.error("删除失败！");
	}

	@ApiOperation(value = "批量删除")
	@DeleteMapping("/")
	public RespBean deleteJobLevelsByIds(Integer[] ids){
		if (joblevelService.removeByIds(Arrays.asList(ids))){
			return RespBean.success("删除成功！");
		}
		return RespBean.error("删除失败！");
	}


}
