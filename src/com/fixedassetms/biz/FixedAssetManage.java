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
	void famUpDate();
	/**
	 * ���ʲ���Ų�ѯ��ȷ���ҽ���
	 */
	void famSerById();
	/**
	 * �������ѯ���н���
	 */
	void famSerByC();
	/**
	 * ��С���ѯ���и������ȫ���̶��ʲ�����
	 */
	void famSerByT();

	/**
	 * ��������������
	 */
	void famReadByC();
	/**
	 * ��С���������
	 */
	void famReadByT();
	/**
	 * ��ʹ���߲�ѯ����
	 */
	void famSerByAuser();
	
	

}
