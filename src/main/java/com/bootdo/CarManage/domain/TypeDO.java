package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车类型表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class TypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer carTypeId;
	//汽车类型名
	private String carTypeName;
	//排序
	private Integer sort;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/**
	 * 设置：
	 */
	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}
	/**
	 * 获取：
	 */
	public Integer getCarTypeId() {
		return carTypeId;
	}
	/**
	 * 设置：汽车类型名
	 */
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	/**
	 * 获取：汽车类型名
	 */
	public String getCarTypeName() {
		return carTypeName;
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
