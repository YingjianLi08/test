package com.zmyjn.index.carousel.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * @Description: 轮播分组信息
 * @author: Administrator
 * @date: 2018-11-20 14:42:10
 */
public class CarouselGroup implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 
	 */
	private Integer id;	
	/**
	 * 轮播分组名称
	 */
	private String name;	
	/**
	 * 轮播分组编号
	 */
	private String code;	
	/**
	 * 类型
	 */
	private String type;	
	/**
	 * 轮播分组排序
	 */
	private Integer sort;	
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
 
 	public void setName(String name){	
 		this.name=name;	
 	}	
 
 	public String getName(){	
 		return this.name;	
 	}	
 
 	public void setCode(String code){	
 		this.code=code;	
 	}	
 
 	public String getCode(){	
 		return this.code;	
 	}	
 
 	public void setType(String type){	
 		this.type=type;	
 	}	
 
 	public String getType(){	
 		return this.type;	
 	}	
 
 	public void setSort(Integer sort){	
 		this.sort=sort;	
 	}	
 
 	public Integer getSort(){	
 		return this.sort;	
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

