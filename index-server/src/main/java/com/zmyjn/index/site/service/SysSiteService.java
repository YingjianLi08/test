package com.zmyjn.index.site.service;


import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.base.service.BaseService;
import com.zmyjn.core.page.Page;
import com.zmyjn.index.site.entity.SysSite;

/**
 * @Description: 网站信息
 * @author: Administrator
 * @date: 2018-12-03 11:48:40
 */
public interface SysSiteService extends BaseService<SysSite, Integer> {
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	void list(ResultData result, Page<SysSite> page,String searchKeys);
	
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
	void addSave(ResultData result, SysSite entity);
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 * @return
	 */
	void updateSave(ResultData result, SysSite entity);
	
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
