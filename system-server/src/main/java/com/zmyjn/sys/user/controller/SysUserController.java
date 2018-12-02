package com.zmyjn.sys.user.controller;


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
import com.zmyjn.sys.user.service.SysUserService;
import com.zmyjn.sys.user.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description: 系统用户信息
 * @author: Administrator
 * @date: 2018-11-15 11:27:00
 */
@RestController
@Api(value = "系统用户信息",tags = "系统用户信息接口")
@RequestMapping("sys/sysuser")
public class SysUserController{
	
	private final  LogUtil logger = LogUtil.getLogger(this.getClass());
	
	@Autowired
	private SysUserService sysUserService;
	

	@GetMapping(value="/list")
	@ApiOperation(value = "系统用户信息列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchKeys",value = "关键词",dataType = "string", paramType = "query",required = false)
	})
	public ResultData list(Page<SysUser> page,String searchKeys){
		ResultData result=new ResultData();
		sysUserService.list(result,page,searchKeys);

		return result;
	}


	@GetMapping(value="/init")
	@ApiOperation(value = "系统用户信息新增/修改初始化")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData init(Integer id){
		ResultData result=new ResultData();
		sysUserService.init(result,id);
		return result;
	}
	

	@PostMapping(value="/addSave")
	@ApiOperation(value = "系统用户信息添加保存")
	public ResultData addSave(SysUser entity){
		ResultData result=new ResultData();
		sysUserService.addSave(result,entity);
		return result;
	}
	

	@PostMapping(value="/updateSave")
	@ApiOperation(value = "系统用户信息修改保存")
	public ResultData updateSave(SysUser entity){
		ResultData result=new ResultData();
		sysUserService.updateSave(result,entity);
		return result;
	}
	

	@GetMapping(value="/findById")
	@ApiOperation(value = "系统用户信息详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData findById(Integer id){		
		ResultData result=new ResultData();
		sysUserService.findById(result,id);
		return result;
	}
	

	@PostMapping(value="/deleteById")
	@ApiOperation(value = "系统用户信息根据id删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
	})
	public ResultData deleteById(Integer id){		
		ResultData result=new ResultData();
		sysUserService.deleteById(result,id);
		return result;
	}

	@PostMapping(value="/deleteByIds")
    @ApiOperation(value = "系统用户信息根据id删除多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键id",dataType = "Integer", paramType = "query",required = true)
    })
	public ResultData deleteByIds(String ids){		
		ResultData result=new ResultData();
		Integer[] splitIds=StringUtils.splitToInteger(ids," ");
		sysUserService.deleteByIds(result,splitIds);
		return result;
	}


	@PostMapping(value="/login")
	@ApiOperation(value = "用户登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username",value = "用户账号",dataType = "string",paramType = "query",required = true),
			@ApiImplicitParam(name = "password",value = "密码",dataType = "string", paramType = "query",required = true),
			// @ApiImplicitParam(name = "mobile",value = "手机号",dataType = "string" , paramType = "form",required = true),
			@ApiImplicitParam(name = "vercode",value = "验证码",dataType = "string", paramType = "query",required = true)
	})
	public ResultData login(HttpServletRequest request, HttpServletResponse response, String username, String password, String vercode){
		ResultData result=new ResultData();
		sysUserService.login(request,response,result,username,password,vercode);
		return result;
	}


	@GetMapping(value="/logout")
	public ResultData logout(){
		ResultData result=new ResultData();
//		Map<String,String> map = new HashMap<>();
//		map.put("access_token","1234");
//		result.setData(map);
		result.setMsg("退出成功");

		return result;
	}


	@GetMapping(value="/testLogin")
	public ResultData testLogin(){
		ResultData result=new ResultData();
		return result;
	}


	@GetMapping(value = "/getUserInfo")
	public ResultData getUserInfo(){
		ResultData result=new ResultData();

		sysUserService.getUserInfo(result);

		return result;
	}

	@PostMapping(value = "/updateUserInfo")
	@ApiOperation(value = "修改用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "nickname",value = "用户昵称",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "sex",value = "性别",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "avatar",value = "头像",dataType = "string",paramType = "query",required = false),
			@ApiImplicitParam(name = "mobile",value = "手机",dataType = "string", paramType = "query",required = false),
			@ApiImplicitParam(name = "email",value = "邮箱",dataType = "string",paramType = "query",required = false),
			@ApiImplicitParam(name = "remark",value = "备注",dataType = "string", paramType = "query",required = false)

	})
	public ResultData updateUserInfo(String nickname,String sex,String avatar,String mobile,String email,String remark){

		ResultData result = new ResultData();

		SysUser sysUser = new SysUser();
		sysUser.setNickname(nickname);
		sysUser.setSex(sex);
		sysUser.setAvatar(avatar);
		sysUser.setMobile(mobile);
		sysUser.setEmail(email);
		sysUser.setRemark(remark);
		sysUserService.updateUserInfo(result,sysUser);

		return result;
	}

	@PostMapping(value = "/updataUserPassword")
	@ApiOperation(value = "修改用户密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "oldPassword",value = "当前密码",dataType = "string", paramType = "query",required = true),
			@ApiImplicitParam(name = "password",value = "新密码",dataType = "string", paramType = "query",required = true),
			@ApiImplicitParam(name = "repassword",value = "确认新密码",dataType = "string", paramType = "query",required = true)
	})
	public ResultData updataUserPassword(String oldPassword,String password,String repassword){
		ResultData result=new ResultData();

		sysUserService.updataUserPassword(result,oldPassword,password,repassword);

		return result;
	}
	

}
