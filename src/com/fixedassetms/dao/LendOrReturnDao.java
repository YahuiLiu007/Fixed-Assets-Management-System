package com.fixedassetms.dao;

import java.util.List;

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
	 * �̶��ʲ����ñ��ӡ  
	 * @return �̶��ʲ����ñ���ȫ����Ϣ
	 */
	List<String> lendShow();
	/**
	 * �̶��ʲ��黹������
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	int retAdd(Object[] param);
	/**
	 * �̶��ʲ��黹���ӡ  
	 * @return �̶��ʲ��黹����ȫ����Ϣ
	 */
	List<String> retShow();
}
