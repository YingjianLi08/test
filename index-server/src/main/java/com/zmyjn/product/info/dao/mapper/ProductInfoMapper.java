package com.zmyjn.product.info.dao.mapper;

import com.zmyjn.product.info.entity.ProductInfo;
import com.zmyjn.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 商品信息
 * @author: LIYINGJIAN
 * @date: 2018-12-30 14:00:45
 */
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo,Integer>{
	
}
