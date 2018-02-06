package com.bootdo.UserManage.domain;

import com.bootdo.common.utils.TimeUtils;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户收藏表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
public class CollectionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//收藏ID
	private Integer collectionId;
	//车贷产品ID
	private Integer carProductId;
	//车贷产品补充ID
	private Integer carProductInformationId;
	//汽车ID
	private Integer carId;
	//收藏时间
	private Date collectionTime;
	//用户ID
	private Integer userId;
	//渠道
	private String channel;
	//0 正常 1 用户删除咯
	private Integer state;

	/*-----------------------------------------------------------------------------------------------------------------*/

	private String carProductName;
	private String carProductInformationName;
	private String carName;

	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}

	public void setCarProductInformationName(String carProductInformationName) {
		this.carProductInformationName = carProductInformationName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarProductName() {
		return carProductName;
	}

	public String getCarProductInformationName() {
		return carProductInformationName;
	}

	public String getCarName() {
		return carName;
	}

	/*-----------------------------------------------------------------------------------------------------------------*/


	/**
	 * 设置：收藏ID
	 */
	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}
	/**
	 * 获取：收藏ID
	 */
	public Integer getCollectionId() {
		return collectionId;
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
	 * 设置：车贷产品补充ID
	 */
	public void setCarProductInformationId(Integer carProductInformationId) {
		this.carProductInformationId = carProductInformationId;
	}
	/**
	 * 获取：车贷产品补充ID
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
	 * 设置：收藏时间
	 */
	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}
	/**
	 * 获取：收藏时间
	 */
	public String getCollectionTime() {
		return TimeUtils.timeToString(collectionTime,null);
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：渠道
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：渠道
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 设置：0 正常 1 用户删除咯
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0 正常 1 用户删除咯
	 */
	public Integer getState() {
		return state;
	}
}
