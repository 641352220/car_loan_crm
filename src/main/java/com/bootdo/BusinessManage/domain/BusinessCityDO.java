package com.bootdo.BusinessManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商家城市关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public class BusinessCityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商家ID
	private Integer businessId;
	//城市ID
	private Integer cityId;
	//级别 1 区域 2 省 3 市 4区
	private Integer level;

	public BusinessCityDO(Integer businessId, Integer cityId, Integer level) {
		this.businessId = businessId;
		this.cityId = cityId;
		this.level = level;
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
	 * 设置：城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：级别 1 区域 2 省 3 市 4区
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：级别 1 区域 2 省 3 市 4区
	 */
	public Integer getLevel() {
		return level;
	}
}
