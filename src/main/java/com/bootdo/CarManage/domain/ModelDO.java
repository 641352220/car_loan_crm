package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车型(例如奥迪A8)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ModelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车型Id
	private Integer carModelId;
	//子公司ID
	private Integer subsidiaryId;
	//品牌Id
	private Integer brandId;
	//
	private String brandName;
	//型号
	private String modelName;
	//logo
	private String logo;
	//销售状态
	private String saleState;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/**
	 * 设置：车型Id
	 */
	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}
	/**
	 * 获取：车型Id
	 */
	public Integer getCarModelId() {
		return carModelId;
	}
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
	 * 设置：品牌Id
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌Id
	 */
	public Integer getBrandId() {
		return brandId;
	}
	/**
	 * 设置：
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取：
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 设置：型号
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	/**
	 * 获取：型号
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 设置：logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：销售状态
	 */
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
	/**
	 * 获取：销售状态
	 */
	public String getSaleState() {
		return saleState;
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
