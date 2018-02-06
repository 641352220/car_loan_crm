package com.bootdo.CarManage.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;



/**
 * 车贷产品
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer carProductId;
	//商家ID
	private Integer businessId;
	//贷款产品名
	private String carProductName;
	//广告语
	private String adver;
	//贷款流程(图片)
	private String loanProcess;
	//申请条件
	private String applyCondition;
	//介绍
	private String introduce;
	//排序
	private Integer sort;
	//logo
	private String logo;
	//联系人姓名
	private String contactName;
	//联系人手机
	private String contactPhone;
	//评论数
	private Integer commentNum;
	//评论综合分数
	private Integer commentBranch;
	//0 停用 1启用
	private Integer platformState;
	//1 H5 2 原生
	private Integer jumpType;
	// 跳转链接
	private String jumpUrl;
	//0 停用 1启用
	private Integer businessState;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;


	/*------------------------------------------------------------------------------------------------------------------------------------------------------*/

	private String businessName;

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/*------------------------------------------------------------------------------------------------------------------------------------------------------*/


	/**
	 * 设置：
	 */
	public void setCarProductId(Integer carProductId) {
		this.carProductId = carProductId;
	}
	/**
	 * 获取：
	 */
	public Integer getCarProductId() {
		return carProductId;
	}
	/**
	 * 设置：商家ID
	 */
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：商家ID
	 */
	public Integer getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：贷款产品名
	 */
	public void setCarProductName(String carProductName) {
		this.carProductName = carProductName;
	}
	/**
	 * 获取：贷款产品名
	 */
	public String getCarProductName() {
		return carProductName;
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
	/**
	 * 设置：贷款流程(图片)
	 */
	public void setLoanProcess(String loanProcess) {
		this.loanProcess = loanProcess;
	}
	/**
	 * 获取：贷款流程(图片)
	 */
	public String getLoanProcess() {
		return loanProcess;
	}
	/**
	 * 设置：申请条件
	 */
	public void setApplyCondition(String applyCondition) {
		this.applyCondition = applyCondition;
	}
	/**
	 * 获取：申请条件
	 */
	public String getApplyCondition() {
		return applyCondition;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntroduce() {
		return introduce;
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
	 * 设置：联系人姓名
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人姓名
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系人手机
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系人手机
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：评论数
	 */
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getCommentNum() {
		return commentNum;
	}
	/**
	 * 设置：评论综合分数
	 */
	public void setCommentBranch(Integer commentBranch) {
		this.commentBranch = commentBranch;
	}
	/**
	 * 获取：评论综合分数
	 */
	public Integer getCommentBranch() {
		return commentBranch;
	}
	/**
	 * 设置：0 停用 1启用
	 */
	public void setPlatformState(Integer platformState) {
		this.platformState = platformState;
	}
	/**
	 * 获取：0 停用 1启用
	 */
	public Integer getPlatformState() {
		return platformState;
	}
	/**
	 * 设置：0 停用 1启用
	 */
	public void setBusinessState(Integer businessState) {
		this.businessState = businessState;
	}
	/**
	 * 获取：0 停用 1启用
	 */
	public Integer getBusinessState() {
		return businessState;
	}

	public Integer getJumpType() {
		return jumpType;
	}

	public void setJumpType(Integer jumpType) {
		this.jumpType = jumpType;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl == null ? null : jumpUrl.trim();
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
		return JSON.toJSONString(this);
	}
}
