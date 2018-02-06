package com.bootdo.BusinessManage.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
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

import com.bootdo.BusinessManage.domain.RecommendDO;
import com.bootdo.BusinessManage.service.RecommendService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 商家推荐表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
 
@Controller
@RequestMapping("/BusinessManage/recommend")
public class RecommendController extends BaseController{
	@Autowired
	private RecommendService recommendService;
	
	@GetMapping()
	@RequiresPermissions("BusinessManage:recommend:recommend")
	String Recommend(){
	    return "BusinessManage/recommend/recommend";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("BusinessManage:recommend:recommend")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		Integer userType = getUserType();
		if(3 == userType){
			query.put("businessId",getDeptId());
		}
		List<RecommendDO> recommendList = recommendService.list(query);
		int total = recommendService.count(query);
		PageUtils pageUtils = new PageUtils(recommendList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("BusinessManage:recommend:add")
	String add(){
	    return "BusinessManage/recommend/add";
	}

	@GetMapping("/edit/{businessId}")
	@RequiresPermissions("BusinessManage:recommend:edit")
	String edit(@PathVariable("businessId") Integer businessId,Model model){
		RecommendDO recommend = recommendService.get(businessId);
		model.addAttribute("recommend", recommend);
	    return "BusinessManage/recommend/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("BusinessManage:recommend:add")
	public R save( RecommendDO recommend){
		recommend.setBusinessId(getDeptId());
		if(null == recommendService.getByBusinessIdAndCarId(getDeptId(),recommend.getCarId())){
			recommend.setCreateBy(Integer.parseInt(getDeptId().toString()));
			recommend.setCreateDate(new Date());
			if(recommendService.save(recommend)>0){
				return R.ok();
			}else{
				return R.error();
			}
		}else{
			return R.error(0,"您已经推荐过这块车了");
		}
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("BusinessManage:recommend:edit")
	public R update( RecommendDO recommend){
		recommendService.update(recommend);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("BusinessManage:recommend:remove")
	public R remove( Integer businessId){
		if(recommendService.remove(businessId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("BusinessManage:recommend:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] businessIds){
		recommendService.batchRemove(businessIds);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/Recommend")
	@ResponseBody
	@RequiresPermissions("BusinessManage:car:add")
	public R Recommend( Integer carId){
		RecommendDO recommendDO = recommendService.getByBusinessIdAndCarId(getDeptId(),carId);
		if(null == recommendDO){
			recommendDO = new RecommendDO();
			recommendDO.setBusinessId(getDeptId());
			recommendDO.setCarId(carId);
			recommendDO.setCreateBy(Integer.parseInt(getUserId().toString()));
			recommendDO.setCreateDate(new Date());
			recommendService.save(recommendDO);
			return R.ok();
		}else{
			return R.error(0,"您已经推荐过这块车了");
		}
	}
	
}
