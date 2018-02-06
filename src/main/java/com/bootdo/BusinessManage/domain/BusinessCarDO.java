package com.bootdo.BusinessManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商家支持的汽车(经销商)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public class BusinessCarDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商家ID
	private Integer businessId;
	//品牌ID
	private Integer brandId;

	public BusinessCarDO(Integer businessId, Integer brandId) {
		this.businessId = businessId;
		this.brandId = brandId;
	}

	/**
	 * 设置：商家ID
	 */
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：商家ID
	 */
	public Integer getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：品牌ID
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌ID
	 */
	public Integer getBrandId() {
		return brandId;
	}
}
