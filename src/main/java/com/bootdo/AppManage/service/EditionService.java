package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.EditionDO;

import java.util.List;
import java.util.Map;

/**
 * 版本表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface EditionService {
	
	EditionDO get(Integer id);
	
	List<EditionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EditionDO edition);
	
	int update(EditionDO edition);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
