package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 首页营销模块
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class MarketingDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer marketingId;
	//营销名
	private String name;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//排序
	private Integer sort;
	//0 停用 1启用
	private Integer state;

	private String time;

	public String getTime() {
		return startTime+"--"+endTime;
	}

	/**
	 * 设置：
	 */
	public void setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
	}
	/**
	 * 获取：
	 */
	public Integer getMarketingId() {
		return marketingId;
	}
	/**
	 * 设置：营销名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：营销名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：0 停用 1启用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0 停用 1启用
	 */
	public Integer getState() {
		return state;
	}
}
