package com.fixedassetms.dao.impl;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.LendOrReturnDao;
/**
 * �̶��ʲ�������黹�����ʵ��
 * @author zhaohui
 *	create on 2016-7-15
 */
public class LendOrReturnDaoImpl extends BaseDao implements LendOrReturnDao{

	/**
	 * �̶��ʲ����ñ�����ʵ��
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int lendAdd(Object[] param) {
		String sql="insert into Lend(fixedasset_id,auser_id,lenddate,purpose,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * �̶��ʲ��黹������ʵ��
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int retAdd(Object[] param) {
		String sql="insert into Ret(fixedasset_id,auser_id,returndate,returnstatus,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
}
