package com.bootdo.AdverManage.domain;

import com.bootdo.common.utils.TimeUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 爆款车辆
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-03 11:10:04
 */
public class AdverCarDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer adverCarId;
	//广告名
	private String name;
	//图片地址
	private String img;
	//1 原生 2 H5
	private String type;
	//链接
	private String url;
	//车贷产品ID
	private Integer carProductId;
	//方案ID
	private Integer carProductInformationId;
	//汽车ID
	private Integer carId;
	//排序
	private Integer sort;
	//0启用 1停用
	private Integer state;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/*----------------------------------------------------------------------------------------------------*/

	//车贷产品名
	private String carProductName;
	//汽车拼接名
	private String carName;
	//汽车ID
	private Integer carModelId;
	//汽车ID
	private Integer brandId;

	//开始时间
	private String startTimeString;
	//结束时间
	private String endTimeString;

	public String getStartTimeString() {
		return TimeUtils.timeToString(startTime,null);
	}

	public String getEndTimeString() {
		return TimeUtils.timeToString(endTime,null);
	}

	public Integer getCarModelId() {
		return carModelId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getCarProductName() {
		return carProductName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	//开始时间/结束时间
	private String startAndEndTime;

	public String getStartAndEndTime() {
		return TimeUtils.timeToString(startTime,null)+"--"+ TimeUtils.timeToString(endTime,null);
	}

	/*----------------------------------------------------------------------------------------------------*/

	/**
	 * 设置：
	 */
	public void setAdverCarId(Integer adverCarId) {
		this.adverCarId = adverCarId;
	}
	/**
	 * 获取：
	 */
	public Integer getAdverCarId() {
		return adverCarId;
	}
	/**
	 * 设置：广告名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：广告名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：图片地址
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：1 原生 2 H5
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1 原生 2 H5
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接
	 */
	public String getUrl() {
		return url;
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
	 * 设置：方案ID
	 */
	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}
	/**
	 * 获取：方案ID
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
	 * 设置：0启用 1停用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0启用 1停用
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
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
		return "AdverCarDO{" +
				"adverCarId=" + adverCarId +
				", name='" + name + '\'' +
				", img='" + img + '\'' +
				", type='" + type + '\'' +
				", url='" + url + '\'' +
				", carProductId=" + carProductId +
				", carProductInformationId=" + carProductInformationId +
				", carId=" + carId +
				", sort=" + sort +
				", state=" + state +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", createBy=" + createBy +
				", createDate=" + createDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				", carProductName='" + carProductName + '\'' +
				", carName='" + carName + '\'' +
				", carModelId=" + carModelId +
				", brandId=" + brandId +
				", startTimeString='" + startTimeString + '\'' +
				", endTimeString='" + endTimeString + '\'' +
				", startAndEndTime='" + startAndEndTime + '\'' +
				'}';
	}
}
