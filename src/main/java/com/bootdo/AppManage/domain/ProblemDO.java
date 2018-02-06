package com.bootdo.AppManage.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 常见问题
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public class ProblemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//问题ID
	private Integer problemId;
	//问题
	private String problem;
	//答案
	private String answer;
	//排序
	private Integer sort;
	//0正常 1停用
	private Integer state;

	/**
	 * 设置：问题ID
	 */
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	/**
	 * 获取：问题ID
	 */
	public Integer getProblemId() {
		return problemId;
	}
	/**
	 * 设置：问题
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}
	/**
	 * 获取：问题
	 */
	public String getProblem() {
		return problem;
	}
	/**
	 * 设置：答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：答案
	 */
	public String getAnswer() {
		return answer;
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
	 * 设置：0正常 1停用
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0正常 1停用
	 */
	public Integer getState() {
		return state;
	}
}
