package com.bootdo.OrderManage.domain;

import com.bootdo.common.utils.TimeUtils;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:59:48
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单ID
	private Integer orderId;
	//车贷产品ID
	private Integer carProductId;
	//车贷产品补充表ID
	private Integer carProductInformationId;
	//车款ID
	private Integer carId;
	//用户ID
	private Integer userId;
	//车贷商家ID
	private Integer loanBusinessId;
	//车贷商家名字
	private String loanBusinessName;
	//汽车经销商ID
	private Integer carBusinessId;
	//汽车经销商名字
	private String carBusinessName;
	//首付比例
	private Double payments;
	//贷款期数
	private Integer term;
	//贷款利率
	private Double rate;
	//1 厂商指导价(car_car表种的) 2 裸车价(经销商报的价)
	private String offerType;
	//车价
	private Integer carPrice;
	//申请渠道
	private String channel;
	//申请时间
	private Date applyTime;
	//状态(状态分的比较大,中间留几个做扩展) 0(用户删除）  1 待审核 2 取消  5 待提车  6 待评论
	private Integer state;
	//状态更新时间
	private Date updateTime;

	/*------------------------------------------------------------------------------------------------*/

	private String carProductName;
	private String carProductInformationName;
	private String carName;
	private String applyTimeString;
	private String updateTimeString;

	public String getApplyTimeString() {
		return TimeUtils.timeToString(applyTime,null);
	}

	public String getUpdateTimeString() {
		return TimeUtils.timeToString(updateTime,null);
	}

	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}

	public void setCarProductInformationName(String carProductInformationName) {
		this.carProductInformationName = carProductInformationName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarProductName() {
		return carProductName;
	}

	public String getCarProductInformationName() {
		return carProductInformationName;
	}

	public String getCarName() {
		return carName;
	}

	/*------------------------------------------------------------------------------------------------*/

	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
	}
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
	 * 设置：车贷产品补充表ID
	 */
	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}
	/**
	 * 获取：车贷产品补充表ID
	 */
	public Integer getCarProductInformationId() {
		return carProductInformationId;
	}
	/**
	 * 设置：车款ID
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车款ID
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：车贷商家ID
	 */
	public void setLoanBusinessId(Integer loanBusinessId) {
		this.loanBusinessId = loanBusinessId;
	}
	/**
	 * 获取：车贷商家ID
	 */
	public Integer getLoanBusinessId() {
		return loanBusinessId;
	}
	/**
	 * 设置：车贷商家名字
	 */
	public void setLoanBusinessName(String loanBusinessName) {
		this.loanBusinessName = loanBusinessName;
	}
	/**
	 * 获取：车贷商家名字
	 */
	public String getLoanBusinessName() {
		return loanBusinessName;
	}
	/**
	 * 设置：汽车经销商ID
	 */
	public void setCarBusinessId(Integer carBusinessId) {
		this.carBusinessId = carBusinessId;
	}
	/**
	 * 获取：汽车经销商ID
	 */
	public Integer getCarBusinessId() {
		return carBusinessId;
	}
	/**
	 * 设置：汽车经销商名字
	 */
	public void setCarBusinessName(String carBusinessName) {
		this.carBusinessName = carBusinessName;
	}
	/**
	 * 获取：汽车经销商名字
	 */
	public String getCarBusinessName() {
		return carBusinessName;
	}
	/**
	 * 设置：首付比例
	 */
	public void setPayments(Double payments) {
		this.payments = payments;
	}
	/**
	 * 获取：首付比例
	 */
	public Double getPayments() {
		return payments;
	}
	/**
	 * 设置：贷款期数
	 */
	public void setTerm(Integer term) {
		this.term = term;
	}
	/**
	 * 获取：贷款期数
	 */
	public Integer getTerm() {
		return term;
	}
	/**
	 * 设置：贷款利率
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/**
	 * 获取：贷款利率
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * 设置：1 厂商指导价(car_car表种的) 2 裸车价(经销商报的价)
	 */
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	/**
	 * 获取：1 厂商指导价(car_car表种的) 2 裸车价(经销商报的价)
	 */
	public String getOfferType() {
		return offerType;
	}
	/**
	 * 设置：车价
	 */
	public void setCarPrice(Integer carPrice) {
		this.carPrice = carPrice;
	}
	/**
	 * 获取：车价
	 */
	public Integer getCarPrice() {
		return carPrice;
	}
	/**
	 * 设置：申请渠道
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：申请渠道
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 设置：申请时间
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * 获取：申请时间
	 */
	public String getApplyTime() {
		return TimeUtils.timeToString(applyTime,null);
	}
	/**
	 * 设置：状态(状态分的比较大,中间留几个做扩展) 0(用户删除）  1 待审核 2 取消  5 待提车  6 待评论
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态(状态分的比较大,中间留几个做扩展) 0(用户删除）  1 待审核 2 取消  5 待提车  6 待评论
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：状态更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：状态更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
