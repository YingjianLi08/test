package com.zmyjn.product.info.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * @Description: 商品信息
 * @author: Administrator
 * @date: 2018-11-18 12:38:46
 */
public class ProductInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 
	 */
	private Integer id;	
	/**
	 * 商品编号
	 */
	private String code;	
	/**
	 * 商品名称
	 */
	private String name;	
	/**
	 * 商品价格
	 */
	private String price;	
	/**
	 * 商品图片
	 */
	private String image;	
	/**
	 * 单位
	 */
	private String unit;	
	/**
	 * 商品条形码
	 */
	private String barCode;	
	/**
	 * 商品库存数量
	 */
	private Integer stockCount;	
	/**
	 * 类型id
	 */
	private Integer typeId;	
	/**
	 * 状态（1：正常）
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
 
 	public void setCode(String code){	
 		this.code=code;	
 	}	
 
 	public String getCode(){	
 		return this.code;	
 	}	
 
 	public void setName(String name){	
 		this.name=name;	
 	}	
 
 	public String getName(){	
 		return this.name;	
 	}	
 
 	public void setPrice(String price){	
 		this.price=price;	
 	}	
 
 	public String getPrice(){	
 		return this.price;	
 	}	
 
 	public void setImage(String image){	
 		this.image=image;	
 	}	
 
 	public String getImage(){	
 		return this.image;	
 	}	
 
 	public void setUnit(String unit){	
 		this.unit=unit;	
 	}	
 
 	public String getUnit(){	
 		return this.unit;	
 	}	
 
 	public void setBarCode(String barCode){	
 		this.barCode=barCode;	
 	}	
 
 	public String getBarCode(){	
 		return this.barCode;	
 	}	
 
 	public void setStockCount(Integer stockCount){	
 		this.stockCount=stockCount;	
 	}	
 
 	public Integer getStockCount(){	
 		return this.stockCount;	
 	}	
 
 	public void setTypeId(Integer typeId){	
 		this.typeId=typeId;	
 	}	
 
 	public Integer getTypeId(){	
 		return this.typeId;	
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

