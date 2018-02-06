package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.OfferDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 汽车报价表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface OfferDao {

	OfferDO get(Integer offerId);
	
	List<OfferDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfferDO offer);
	
	int update(OfferDO offer);
	
	int remove(Integer offer_id);
	
	int batchRemove(Integer[] offerIds);

	OfferDO getPriceMin(@Param("carId") Integer carId);
}
