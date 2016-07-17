/**
 * 管理人员管理操作接口
 * @author wenxing
 *create on 2016-7-16 14:54:42
 *
 */
package com.fixedassetms.biz;

import java.util.List;

import com.fixedassetms.entity.Manager;
/**
 * 
 * @author wenxing
 * modified by muse on 2016-7-17
 *
 */
public interface ManagerManage {
	/**
	 * 增添管理人员信息界面
	 */
	public void msave();
	/**
	 * 更新管理人员信息界面
	 */
	public void mupdate(Manager manager);
	/**
	 * 删除管理人员信息界面
	 */
	public void mdel();
	/**
	 * 打印所有管理人员信息界面
	 */
	public void managershowall();
	/**
	 * 管理人员登录方法
	 */
	public Manager Login();
}
