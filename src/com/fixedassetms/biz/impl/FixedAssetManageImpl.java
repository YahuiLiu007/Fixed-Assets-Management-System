package com.fixedassetms.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fixedassetms.biz.FixedAssetManage;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.dao.impl.FixedAssetDaoImpl;
import com.fixedassetms.entity.FixedAsset;

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

	/**
	 * �̶��ʲ����ӽ���ʵ��
	 */
	public void famAdd() {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//���� ��ʽת��
		
		System.out.println("********�̶��ʲ�����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ����̶��ʲ��������Ϣ>>>");
		System.out.print("�������ʲ�����");
		String name=input.next();
		System.out.println("��������б���ѡ���ʲ����:");
		/**
		 * �˴���ʵ�ִ���
		 * @return category
		 */
		System.out.print("��������б���ѡ���ʲ��ͺ�:");
		/**
		 * �˴���ʵ�ִ���
		 * @return type
		 */
		System.out.print("�������ֵ:");
		int price=input.nextInt();
		System.out.print("�����빺�����ڣ�xxxx-xx-xx��:");
		String sindate=input.next();
		Date indate=sd.parse(sindate);//���ڸ�ʽת��
		System.out.println("�������ѡ����ѡ�����豸״̬:");
		System.out.println("1.����");
		System.out.println("2.ά��");
		System.out.println("3.����");
		int choice1=input.nextInt();
		String status=null;
		switch(choice1)
		{
		case 1:
			 status="����";
			break;
		case 2:
			 status="ά��";
			 break;
		case 3:
			 status="����";
			break;
		default :
			 System.out.println("��Ч���");
			 return ;
			
		}
		String auser=null;//��¼��ʱΪ��
		System.out.print("�����뱸ע:");
		String remark=input.next();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setName(name);
		fixedAsset.setCategory(category);
		fixedAsset.setType(type);
		fixedAsset.setPrice(price);
		fixedAsset.setIndate(indate);
		fixedAsset.setStatus(status);
		fixedAsset.setAuser(auser);
		fixedAsset.setRemark(remark);
		
		FixedAssetDao fixedAssetDao=new FixedAssetDaoImpl();
		int result=fixedAssetDao.fixedAssetAdd(fixedAsset);
		if(result==1){
			System.out.println(">>>����̶��ʲ���Ϣ�ɹ�");
			return ;
		}
		else{
			System.out.println(">>>����������Ϣʧ��");
			return ;
		}	
	
		
	}

	/**
	 * �̶��ʲ�ɾ������
	 */
	public void famDel() {
		System.out.println("********�̶��ʲ�����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ���̶��ʲ���ID>>>");
		System.out.print("������ID:");
		int id=input.nextInt();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setId(id);
		
		FixedAssetDao fixedAssetDao=new FixedAssetDaoImpl();
		
		if(fixedAssetDao.fixedAssetSerById(id)!=null){
			int result=fixedAssetDao.fixedAssetDel(fixedAsset);
			if(result==1){
				System.out.println(">>>ɾ���̶��β���Ϣ�ɹ�");
				return ;
			}
			else{
				System.out.println(">>>ɾ���̶��ʲ���Ϣʧ��");
				return ;
			}
		}
		else{
			System.out.println("�ʲ�ID����ɾ����Ϣʧ�ܣ�");
			return ;
		}
		

		
	}


	public void famUpDate() {
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//���� ��ʽת��
		
		System.out.println("********�̶��ʲ��޸�********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�޸Ĺ̶��ʲ���ID>>>");
		int id=input.nextInt();
		System.out.println("�������޸ĺ�����>>>");
		System.out.print("�������ʲ�����");
		String name=input.next();
		System.out.println("��������б���ѡ���ʲ����:");
		/**
		 * �˴���ʵ�ִ���
		 * @return category
		 */
		System.out.print("��������б���ѡ���ʲ��ͺ�:");
		/**
		 * �˴���ʵ�ִ���
		 * @return type
		 */
		System.out.print("�������ֵ:");
		int price=input.nextInt();
		System.out.print("�����빺�����ڣ�xxxx-xx-xx��:");
		String sindate=input.next();
		Date indate=sd.parse(sindate);//���ڸ�ʽת��
		System.out.println("�������ѡ����ѡ�����豸״̬:");
		System.out.println("1.����");
		System.out.println("2.ά��");
		System.out.println("3.����");
		int choice1=input.nextInt();
		String status=null;
		switch(choice1)
		{
		case 1:
			 status="����";
			break;
		case 2:
			 status="ά��";
			 break;
		case 3:
			 status="����";
			break;
		default :
			 System.out.println("��Ч���");
			 return ;
			
		}
		System.out.print("������ʹ����:");
		String auser=input.next();
		System.out.print("�����뱸ע:");
		String remark=input.next();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setName(name);
		fixedAsset.setCategory(category);
		fixedAsset.setType(type);
		fixedAsset.setPrice(price);
		fixedAsset.setIndate(indate);
		fixedAsset.setStatus(status);
		fixedAsset.setAuser(auser);
		fixedAsset.setRemark(remark);
		
		FixedAssetDao fixedAssetDao=new FixedAssetDaoImpl();
		if(fixedAssetDao.fixedAssetSerById(id)!=null){
			int result=fixedAssetDao.fixedAssetDel(fixedAsset);
			if(result==1){
				System.out.println(">>>�޸Ĺ̶��β���Ϣ�ɹ�");
				return ;
			}
			else{
				System.out.println(">>>�޸Ĺ̶��ʲ���Ϣʧ��");
				return ;
			}
		}
		else{
			System.out.println("�ʲ�ID����ɾ����Ϣʧ�ܣ�");
			return false;
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
