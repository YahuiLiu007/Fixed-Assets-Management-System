package com.fixedassetms.biz;

import com.fixedassetms.entity.Manager;

/**
 * �̶��ʲ�������黹�ӿ�
 * @author zhaohui
 *	create on 2016-7-15
 */
public interface LendOrReturn {
	/**
	 * �̶��ʲ����÷���
	 * @param manager ��¼���ò����Ĺ���Ա
	 */
	void aLend(Manager manager);
	/**
	 * ��ӡ�̶��ʲ��������
	 */
	void sLend();
	/**
	 * �̶��ʲ��黹����
	 * @param manager ��¼���ò����Ĺ���Ա
	 */
	void aRet(Manager manager);
	/**
	 * ��ӡ�̶��ʲ��黹���
	 */
	void sRet();
}
