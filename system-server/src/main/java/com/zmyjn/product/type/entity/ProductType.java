package com.zmyjn.product.type.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * @Description: 商品类型
 * @author: Administrator
 * @date: 2019-01-04 16:05:01
 */
public class ProductType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键ID
	 */
	private Integer id;	
	/**
	 * 父Id
	 */
	private Integer parentId;	
	/**
	 * 类型名称
	 */
	private String name;	
	/**
	 * 编号
	 */
	private String code;	
	/**
	 * 排序
	 */
	private Integer sort;	
	/**
	 * 状态（0：待发布，1：正常）
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
 
 	public void setParentId(Integer parentId){	
 		this.parentId=parentId;	
 	}	
 
 	public Integer getParentId(){	
 		return this.parentId;	
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

