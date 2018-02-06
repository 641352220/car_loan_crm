package com.bootdo.UserManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户信息补充表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
public class UserInformationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Integer userId;
	//姓名
	private String name;
	//身份证
	private String idNum;
	//上牌省份
	private String carProvince;
	//上牌城市
	private String carCity;
	//上牌区县
	private String carArea;
	//居住省份
	private String liveProvince;
	//居住城市
	private String liveCity;
	//居住区县
	private String liveArea;
	//居住详细地址
	private String liveAddress;

	/*------------------------------------------------------------------------------------*/

	private String carAddress;

	public String getCarAddress() {
		return carProvince +" "+carCity+" "+carArea;
	}

	/*------------------------------------------------------------------------------------*/


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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证
	 */
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdNum() {
		return idNum;
	}
	/**
	 * 设置：上牌省份
	 */
	public void setCarProvince(String carProvince) {
		this.carProvince = carProvince;
	}
	/**
	 * 获取：上牌省份
	 */
	public String getCarProvince() {
		return carProvince;
	}
	/**
	 * 设置：上牌城市
	 */
	public void setCarCity(String carCity) {
		this.carCity = carCity;
	}
	/**
	 * 获取：上牌城市
	 */
	public String getCarCity() {
		return carCity;
	}
	/**
	 * 设置：上牌区县
	 */
	public void setCarArea(String carArea) {
		this.carArea = carArea;
	}
	/**
	 * 获取：上牌区县
	 */
	public String getCarArea() {
		return carArea;
	}
	/**
	 * 设置：居住省份
	 */
	public void setLiveProvince(String liveProvince) {
		this.liveProvince = liveProvince;
	}
	/**
	 * 获取：居住省份
	 */
	public String getLiveProvince() {
		return liveProvince;
	}
	/**
	 * 设置：居住城市
	 */
	public void setLiveCity(String liveCity) {
		this.liveCity = liveCity;
	}
	/**
	 * 获取：居住城市
	 */
	public String getLiveCity() {
		return liveCity;
	}
	/**
	 * 设置：居住区县
	 */
	public void setLiveArea(String liveArea) {
		this.liveArea = liveArea;
	}
	/**
	 * 获取：居住区县
	 */
	public String getLiveArea() {
		return liveArea;
	}
	/**
	 * 设置：居住详细地址
	 */
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	/**
	 * 获取：居住详细地址
	 */
	public String getLiveAddress() {
		return liveProvince+" "+liveCity+" "+liveCity+" "+liveAddress;
	}
}
