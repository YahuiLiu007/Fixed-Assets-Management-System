/**
 * ������Ա��������ӿ�
 * @author wenxing
 *create on 2016-7-16 14:54:42
 *
 */
package com.fixedassetms.biz;

import java.util.List;

import com.fixedassetms.entity.Manager;
/**
 * 
 * @author wenxing
 * modified by muse on 2016-7-17
 *
 */
public interface ManagerManage {
	/**
	 * ���������Ա��Ϣ����
	 */
	public void msave();
	/**
	 * ���¹�����Ա��Ϣ����
	 */
	public void mupdate(Manager manager);
	/**
	 * ɾ��������Ա��Ϣ����
	 */
	public void mdel(Manager manager);
	/**
	 * ��ӡ���й�����Ա��Ϣ����
	 */
	public void managershowall();
	/**
	 * ������Ա��¼����
	 */
	public Manager Login();
}
