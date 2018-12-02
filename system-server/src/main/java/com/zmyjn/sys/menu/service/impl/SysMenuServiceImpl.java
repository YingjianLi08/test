package com.zmyjn.sys.menu.service.impl;

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

import com.zmyjn.sys.menu.dao.mapper.SysMenuMapper;
import com.zmyjn.sys.menu.entity.SysMenu;
import com.zmyjn.sys.menu.service.SysMenuService;

/**
 * @Description: 系统菜单信息
 * @author: Administrator
 * @date: 2018-11-15 10:39:15
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, Integer> implements SysMenuService{

	@SuppressWarnings("unused")
	private final LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Override
	public BaseMapper<SysMenu, Integer> getMapper(){
		return sysMenuMapper;
	}
	
	/**
	 * 列表
	 * @param page
	 * @param searchKeys
	 */
	public void list(ResultData result,Page<SysMenu> page,String searchKeys){
		Map<String, Object> mapSql=new HashMap<String, Object>();
		mapSql.put("searchKeys", StringUtils.searchKeys(searchKeys));
		
		PageHelper.startPage((int)page.getPage(), (int)page.getLimit());
		List<SysMenu> list = sysMenuMapper.list(mapSql);
		
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
			result.setData(sysMenuMapper.findById(id));
		}
	}

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSave(ResultData result,SysMenu entity){
		sysMenuMapper.insert(entity);
	}
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSave(ResultData result,SysMenu entity){
		sysMenuMapper.updateWithIf(entity);
	}

	/**
	 * 详情
	 * @param result
	 * @param id
	 */
	public void findById(ResultData result,Integer id){
		SysMenu entity=sysMenuMapper.findById(id);
		result.setData(entity);
	}
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(ResultData result,Integer id){
		sysMenuMapper.logicDelete(id);
	}
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByIds(ResultData result,Integer[] ids){
		sysMenuMapper.logicDeleteByIds(ids);
	}

}
