package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.FeedbackDao;
import com.bootdo.AppManage.domain.FeedbackDO;
import com.bootdo.AppManage.service.FeedbackService;



@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackDao feedbackDao;
	
	@Override
	public FeedbackDO get(Integer feedbackId){
		return feedbackDao.get(feedbackId);
	}
	
	@Override
	public List<FeedbackDO> list(Map<String, Object> map){
		return feedbackDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return feedbackDao.count(map);
	}
	
	@Override
	public int save(FeedbackDO feedback){
		return feedbackDao.save(feedback);
	}
	
	@Override
	public int update(FeedbackDO feedback){
		return feedbackDao.update(feedback);
	}
	
	@Override
	public int remove(Integer feedbackId){
		return feedbackDao.remove(feedbackId);
	}
	
	@Override
	public int batchRemove(Integer[] feedbackIds){
		return feedbackDao.batchRemove(feedbackIds);
	}
	
}
