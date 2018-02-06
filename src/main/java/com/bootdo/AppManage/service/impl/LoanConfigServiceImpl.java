package com.bootdo.AppManage.service.impl;

import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.LoanConfigDao;
import com.bootdo.AppManage.domain.LoanConfigDO;
import com.bootdo.AppManage.service.LoanConfigService;



@Service
public class LoanConfigServiceImpl implements LoanConfigService {
	@Autowired
	private LoanConfigDao loanConfigDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public LoanConfigDO get(Integer loanConfigId){
		return loanConfigDao.get(loanConfigId);
	}
	
	@Override
	public List<LoanConfigDO> list(Map<String, Object> map){
		List<LoanConfigDO> loanConfigDOList = loanConfigDao.list(map);
		for(LoanConfigDO loanConfigDO : loanConfigDOList){
			loanConfigDO.setType(dictService.getName("loan_config_type",loanConfigDO.getType()));
		}
		return loanConfigDOList;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return loanConfigDao.count(map);
	}
	
	@Override
	public int save(LoanConfigDO loanConfig){
		return loanConfigDao.save(loanConfig);
	}
	
	@Override
	public int update(LoanConfigDO loanConfig){
		return loanConfigDao.update(loanConfig);
	}
	
	@Override
	public int remove(Integer loanConfigId){
		return loanConfigDao.remove(loanConfigId);
	}
	
	@Override
	public int batchRemove(Integer[] loanConfigIds){
		return loanConfigDao.batchRemove(loanConfigIds);
	}

	@Override
	public List<LoanConfigDO> LoanConfigDOList(Integer type,Integer carProductInformationId) {
		return loanConfigDao.LoanConfigDOList(type,carProductInformationId);
	}

}
