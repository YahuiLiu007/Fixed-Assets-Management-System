/**
 * 创建管理员信息的实体类
 * @author wenxing
 * create on 2016-7-14
 */
package com.fixedassetms.entity;

public class Manager {
	/**
	 * 管理员id
	 */
	private int id;
	/**
	 * 管理员名
	 */
	private String name;
	/**
	 * 管理员密码
	 */
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
