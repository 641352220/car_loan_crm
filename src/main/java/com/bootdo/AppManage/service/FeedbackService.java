package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.FeedbackDO;

import java.util.List;
import java.util.Map;

/**
 * 用户反馈表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface FeedbackService {
	
	FeedbackDO get(Integer feedbackId);
	
	List<FeedbackDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FeedbackDO feedback);
	
	int update(FeedbackDO feedback);
	
	int remove(Integer feedbackId);
	
	int batchRemove(Integer[] feedbackIds);
}
