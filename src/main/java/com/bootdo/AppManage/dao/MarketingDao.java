package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.MarketingDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 首页营销模块
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface MarketingDao {

	MarketingDO get(Integer marketingId);
	
	List<MarketingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MarketingDO marketing);
	
	int update(MarketingDO marketing);
	
	int remove(Integer marketing_id);
	
	int batchRemove(Integer[] marketingIds);

	List<MarketingDO> nameList();
}
