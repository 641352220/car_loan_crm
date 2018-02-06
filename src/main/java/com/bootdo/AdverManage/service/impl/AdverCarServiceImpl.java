package com.bootdo.AdverManage.service.impl;

import com.bootdo.AdverManage.dao.AdverCarDao;
import com.bootdo.AdverManage.domain.AdverCarDO;
import com.bootdo.AdverManage.service.AdverCarService;
import com.bootdo.common.config.AliyunOSS;
import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class AdverCarServiceImpl implements AdverCarService {
	@Autowired
	private AdverCarDao carDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private AliyunOSS aliyunOSS;
	
	@Override
	public AdverCarDO get(Integer adverCarId){
		return carDao.get(adverCarId);
	}
	
	@Override
	public List<AdverCarDO> list(Map<String, Object> map){
		List<AdverCarDO> adverCarDOList = carDao.list(map);
		for (AdverCarDO adverCarDO : adverCarDOList) {
			adverCarDO.setType(dictService.getName("adver_car_type", adverCarDO.getType()));
			adverCarDO.setImg(aliyunOSS.getCdn()+adverCarDO.getImg());
		}
		return adverCarDOList;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return carDao.count(map);
	}
	
	@Override
	public int save(AdverCarDO car){
		return carDao.save(car);
	}
	
	@Override
	public int update(AdverCarDO car){
		return carDao.update(car);
	}
	
	@Override
	public int remove(Integer adverCarId){
		return carDao.remove(adverCarId);
	}
	
	@Override
	public int batchRemove(Integer[] adverCarIds){
		return carDao.batchRemove(adverCarIds);
	}

	@Override
	public AdverCarDO getCarInfo(Integer adverCarId) {
		return carDao.getCarInfo(adverCarId);
	}

}
