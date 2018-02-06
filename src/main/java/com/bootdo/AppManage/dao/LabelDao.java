package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.LabelDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 标签表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface LabelDao {

	LabelDO get(Integer labelId);
	
	List<LabelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LabelDO label);
	
	int update(LabelDO label);
	
	int remove(Integer label_id);
	
	int batchRemove(Integer[] labelIds);

	List<LabelDO> labelList(@Param("type") Integer type,@Param("id") Integer id);
}
