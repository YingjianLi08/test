package com.zmyjn.product.info.dao.mapper;

import com.zmyjn.product.info.entity.ProductInfo;
import com.zmyjn.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 商品信息
 * @author: Administrator
 * @date: 2018-11-18 12:38:46
 */
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo,Integer>{
	
}
