package com.zmyjn.sys.test.controller;


import com.zmyjn.common.annotation.SysLog;
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
import com.zmyjn.sys.test.service.SysTestService;
import com.zmyjn.sys.test.entity.SysTest;


/**
 * @Description: 测试
 * @author: Administrator
 * @date: 2019-01-04 11:39:52
 */
@RestController
@Api(value = "测试",tags = "测试接口")
@RequestMapping("/sys/sysTest")
public class SysTestController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysTestService sysTestService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "测试列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false)
	})
	@SysLog("测试啊")
	public ResultData list(@ModelAttribute Page<SysTest> page,String searchKeys){
		ResultData result=new ResultData();
		sysTestService.list(result,page,searchKeys);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "测试新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		sysTestService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "测试添加保存")
	public ResultData addSave(@ModelAttribute SysTest entity){
		ResultData result=new ResultData();
		sysTestService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "测试修改保存")
	public ResultData updateSave(@ModelAttribute SysTest entity){
		ResultData result=new ResultData();
		sysTestService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "测试详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		sysTestService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "测试根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		sysTestService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "测试根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		sysTestService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
