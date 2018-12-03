package com.zmyjn.index.site.controller;


import com.zmyjn.core.log.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.page.Page;
import com.zmyjn.core.util.StringUtils;
import com.zmyjn.index.site.service.SysSiteService;
import com.zmyjn.index.site.entity.SysSite;


/**
 * @Description: 网站信息
 * @author: Administrator
 * @date: 2018-12-03 11:48:40
 */
@RestController
@Api(value = "网站信息",tags = "网站信息接口")
@RequestMapping("index/syssite")
public class SysSiteController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysSiteService sysSiteService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "网站信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false)
	})
	public ResultData list(@ModelAttribute Page<SysSite> page,String searchKeys){
		ResultData result=new ResultData();
		sysSiteService.list(result,page,searchKeys);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "网站信息新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		sysSiteService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "网站信息添加保存")
	public ResultData addSave(@ModelAttribute SysSite entity){
		ResultData result=new ResultData();
		sysSiteService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "网站信息修改保存")
	public ResultData updateSave(@ModelAttribute SysSite entity){
		ResultData result=new ResultData();
		sysSiteService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "网站信息详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		sysSiteService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "网站信息根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		sysSiteService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "网站信息根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		sysSiteService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
