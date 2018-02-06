package com.bootdo.UserManage.controller;

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

import com.bootdo.UserManage.domain.CollectionDO;
import com.bootdo.UserManage.service.CollectionService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户收藏表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
 
@Controller
@RequestMapping("/UserManage/collection")
public class CollectionController {
	@Autowired
	private CollectionService collectionService;
	
	@GetMapping()
	@RequiresPermissions("UserManage:collection:collection")
	String Collection(){
	    return "UserManage/collection/collection";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("UserManage:collection:collection")
	public PageUtils list(@RequestParam Map<String, Object> params){
		System.out.println("list:"+params.toString());
		//查询列表数据
        Query query = new Query(params);
		List<CollectionDO> collectionList = collectionService.list(query);
		int total = collectionService.count(query);
		PageUtils pageUtils = new PageUtils(collectionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("UserManage:collection:add")
	String add(){
	    return "UserManage/collection/add";
	}

	@GetMapping("/edit/{collectionId}")
	@RequiresPermissions("UserManage:collection:edit")
	String edit(@PathVariable("collectionId") Integer collectionId,Model model){
		CollectionDO collection = collectionService.get(collectionId);
		model.addAttribute("collection", collection);
	    return "UserManage/collection/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("UserManage:collection:add")
	public R save( CollectionDO collection){
		if(collectionService.save(collection)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("UserManage:collection:edit")
	public R update( CollectionDO collection){
		collectionService.update(collection);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("UserManage:collection:remove")
	public R remove( Integer collectionId){
		if(collectionService.remove(collectionId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("UserManage:collection:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] collectionIds){
		collectionService.batchRemove(collectionIds);
		return R.ok();
	}

	
}
