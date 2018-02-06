package com.bootdo.common.controller;

import com.bootdo.BusinessManage.service.InformationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;

@Controller
public class BaseController {

	@Autowired
	private InformationService informationService;

	protected Log log = LogFactory.getLog(getClass());

	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public Integer getUserIdInt() {
		return Integer.parseInt(getUser().getUserId().toString());
	}

	public String getUsername() {
		return getUser().getUsername();
	}

	public Integer getDeptId() {
		return Integer.parseInt(getUser().getDeptId().toString());
	}

	public Integer getUserType() {// 1 平台
		if(1 == getUser().getUserId()){
			return 0;
		}else {
			return informationService.get(Integer.parseInt(getUser().getDeptId().toString())).getParentId();
		}
	}
}