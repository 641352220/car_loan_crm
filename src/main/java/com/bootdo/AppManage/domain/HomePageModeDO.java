package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 模块表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class HomePageModeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer homePageModeId;
	//名字
	private String name;
	//
	private String logoNoClick;
	//logo
	private String logoClick;
	//0 不能点击 1能点击
	private Integer click;
	//1 tab栏 2 首页模块 3 品牌 4 首付  5新车贷车价
	private String position;
	//1 原生 2 H5
	private String jumpType;
	//跳转链接
	private String jumpUrl;
	//品牌ID 当位置为3并且跳转类型为原生时该字段有值
	private Integer brandId;
	//最低
	private Integer min;
	//最大
	private Integer max;
	//排序
	private Integer sort;
	//0停用 1启用
	private Integer state;
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
	public void setHomePageModeId(Integer homePageModeId) {
		this.homePageModeId = homePageModeId;
	}
	/**
	 * 获取：
	 */
	public Integer getHomePageModeId() {
		return homePageModeId;
	}
	/**
	 * 设置：名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setLogoNoClick(String logoNoClick) {
		this.logoNoClick = logoNoClick;
	}
	/**
	 * 获取：
	 */
	public String getLogoNoClick() {
		return logoNoClick;
	}
	/**
	 * 设置：logo
	 */
	public void setLogoClick(String logoClick) {
		this.logoClick = logoClick;
	}
	/**
	 * 获取：logo
	 */
	public String getLogoClick() {
		return logoClick;
	}
	/**
	 * 设置：0 不能点击 1能点击
	 */
	public void setClick(Integer click) {
		this.click = click;
	}
	/**
	 * 获取：0 不能点击 1能点击
	 */
	public Integer getClick() {
		return click;
	}
	/**
	 * 设置：1 tab栏 2 首页模块 3 品牌 4 首付  5新车贷车价
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：1 tab栏 2 首页模块 3 品牌 4 首付  5新车贷车价
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：1 原生 2 H5
	 */
	public void setJumpType(String jumpType) {
		this.jumpType = jumpType;
	}
	/**
	 * 获取：1 原生 2 H5
	 */
	public String getJumpType() {
		return jumpType;
	}
	/**
	 * 设置：跳转链接
	 */
	public void setJumpUrl(String jumpUrl) { this.jumpUrl = jumpUrl; }
	/**
	 * 获取：跳转链接
	 */
	public String getJumpUrl() {
		return jumpUrl;
	}
	/**
	 * 设置：品牌ID 当位置为3并且跳转类型为原生时该字段有值
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌ID 当位置为3并且跳转类型为原生时该字段有值
	 */
	public Integer getBrandId() {
		return brandId;
	}
	/**
	 * 设置：最低
	 */
	public void setMin(Integer min) {
		this.min = min;
	}
	/**
	 * 获取：最低
	 */
	public Integer getMin() {
		return min;
	}
	/**
	 * 设置：最大
	 */
	public void setMax(Integer max) {
		this.max = max;
	}
	/**
	 * 获取：最大
	 */
	public Integer getMax() {
		return max;
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
	 * 设置：0停用 1启用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0停用 1启用
	 */
	public Integer getState() {
		return state;
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
		return "HomePageModeDO{" +
				"homePageModeId=" + homePageModeId +
				", name='" + name + '\'' +
				", logoNoClick='" + logoNoClick + '\'' +
				", logoClick='" + logoClick + '\'' +
				", click=" + click +
				", position='" + position + '\'' +
				", jumpType='" + jumpType + '\'' +
				", jumpUrl='" + jumpUrl + '\'' +
				", brandId=" + brandId +
				", min=" + min +
				", max=" + max +
				", sort=" + sort +
				", state=" + state +
				", createBy=" + createBy +
				", createDate=" + createDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				'}';
	}
}
