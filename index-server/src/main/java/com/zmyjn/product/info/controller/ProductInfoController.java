package com.zmyjn.product.info.controller;


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
import com.zmyjn.product.info.service.ProductInfoService;
import com.zmyjn.product.info.entity.ProductInfo;


/**
 * @Description: 商品信息
 * @author: LIYINGJIAN
 * @date: 2018-12-30 14:00:45
 */
@RestController
@Api(value = "商品信息",tags = "商品信息接口")
@RequestMapping("index/productinfo")
public class ProductInfoController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private ProductInfoService productInfoService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "商品信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false)
	})
	public ResultData list(@ModelAttribute Page<ProductInfo> page,String searchKeys){
		ResultData result=new ResultData();
		productInfoService.list(result,page,searchKeys);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "商品信息新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		productInfoService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "商品信息添加保存")
	public ResultData addSave(@ModelAttribute ProductInfo entity){
		ResultData result=new ResultData();
		productInfoService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "商品信息修改保存")
	public ResultData updateSave(@ModelAttribute ProductInfo entity){
		ResultData result=new ResultData();
		productInfoService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "商品信息详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		productInfoService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "商品信息根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		productInfoService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "商品信息根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		productInfoService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
