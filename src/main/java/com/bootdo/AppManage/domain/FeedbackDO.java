package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户反馈表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class FeedbackDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer feedbackId;
	//反馈内容
	private String feedbackContent;
	//反馈时间
	private Date time;
	//用户ID
	private Integer userId;
	//渠道
	private String channel;

	/**
	 * 设置：
	 */
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	/**
	 * 获取：
	 */
	public Integer getFeedbackId() {
		return feedbackId;
	}
	/**
	 * 设置：反馈内容
	 */
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	/**
	 * 获取：反馈内容
	 */
	public String getFeedbackContent() {
		return feedbackContent;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：反馈时间
	 */
	public Date getTime() {
		return time;
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
}
