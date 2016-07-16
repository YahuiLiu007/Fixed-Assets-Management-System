package com.fixedassetms.dao;
/**
 * 固定资产领用与归还表操作接口
 * @author zhaohui
 *	create on 2016-7-15
 */
public interface LendOrReturnDao {
	/**
	 * 固定资产领用表增添
	 */
	int lendAdd(Object[] param);
	/**
	 * 固定资产归还表增添
	 */
	int returnAdd(Object[] param);
}
