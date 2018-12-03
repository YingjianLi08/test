package com.zmyjn.index.site.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * @Description: 网站信息
 * @author: Administrator
 * @date: 2018-12-03 11:48:40
 */
public class SysSite implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 
	 */
	private Integer id;	
	/**
	 * 网站名称
	 */
	private String siteName;	
	/**
	 * 网站域名
	 */
	private String domain;	
	/**
	 * 首页标题
	 */
	private String title;	
	/**
	 * 关键词
	 */
	private String keywords;	
	/**
	 * 网站描述
	 */
	private String description;	
	/**
	 * 网站logo
	 */
	private String logo;	
	/**
	 * 网站电话
	 */
	private String phone;	
	/**
	 * 网站邮箱
	 */
	private String email;	
	/**
	 * 版权
	 */
	private String copyright;	
	/**
	 * 网站备案
	 */
	private String beian;	
	/**
	 * 类型
	 */
	private String type;	
	/**
	 * 状态
	 */
	private String status1;	
	/**
	 * 备注
	 */
	private String remark;	
	/**
	 * 创建人id
	 */
	private Integer createBy;	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;	
	/**
	 * 修改人id
	 */
	private Integer updateBy;	
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime;	


 	public void setId(Integer id){	
 		this.id=id;	
 	}	
 
 	public Integer getId(){	
 		return this.id;	
 	}	
 
 	public void setSiteName(String siteName){	
 		this.siteName=siteName;	
 	}	
 
 	public String getSiteName(){	
 		return this.siteName;	
 	}	
 
 	public void setDomain(String domain){	
 		this.domain=domain;	
 	}	
 
 	public String getDomain(){	
 		return this.domain;	
 	}	
 
 	public void setTitle(String title){	
 		this.title=title;	
 	}	
 
 	public String getTitle(){	
 		return this.title;	
 	}	
 
 	public void setKeywords(String keywords){	
 		this.keywords=keywords;	
 	}	
 
 	public String getKeywords(){	
 		return this.keywords;	
 	}	
 
 	public void setDescription(String description){	
 		this.description=description;	
 	}	
 
 	public String getDescription(){	
 		return this.description;	
 	}	
 
 	public void setLogo(String logo){	
 		this.logo=logo;	
 	}	
 
 	public String getLogo(){	
 		return this.logo;	
 	}	
 
 	public void setPhone(String phone){	
 		this.phone=phone;	
 	}	
 
 	public String getPhone(){	
 		return this.phone;	
 	}	
 
 	public void setEmail(String email){	
 		this.email=email;	
 	}	
 
 	public String getEmail(){	
 		return this.email;	
 	}	
 
 	public void setCopyright(String copyright){	
 		this.copyright=copyright;	
 	}	
 
 	public String getCopyright(){	
 		return this.copyright;	
 	}	
 
 	public void setBeian(String beian){	
 		this.beian=beian;	
 	}	
 
 	public String getBeian(){	
 		return this.beian;	
 	}	
 
 	public void setType(String type){	
 		this.type=type;	
 	}	
 
 	public String getType(){	
 		return this.type;	
 	}	
 
 	public void setStatus1(String status1){	
 		this.status1=status1;	
 	}	
 
 	public String getStatus1(){	
 		return this.status1;	
 	}	
 
 	public void setRemark(String remark){	
 		this.remark=remark;	
 	}	
 
 	public String getRemark(){	
 		return this.remark;	
 	}	
 
 	public void setCreateBy(Integer createBy){	
 		this.createBy=createBy;	
 	}	
 
 	public Integer getCreateBy(){	
 		return this.createBy;	
 	}	
 
 	public void setCreateTime(Date createTime){	
 		this.createTime=createTime;	
 	}	
 
 	public Date getCreateTime(){	
 		return this.createTime;	
 	}	
 
 	public void setUpdateBy(Integer updateBy){	
 		this.updateBy=updateBy;	
 	}	
 
 	public Integer getUpdateBy(){	
 		return this.updateBy;	
 	}	
 
 	public void setUpdateTime(Date updateTime){	
 		this.updateTime=updateTime;	
 	}	
 
 	public Date getUpdateTime(){	
 		return this.updateTime;	
 	}	
 

}

