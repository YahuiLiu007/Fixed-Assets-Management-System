package com.fixedassetms.entity;

public class Manager {
	/**
	 * 管理人员id
	 */
	private int id;
	/**
	 * 管理人员名
	 */
	private String name;
	/**
	 * 管理人员密码
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
