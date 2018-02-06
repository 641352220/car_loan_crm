package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.OfferDao;
import com.bootdo.CarManage.domain.OfferDO;
import com.bootdo.CarManage.service.OfferService;



@Service
public class OfferServiceImpl implements OfferService {
	@Autowired
	private OfferDao offerDao;
	
	@Override
	public OfferDO get(Integer offerId){
		return offerDao.get(offerId);
	}
	
	@Override
	public List<OfferDO> list(Map<String, Object> map){
		return offerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return offerDao.count(map);
	}
	
	@Override
	public int save(OfferDO offer){
		return offerDao.save(offer);
	}
	
	@Override
	public int update(OfferDO offer){
		return offerDao.update(offer);
	}
	
	@Override
	public int remove(Integer offerId){
		return offerDao.remove(offerId);
	}
	
	@Override
	public int batchRemove(Integer[] offerIds){
		return offerDao.batchRemove(offerIds);
	}

	@Override
	public OfferDO getPriceMin(Integer carId) {
		return offerDao.getPriceMin(carId);
	}

}
