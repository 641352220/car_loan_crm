package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 品牌
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class BrandDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//品牌Id
	private Integer brandId;
	//品牌名
	private String brandName;
	//首字母
	private String initial;
	//LOGO
	private String logo;
	//是否热门 0否 1是
	private Integer isItHot;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/*-----------------------------------------------------------------------------------------------------------------------------*/

	private Integer sf;

	public Integer getSf() {
		return sf;
	}

	public void setSf(Integer sf) {
		this.sf = sf;
	}

	/*-----------------------------------------------------------------------------------------------------------------------------*/

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
	 * 设置：品牌名
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取：品牌名
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 设置：首字母
	 */
	public void setInitial(String initial) {
		this.initial = initial;
	}
	/**
	 * 获取：首字母
	 */
	public String getInitial() {
		return initial;
	}
	/**
	 * 设置：LOGO
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：LOGO
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：是否热门 0否 1是
	 */
	public void setIsItHot(Integer isItHot) {
		this.isItHot = isItHot;
	}
	/**
	 * 获取：是否热门 0否 1是
	 */
	public Integer getIsItHot() {
		return isItHot;
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
