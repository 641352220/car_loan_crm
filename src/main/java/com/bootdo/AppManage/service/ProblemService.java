package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.ProblemDO;

import java.util.List;
import java.util.Map;

/**
 * 常见问题
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface ProblemService {
	
	ProblemDO get(Integer problemId);
	
	List<ProblemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProblemDO problem);
	
	int update(ProblemDO problem);
	
	int remove(Integer problemId);
	
	int batchRemove(Integer[] problemIds);
}
