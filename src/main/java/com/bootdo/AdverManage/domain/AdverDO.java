package com.bootdo.AdverManage.domain;

import com.bootdo.common.utils.TimeUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 广告
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-03 11:10:04
 */
public class AdverDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//广告ID
	private Integer adverId;
	//0不需要登录 1需要登录
	private String login;
	//广告链接
	private String adverUrl;
	//位置 0 广告页(启动的时候) 1 首页上面banner 2 下面banner  3 新车贷页面
	private String adverPosition;
	//广告名
	private String adverName;
	//图片地址
	private String img;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//排序
	private Integer sort;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;


	/*------------------------------------映射字段--------------------------------------*/
	//开始时间/结束时间
	private String startAndEndTime;

	public String getStartAndEndTime() {
		return startTime+"--"+ endTime;
	}

	/*------------------------------------映射字段--------------------------------------*/

	/**
	 * 设置：广告ID
	 */
	public void setAdverId(Integer adverId) {
		this.adverId = adverId;
	}
	/**
	 * 获取：广告ID
	 */
	public Integer getAdverId() {
		return adverId;
	}
	/**
	 * 设置：0不需要登录 1需要登录
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * 获取：0不需要登录 1需要登录
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * 设置：广告链接
	 */
	public void setAdverUrl(String adverUrl) {
		this.adverUrl = adverUrl;
	}
	/**
	 * 获取：广告链接
	 */
	public String getAdverUrl() {
		return adverUrl;
	}
	/**
	 * 设置：位置 0 广告页(启动的时候) 1 首页上面banner 2 下面banner  3 新车贷页面
	 */
	public void setAdverPosition(String adverPosition) {
		this.adverPosition = adverPosition;
	}
	/**
	 * 获取：位置 0 广告页(启动的时候) 1 首页上面banner 2 下面banner  3 新车贷页面
	 */
	public String getAdverPosition() {
		return adverPosition;
	}
	/**
	 * 设置：广告名
	 */
	public void setAdverName(String adverName) {
		this.adverName = adverName;
	}
	/**
	 * 获取：广告名
	 */
	public String getAdverName() {
		return adverName;
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
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
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
		return "AdverDO{" +
				"adverId=" + adverId +
				", login='" + login + '\'' +
				", adverUrl='" + adverUrl + '\'' +
				", adverPosition='" + adverPosition + '\'' +
				", adverName='" + adverName + '\'' +
				", img='" + img + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", sort=" + sort +
				", createBy=" + createBy +
				", createDate=" + createDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				", startAndEndTime='" + startAndEndTime + '\'' +
				'}';
	}
}
