package com.bootdo.BusinessManage.service.impl;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.BusinessManage.dao.InformationDao;
import com.bootdo.BusinessManage.domain.InformationDO;
import com.bootdo.BusinessManage.service.InformationService;



@Service
public class InformationServiceImpl implements InformationService {
	@Autowired
	private InformationDao informationDao;
	
	@Override
	public InformationDO get(Integer businessId){
		return informationDao.get(businessId);
	}
	
	@Override
	public List<InformationDO> list(Map<String, Object> map){
		return informationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return informationDao.count(map);
	}
	
	@Override
	public int save(InformationDO information){
		return informationDao.save(information);
	}
	
	@Override
	public int update(InformationDO information){
		return informationDao.update(information);
	}
	
	@Override
	public int remove(Integer businessId){
		return informationDao.remove(businessId);
	}
	
	@Override
	public int batchRemove(Integer[] businessIds){
		return informationDao.batchRemove(businessIds);
	}

	@Override
	public Tree<InformationDO> getTree() {
		List<Tree<InformationDO>> trees = new ArrayList<Tree<InformationDO>>();
		List<InformationDO> informationDOS = informationDao.nameList();
		for (InformationDO informationDO : informationDOS) {
			Tree<InformationDO> tree = new Tree<InformationDO>();
			tree.setId(informationDO.getBusinessId().toString());
			tree.setParentId(informationDO.getParentId().toString());
			tree.setText(informationDO.getCompanyName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<InformationDO> t = BuildTree.build(trees);
		return t;
	}

}
