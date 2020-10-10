package com.fixedassetms.dao;

import java.util.List;

/**
 * 固定资产领用与归还表操作接口
 * @author zhaohui
 *	create on 2016-7-15
 */
public interface LendOrReturnDao {
	/**
	 * 固定资产领用表增添
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	int lendAdd(Object[] param);
	/**
	 * 固定资产领用表打印  
	 * @return 固定资产领用表里全部消息
	 */
	List<String> lendShow();
	/**
	 * 固定资产归还表增添
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	int retAdd(Object[] param);
	/**
	 * 固定资产归还表打印  
	 * @return 固定资产归还表里全部消息
	 */
	List<String> retShow();
}
