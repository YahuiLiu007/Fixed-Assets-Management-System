package com.fixedassetms.entity;

import java.util.Date;
/**固定资产实体类
 * 
 * @author muse
 *create on 2016-7-15
 */
public class FixedAsset {
	
	/**
	 * 设备编号
	 */
	private int id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 型号
	 */
	private String type;
	/**
	 * 价值
	 */
	private int price;
	/**
	 * 购买日期(xxxx-xx-xx)
	 */
	private Date indate;
	/**
	 * 状态（正常、维修、报废）
	 */
	private String status;
	/**
	 * 使用者Id
	 */
	
	private int auser_id;
	/**
	 * 备注
	 */
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getAuser_id() {
		return auser_id;
	}
	public void setAuser_id(int auser_id) {
		this.auser_id = auser_id;
	}
	


}
