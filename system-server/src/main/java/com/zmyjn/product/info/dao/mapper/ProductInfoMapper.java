package com.zmyjn.product.info.dao.mapper;

import com.zmyjn.product.info.entity.ProductInfo;
import com.zmyjn.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 商品轮播信息
 * @author: LIYINGJIAN
 * @date: 2018-12-23 10:25:04
 */
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo,Integer>{
	
}
