package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.ProblemDao;
import com.bootdo.AppManage.domain.ProblemDO;
import com.bootdo.AppManage.service.ProblemService;



@Service
public class ProblemServiceImpl implements ProblemService {
	@Autowired
	private ProblemDao problemDao;
	
	@Override
	public ProblemDO get(Integer problemId){
		return problemDao.get(problemId);
	}
	
	@Override
	public List<ProblemDO> list(Map<String, Object> map){
		return problemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return problemDao.count(map);
	}
	
	@Override
	public int save(ProblemDO problem){
		return problemDao.save(problem);
	}
	
	@Override
	public int update(ProblemDO problem){
		return problemDao.update(problem);
	}
	
	@Override
	public int remove(Integer problemId){
		return problemDao.remove(problemId);
	}
	
	@Override
	public int batchRemove(Integer[] problemIds){
		return problemDao.batchRemove(problemIds);
	}
	
}
