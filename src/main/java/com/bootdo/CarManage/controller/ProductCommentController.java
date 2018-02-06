package com.bootdo.CarManage.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.service.ProductService;
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

import com.bootdo.CarManage.domain.ProductCommentDO;
import com.bootdo.CarManage.service.ProductCommentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 车贷产品评价表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/productComment")
public class ProductCommentController {
	@Autowired
	private ProductCommentService productCommentService;
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:productComment:productComment")
	String ProductComment(){
	    return "CarManage/productComment/productComment";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:productComment:productComment")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductCommentDO> productCommentList = productCommentService.list(query);
		int total = productCommentService.count(query);
		PageUtils pageUtils = new PageUtils(productCommentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:productComment:add")
	String add(){
	    return "CarManage/productComment/add";
	}

	@GetMapping("/edit/{carProductCommentId}")
	@RequiresPermissions("CarManage:productComment:edit")
	String edit(@PathVariable("carProductCommentId") Integer carProductCommentId,Model model){
		ProductCommentDO productComment = productCommentService.get(carProductCommentId);
		model.addAttribute("productComment", productComment);
	    return "CarManage/productComment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:productComment:add")
	public R save( ProductCommentDO productComment){
		if(productCommentService.save(productComment)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:productComment:edit")
	public R update( ProductCommentDO productComment){
		productCommentService.update(productComment);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/pass")
	@ResponseBody
	@RequiresPermissions("CarManage:productComment:pass")
	public R remove( Integer carProductCommentId){
		ProductCommentDO productComment = productCommentService.get(carProductCommentId);
		productComment.setState(1);
		productCommentService.update(productComment);
		Integer pjf = productCommentService.getPJF(productComment.getCarProductId());
		productService.updateComment(productComment.getCarProductId(),pjf);
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:productComment:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carProductCommentIds){
		productCommentService.batchRemove(carProductCommentIds);
		return R.ok();
	}
	
}
