package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车产品补充表关联汽车表,一个方案支持多款车
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ProductInformationCarDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商家ID
	private Integer businessId;
	//汽车产品补充表id
	private Integer carProductInformationId;
	//汽车ID
	private Integer carId;
	//车型ID
	private Integer carModelId;
	//车贷产品ID
	private Integer carProductId;
	//最新最低车价
	private Integer carPrice;
	//该产品的该方案的最低首付(没精确到车,重点注意)
	private Double downPaymentsMin;
	//最长的贷款期限(没精确到车,重点注意)
	private Integer termMax;
	//对应贷款期限的贷款利率(没精确到车,重点注意)
	private Double rate;
	//排序
	private Integer sort;

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
	 * 设置：汽车产品补充表id
	 */
	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}
	/**
	 * 获取：汽车产品补充表id
	 */
	public Integer getCarProductInformationId() {
		return carProductInformationId;
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
	 * 设置：最新最低车价
	 */
	public void setCarPrice(Integer carPrice) {
		this.carPrice = carPrice;
	}
	/**
	 * 获取：最新最低车价
	 */
	public Integer getCarPrice() {
		return carPrice;
	}
	/**
	 * 设置：该产品的该方案的最低首付(没精确到车,重点注意)
	 */
	public void setDownPaymentsMin(Double downPaymentsMin) {
		this.downPaymentsMin = downPaymentsMin;
	}
	/**
	 * 获取：该产品的该方案的最低首付(没精确到车,重点注意)
	 */
	public Double getDownPaymentsMin() {
		return downPaymentsMin;
	}
	/**
	 * 设置：最长的贷款期限(没精确到车,重点注意)
	 */
	public void setTermMax(Integer termMax) {
		this.termMax = termMax;
	}
	/**
	 * 获取：最长的贷款期限(没精确到车,重点注意)
	 */
	public Integer getTermMax() {
		return termMax;
	}
	/**
	 * 设置：对应贷款期限的贷款利率(没精确到车,重点注意)
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/**
	 * 获取：对应贷款期限的贷款利率(没精确到车,重点注意)
	 */
	public Double getRate() {
		return rate;
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

	@Override
	public String toString() {
		return "ProductInformationCarDO{" +
				"businessId=" + businessId +
				", carProductInformationId=" + carProductInformationId +
				", carId=" + carId +
				", carModelId=" + carModelId +
				", carProductId=" + carProductId +
				", carPrice=" + carPrice +
				", downPaymentsMin=" + downPaymentsMin +
				", termMax=" + termMax +
				", rate=" + rate +
				", sort=" + sort +
				'}';
	}


}
