package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.BrandDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface BrandDao {

	BrandDO get(Integer brandId);
	
	List<BrandDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BrandDO brand);
	
	int update(BrandDO brand);
	
	int remove(Integer brand_id);
	
	int batchRemove(Integer[] brandIds);

	List<BrandDO> BrandDOList();

	List<BrandDO> BrandDOListByFA();

	List<BrandDO> listByBusinessId(@Param("businessId") Integer businessId);

	List<BrandDO> BrandDOListByCpii(@Param("carProductInformationId") Integer carProductInformationId);
}
