
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
	 * ������Ա��Ϣ
	 * @param auser
	 * @return
	 */
	int save(AUser auser);
	/**
	 * ɾ����Ա��Ϣ
	 * @param auser
	 * @return
	 */
	int del(AUser auser);
	/**
	 * ������Ա��Ϣ
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
	 * ��ӡ������Ա��Ϣ
	 * @return
	 */
	List<AUser> showall();

}