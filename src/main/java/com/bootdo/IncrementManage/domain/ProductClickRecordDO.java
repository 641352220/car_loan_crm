package com.bootdo.IncrementManage.domain;

import com.bootdo.common.utils.TimeUtils;

import java.io.Serializable;
import java.util.Date;



/**
 * 增值产品点击记录
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:12
 */
public class ProductClickRecordDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer incrementProductId;
	//1 贷款产品 2 车险 3 信用卡
	private String type;
	//
	private Integer userId;
	//
	private Date clickTime;
	//
	private String channel;

	/*--------------------------------------------------------------------------------------------*/

	private String incrementProductName;

	private String clickTimeString;

	public String getClickTimeString() {
		return TimeUtils.timeToString(clickTime,null);
	}

	public void setIncrementProductName(String incrementProductName) {
		this.incrementProductName = incrementProductName;
	}

	public String getIncrementProductName() {
		return incrementProductName;
	}

	/*--------------------------------------------------------------------------------------------*/

	/**
	 * 设置：
	 */
	public void setIncrementProductId(Integer incrementProductId) {
		this.incrementProductId = incrementProductId;
	}
	/**
	 * 获取：
	 */
	public Integer getIncrementProductId() {
		return incrementProductId;
	}
	/**
	 * 设置：1 贷款产品 2 车险 3 信用卡
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1 贷款产品 2 车险 3 信用卡
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setClickTime(Date clickTime) {
		this.clickTime = clickTime;
	}
	/**
	 * 获取：
	 */
	public Date getClickTime() {
		return clickTime;
	}
	/**
	 * 设置：
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：
	 */
	public String getChannel() {
		return channel;
	}
}
