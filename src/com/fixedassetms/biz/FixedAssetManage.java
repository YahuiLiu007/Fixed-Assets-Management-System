package com.fixedassetms.biz;
/**
 * �̶��ʲ���������ӿ�
 * @author muse and zhaohui
 *create on 2016-7-16 14:54:42
 *
 */

public interface FixedAssetManage {
	/**
	 * �̶��ʲ�������
	 */
	void famAddCT();
	/**
	 * �̶��ʲ�ɾ�����
	 */
	void famDelCT();
	/**
	 * ��ӡ�������
	 */
	void famShowCT();
	/**
	 * �̶��ʲ���������
	 */
	void famShowByCT();
	

	
	
	/**
	 * �̶��ʲ����ӽ���
	 */
	void famAdd();
	/**
	 * �̶��ʲ�ɾ������
	 */
	void famDel();
	/**
	 * �̶��ʲ��޸Ľ���
	 */
	void famUpdate();
	/**
	 * ���ʲ���Ų�ѯ��ȷ���ҽ���
	 */
	void famSerById();
	/**
	 * ����𣨴����С�ࣩ��ѯ�����ʲ�
	 */
	void famSerByCT();
	/**
	 * ��ʹ���߲�ѯ����
	 */
	void famSerByAuser();
	
	

}
