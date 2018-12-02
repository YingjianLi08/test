package com.zmyjn.index.carousel.controller;


import com.zmyjn.core.log.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.page.Page;
import com.zmyjn.core.util.StringUtils;
import com.zmyjn.index.carousel.service.CarouselGroupService;
import com.zmyjn.index.carousel.entity.CarouselGroup;


/**
 * @Description: 轮播分组信息
 * @author: Administrator
 * @date: 2018-11-20 14:42:10
 */
@RestController
@Api(value = "轮播分组信息",tags = "轮播分组信息接口")
@RequestMapping("sys/carouselgroup")
public class CarouselGroupController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private CarouselGroupService carouselGroupService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "轮播分组信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "name",value = "分组名称",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "code",value = "分组编号",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "type",value = "类型",dataType = "string", paramType = "query",required = false)
	})
	public ResultData list(@ModelAttribute Page<CarouselGroup> page, String searchKeys,String name,String code,String type){
		ResultData result=new ResultData();
		carouselGroupService.list(result,page,searchKeys,name,code,type);
		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "轮播分组信息新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		carouselGroupService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "轮播分组信息添加保存")
	public ResultData addSave(@ModelAttribute CarouselGroup entity){
		ResultData result=new ResultData();
		carouselGroupService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "轮播分组信息修改保存")
	public ResultData updateSave(CarouselGroup entity){
		ResultData result=new ResultData();
		carouselGroupService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "轮播分组信息详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		carouselGroupService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "轮播分组信息根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		carouselGroupService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "轮播分组信息根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		carouselGroupService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
