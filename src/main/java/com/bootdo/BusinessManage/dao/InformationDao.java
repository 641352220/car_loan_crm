package com.bootdo.BusinessManage.dao;

import com.bootdo.BusinessManage.domain.InformationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 合作商信息
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
@Mapper
public interface InformationDao {

	InformationDO get(Integer businessId);
	
	List<InformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InformationDO information);
	
	int update(InformationDO information);
	
	int remove(Integer business_id);
	
	int batchRemove(Integer[] businessIds);

	List<InformationDO> nameList();
}
