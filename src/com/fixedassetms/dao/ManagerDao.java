/**
 * ��������Ա��Ϣ����dao��Ľӿ�
 * @author wenxing
 * create on 2016-7-14
 */
package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.Manager;;

public interface ManagerDao {
	/**
	 * �������Ա��Ϣ
	 * @param manager
	 * @return Ӱ������
	 */
	int save(Manager manager);
	/**
	 * ɾ������Ա��Ϣ
	 * @param manager
	 * @return Ӱ������
	 */
	int del(Manager manager);
	/**
	 * ���¹���Ա��Ϣ
	 * @param manager
	 * @return Ӱ������
	 */
	int update(Manager manager);
	/**
	 * ��ȷ��ѯ����Ա��Ϣ
	 * @param manager
	 * @return manager����
	 */
	Manager findManager(Manager manager);
	/**
	 * ���ݹ���Ա�����ҹ���Ա
	 * @param ����Ա��
	 * @return true ���ҵ���false�������ҵ�
	 */
	boolean findManByName(String manName);
	/**
	 * ����id��ѯ����Ա��Ϣ
	 * @param ����Աid
	 * @return manager����
	 */
	Manager getByID(int ID);//����ID��ѯ
	/**
	 * ��ӡ���й���Ա��Ϣ
	 * @param 
	 * @return list
	 */
	List<Manager> showall();//��ӡ���й���Ա��Ϣ
}
