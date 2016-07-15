package com.fixedassetms.dao.impl;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.LendOrReturnDao;
/**
 * 固定资产领用与归还表操作实现
 * @author zhaohui
 *	create 2016-7-15
 */
public class LendOrReturnDaoImpl extends BaseDao implements LendOrReturnDao{

	/**
	 * 固定资产领用表增添实现
	 */
	public int lendAdd(Object[] param) {
		String sql="insert into Lend(fiexedasset_id,auser_id,lenddate,purpose,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * 固定资产归还表增添实现
	 */
	public int returnAdd(Object[] param) {
		String sql="insert into Return(fiexedasset_id,auser_id,returndate,purpose,returnstatus,manager_id,remark) values(?,?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

}
