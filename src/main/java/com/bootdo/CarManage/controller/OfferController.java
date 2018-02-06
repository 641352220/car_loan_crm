package com.bootdo.CarManage.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.domain.LabelRelationDO;
import com.bootdo.AppManage.service.LabelRelationService;
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

import com.bootdo.CarManage.domain.OfferDO;
import com.bootdo.CarManage.service.OfferService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汽车报价表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/offer")
public class OfferController extends BaseController{
	@Autowired
	private OfferService offerService;
	@Autowired
	private LabelRelationService labelRelationService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:offer:offer")
	String Offer(){
	    return "CarManage/offer/offer";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:offer:offer")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		Integer userType = getUserType();
		if(3 == userType){
			query.put("businessId",getDeptId());
		}
		List<OfferDO> offerList = offerService.list(query);
		int total = offerService.count(query);
		PageUtils pageUtils = new PageUtils(offerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:offer:add")
	String add(){
	    return "CarManage/offer/add";
	}

	@GetMapping("/edit/{offerId}")
	@RequiresPermissions("CarManage:offer:edit")
	String edit(@PathVariable("offerId") Integer offerId,Model model){
		OfferDO offer = offerService.get(offerId);
		model.addAttribute("offer", offer);
	    return "CarManage/offer/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:offer:add")
	public R save(@RequestParam Map<String,Object> param, OfferDO offer){
		offer.setCreateBy(Integer.parseInt(getDeptId().toString()));
		offer.setCreateDate(new Date());
		offer.setBusinessId(getDeptId());
		offer.setOfferTime(new Date());
		if(offerService.save(offer)>0){
			try{
				labelRelationService.save(new LabelRelationDO(offer.getOfferId(),Integer.parseInt(param.get("labelId").toString()),4));
			}catch (Exception e){
			}
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:offer:edit")
	public R update(@RequestParam Map<String,Object> param, OfferDO offer){
		offerService.update(offer);
		try{
			labelRelationService.save(new LabelRelationDO(offer.getOfferId(),Integer.parseInt(param.get("labelId").toString()),4));
		}catch (Exception e){
		}
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:offer:remove")
	public R remove( Integer offerId){
		if(offerService.remove(offerId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:offer:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] offerIds){
		offerService.batchRemove(offerIds);
		return R.ok();
	}
	
}
