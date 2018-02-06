package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车报价表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class OfferDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//报价表ID
	private Integer offerId;
	//汽车ID
	private Integer carId;
	//车型ID
	private Integer carModelId;
	//1裸车价  2提车价
	private Integer offerType;
	//报价
	private Integer carOffer;
	//报价的商家ID
	private Integer businessId;
	//报价时间
	private Date offerTime;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/*--------------------------------------------------------------------------------------------*/

	private String carName;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	/*--------------------------------------------------------------------------------------------*/

	/**
	 * 设置：报价表ID
	 */
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	/**
	 * 获取：报价表ID
	 */
	public Integer getOfferId() {
		return offerId;
	}
	/**
	 * 设置：汽车ID
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：汽车ID
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：车型ID
	 */
	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}
	/**
	 * 获取：车型ID
	 */
	public Integer getCarModelId() {
		return carModelId;
	}
	/**
	 * 设置：1裸车价  2提车价
	 */
	public void setOfferType(Integer offerType) {
		this.offerType = offerType;
	}
	/**
	 * 获取：1裸车价  2提车价
	 */
	public Integer getOfferType() {
		return offerType;
	}
	/**
	 * 设置：报价
	 */
	public void setCarOffer(Integer carOffer) {
		this.carOffer = carOffer;
	}
	/**
	 * 获取：报价
	 */
	public Integer getCarOffer() {
		return carOffer;
	}
	/**
	 * 设置：报价的商家ID
	 */
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：报价的商家ID
	 */
	public Integer getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：报价时间
	 */
	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}
	/**
	 * 获取：报价时间
	 */
	public Date getOfferTime() {
		return offerTime;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：更新者
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新者
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
