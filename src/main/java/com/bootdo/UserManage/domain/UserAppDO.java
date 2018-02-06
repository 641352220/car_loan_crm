package com.bootdo.UserManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
public class UserAppDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer userId;
	//
	private String nickName;
	//头像
	private String headPortrait;
	//登录类型 1 手机 2 微信 3QQ 4支付宝
	private String loginType;
	//手机号
	private String phone;
	//微信标识
	private String vxMarking;
	//QQ标识
	private String qqMarking;
	//支付宝标识
	private String zfbMarking;
	//密码
	private String password;
	//注册时间
	private Date time;
	//登录时间
	private Date loginTime;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//省份
	private String province;
	//市
	private String city;
	//区/县
	private String area;
	//详细地址
	private String address;
	//0 正常 1停用
	private Integer state;

	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadPortrait() {
		return headPortrait;
	}
	/**
	 * 设置：登录类型 1 手机 2 微信 3QQ 4支付宝
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	/**
	 * 获取：登录类型 1 手机 2 微信 3QQ 4支付宝
	 */
	public String getLoginType() {
		return loginType;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：微信标识
	 */
	public void setVxMarking(String vxMarking) {
		this.vxMarking = vxMarking;
	}
	/**
	 * 获取：微信标识
	 */
	public String getVxMarking() {
		return vxMarking;
	}
	/**
	 * 设置：QQ标识
	 */
	public void setQqMarking(String qqMarking) {
		this.qqMarking = qqMarking;
	}
	/**
	 * 获取：QQ标识
	 */
	public String getQqMarking() {
		return qqMarking;
	}
	/**
	 * 设置：支付宝标识
	 */
	public void setZfbMarking(String zfbMarking) {
		this.zfbMarking = zfbMarking;
	}
	/**
	 * 获取：支付宝标识
	 */
	public String getZfbMarking() {
		return zfbMarking;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：注册时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * 设置：登录时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * 获取：登录时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区/县
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区/县
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return province+"-"+city+"-"+area+"-"+address;
	}
	/**
	 * 设置：0 正常 1停用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0 正常 1停用
	 */
	public Integer getState() {
		return state;
	}
}
