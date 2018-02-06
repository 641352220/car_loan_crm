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

import com.bootdo.AppManage.domain.FeedbackDO;
import com.bootdo.AppManage.service.FeedbackService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户反馈表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:feedback:feedback")
	String Feedback(){
	    return "AppManage/feedback/feedback";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:feedback:feedback")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FeedbackDO> feedbackList = feedbackService.list(query);
		int total = feedbackService.count(query);
		PageUtils pageUtils = new PageUtils(feedbackList, total);
		return pageUtils;
	}
	

}
