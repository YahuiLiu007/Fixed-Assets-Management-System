package com.fixedassetms.biz.impl;

import java.util.Scanner;

import com.fixedassetms.biz.LendOrReturn;
import com.fixedassetms.dao.AUserDao;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.dao.impl.AUserDaoImpl;
import com.fixedassetms.dao.impl.FixedAssetDaoImpl;
import com.fixedassetms.entity.AUser;
import com.fixedassetms.entity.FixedAsset;
/**
 * �̶��ʲ�������黹ʵ��
 * @author zhaohui
 *	create on 2016-7-15
 */
public class LendOrReturnImpl implements LendOrReturn{
	/**
	 * �̶��ʲ����÷���ʵ��
	 */
	public boolean aLend() {
		System.out.println("********�̶��ʲ�����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������������ԱID��");
		int aUserId=input.nextInt();
		System.out.println("�����������ʲ�ID��");
		int fAssetId=input.nextInt();
		
		/**
		 * �жϸ�������Ա�Ƿ��ѵǼ�
		 */
		AUser aUser=null;
		AUserDao aUserDao=new AUserDaoImpl();
		aUser=aUserDao.
		
		FixedAsset fAsset=null;
		FixedAssetDao fAssetDao=new FixedAssetDaoImpl();
		fAsset=fAssetDao.fixedAssetSerById(fAssetId);
		return false;
	}

	/**
	 * �̶��ʲ��黹����ʵ��
	 */
	public boolean aReturn() {
		System.out.println("�̶��ʲ�����");
		
		return false;
	}

}
