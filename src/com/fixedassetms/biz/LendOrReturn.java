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
	 * �̶��ʲ��黹����
	 * @param manager ��¼���ò����Ĺ���Ա
	 */
	void aReturn(Manager manager);
}
