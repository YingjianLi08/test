package com.zmyjn.product.info.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zmyjn.core.log.LogUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zmyjn.core.base.mapper.BaseMapper;
import com.zmyjn.core.base.service.impl.BaseServiceImpl;
import com.zmyjn.core.page.Page;
import com.zmyjn.core.page.PageUtil;
import com.zmyjn.core.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.zmyjn.core.base.controller.ResultData;

import com.zmyjn.product.info.dao.mapper.ProductInfoMapper;
import com.zmyjn.product.info.entity.ProductInfo;
import com.zmyjn.product.info.service.ProductInfoService;

/**
 * @Description: 商品信息
 * @author: Administrator
 * @date: 2018-11-18 12:38:46
 */
@Service
public class ProductInfoServiceImpl extends BaseServiceImpl<ProductInfo, Integer> implements ProductInfoService{

	@SuppressWarnings("unused")
	private final LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Override
	public BaseMapper<ProductInfo, Integer> getMapper(){
		return productInfoMapper;
	}
	
	/**
	 * 列表
	 * @param page
	 * @param searchKeys
	 */
	public void list(ResultData result,Page<ProductInfo> page,String searchKeys){
		Map<String, Object> mapSql=new HashMap<String, Object>();
		mapSql.put("searchKeys", StringUtils.searchKeys(searchKeys));
		
		PageHelper.startPage((int)page.getPage(), (int)page.getLimit());
		List<ProductInfo> list = productInfoMapper.list(mapSql);
		
		PageUtil.setPageInfo(page, list);
//		page.setRows(list);

		result.setData(list);
	}

	/**
	 * 新增/修改初始化
	 * @param result
	 * @param id
	 */
	public void init(ResultData result,Integer id){
		
		if(id!=null) {
			result.setData(productInfoMapper.findById(id));
		}
	}

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSave(ResultData result,ProductInfo entity){
		productInfoMapper.insert(entity);
	}
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSave(ResultData result,ProductInfo entity){
		productInfoMapper.updateWithIf(entity);
	}

	/**
	 * 详情
	 * @param result
	 * @param id
	 */
	public void findById(ResultData result,Integer id){
		ProductInfo entity=productInfoMapper.findById(id);
		result.setData(entity);
	}
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(ResultData result,Integer id){
		productInfoMapper.logicDelete(id);
	}
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByIds(ResultData result,Integer[] ids){
		productInfoMapper.logicDeleteByIds(ids);
	}

}
