package com.fixedassetms.biz;
/**
 * 
 * @author muse
 *create on 2016-7-16 14:54:42
 *
 */

public interface FixedAssetManage {

	/**
	 * �̶��ʲ����ӽ���
	 */
	public void famAdd();
	/**
	 * �̶��ʲ�ɾ������
	 */
	public void famDel();
	/**
	 * �̶��ʲ��޸Ľ���
	 */
	public void famUpDate();
	/**
	 * ���ʲ���Ų�ѯ��ȷ���ҽ���
	 */
	public void famSerById();
	/**
	 * �������ѯ���н���
	 */
	public void famSerByC();
	/**
	 * ��С���ѯ���и������ȫ���̶��ʲ�����
	 */
	public void famSerByT();

	/**
	 * ��������������
	 */
	public void famReadByC();
	/**
	 * ��С���������
	 */
	public void famReadByT();
	/**
	 * ��ʹ���߲�ѯ����
	 */
	public void famSerByAuser();
	
	

}
