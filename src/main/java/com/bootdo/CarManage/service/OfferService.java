package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.OfferDO;

import java.util.List;
import java.util.Map;

/**
 * 汽车报价表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface OfferService {
	
	OfferDO get(Integer offerId);
	
	List<OfferDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfferDO offer);
	
	int update(OfferDO offer);
	
	int remove(Integer offerId);
	
	int batchRemove(Integer[] offerIds);

	OfferDO getPriceMin(Integer carId);
}
