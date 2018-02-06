package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 版本表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class EditionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//内部版本
	private Integer inEdition;
	//外部版本
	private String outEdition;
	//链接
	private String url;
	//更新内容
	private String remarks;
	//安卓渠道
	private String channel;
	//0不强制 1强制
	private Integer updateType;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：内部版本
	 */
	public void setInEdition(Integer inEdition) {
		this.inEdition = inEdition;
	}
	/**
	 * 获取：内部版本
	 */
	public Integer getInEdition() {
		return inEdition;
	}
	/**
	 * 设置：外部版本
	 */
	public void setOutEdition(String outEdition) {
		this.outEdition = outEdition;
	}
	/**
	 * 获取：外部版本
	 */
	public String getOutEdition() {
		return outEdition;
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
	 * 设置：更新内容
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：更新内容
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：安卓渠道
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 获取：安卓渠道
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 设置：0不强制 1强制
	 */
	public void setUpdateType(Integer updateType) {
		this.updateType = updateType;
	}
	/**
	 * 获取：0不强制 1强制
	 */
	public Integer getUpdateType() {
		return updateType;
	}
}
