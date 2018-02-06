package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 标签表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class LabelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer labelId;
	//1汽车产品标签 2经销商标签 3 汽车产品优惠标签  4 报价标签 5 首页营销模块标签
	private String type;
	//标签名
	private String name;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/*-----------------------------------------------------------------------------------------------------------------------------------*/

	private Integer sf;

	public Integer getSf() {
		return sf;
	}

	public void setSf(Integer sf) {
		this.sf = sf;
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 设置：
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	/**
	 * 获取：
	 */
	public Integer getLabelId() {
		return labelId;
	}
	/**
	 * 设置：1汽车产品标签 2经销商标签 3 汽车产品优惠标签  4 报价标签 5 首页营销模块标签
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1汽车产品标签 2经销商标签 3 汽车产品优惠标签  4 报价标签 5 首页营销模块标签
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：标签名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：标签名
	 */
	public String getName() {
		return name;
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
