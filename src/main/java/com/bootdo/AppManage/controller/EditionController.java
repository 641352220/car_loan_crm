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

import com.bootdo.AppManage.domain.EditionDO;
import com.bootdo.AppManage.service.EditionService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 版本表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/edition")
public class EditionController {
	@Autowired
	private EditionService editionService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:edition:edition")
	String Edition(){
	    return "AppManage/edition/edition";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:edition:edition")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EditionDO> editionList = editionService.list(query);
		int total = editionService.count(query);
		PageUtils pageUtils = new PageUtils(editionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:edition:add")
	String add(){
	    return "AppManage/edition/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("AppManage:edition:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		EditionDO edition = editionService.get(id);
		model.addAttribute("edition", edition);
	    return "AppManage/edition/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:edition:add")
	public R save( EditionDO edition){
		if(editionService.save(edition)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:edition:edit")
	public R update( EditionDO edition){
		editionService.update(edition);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:edition:remove")
	public R remove( Integer id){
		if(editionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:edition:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		editionService.batchRemove(ids);
		return R.ok();
	}
	
}
