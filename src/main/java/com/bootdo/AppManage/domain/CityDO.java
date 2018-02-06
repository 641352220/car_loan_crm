package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 城市表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class CityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//城市ID
	private Integer cityId;
	//父ID
	private Integer pid;
	//名字
	private String name;
	//级别
	private Integer level;
	//首字符
	private String initials;
	//全拼
	private String pinyin;

	/*-----------------------------------------------------------------------------*/

	private Integer sf;

	public Integer getSf() {
		return sf;
	}

	public void setSf(Integer sf) {
		this.sf = sf;
	}

	/*-----------------------------------------------------------------------------*/

	/**
	 * 设置：城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：父ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父ID
	 */
	public Integer getPid() {
		return pid;
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
	 * 设置：级别
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：级别
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：首字符
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}
	/**
	 * 获取：首字符
	 */
	public String getInitials() {
		return initials;
	}
	/**
	 * 设置：全拼
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	/**
	 * 获取：全拼
	 */
	public String getPinyin() {
		return pinyin;
	}
}
