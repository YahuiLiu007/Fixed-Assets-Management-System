/**
 * �����Ǽ���Ա��Ϣ��ʵ����
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.entity;

public class AUser {
	private int id;
	/**
	 * �Ǽ���Ա���
	 */
	private String name;
	/**
	 * �Ǽ���Ա����
	 */
	private String duty;
	/**
	 * �Ǽ���Աְ��
	 */
	private String remark;
	/**
	 * ��ע
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