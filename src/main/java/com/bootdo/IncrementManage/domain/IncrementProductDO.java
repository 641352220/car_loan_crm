package com.bootdo.IncrementManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 增值产品表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:11
 */
public class IncrementProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//产品ID
	private Integer productId;
	//1 贷款产品 2 车险 3 信用卡
	private String type;
	//
	private Integer sort;
	//产品名
	private String name;
	//广告语
	private String adver;
	//最小金额
	private String moneyMin;
	//最大金额
	private String moneyMax;
	//最小期限
	private String termMin;
	//最大期限
	private String termMax;
	//申请链接
	private String applyUrl;
	//排序
	private String logo;
	//0正常 1停用
	private Integer state;

	/**
	 * 设置：产品ID
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品ID
	 */
	public Integer getProductId() {
		return productId;
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
	 * 设置：产品名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：产品名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：广告语
	 */
	public void setAdver(String adver) {
		this.adver = adver;
	}
	/**
	 * 获取：广告语
	 */
	public String getAdver() {
		return adver;
	}
	/**
	 * 设置：最小金额
	 */
	public void setMoneyMin(String moneyMin) {
		this.moneyMin = moneyMin;
	}
	/**
	 * 获取：最小金额
	 */
	public String getMoneyMin() {
		return moneyMin;
	}
	/**
	 * 设置：最大金额
	 */
	public void setMoneyMax(String moneyMax) {
		this.moneyMax = moneyMax;
	}
	/**
	 * 获取：最大金额
	 */
	public String getMoneyMax() {
		return moneyMax;
	}
	/**
	 * 设置：最小期限
	 */
	public void setTermMin(String termMin) {
		this.termMin = termMin;
	}
	/**
	 * 获取：最小期限
	 */
	public String getTermMin() {
		return termMin;
	}
	/**
	 * 设置：最大期限
	 */
	public void setTermMax(String termMax) {
		this.termMax = termMax;
	}
	/**
	 * 获取：最大期限
	 */
	public String getTermMax() {
		return termMax;
	}
	/**
	 * 设置：申请链接
	 */
	public void setApplyUrl(String applyUrl) {
		this.applyUrl = applyUrl;
	}
	/**
	 * 获取：申请链接
	 */
	public String getApplyUrl() {
		return applyUrl;
	}
	/**
	 * 设置：排序
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：排序
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：0正常 1停用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0正常 1停用
	 */
	public Integer getState() {
		return state;
	}

	@Override
	public String toString() {
		return "IncrementProductDO{" +
				"productId=" + productId +
				", type='" + type + '\'' +
				", sort=" + sort +
				", name='" + name + '\'' +
				", adver='" + adver + '\'' +
				", moneyMin='" + moneyMin + '\'' +
				", moneyMax='" + moneyMax + '\'' +
				", termMin='" + termMin + '\'' +
				", termMax='" + termMax + '\'' +
				", applyUrl='" + applyUrl + '\'' +
				", logo='" + logo + '\'' +
				", state=" + state +
				'}';
	}
}
