/**
 * 创建管理员信息管理dao层的接口
 * @author wenxing
 * create on 2016-7-14
 */
package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.Manager;;

public interface ManagerDao {
	/**
	 * 增添管理员信息
	 * @param manager
	 * @return 影响行数
	 */
	int save(Manager manager);
	/**
	 * 删除管理员信息
	 * @param manager
	 * @return 影响行数
	 */
	int del(Manager manager);
	/**
	 * 更新管理员信息
	 * @param manager
	 * @return 影响行数
	 */
	int update(Manager manager);
	/**
	 * 精确查询管理员信息
	 * @param manager
	 * @return manager对象
	 */
	Manager findManager(Manager manager);
	/**
	 * 根据管理员名查找管理员
	 * @param 管理员名
	 * @return true 能找到，false，不能找到
	 */
	boolean findManByName(String manName);
	/**
	 * 根据id查询管理员信息
	 * @param 管理员id
	 * @return manager对象
	 */
	Manager getByID(int ID);//根据ID查询
	/**
	 * 打印所有管理员信息
	 * @param 
	 * @return list
	 */
	List<Manager> showall();//打印所有管理员信息
}
