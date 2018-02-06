package com.bootdo.AppManage.controller;

import java.util.Date;
import java.util.Iterator;
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

import com.bootdo.AppManage.domain.ConfigDO;
import com.bootdo.AppManage.service.ConfigService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * app常量
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/config")
public class ConfigController extends BaseController{
	@Autowired
	private ConfigService configService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:config:config")
	String Config(Model model){
		List<ConfigDO> configDOList = configService.list();
		for(ConfigDO configDO : configDOList){
			model.addAttribute(configDO.getName(),configDO.getValue());
		}
		return "AppManage/config/edit";
	}

	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:config:config")
	public R save( @RequestParam Map<String,Object> param){
		Iterator it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object val = entry.getValue();
			Object key = entry.getKey();
			ConfigDO configDO = configService.get(key.toString());
			if(null == configDO){
				configDO = new ConfigDO();
				configDO.setCreateBy(Integer.parseInt(getUserId().toString()));
				configDO.setCreateDate(new Date());
				configDO.setName(key.toString());
				configDO.setValue(val.toString());
				configService.save(configDO);
			}else{
				if(!configDO.getValue().equals(val.toString())){
					configDO.setUpdateBy(getUserId());
					configDO.setUpdateDate(new Date());
					configDO.setName(key.toString());
					configDO.setValue(val.toString());
					configService.update(configDO);
				}
			}
		}
		return R.ok();
	}

	

}
