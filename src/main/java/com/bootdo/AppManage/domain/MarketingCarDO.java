package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 首页营销关联汽车表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class MarketingCarDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer appMarketingCarId;
	//营销ID
	private Integer marketingId;
	//汽车ID
	private Integer carId;
	//广告语
	private String adver;

	/**产品ID */
	private Integer carProductId;

	/**方案ID */
	private Integer carProductInformationId;

	public void setCarProductId(Integer carProductId) {
		this.carProductId = carProductId;
	}

	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}

	public Integer getCarProductId() {
		return carProductId;
	}

	public Integer getCarProductInformationId() {
		return carProductInformationId;
	}

	/*-----------------------------------------------------------------------------------*/
	//营销名
	private String marketingName;
	//拼接的车子名
	private String carName;
	//车贷产品名
	private String carProductName;
    //方案名
	private String carProductInformationName;

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}

	public void setCarProductInformationName(String carProductInformationName) {
		this.carProductInformationName = carProductInformationName;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarProductName() {
		return carProductName;
	}

	public String getCarProductInformationName() {
		return carProductInformationName;
	}

	/*-----------------------------------------------------------------------------------*/

	/**
	 * 设置：
	 */
	public void setAppMarketingCarId(Integer appMarketingCarId) {
		this.appMarketingCarId = appMarketingCarId;
	}
	/**
	 * 获取：
	 */
	public Integer getAppMarketingCarId() {
		return appMarketingCarId;
	}
	/**
	 * 设置：营销ID
	 */
	public void setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
	}
	/**
	 * 获取：营销ID
	 */
	public Integer getMarketingId() {
		return marketingId;
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
}
