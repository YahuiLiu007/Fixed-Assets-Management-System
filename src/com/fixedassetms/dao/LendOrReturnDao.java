package com.fixedassetms.dao;
/**
 * �̶��ʲ�������黹������ӿ�
 * @author zhaohui
 *	create on 2016-7-15
 */
public interface LendOrReturnDao {
	/**
	 * �̶��ʲ����ñ�����
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	int lendAdd(Object[] param);
	/**
	 * �̶��ʲ��黹������
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	int returnAdd(Object[] param);
}
