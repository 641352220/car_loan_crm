package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.FeedbackDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户反馈表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface FeedbackDao {

	FeedbackDO get(Integer feedbackId);
	
	List<FeedbackDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FeedbackDO feedback);
	
	int update(FeedbackDO feedback);
	
	int remove(Integer feedback_id);
	
	int batchRemove(Integer[] feedbackIds);
}
