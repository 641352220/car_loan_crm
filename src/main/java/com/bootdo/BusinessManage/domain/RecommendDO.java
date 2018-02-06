package com.bootdo.BusinessManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商家推荐表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public class RecommendDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商家Id
	private Integer businessId;
	//车型ID
	private Integer carId;
	//
	private Integer sort;
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
	 * 设置：商家Id
	 */
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：商家Id
	 */
	public Integer getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：车型ID
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车型ID
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
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
