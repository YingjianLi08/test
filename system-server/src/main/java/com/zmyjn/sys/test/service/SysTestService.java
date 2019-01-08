package com.zmyjn.sys.test.service;


import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.base.service.BaseService;
import com.zmyjn.core.page.Page;
import com.zmyjn.sys.test.entity.SysTest;

/**
 * @Description: 测试
 * @author: Administrator
 * @date: 2019-01-04 11:39:52
 */
public interface SysTestService extends BaseService<SysTest, Integer> {
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	void list(ResultData result, Page<SysTest> page,String searchKeys);
	
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
	void addSave(ResultData result, SysTest entity);
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 * @return
	 */
	void updateSave(ResultData result, SysTest entity);
	
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
