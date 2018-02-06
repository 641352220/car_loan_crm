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

import com.bootdo.AppManage.domain.LabelDO;
import com.bootdo.AppManage.service.LabelService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 标签表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/label")
public class LabelController {
	@Autowired
	private LabelService labelService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:label:label")
	String Label(){
	    return "AppManage/label/label";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:label:label")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LabelDO> labelList = labelService.list(query);
		int total = labelService.count(query);
		PageUtils pageUtils = new PageUtils(labelList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:label:add")
	String add(){
	    return "AppManage/label/add";
	}

	@GetMapping("/edit/{labelId}")
	@RequiresPermissions("AppManage:label:edit")
	String edit(@PathVariable("labelId") Integer labelId,Model model){
		LabelDO label = labelService.get(labelId);
		model.addAttribute("label", label);
	    return "AppManage/label/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:label:add")
	public R save( LabelDO label){
		if(labelService.save(label)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:label:edit")
	public R update( LabelDO label){
		labelService.update(label);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:label:remove")
	public R remove( Integer labelId){
		if(labelService.remove(labelId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:label:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] labelIds){
		labelService.batchRemove(labelIds);
		return R.ok();
	}



	@ResponseBody
	@GetMapping("/labelList")
	public List<LabelDO> labelList(Integer type,Integer id){
		//查询列表数据
		return labelService.labelList(type,id);
	}
}
