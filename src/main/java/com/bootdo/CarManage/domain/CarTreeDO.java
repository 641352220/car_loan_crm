package com.bootdo.CarManage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 车子树形图
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public class CarTreeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//名字
	private String text;
	//父ID
	private Integer parent;
	//是否选中
	private boolean checked = false;
	/**
	 * 节点状态，open closed
	 */
	private Map<String, Object> state;

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Integer getParent() {
		return parent;
	}

	public boolean isChecked() {
		return checked;
	}

	public Map<String, Object> getState() {
		return state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setState(Map<String, Object> state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CarTreeDO{" +
				"id=" + id +
				", text='" + text + '\'' +
				", parent=" + parent +
				", checked=" + checked +
				", state=" + state +
				'}';
	}

	public CarTreeDO(Integer id, String text, Integer parent, boolean checked, Map<String, Object> state) {
		this.id = id;
		this.text = text;
		this.parent = parent;
		this.checked = checked;
		this.state = state;
	}
}
