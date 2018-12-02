package com.zmyjn.sys.user.service;


import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.base.service.BaseService;
import com.zmyjn.core.page.Page;
import com.zmyjn.sys.user.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 系统用户信息
 * @author: Administrator
 * @date: 2018-11-15 11:27:00
 */
public interface SysUserService extends BaseService<SysUser, Integer> {
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	void list(ResultData result, Page<SysUser> page,String searchKeys);
	
	/**
	 * 新增/修改初始化
	 * @param result
	 * @param id
	 * @return
	 */
	void init(ResultData result,Integer id);

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 * @return
	 */
	void addSave(ResultData result, SysUser entity);
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 * @return
	 */
	void updateSave(ResultData result, SysUser entity);
	
	/**
	 * 详情
	 * @param result
	 * @param id
	 * @return
	 */
	void findById( ResultData result, Integer id);
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 * @return
	 */
	void deleteByIds(ResultData result, Integer[] ids);
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 * @return
	 */
	void deleteById(ResultData result, Integer id);

	/**
	 * 用户登录
	 * @param result
	 * @param username 用户名
	 * @param password 密码
	 * @param vercode 验证码
	 */
	void login(HttpServletRequest request, HttpServletResponse response, ResultData result, String username, String password, String vercode);

	/**
	 * 获取用户信息
	 * @param result
	 */
	void getUserInfo(ResultData result);

	/**
	 * 修改用户信息
	 * @param result
	 * @param sysUser
	 */
	void updateUserInfo(ResultData result,SysUser sysUser);


	/**
	 * 修改用户密码
	 * @param result
	 * @param oldPassword 当前密码
	 * @param password 新密码
	 * @param repassword 确认密码
	 */
	void updataUserPassword(ResultData result,String oldPassword,String password,String repassword);
}
