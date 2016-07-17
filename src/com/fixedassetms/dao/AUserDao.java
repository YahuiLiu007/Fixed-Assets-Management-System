
/**
 * 创建登记人员信息管理dao层的接口
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.dao;
import java.util.List;

import com.fixedassetms.entity.AUser;
public interface AUserDao {
	/**
	 * 增添人员信息
	 * @param auser
	 * @return
	 */
	int save(AUser auser);
	/**
	 * 删除人员信息
	 * @param auser
	 * @return
	 */
	int del(AUser auser);
	/**
	 * 更新人员信息
	 * @param auser
	 * @return
	 */
	int update(AUser auser);
	/**
	 * 根据用户名及职务查询
	 * @param auser
	 * @return
	 */
	AUser findUser(AUser auser);
	/**
	 * 根据ID查询
	 * @param ID
	 * @return
	 */
	AUser getByID(int ID);
	/**
	 * 打印所有人员信息
	 * @return
	 */
	List<AUser> showall();

}