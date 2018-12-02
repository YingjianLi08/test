package com.zmyjn.sys.menu.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * @Description: 系统菜单信息
 * @author: Administrator
 * @date: 2018-11-15 10:39:15
 */
public class SysMenu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键
	 */
	private Integer id;	
	/**
	 * 父id
	 */
	private Integer pid;	
	/**
	 * 菜单name
	 */
	private String name;	
	/**
	 * 标题
	 */
	private String title;	
	/**
	 * 跳转链接
	 */
	private String jump;	
	/**
	 * 图标
	 */
	private String icon;	
	/**
	 * 是否展开
	 */
	private String spread;	
	/**
	 * 排序
	 */
	private Integer sort;	
	/**
	 * 状态（1：正常）
	 */
	private String status;	
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
 
 	public void setPid(Integer pid){	
 		this.pid=pid;	
 	}	
 
 	public Integer getPid(){	
 		return this.pid;	
 	}	
 
 	public void setName(String name){	
 		this.name=name;	
 	}	
 
 	public String getName(){	
 		return this.name;	
 	}	
 
 	public void setTitle(String title){	
 		this.title=title;	
 	}	
 
 	public String getTitle(){	
 		return this.title;	
 	}	
 
 	public void setJump(String jump){	
 		this.jump=jump;	
 	}	
 
 	public String getJump(){	
 		return this.jump;	
 	}	
 
 	public void setIcon(String icon){	
 		this.icon=icon;	
 	}	
 
 	public String getIcon(){	
 		return this.icon;	
 	}	
 
 	public void setSpread(String spread){	
 		this.spread=spread;	
 	}	
 
 	public String getSpread(){	
 		return this.spread;	
 	}	
 
 	public void setSort(Integer sort){	
 		this.sort=sort;	
 	}	
 
 	public Integer getSort(){	
 		return this.sort;	
 	}	
 
 	public void setStatus(String status){	
 		this.status=status;	
 	}	
 
 	public String getStatus(){	
 		return this.status;	
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

