package com.zmyjn.sys.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zmyjn.core.constant.SessionConstants;
import com.zmyjn.core.log.LogUtil;

import com.zmyjn.core.util.MD5Utils;
import com.zmyjn.core.util.SessionUtil;
import com.zmyjn.core.util.jwt.Audience;
import com.zmyjn.core.util.jwt.JwtHelper;
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

import com.zmyjn.sys.user.dao.mapper.SysUserMapper;
import com.zmyjn.sys.user.entity.SysUser;
import com.zmyjn.sys.user.service.SysUserService;

/**
 * @Description: 系统用户信息
 * @author: Administrator
 * @date: 2018-11-15 11:27:00
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Integer> implements SysUserService{

	@SuppressWarnings("unused")
	private final LogUtil logger = LogUtil.getLogger(this.getClass());

	@Autowired
	private Audience audience;

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public BaseMapper<SysUser, Integer> getMapper(){
		return sysUserMapper;
	}
	
	/**
	 * 列表
	 * @param page
	 * @param searchKeys
	 */
	public void list(ResultData result,Page<SysUser> page,String searchKeys){
		Map<String, Object> mapSql=new HashMap<String, Object>();
		mapSql.put("searchKeys", StringUtils.searchKeys(searchKeys));
		
		PageHelper.startPage((int)page.getPage(), (int)page.getLimit());
		List<SysUser> list = sysUserMapper.list(mapSql);
		
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
			result.setData(sysUserMapper.findById(id));
		}
	}

	/**
	 * 添加保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSave(ResultData result,SysUser entity){
		sysUserMapper.insert(entity);
	}
	
	/**
	 * 修改保存
	 * @param result
	 * @param entity
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSave(ResultData result,SysUser entity){
		sysUserMapper.updateWithIf(entity);
	}

	/**
	 * 详情
	 * @param result
	 * @param id
	 */
	public void findById(ResultData result,Integer id){
		SysUser entity=sysUserMapper.findById(id);
		result.setData(entity);
	}
	
	/**
	 * 根据id删除
	 * @param result
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(ResultData result,Integer id){
		sysUserMapper.logicDelete(id);
	}
	
	/**
	 * 根据ids删除
	 * @param result
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByIds(ResultData result,Integer[] ids){
		sysUserMapper.logicDeleteByIds(ids);
	}



	/**
	 * 用户登录
	 * @param result
	 * @param username 用户名
	 * @param password 密码
	 * @param vercode 验证码
	 */
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response, ResultData result, String username, String password, String vercode) {

		logger.info("用户登录》》》》》》》》》》》》》");
		logger.info("请求参数》username："+username + ",password："+password+",vercode："+vercode);

		boolean flag = false;
		String msg = "";
		Integer code = -1;

		// 验证验证码
		if(vercode!=null){

			String sessionVercode = (String)request.getSession().getAttribute(SessionConstants.SESSION_VERCODE_KEY);
			logger.info("sessionVercode>>>"+sessionVercode);
			logger.info("vercode>>>"+vercode);

			if(sessionVercode.toUpperCase().equals(vercode.toUpperCase())){
				flag=true;
			}else{
				flag=false;
				msg = "验证码错误";
			}
		}

		// 验证账号密码
		if(flag){

			Map<String,Object> userMap = new HashMap<>();
			userMap.put("username",username);
			// 解密
			String decodePassword = MD5Utils.encrypt(password);
			userMap.put("password",decodePassword);
			SysUser sysUser = sysUserMapper.findOneByMap(userMap);

			if(sysUser!=null){

				flag = true;

				// 创建token
				String jwtToken = JwtHelper.createJWT(sysUser.getId().toString(),
						username,
						sysUser.getNickname(),
						sysUser.getMobile(),
						audience.getClientId(),
						audience.getName(),
						audience.getExpiresSecond()*1000,
						audience.getBase64Secret());

				String token = "bearer;" + jwtToken;

				Map<String,String> tokenMap = new HashMap<>();
				tokenMap.put("access_token",token);

				result.setData(tokenMap);
				msg = "登录成功";
				code = 0;

			}else{
				flag = false;
				msg="账号或密码错误";
			}
		}

		result.setResult(flag);
		result.setCode(code);
		result.setMsg(msg);
	}


	/**
	 * 获取用户信息
	 * @param result
	 */
	public void getUserInfo(ResultData result){
		Integer userId = SessionUtil.getLoginUserId();
		SysUser sysUser = sysUserMapper.findById(userId);
		result.setData(sysUser);
	}

	public void updateUserInfo(ResultData result,SysUser sysUser){
		Integer userId = SessionUtil.getLoginUserId();
		sysUser.setId(userId);
		sysUserMapper.updateWithIf(sysUser);
		result.setMsg("修改用户信息成功");
	}

	/**
	 * 修改用户密码
	 * @param result
	 * @param oldPassword 当前密码
	 * @param password 新密码
	 * @param repassword 确认密码
	 */
	public void updataUserPassword(ResultData result,String oldPassword,String password,String repassword){
		boolean flag = false;
		String msg = "操作失败";

		Integer userId = SessionUtil.getLoginUserId();

		SysUser sysUser = sysUserMapper.findById(userId);

		// 当前用户密码
		String userPassword = sysUser.getPassword();

		// 加密后的密码对比
		String encryptOldPassword = MD5Utils.encrypt(oldPassword);

		if(userPassword.equals(encryptOldPassword)){

			// 对比两次输入的新密码
			if(password.equals(repassword)){

				// 加密新密码
				String newPassword = MD5Utils.encrypt(password);
				SysUser updataSysUser = new SysUser();
				updataSysUser.setId(userId);
				updataSysUser.setPassword(newPassword);
				sysUserMapper.updateWithIf(updataSysUser);
                flag = true;
                msg = "修改密码成功";
			}else{
				flag = false;
				msg = "两次密码输入不一致";
			}

		}else{
			flag = false;
			msg = "当前输入的密码不正确";
		}


		result.setResult(flag);
		result.setMsg(msg);
	}
}
