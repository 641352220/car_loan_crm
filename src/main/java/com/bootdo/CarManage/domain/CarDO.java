package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车型下具体的某款车
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class CarDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车款Id
	private Integer carId;
	//车型ID
	private Integer carModelId;
	//子公司ID
	private Integer subsidiaryId;
	//品牌ID
	private Integer brandId;
	//款式(2016款 Sportback 35TFSI 进取型)
	private String styleName;
	//型号(A3)
	private String modelName;
	//子公司名字
	private String subsidiaryName;
	//品牌名(奥迪)
	private String brandName;
	//logo
	private String logo;
	//厂商指导价格
	private String price;
	//商家报价(13.13万-18.47万)
	private String salePrice;
	//年款(2016款)
	private String yearType;
	//生产状态(在产)
	private String productionState;
	//销售状态(在销)
	private String saleState;
	//车辆等级(紧凑型车)
	private String sizeType;
	//综合工况油耗(L/100km)
	private String oilConsumption;
	//排量(L)
	private String displacement;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/*----------------------------------------------------------------*/

	private Integer priceMin;

	public Integer getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}

	private String carName;

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	private Integer sf;

	public void setSf(Integer sf) {
		this.sf = sf;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	/*----------------------------------------------------------------*/

	/**
	 * 设置：车款Id
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车款Id
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
	 * 设置：品牌ID
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌ID
	 */
	public Integer getBrandId() {
		return brandId;
	}
	/**
	 * 设置：款式(2016款 Sportback 35TFSI 进取型)
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	/**
	 * 获取：款式(2016款 Sportback 35TFSI 进取型)
	 */
	public String getStyleName() {
		return styleName;
	}
	/**
	 * 设置：型号(A3)
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	/**
	 * 获取：型号(A3)
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 设置：子公司名字
	 */
	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
	}
	/**
	 * 获取：子公司名字
	 */
	public String getSubsidiaryName() {
		return subsidiaryName;
	}
	/**
	 * 设置：品牌名(奥迪)
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取：品牌名(奥迪)
	 */
	public String getBrandName() {
		return brandName;
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
	 * 设置：厂商指导价格
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：厂商指导价格
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：商家报价(13.13万-18.47万)
	 */
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * 获取：商家报价(13.13万-18.47万)
	 */
	public String getSalePrice() {
		return salePrice;
	}
	/**
	 * 设置：年款(2016款)
	 */
	public void setYearType(String yearType) {
		this.yearType = yearType;
	}
	/**
	 * 获取：年款(2016款)
	 */
	public String getYearType() {
		return yearType;
	}
	/**
	 * 设置：生产状态(在产)
	 */
	public void setProductionState(String productionState) {
		this.productionState = productionState;
	}
	/**
	 * 获取：生产状态(在产)
	 */
	public String getProductionState() {
		return productionState;
	}
	/**
	 * 设置：销售状态(在销)
	 */
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
	/**
	 * 获取：销售状态(在销)
	 */
	public String getSaleState() {
		return saleState;
	}
	/**
	 * 设置：车辆等级(紧凑型车)
	 */
	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}
	/**
	 * 获取：车辆等级(紧凑型车)
	 */
	public String getSizeType() {
		return sizeType;
	}
	/**
	 * 设置：综合工况油耗(L/100km)
	 */
	public void setOilConsumption(String oilConsumption) {
		this.oilConsumption = oilConsumption;
	}
	/**
	 * 获取：综合工况油耗(L/100km)
	 */
	public String getOilConsumption() {
		return oilConsumption;
	}
	/**
	 * 设置：排量(L)
	 */
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	/**
	 * 获取：排量(L)
	 */
	public String getDisplacement() {
		return displacement;
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
