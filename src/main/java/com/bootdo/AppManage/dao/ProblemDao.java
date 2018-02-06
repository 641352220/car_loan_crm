package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.ProblemDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 常见问题
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface ProblemDao {

	ProblemDO get(Integer problemId);
	
	List<ProblemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProblemDO problem);
	
	int update(ProblemDO problem);
	
	int remove(Integer problem_id);
	
	int batchRemove(Integer[] problemIds);
}
