package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车贷产品期数及首付比例配置
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class LoanConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer loanConfigId;
	//1 首付配置 2 期数配置
	private String type;
	//配置的值
	private String configValue;

	/*--------------------------------------------------*/

	private Integer sf;

	private Double rate;

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getSf() {
		return sf;
	}

	public void setSf(Integer sf) {
		this.sf = sf;
	}

	/*--------------------------------------------------*/
	/**
	 * 设置：
	 */
	public void setLoanConfigId(Integer loanConfigId) {
		this.loanConfigId = loanConfigId;
	}
	/**
	 * 获取：
	 */
	public Integer getLoanConfigId() {
		return loanConfigId;
	}
	/**
	 * 设置：1 首付配置 2 期数配置
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1 首付配置 2 期数配置
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：配置的值
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	/**
	 * 获取：配置的值
	 */
	public String getConfigValue() {
		return configValue;
	}
}
