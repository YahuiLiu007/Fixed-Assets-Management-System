package com.fixedassetms.entity;

import java.util.Date;

public class FixedAsset {
	
	/**
	 * �豸���
	 */
	private int id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ���
	 */
	private String category;
	/**
	 * �ͺ�
	 */
	private String type;
	/**
	 * ��ֵ
	 */
	private int price;
	/**
	 * ��������(xxxx-xx-xx)
	 */
	private Date indate;
	/**
	 * ״̬��������ά�ޡ����ϣ�
	 */
	private String status;
	/**
	 * ʹ����
	 */
	
	private String auser;
	/**
	 * ��ע
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
	public String getAuser() {
		return auser;
	}
	public void setAuser(String auser) {
		this.auser = auser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	


}
