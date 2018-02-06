package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.LabelRelationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 标签中间关联表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface LabelRelationDao {

	LabelRelationDO get(Integer relationId);
	
	List<LabelRelationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LabelRelationDO labelRelation);
	
	int update(LabelRelationDO labelRelation);
	
	int remove(@Param("id") Integer id,@Param("type") String type);
	
	int batchRemove(Integer[] relationIds);
}
