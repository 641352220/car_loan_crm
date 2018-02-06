package com.bootdo.AdverManage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.AdverManage.domain.AdverDO;
import com.bootdo.AdverManage.service.AdverService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.MapUntils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 广告
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-03 11:10:04
 */
 
@Controller
@RequestMapping("/AdverManage/adver")
public class AdverController extends BaseController{

	public Log log = LogFactory.getLog(getClass());
	@Autowired
	private AdverService adverService;
	
	@GetMapping()
	@RequiresPermissions("AdverManage:adver:adver")
	String Adver(){ return "AdverManage/adver/adver";}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AdverManage:adver:adver")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<AdverDO> adverList = adverService.list(query);
		int total = adverService.count(query);
		PageUtils pageUtils = new PageUtils(adverList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AdverManage:adver:add")
	String add(){
	    return "AdverManage/adver/add";
	}

	@GetMapping("/edit/{adverId}")
	@RequiresPermissions("AdverManage:adver:edit")
	String edit(@PathVariable("adverId") Integer adverId,Model model){
		AdverDO adver = adverService.get(adverId);
		model.addAttribute("adver", adver);
	    return "AdverManage/adver/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AdverManage:adver:add")
	public R save(AdverDO adverDO){
		try{
			adverDO.setCreateBy(Integer.parseInt(getUserId().toString()));
			adverDO.setCreateDate(new Date());
			if(adverService.save(adverDO)>0){
				return R.ok();
			}
			return R.error();
		}catch (Exception e){
			e.printStackTrace();
			return R.error();
		}

	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AdverManage:adver:edit")
	public R update(AdverDO adver){
		adver.setUpdateBy(getUserId());
		adver.setUpdateDate(new Date());
		adverService.update(adver);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AdverManage:adver:remove")
	public R remove(Integer adverId){
		if(adverService.remove(adverId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AdverManage:adver:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] adverIds){
		adverService.batchRemove(adverIds);
		return R.ok();
	}
	
}
