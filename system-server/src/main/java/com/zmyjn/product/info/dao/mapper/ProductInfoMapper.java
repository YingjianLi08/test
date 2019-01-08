package com.zmyjn.product.info.dao.mapper;

import com.zmyjn.product.info.entity.ProductInfo;
import com.zmyjn.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 商品信息
 * @author: Administrator
 * @date: 2019-01-04 15:01:13
 */
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo,Integer>{
	
}
