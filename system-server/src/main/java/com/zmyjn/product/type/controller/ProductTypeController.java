package com.zmyjn.product.type.controller;


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
import com.zmyjn.product.type.service.ProductTypeService;
import com.zmyjn.product.type.entity.ProductType;


/**
 * @Description: 商品类型
 * @author: Administrator
 * @date: 2019-01-04 16:05:01
 */
@RestController
@Api(value = "商品类型",tags = "商品类型接口")
@RequestMapping("/sys/productType")
public class ProductTypeController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private ProductTypeService productTypeService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "商品类型列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false)
	})
	public ResultData list(@ModelAttribute Page<ProductType> page,String searchKeys){
		ResultData result=new ResultData();
		productTypeService.list(result,page,searchKeys);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "商品类型新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		productTypeService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "商品类型添加保存")
	public ResultData addSave(@ModelAttribute ProductType entity){
		ResultData result=new ResultData();
		productTypeService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "商品类型修改保存")
	public ResultData updateSave(@ModelAttribute ProductType entity){
		ResultData result=new ResultData();
		productTypeService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "商品类型详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		productTypeService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "商品类型根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		productTypeService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "商品类型根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		productTypeService.deleteByIds(result,splitIds);
		return result;
	}
	
	

}
