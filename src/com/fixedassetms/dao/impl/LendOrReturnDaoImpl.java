package com.fixedassetms.dao.impl;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.LendOrReturnDao;
/**
 * 固定资产领用与归还表操作实现
 * @author zhaohui
 *	create on 2016-7-15
 */
public class LendOrReturnDaoImpl extends BaseDao implements LendOrReturnDao{

	/**
	 * 固定资产领用表增添实现
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int lendAdd(Object[] param) {
		String sql="insert into Lend(fixedasset_id,auser_id,lenddate,purpose,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * 固定资产归还表增添实现
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int retAdd(Object[] param) {
		String sql="insert into Ret(fixedasset_id,auser_id,returndate,returnstatus,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
}
