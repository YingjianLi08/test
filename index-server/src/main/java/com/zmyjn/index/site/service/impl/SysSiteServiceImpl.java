package com.zmyjn.index.site.service.impl;

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

import com.zmyjn.index.site.dao.mapper.SysSiteMapper;
import com.zmyjn.index.site.entity.SysSite;
import com.zmyjn.index.site.service.SysSiteService;

/**
 * @Description: 网站信息
 * @author: Administrator
 * @date: 2018-12-03 11:48:40
 */
@Service
public class SysSiteServiceImpl extends BaseServiceImpl<SysSite, Integer> implements SysSiteService{

	@SuppressWarnings("unused")
	private final LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysSiteMapper sysSiteMapper;
	
	@Override
	public BaseMapper<SysSite, Integer> getMapper(){
		return sysSiteMapper;
	}
	
	/**
	 * 列表
	 * @param page
	 * @param searchKeys
	 */
	public void list(ResultData result,Page<SysSite> page,String searchKeys){
		Map<String, Object> mapSql=new HashMap<String, Object>();
		mapSql.put("searchKeys", StringUtils.searchKeys(searchKeys));
		
		PageHelper.startPage((int)page.getPage(), (int)page.getLimit());
		List<SysSite> list = sysSiteMapper.list(mapSql);
		
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
			result.setData(sysSiteMapper.findById(id));
		}
	}

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSave(ResultData result,SysSite entity){
		sysSiteMapper.insert(entity);
	}
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSave(ResultData result,SysSite entity){
		sysSiteMapper.updateWithIf(entity);
	}

	/**
	 * 详情
	 * @param result
	 * @param id
	 */
	public void findById(ResultData result,Integer id){
		SysSite entity=sysSiteMapper.findById(id);
		result.setData(entity);
	}
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(ResultData result,Integer id){
		sysSiteMapper.logicDelete(id);
	}
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByIds(ResultData result,Integer[] ids){
		sysSiteMapper.logicDeleteByIds(ids);
	}

}
