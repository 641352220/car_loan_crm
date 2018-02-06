package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车详情(很多字段的那个)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class DetailsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer carDetailsId;
	//
	private Integer carId;
	//汽车详情
	private String details;

	/**
	 * 设置：
	 */
	public void setCarDetailsId(Integer carDetailsId) {
		this.carDetailsId = carDetailsId;
	}
	/**
	 * 获取：
	 */
	public Integer getCarDetailsId() {
		return carDetailsId;
	}
	/**
	 * 设置：
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：汽车详情
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * 获取：汽车详情
	 */
	public String getDetails() {
		return details;
	}
}
