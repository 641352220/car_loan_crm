package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车贷报价方案期限利率详情表,一个方案可以有多条首付和期限
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ProductInformationConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车贷产品报价方案ID
	private Integer carProductInformationId;
	//车贷配置ID
	private Integer loanConfigId;
	//1 首付配置 2 期数配置
	private Integer type;
	//具体的值
	private String value;
	//当type为期数配置的时候有利率的具体值的
	private Double rate;

	/**
	 * 设置：车贷产品报价方案ID
	 */
	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}
	/**
	 * 获取：车贷产品报价方案ID
	 */
	public Integer getCarProductInformationId() {
		return carProductInformationId;
	}
	/**
	 * 设置：车贷配置ID
	 */
	public void setLoanConfigId(Integer loanConfigId) {
		this.loanConfigId = loanConfigId;
	}
	/**
	 * 获取：车贷配置ID
	 */
	public Integer getLoanConfigId() {
		return loanConfigId;
	}
	/**
	 * 设置：1 首付配置 2 期数配置
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1 首付配置 2 期数配置
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：具体的值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：具体的值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：当type为期数配置的时候有利率的具体值的
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/**
	 * 获取：当type为期数配置的时候有利率的具体值的
	 */
	public Double getRate() {
		return rate;
	}

	@Override
	public String toString() {
		return "ProductInformationConfigDO{" +
				"carProductInformationId=" + carProductInformationId +
				", loanConfigId=" + loanConfigId +
				", type=" + type +
				", value='" + value + '\'' +
				", rate=" + rate +
				'}';
	}


}
