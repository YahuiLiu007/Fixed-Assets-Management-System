package com.fixedassetms.dao;
/**
 * �̶��ʲ�������黹������ӿ�
 * @author zhaohui
 *	create 2016-7-15
 */
public interface LendOrReturnDao {
	/**
	 * �̶��ʲ����ñ�����
	 */
	int lendadd(Object[] param);
	/**
	 * �̶��ʲ��黹������
	 */
	int returnadd(Object[] param);
}
