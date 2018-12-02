package com.zmyjn.sys.menu.controller;


import com.zmyjn.core.log.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.page.Page;
import com.zmyjn.core.util.StringUtils;
import com.zmyjn.sys.menu.service.SysMenuService;
import com.zmyjn.sys.menu.entity.SysMenu;


/**
 * @Description: 系统菜单信息
 * @author: Administrator
 * @date: 2018-11-15 10:39:15
 */
@RestController
@Api(value = "系统菜单信息",tags = "系统菜单信息接口")
@RequestMapping("/sysmenu")
public class SysMenuController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysMenuService sysMenuService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "系统菜单信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false)
	})
	public ResultData list(Page<SysMenu> page,String searchKeys){
		ResultData result=new ResultData();
		sysMenuService.list(result,page,searchKeys);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "系统菜单信息新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		sysMenuService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "系统菜单信息添加保存")
	public ResultData addSave(SysMenu entity){
		ResultData result=new ResultData();
		sysMenuService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "系统菜单信息修改保存")
	public ResultData updateSave(SysMenu entity){
		ResultData result=new ResultData();
		sysMenuService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "系统菜单信息详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		sysMenuService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "系统菜单信息根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		sysMenuService.deleteById(result,id);
		return result;
	}
	/**
	 * 根据ids删除
	 * @param ids
	 * @return
	 */
	@PostMapping(value="/deleteByIds")
	@ApiOperation(value = "系统菜单信息根据id删除多个")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids",value = "主键ids",dataType = "##{tablePrimaryKeyType}##", paramType = "query",required = true)
	})
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		sysMenuService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
