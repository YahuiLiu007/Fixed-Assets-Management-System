package com.fixedassetms.dao;
/**
 * �̶��ʲ�������黹������ӿ�
 * @author zhaohui
 *	create on 2016-7-15
 */
public interface LendOrReturnDao {
	/**
	 * �̶��ʲ����ñ�����
	 */
	int lendAdd(Object[] param);
	/**
	 * �̶��ʲ��黹������
	 */
	int returnAdd(Object[] param);
}
