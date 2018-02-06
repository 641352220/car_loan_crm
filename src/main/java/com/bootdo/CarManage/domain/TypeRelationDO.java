package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汽车类型关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class TypeRelationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//汽车ID
	private Integer carId;
	//汽车类型ID
	private Integer carTypeId;
	//广告语
	private String adver;

	/**产品ID */
	private Integer carProductId;

	/**方案ID */
	private Integer carProductInformationId;

	/**------------------------------------------------------------------*/

	private String carTypeName;
	private String carName;
	private String carProductName;
	private String carProductInformationName;

	public String getCarTypeName() {
		return carTypeName;
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

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
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

	/**------------------------------------------------------------------*/

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
	 * 设置：汽车类型ID
	 */
	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}
	/**
	 * 获取：汽车类型ID
	 */
	public Integer getCarTypeId() {
		return carTypeId;
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
