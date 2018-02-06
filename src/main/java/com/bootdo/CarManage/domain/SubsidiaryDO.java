package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 子公司(例如一汽奥迪)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class SubsidiaryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//子公司ID
	private Integer subsidiaryId;
	//品牌ID
	private Integer brandId;
	//子公司名字
	private String subsidiaryName;

	/**
	 * 设置：子公司ID
	 */
	public void setSubsidiaryId(Integer subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}
	/**
	 * 获取：子公司ID
	 */
	public Integer getSubsidiaryId() {
		return subsidiaryId;
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
	/**
	 * 设置：子公司名字
	 */
	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
	}
	/**
	 * 获取：子公司名字
	 */
	public String getSubsidiaryName() {
		return subsidiaryName;
	}
}
