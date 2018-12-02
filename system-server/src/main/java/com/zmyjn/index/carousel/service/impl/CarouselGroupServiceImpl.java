package com.zmyjn.index.carousel.service.impl;

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

import com.zmyjn.index.carousel.dao.mapper.CarouselGroupMapper;
import com.zmyjn.index.carousel.entity.CarouselGroup;
import com.zmyjn.index.carousel.service.CarouselGroupService;

/**
 * @Description: 轮播分组信息
 * @author: Administrator
 * @date: 2018-11-20 14:42:10
 */
@Service
public class CarouselGroupServiceImpl extends BaseServiceImpl<CarouselGroup, Integer> implements CarouselGroupService{

	@SuppressWarnings("unused")
	private final LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private CarouselGroupMapper carouselGroupMapper;
	
	@Override
	public BaseMapper<CarouselGroup, Integer> getMapper(){
		return carouselGroupMapper;
	}
	
	/**
	 * 列表
	 * @param page
	 * @param searchKeys
	 */
	public void list(ResultData result,Page<CarouselGroup> page,String searchKeys,String name,String code,String type){
		Map<String, Object> mapSql=new HashMap<String, Object>();
		mapSql.put("searchKeys", StringUtils.searchKeys(searchKeys));
		if(StringUtils.isNotBlank(name)){
			mapSql.put("name", StringUtils.trim(name));
		}
		if(StringUtils.isNotBlank(code)){
			mapSql.put("code", StringUtils.trim(code));
		}
		if(StringUtils.isNotBlank(type)){
			mapSql.put("type", StringUtils.trim(type));
		}

		PageHelper.startPage((int)page.getPage(), (int)page.getLimit());
		List<CarouselGroup> list = carouselGroupMapper.list(mapSql);
		
		PageUtil.setPageInfo(page, list);

		result.setData(list);
		result.setCount((int) page.getTotal());
	}

	/**
	 * 新增/修改初始化
	 * @param result
	 * @param id
	 */
	public void init(ResultData result,Integer id){
		
		if(id!=null) {
			result.setData(carouselGroupMapper.findById(id));
		}
	}

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSave(ResultData result,CarouselGroup entity){
		carouselGroupMapper.insert(entity);
	}
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSave(ResultData result,CarouselGroup entity){
		carouselGroupMapper.updateWithIf(entity);
	}

	/**
	 * 详情
	 * @param result
	 * @param id
	 */
	public void findById(ResultData result,Integer id){
		CarouselGroup entity=carouselGroupMapper.findById(id);
		result.setData(entity);
	}
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(ResultData result,Integer id){
		carouselGroupMapper.logicDelete(id);
	}
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByIds(ResultData result,Integer[] ids){
		carouselGroupMapper.logicDeleteByIds(ids);
	}

}
