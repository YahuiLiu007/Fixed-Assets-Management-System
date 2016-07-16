
/**
 * �����Ǽ���Ա��Ϣ����dao��Ľӿ�
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.dao;
import java.util.List;

import com.fixedassetms.entity.AUser;
public interface AUserDao {
	/**
	 * ����������Ϣ
	 * @param auser
	 * @return
	 */
	int save(AUser auser);
	/**
	 * ɾ��������Ϣ
	 * @param auser
	 * @return
	 */
	int del(AUser auser);
	/**
	 * ����������Ϣ
	 * @param auser
	 * @return
	 */
	int update(AUser auser);
	/**
	 * �����û�����ְ���ѯ
	 * @param auser
	 * @return
	 */
	AUser findUser(AUser auser);
	/**
	 * ����ID��ѯ
	 * @param ID
	 * @return
	 */
	AUser getByID(int ID);
	/**
	 * ��ӡ����������Ϣ
	 * @return
	 */
	List<AUser> showall();

}