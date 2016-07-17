package com.fixedassetms.biz.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fixedassetms.biz.FixedAssetManage;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.dao.impl.FixedAssetDaoImpl;

/**
 * �̶��ʲ��������ʵ��
 * @author muse and zhaohui
 *create on 2016-7-16 16:41:20
 */
public class FixedAssetManageImpl implements FixedAssetManage{
	/**
	 * �̶��ʲ�������ʵ��
	 */
	public void famAddCT() {
		System.out.println("********�̶��ʲ�������********");
		Scanner input=new Scanner(System.in);
		System.out.println("��������ࣺ");
		String category=input.next();
		System.out.println("����������С�ࣺ");
		String type=input.next();
		
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		/**
		 * �жϸ�С���Ƿ���ڣ�С��Ψһ��
		 */
		if(faDao.cntSerT(type)){
			System.out.println("�������𣨴��༰С�ࣩ�Ѵ��ڣ��޷��ٴ���ӣ�");
			return;
		}
		/**
		 * ���������𣨴����С�ࣩΪ�£���ִ�����
		 */
		System.out.println("ִ���ʲ�������...");
		int flag=faDao.cntAddCT(category, type);
		if(flag==1){
			System.out.println("�̶��ʲ������ӳɹ���");
		}else{
			System.out.println("�̶��ʲ�������ʧ�ܣ����ٴγ���");
		}	
	}
	/**
	 * �̶��ʲ�ɾ�����ʵ��
	 */
	public void famDelCT() {
		System.out.println("********�̶��ʲ����ɾ��********");
		Scanner input=new Scanner(System.in);
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		/**
		 * ���й̶��ʲ����������д����Թ�ѡ��
		 */
		System.out.println("��ѡ����ࣺ");
		List<String> cList=null;
		cList=faDao.cntShowC();
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		int ci=input.nextInt();
		String category=cList.get(ci-1);
		/**
		 * ���иô���������С���Թ�ѡ��
		 */
		System.out.println("��ѡ������С�ࣺ");
		List<String> tList=null;
		tList=faDao.cntShowTuC(category);
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		int ti=input.nextInt();
		String type=tList.get(ti-1);
		/**
		 * ִ�й̶��ʲ����ɾ��
		 */
		System.out.println("ִ���ʲ����ɾ��...");
		int flag=faDao.cntDelCT(category, type);
		if(flag==1){
			System.out.println("�̶��ʲ����ɾ���ɹ���");
		}else{
			System.out.println("�̶��ʲ����ɾ��ʧ�ܣ����ٴγ���");
		}	
		
	}

	
	
	@Override
	public void famAdd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famDel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famUpDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famSerById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famSerByC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famSerByT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famReadByC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famReadByT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famSerByAuser() {
		// TODO Auto-generated method stub
		
	}
	

}
