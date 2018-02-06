package com.bootdo.BusinessManage.service;

import com.bootdo.BusinessManage.domain.InformationDO;
import com.bootdo.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * 合作商信息
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public interface InformationService {
	
	InformationDO get(Integer businessId);
	
	List<InformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InformationDO information);
	
	int update(InformationDO information);
	
	int remove(Integer businessId);
	
	int batchRemove(Integer[] businessIds);

	Tree<InformationDO> getTree();
}
