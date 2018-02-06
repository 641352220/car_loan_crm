package com.bootdo.BusinessManage.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.BusinessManage.domain.BusinessCityDO;
import com.bootdo.BusinessManage.service.BusinessCityService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 商家城市关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
 
@Controller
@RequestMapping("/BusinessManage/city")
public class BusinessCityController {
	@Autowired
	private BusinessCityService businessCityService;

}
