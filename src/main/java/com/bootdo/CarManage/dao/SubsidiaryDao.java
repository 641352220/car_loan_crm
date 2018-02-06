package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.SubsidiaryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 子公司(例如一汽奥迪)
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface SubsidiaryDao {

	SubsidiaryDO get(Integer subsidiaryId);
	
	List<SubsidiaryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubsidiaryDO subsidiary);
	
	int update(SubsidiaryDO subsidiary);
	
	int remove(Integer subsidiary_id);
	
	int batchRemove(Integer[] subsidiaryIds);
}
