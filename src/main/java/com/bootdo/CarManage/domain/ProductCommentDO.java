package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 车贷产品评价表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ProductCommentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//汽车产品评论ID
	private Integer carProductCommentId;
	//订单ID
	private Integer orderId;
	//汽车ID
	private Integer carId;
	//汽车产品ID
	private Integer carProductId;
	//用户ID
	private Integer userId;
	//评论人昵称
	private String commentName;
	//0待审核 1审核通过 2审核拒绝
	private Integer state;
	//评论时间
	private Date commentTime;
	//更新状态时间
	private Date updateTime;
	//评论分数
	private Integer fraction;
	//评论内容
	private String commentContent;

	/*---------------------------------------------------------------------------------------------------------------------*/

	private String carName;

	private String carProductName;

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarProductName() {
		return carProductName;
	}

	/*---------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 设置：汽车产品评论ID
	 */
	public void setCarProductCommentId(Integer carProductCommentId) {
		this.carProductCommentId = carProductCommentId;
	}
	/**
	 * 获取：汽车产品评论ID
	 */
	public Integer getCarProductCommentId() {
		return carProductCommentId;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
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
	 * 设置：汽车产品ID
	 */
	public void setCarProductId(Integer carProductId) {
		this.carProductId = carProductId;
	}
	/**
	 * 获取：汽车产品ID
	 */
	public Integer getCarProductId() {
		return carProductId;
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
	 * 设置：评论人昵称
	 */
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	/**
	 * 获取：评论人昵称
	 */
	public String getCommentName() {
		return commentName;
	}
	/**
	 * 设置：0待审核 1审核通过 2审核拒绝
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0待审核 1审核通过 2审核拒绝
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：评论时间
	 */
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	/**
	 * 获取：评论时间
	 */
	public Date getCommentTime() {
		return commentTime;
	}
	/**
	 * 设置：更新状态时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新状态时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：评论分数
	 */
	public void setFraction(Integer fraction) {
		this.fraction = fraction;
	}
	/**
	 * 获取：评论分数
	 */
	public Integer getFraction() {
		return fraction;
	}
	/**
	 * 设置：评论内容
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * 获取：评论内容
	 */
	public String getCommentContent() {
		return commentContent;
	}
}
