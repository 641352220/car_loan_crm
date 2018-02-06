package com.bootdo.AppManage.service.impl;

import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.LabelDao;
import com.bootdo.AppManage.domain.LabelDO;
import com.bootdo.AppManage.service.LabelService;



@Service
public class LabelServiceImpl implements LabelService {
	@Autowired
	private LabelDao labelDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public LabelDO get(Integer labelId){
		return labelDao.get(labelId);
	}
	
	@Override
	public List<LabelDO> list(Map<String, Object> map){
		List<LabelDO> labelDOList = labelDao.list(map);
		for (LabelDO labelDO : labelDOList) {
			labelDO.setType(dictService.getName("app_label_type",labelDO.getType()));
		}
		return labelDOList;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return labelDao.count(map);
	}
	
	@Override
	public int save(LabelDO label){
		return labelDao.save(label);
	}
	
	@Override
	public int update(LabelDO label){
		return labelDao.update(label);
	}
	
	@Override
	public int remove(Integer labelId){
		return labelDao.remove(labelId);
	}
	
	@Override
	public int batchRemove(Integer[] labelIds){
		return labelDao.batchRemove(labelIds);
	}

	@Override
	public List<LabelDO> labelList(Integer type, Integer id) {
		return labelDao.labelList(type,id);
	}

}
