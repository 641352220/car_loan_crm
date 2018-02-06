package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车贷产品城市关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ProductCityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车贷产品ID
	private Integer carProductId;
	//
	private Integer cityId;
	//级别 1 区域 2 省 3 市 4区
	private Integer level;

	/**
	 * 设置：车贷产品ID
	 */
	public void setCarProductId(Integer carProductId) {
		this.carProductId = carProductId;
	}
	/**
	 * 获取：车贷产品ID
	 */
	public Integer getCarProductId() {
		return carProductId;
	}
	/**
	 * 设置：
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：
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
