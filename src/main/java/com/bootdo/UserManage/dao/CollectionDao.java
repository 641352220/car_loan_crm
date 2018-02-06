package com.bootdo.UserManage.dao;

import com.bootdo.UserManage.domain.CollectionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户收藏表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
@Mapper
public interface CollectionDao {

	CollectionDO get(Integer collectionId);
	
	List<CollectionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CollectionDO collection);
	
	int update(CollectionDO collection);
	
	int remove(Integer collection_id);
	
	int batchRemove(Integer[] collectionIds);
}
