package com.zmyjn.product.type.dao.mapper;

import com.zmyjn.product.type.entity.ProductType;
import com.zmyjn.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 商品类型
 * @author: Administrator
 * @date: 2019-01-04 16:05:01
 */
@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType,Integer>{
	
}
