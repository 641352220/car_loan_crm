package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.LabelDO;

import java.util.List;
import java.util.Map;

/**
 * 标签表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface LabelService {
	
	LabelDO get(Integer labelId);
	
	List<LabelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LabelDO label);
	
	int update(LabelDO label);
	
	int remove(Integer labelId);
	
	int batchRemove(Integer[] labelIds);

	List<LabelDO> labelList(Integer type,Integer id);
}
