package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.LoanConfigDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 车贷产品期数及首付比例配置
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface LoanConfigDao {

	LoanConfigDO get(Integer loanConfigId);
	
	List<LoanConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LoanConfigDO loanConfig);
	
	int update(LoanConfigDO loanConfig);
	
	int remove(Integer loan_config_id);
	
	int batchRemove(Integer[] loanConfigIds);

	List<LoanConfigDO> LoanConfigDOList(@Param("type") Integer type, @Param("carProductInformationId") Integer carProductInformationId);
}
