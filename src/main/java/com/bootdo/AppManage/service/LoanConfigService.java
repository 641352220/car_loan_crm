package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.LoanConfigDO;

import java.util.List;
import java.util.Map;

/**
 * 车贷产品期数及首付比例配置
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface LoanConfigService {
	
	LoanConfigDO get(Integer loanConfigId);
	
	List<LoanConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LoanConfigDO loanConfig);
	
	int update(LoanConfigDO loanConfig);
	
	int remove(Integer loanConfigId);
	
	int batchRemove(Integer[] loanConfigIds);

	List<LoanConfigDO> LoanConfigDOList(Integer type,Integer carProductInformationId);
}
