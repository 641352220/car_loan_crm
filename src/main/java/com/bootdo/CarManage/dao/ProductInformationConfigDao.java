package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ProductInformationConfigDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 车贷报价方案期限利率详情表,一个方案可以有多条首付和期限
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ProductInformationConfigDao {

	ProductInformationConfigDO get(@Param("carProductInformationId") Integer carProductInformationId
			,@Param("loanConfigId") Integer loanConfigId);
	
	List<ProductInformationConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductInformationConfigDO productInformationConfig);
	
	int update(ProductInformationConfigDO productInformationConfig);
	
	int remove(Integer car_product_information_id);
	
	int batchRemove(Integer[] carProductInformationIds);

	ProductInformationConfigDO getMinSF(@Param("carProductInformationId") Integer carProductInformationId);

	ProductInformationConfigDO getMaxTerm(@Param("carProductInformationId") Integer carProductInformationId);
}
