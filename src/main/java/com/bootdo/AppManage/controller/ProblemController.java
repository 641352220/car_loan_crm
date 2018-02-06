package com.bootdo.AppManage.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.AppManage.domain.ProblemDO;
import com.bootdo.AppManage.service.ProblemService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 常见问题
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/problem")
public class ProblemController {
	@Autowired
	private ProblemService problemService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:problem:problem")
	String Problem(){
	    return "AppManage/problem/problem";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:problem:problem")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProblemDO> problemList = problemService.list(query);
		int total = problemService.count(query);
		PageUtils pageUtils = new PageUtils(problemList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:problem:add")
	String add(){
	    return "AppManage/problem/add";
	}

	@GetMapping("/edit/{problemId}")
	@RequiresPermissions("AppManage:problem:edit")
	String edit(@PathVariable("problemId") Integer problemId,Model model){
		ProblemDO problem = problemService.get(problemId);
		model.addAttribute("problem", problem);
	    return "AppManage/problem/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:problem:add")
	public R save( ProblemDO problem){
		if(problemService.save(problem)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:problem:edit")
	public R update( ProblemDO problem){
		problemService.update(problem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:problem:remove")
	public R remove( Integer problemId){
		if(problemService.remove(problemId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:problem:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] problemIds){
		problemService.batchRemove(problemIds);
		return R.ok();
	}
	
}
