package com.bootdo.CarManage.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bootdo.AppManage.domain.LabelRelationDO;
import com.bootdo.AppManage.domain.LoanConfigDO;
import com.bootdo.AppManage.service.LabelRelationService;
import com.bootdo.AppManage.service.LoanConfigService;
import com.bootdo.CarManage.dao.CarDao;
import com.bootdo.CarManage.dao.OfferDao;
import com.bootdo.CarManage.dao.ProductInformationCarDao;
import com.bootdo.CarManage.domain.*;
import com.bootdo.CarManage.service.*;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.insertBatch.MySQLUpdate;
import net.sf.ehcache.util.ProductInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;

/**
 * 车贷产品补充表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/productInformation")
public class ProductInformationController extends BaseController{
	@Autowired
	private ProductInformationService productInformationService;
	@Autowired
	private ProductInformationConfigService productInformationConfigService;
	@Autowired
	private LoanConfigService loanConfigService;
	@Autowired
	private CarService carService;
	@Autowired
	private ProductInformationCarService productInformationCarService;
	@Autowired
	private LabelRelationService labelRelationService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:productInformation:productInformation")
	String ProductInformation(){
	    return "CarManage/productInformation/productInformation";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:productInformation:productInformation")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		Integer userType = getUserType();
		if(2 == userType){
			query.put("businessId",getDeptId());
		}
		List<ProductInformationDO> productInformationList = productInformationService.list(query);
		int total = productInformationService.count(query);
		PageUtils pageUtils = new PageUtils(productInformationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:productInformation:add")
	String add(){
	    return "CarManage/productInformation/add";
	}

	@GetMapping("/edit/{carProductInformationId}")
	@RequiresPermissions("CarManage:productInformation:edit")
	String edit(@PathVariable("carProductInformationId") Integer carProductInformationId,Model model){
		ProductInformationDO productInformation = productInformationService.get(carProductInformationId);
		model.addAttribute("productInformation", productInformation);
	    return "CarManage/productInformation/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:productInformation:add")
	public R save(@RequestParam Map<String,Object> param, ProductInformationDO productInformation, HttpServletRequest request){
		try{
			productInformation.setBusinessId(getDeptId());
			productInformation.setCreateBy(Integer.parseInt(getUserId().toString()));
			productInformation.setCreateDate(new Date());
			productInformation.setApplyNum(0);
			productInformationService.save(productInformation);
			try{
				labelRelationService.save(new LabelRelationDO(Integer.parseInt(param.get("programmeLabel").toString()),productInformation.getCarProductInformationId(),1));
			}catch (Exception e){

			}
			try{
				labelRelationService.save(new LabelRelationDO(Integer.parseInt(param.get("discountLabel").toString()),productInformation.getCarProductInformationId(),3));
			}catch (Exception e){

			}
			until(loanConfigService,productInformationConfigService,carService,productInformationCarService,getDeptId(),request,productInformation,param);
			ProductInformationConfigDO max = productInformationConfigService.getMaxTerm(productInformation.getCarProductInformationId());
			ProductInformationConfigDO min = productInformationConfigService.getMinSF(productInformation.getCarProductInformationId());
			MinOrMaxUtil(productInformationCarService,productInformation.getCarProductInformationId(),Double.parseDouble(min.getValue()),
					Integer.parseInt(max.getValue()),max.getRate());
			return R.ok();
		}catch (Exception e){
			log.error(e.getMessage(),e);
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:productInformation:edit")
	public R update(@RequestParam Map<String,Object> param, ProductInformationDO productInformation, HttpServletRequest request){
		System.out.println("productInformation:"+JSON.toJSON(productInformation).toString());
		System.out.println("param:"+JSON.toJSON(param).toString());
		Long startTime = System.currentTimeMillis();
		try{
			productInformation.setUpdateBy(getUserId());
			productInformation.setUpdateDate(new Date());
			productInformationService.update(productInformation);
			labelRelationService.remove(productInformation.getCarProductInformationId(),"1,3");
			try{
				labelRelationService.save(new LabelRelationDO(productInformation.getCarProductInformationId(),Integer.parseInt(param.get("programmeLabel").toString()),1));
			}catch (Exception e){
			}
			try{
				labelRelationService.save(new LabelRelationDO(productInformation.getCarProductInformationId(),Integer.parseInt(param.get("discountLabel").toString()),3));
			}catch (Exception e){
			}
			Long startuntil = System.currentTimeMillis();
			productInformationConfigService.remove(productInformation.getCarProductInformationId());
			productInformationCarService.remove(productInformation.getCarProductInformationId());
			Integer carNum = until(loanConfigService,productInformationConfigService,carService,productInformationCarService,getDeptId(),request,productInformation,param);
			Long enduntil = System.currentTimeMillis();
			Long startMinOrMaxUtil = System.currentTimeMillis();
			ProductInformationConfigDO max = productInformationConfigService.getMaxTerm(productInformation.getCarProductInformationId());
			ProductInformationConfigDO min = productInformationConfigService.getMinSF(productInformation.getCarProductInformationId());
			MinOrMaxUtil(productInformationCarService,productInformation.getCarProductInformationId(),Double.parseDouble(min.getValue()),
					Integer.parseInt(max.getValue()),max.getRate());
			Long endMinOrMaxUtil = System.currentTimeMillis();
			Long endTime = System.currentTimeMillis();
			System.out.println("startuntil开始时间:"+startuntil);
			System.out.println("enduntil结束时间:"+enduntil);
			System.out.println("startMinOrMaxUtil开始时间:"+startMinOrMaxUtil);
			System.out.println("endMinOrMaxUtil结束时间:"+endMinOrMaxUtil);
			System.out.println("开始时间:"+startTime);
			System.out.println("结束时间:"+endTime);
			System.out.println("操作汽车:"+carNum);
			return R.ok();
		}catch (Exception e){
			log.error(e.getMessage(),e);
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("开始时间:"+startTime);
		System.out.println("结束时间:"+endTime);
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:productInformation:remove")
	public R remove( Integer carProductInformationId){
		if(productInformationService.remove(carProductInformationId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:productInformation:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carProductInformationIds){
		productInformationService.batchRemove(carProductInformationIds);
		return R.ok();
	}


	@ResponseBody
	@GetMapping("/listByCarProductId")
	public List<ProductInformationDO> listByCarProductId(Integer carProductId){
		//查询列表数据
		List<ProductInformationDO> productInformationDOList = productInformationService.listByCarProductId(carProductId);
		return productInformationDOList;
	}


	public static Integer until(LoanConfigService loanConfigService,ProductInformationConfigService productInformationConfigService,CarService carService,ProductInformationCarService productInformationCarService,Integer dept,
							 HttpServletRequest request,ProductInformationDO productInformation,Map<String,Object> param){
		Integer carNum = 0;
		try{
			String[] terms = request.getParameterValues("terms");
			for(String term : terms){
				LoanConfigDO loanConfigDO = loanConfigService.get(Integer.parseInt(term));
				ProductInformationConfigDO productInformationConfigDO = new ProductInformationConfigDO();
				productInformationConfigDO.setCarProductInformationId(productInformation.getCarProductInformationId());
				productInformationConfigDO.setLoanConfigId(loanConfigDO.getLoanConfigId());
				productInformationConfigDO.setType(2);
				productInformationConfigDO.setValue(loanConfigDO.getConfigValue());
				productInformationConfigDO.setRate(Double.parseDouble(param.get(term).toString()));
				productInformationConfigService.save(productInformationConfigDO);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		try{
			String[] downPayments = request.getParameterValues("downPayments");
			for(String downPayment : downPayments){
				LoanConfigDO loanConfigDO = loanConfigService.get(Integer.parseInt(downPayment));
				ProductInformationConfigDO productInformationConfigDO = new ProductInformationConfigDO();
				productInformationConfigDO.setCarProductInformationId(productInformation.getCarProductInformationId());
				productInformationConfigDO.setLoanConfigId(loanConfigDO.getLoanConfigId());
				productInformationConfigDO.setType(1);
				productInformationConfigDO.setValue(loanConfigDO.getConfigValue());
				productInformationConfigService.save(productInformationConfigDO);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		Object carIdQuery = param.get("carIds");
		if(null == carIdQuery || "".equals(carIdQuery)){
			return 0;
		}
		List<CarDO> carDOS = carService.listById(carIdQuery.toString());
		carNum = carDOS.size();
		Integer rmNum = productInformationCarService.remove(productInformation.getCarProductInformationId());
		System.out.println("删除车辆----------------->:"+rmNum);
		MySQLUpdate.executeInsert(carDOS,dept,productInformation.getCarProductInformationId(),productInformation.getCarProductId());
//		for(CarDO carDO : carDOS){
//				ProductInformationCarDO productInformationCarDO = new ProductInformationCarDO();
//				productInformationCarDO.setBusinessId(dept);
//				productInformationCarDO.setCarProductInformationId(productInformation.getCarProductInformationId());
//				productInformationCarDO.setCarId(carDO.getCarId());
//				productInformationCarDO.setCarModelId(carDO.getCarModelId());
//				productInformationCarDO.setCarProductId(productInformation.getCarProductId());
//				productInformationCarDO.setSort(100000);
//				productInformationCarDO.setTermMax(null);
//				productInformationCarDO.setDownPaymentsMin(null);
//				productInformationCarDO.setRate(null);
//				productInformationCarDO.setCarPrice(carDO.getPriceMin());
//				productInformationCarService.save(productInformationCarDO);
//		}


		return carNum;
	}

	public static void MinOrMaxUtil(ProductInformationCarService productInformationCarService,Integer carProductInformationId,Double downPaymentsMin,Integer termMax,Double rate){
		System.out.println("--------------------匹配最低首付及期限开始-------------------------------------------------------------------->");
		Map<String,Object> map1 = new HashMap<>();
		map1.put("carProductInformationId",carProductInformationId);
		map1.put("dp",downPaymentsMin);
		productInformationCarService.updateDp(map1);

		Map<String,Object> map2 = new HashMap<>();
		map2.put("carProductInformationId",carProductInformationId);
		map2.put("term",termMax);
		map2.put("rate",rate);
		productInformationCarService.updateTerm(map2);
		System.out.println("--------------------匹配最低首付及期限结束-------------------------------------------------------------------->");
	}
}
