package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车贷产品补充表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ProductInformationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//补充表id
	private Integer carProductInformationId;
	//方案名
	private String carProductInformationName;
	//商家ID
	private Integer businessId;
	//汽车产品ID
	private Integer carProductId;
	//申请人数
	private Integer applyNum;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/*------------------------------------------------------------------------------------------------------------------------------------------------------*/

	private String carProductName;

	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}

	public String getCarProductName() {
		return carProductName;
	}
	/*------------------------------------------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 设置：补充表id
	 */
	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}
	/**
	 * 获取：补充表id
	 */
	public Integer getCarProductInformationId() {
		return carProductInformationId;
	}
	/**
	 * 设置：方案名
	 */
	public void setCarProductInformationName(String carProductInformationName) {
		this.carProductInformationName = carProductInformationName;
	}
	/**
	 * 获取：方案名
	 */
	public String getCarProductInformationName() {
		return carProductInformationName;
	}
	/**
	 * 设置：商家ID
	 */
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：商家ID
	 */
	public Integer getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：汽车产品ID
	 */
	public void setCarProductId(Integer carProductId) {
		this.carProductId = carProductId;
	}
	/**
	 * 获取：汽车产品ID
	 */
	public Integer getCarProductId() {
		return carProductId;
	}
	/**
	 * 设置：申请人数
	 */
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}
	/**
	 * 获取：申请人数
	 */
	public Integer getApplyNum() {
		return applyNum;
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

	@Override
	public String toString() {
		return "ProductInformationDO{" +
				"carProductInformationId=" + carProductInformationId +
				", carProductInformationName='" + carProductInformationName + '\'' +
				", businessId=" + businessId +
				", carProductId=" + carProductId +
				", applyNum=" + applyNum +
				", createBy=" + createBy +
				", createDate=" + createDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				", carProductName='" + carProductName + '\'' +
				'}';
	}
}
