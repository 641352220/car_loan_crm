package com.bootdo.BusinessManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 合作商信息
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public class InformationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商家ID
	private Integer businessId;
	//上级ID 0为分类
	private Integer parentId;
	//公司名字
	private String companyName;
	//联系人姓名
	private String contactName;
	//对外联系方式
	private String contactWay;
	//QQ
	private String qq;
	//邮箱
	private String email;
	//0 正常 1禁用
	private Integer state;
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
	//合作方式 0 没填写 1 官方 2 自营
	private String cooperationType;
	//经销商等级 0 未填写 1 一级 2 二级
	private String grade;
	//排序
	private Integer sort;
	//排序
	private String img;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	//详细地址
	private String addressString;

	public String getAddressString() {
		return province+" "+city+" "+area+" "+address;
	}


	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
	 * 设置：上级ID 0为分类
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级ID 0为分类
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：公司名字
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：公司名字
	 */
	public String getCompanyName() {
		return companyName;
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
	 * 设置：对外联系方式
	 */
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	/**
	 * 获取：对外联系方式
	 */
	public String getContactWay() {
		return contactWay;
	}
	/**
	 * 设置：QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：0 正常 1禁用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0 正常 1禁用
	 */
	public Integer getState() {
		return state;
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
		return address;
	}
	/**
	 * 设置：合作方式 0 没填写 1 官方 2 自营
	 */
	public void setCooperationType(String cooperationType) {
		this.cooperationType = cooperationType;
	}
	/**
	 * 获取：合作方式 0 没填写 1 官方 2 自营
	 */
	public String getCooperationType() {
		return cooperationType;
	}
	/**
	 * 设置：经销商等级 0 未填写 1 一级 2 二级
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：经销商等级 0 未填写 1 一级 2 二级
	 */
	public String getGrade() {
		return grade;
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
		return "InformationDO{" +
				"businessId=" + businessId +
				", parentId=" + parentId +
				", companyName='" + companyName + '\'' +
				", contactName='" + contactName + '\'' +
				", contactWay='" + contactWay + '\'' +
				", qq='" + qq + '\'' +
				", email='" + email + '\'' +
				", state=" + state +
				", longitude='" + longitude + '\'' +
				", latitude='" + latitude + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", area='" + area + '\'' +
				", address='" + address + '\'' +
				", cooperationType='" + cooperationType + '\'' +
				", grade='" + grade + '\'' +
				", sort=" + sort +
				", img='" + img + '\'' +
				", createBy=" + createBy +
				", createDate=" + createDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				", addressString='" + addressString + '\'' +
				'}';
	}
}
