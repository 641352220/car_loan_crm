package com.bootdo.AdverManage.service;

import com.bootdo.AdverManage.domain.AdverDO;

import java.util.List;
import java.util.Map;

/**
 * 广告
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-03 11:10:04
 */
public interface AdverService {
	
	AdverDO get(Integer adverId);
	
	List<AdverDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdverDO adver);
	
	int update(AdverDO adver);
	
	int remove(Integer adverId);
	
	int batchRemove(Integer[] adverIds);
}
