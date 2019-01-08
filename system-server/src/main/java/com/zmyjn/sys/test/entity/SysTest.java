package com.zmyjn.sys.test.entity;


import java.io.Serializable;


/**
 * @Description: 测试
 * @author: Administrator
 * @date: 2019-01-04 11:39:52
 */
public class SysTest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键ID
	 */
	private Integer id;	
	/**
	 * 名称
	 */
	private String name;	
	/**
	 * 状态
	 */
	private String status1;	
	/**
	 * 备注
	 */
	private String remark;	


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
 

}

