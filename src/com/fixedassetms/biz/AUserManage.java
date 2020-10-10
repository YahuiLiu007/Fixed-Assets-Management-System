/**
 * 创建登记人员信息管理功能界面的接口
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.biz;

public interface AUserManage {
	/**
	 * 增添登记人员信息界面
	 */
	public void msave();
	/**
	 * 更新登记人员信息界面
	 */
	public void mupdate();
	/**
	 * 删除登记人员信息界面
	 */
	public void mdel();
	/**
	 * 打印登记人员信息界面
	 */
	public void usershowall();

}
