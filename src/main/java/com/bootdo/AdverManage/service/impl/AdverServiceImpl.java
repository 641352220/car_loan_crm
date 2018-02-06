package com.bootdo.AdverManage.service.impl;

import com.bootdo.AdverManage.dao.AdverDao;
import com.bootdo.AdverManage.domain.AdverDO;
import com.bootdo.AdverManage.service.AdverService;
import com.bootdo.common.config.AliyunOSS;
import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class AdverServiceImpl implements AdverService {
	@Autowired
	private AdverDao adverDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private AliyunOSS aliyunOSS;

	
	@Override
	public AdverDO get(Integer adverId){
		return adverDao.get(adverId);
	}
	
	@Override
	public List<AdverDO> list(Map<String, Object> map){
		List<AdverDO> adverDOS = adverDao.list(map);
		for (AdverDO adverDO : adverDOS) {
			adverDO.setLogin(dictService.getName("adver_login", adverDO.getLogin()) );
			adverDO.setAdverPosition(dictService.getName("adver_adver_position",adverDO.getAdverPosition()));
			adverDO.setImg(aliyunOSS.getCdn()+adverDO.getImg());
		}
		return adverDOS;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return adverDao.count(map);
	}
	
	@Override
	public int save(AdverDO adver){
		return adverDao.save(adver);
	}
	
	@Override
	public int update(AdverDO adver){
		return adverDao.update(adver);
	}
	
	@Override
	public int remove(Integer adverId){
		return adverDao.remove(adverId);
	}
	
	@Override
	public int batchRemove(Integer[] adverIds){
		return adverDao.batchRemove(adverIds);
	}
	
}
