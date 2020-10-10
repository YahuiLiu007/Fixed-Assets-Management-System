/**
 * 创建登记人员信息的实体类
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.entity;

public class AUser {
	private int id;
	/**
	 * 登记人员编号
	 */
	private String name;
	/**
	 * 登记人员姓名
	 */
	private String duty;
	/**
	 * 登记人员职务
	 */
	private String remark;
	/**
	 * 备注
	 */
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
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
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
}