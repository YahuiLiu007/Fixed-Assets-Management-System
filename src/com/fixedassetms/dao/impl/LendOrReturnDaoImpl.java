package com.fixedassetms.dao.impl;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.LendOrReturnDao;
/**
 * �̶��ʲ�������黹�����ʵ��
 * @author zhaohui
 *	create 2016-7-15
 */
public class LendOrReturnDaoImpl extends BaseDao implements LendOrReturnDao{

	/**
	 * �̶��ʲ����ñ�����ʵ��
	 */
	public int lendAdd(Object[] param) {
		String sql="insert into Lend(fiexedasset_id,auser_id,lenddate,purpose,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * �̶��ʲ��黹������ʵ��
	 */
	public int returnAdd(Object[] param) {
		String sql="insert into Return(fiexedasset_id,auser_id,returndate,purpose,returnstatus,manager_id,remark) values(?,?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

}
