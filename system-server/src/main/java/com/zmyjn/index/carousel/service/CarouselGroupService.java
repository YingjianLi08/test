package com.zmyjn.index.carousel.service;


import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.base.service.BaseService;
import com.zmyjn.core.page.Page;
import com.zmyjn.index.carousel.entity.CarouselGroup;

/**
 * @Description: 轮播分组信息
 * @author: Administrator
 * @date: 2018-11-20 14:42:10
 */
public interface CarouselGroupService extends BaseService<CarouselGroup, Integer> {
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	void list(ResultData result, Page<CarouselGroup> page,String searchKeys,String name,String code,String type);
	
	/**
	 * 新增/修改初始化
	 * @param result
	 * @param id
	 * @return
	 */
	void init(ResultData result,Integer id);

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 * @return
	 */
	void addSave(ResultData result, CarouselGroup entity);
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 * @return
	 */
	void updateSave(ResultData result, CarouselGroup entity);
	
	/**
	 * 详情
	 * @param result
	 * @param id
	 * @return
	 */
	void findById( ResultData result, Integer id);
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 * @return
	 */
	void deleteByIds(ResultData result, Integer[] ids);
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 * @return
	 */
	void deleteById(ResultData result, Integer id);
}
