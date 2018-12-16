package com.zmyjn.index.carousel.controller;


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
import com.zmyjn.index.carousel.service.CarouselInfoService;
import com.zmyjn.index.carousel.entity.CarouselInfo;


/**
 * @Description: 轮播信息
 * @author: Administrator
 * @date: 2018-11-30 21:28:42
 */
@RestController
@Api(value = "轮播信息",tags = "轮播信息接口")
@RequestMapping("index/carouselinfo")
public class CarouselInfoController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private CarouselInfoService carouselInfoService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "轮播信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "groupId",value = "分组ID",dataType = "int", paramType = "query",required = false),
	})
	public ResultData list(@ModelAttribute Page<CarouselInfo> page,String searchKeys,Integer groupId){
		ResultData result=new ResultData();
		carouselInfoService.list(result,page,searchKeys,groupId);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "轮播信息新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		carouselInfoService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "轮播信息添加保存")
	public ResultData addSave(@ModelAttribute CarouselInfo entity){
		ResultData result=new ResultData();
		carouselInfoService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "轮播信息修改保存")
	public ResultData updateSave(@ModelAttribute CarouselInfo entity){
		ResultData result=new ResultData();
		carouselInfoService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "轮播信息详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		carouselInfoService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "轮播信息根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		carouselInfoService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "轮播信息根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		carouselInfoService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
