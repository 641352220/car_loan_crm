package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 标签中间关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class LabelRelationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//关联Id 不同的type关联不同表的ID
	private Integer relationId;
	//标签ID
	private Integer labelId;
	//1汽车产品标签 2经销商标签 3 汽车产品优惠标签 4 报价标签 5 首页推荐标签
	private Integer type;

	public LabelRelationDO(Integer relationId, Integer labelId, Integer type) {
		this.relationId = relationId;
		this.labelId = labelId;
		this.type = type;
	}

	/**
	 * 设置：关联Id 不同的type关联不同表的ID
	 */
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	/**
	 * 获取：关联Id 不同的type关联不同表的ID
	 */
	public Integer getRelationId() {
		return relationId;
	}
	/**
	 * 设置：标签ID
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	/**
	 * 获取：标签ID
	 */
	public Integer getLabelId() {
		return labelId;
	}
	/**
	 * 设置：1汽车产品标签 2经销商标签 3 汽车产品优惠标签 4 报价标签 5 首页推荐标签
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1汽车产品标签 2经销商标签 3 汽车产品优惠标签 4 报价标签 5 首页推荐标签
	 */
	public Integer getType() {
		return type;
	}
}
