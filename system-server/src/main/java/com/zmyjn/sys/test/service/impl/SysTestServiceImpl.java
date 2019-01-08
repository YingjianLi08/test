package com.zmyjn.sys.test.service.impl;

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

import com.zmyjn.sys.test.dao.mapper.SysTestMapper;
import com.zmyjn.sys.test.entity.SysTest;
import com.zmyjn.sys.test.service.SysTestService;

/**
 * @Description: 测试
 * @author: Administrator
 * @date: 2019-01-04 11:39:52
 */
@Service
public class SysTestServiceImpl extends BaseServiceImpl<SysTest, Integer> implements SysTestService{

	@SuppressWarnings("unused")
	private final LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysTestMapper sysTestMapper;
	
	@Override
	public BaseMapper<SysTest, Integer> getMapper(){
		return sysTestMapper;
	}
	
	/**
	 * 列表
	 * @param page
	 * @param searchKeys
	 */
	public void list(ResultData result,Page<SysTest> page,String searchKeys){
		Map<String, Object> mapSql=new HashMap<String, Object>();
		mapSql.put("searchKeys", StringUtils.searchKeys(searchKeys));
		
		PageHelper.startPage((int)page.getPage(), (int)page.getLimit());
		List<SysTest> list = sysTestMapper.list(mapSql);
		
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
			result.setData(sysTestMapper.findById(id));
		}
	}

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSave(ResultData result,SysTest entity){
		sysTestMapper.insert(entity);
	}
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSave(ResultData result,SysTest entity){
		sysTestMapper.updateWithIf(entity);
	}

	/**
	 * 详情
	 * @param result
	 * @param id
	 */
	public void findById(ResultData result,Integer id){
		SysTest entity=sysTestMapper.findById(id);
		result.setData(entity);
	}
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(ResultData result,Integer id){
		sysTestMapper.logicDelete(id);
	}
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByIds(ResultData result,Integer[] ids){
		sysTestMapper.logicDeleteByIds(ids);
	}

}
