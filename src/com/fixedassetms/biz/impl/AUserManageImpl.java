/**
 * �Ǽ���Ա��Ϣ�����ܽ���ӿڵ�ʵ�ַ���
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.biz.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.fixedassetms.biz.AUserManage;

import com.fixedassetms.dao.AUserDao;
import com.fixedassetms.dao.impl.AUserDaoImpl;
import com.fixedassetms.entity.AUser;

public class AUserManageImpl implements AUserManage{
	/**
	 * ����Ǽ���Ա��Ϣ����
	 */
	public void msave(){
		System.out.println("+++����Ǽ���Ա��Ϣ����+++");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ����Ǽ���Ա�������Ϣ>>>");
		System.out.print("�û���:");
		String name=input.next();
		System.out.print("ְ��:");
		String duty=input.next();
		System.out.print("��ע:");
		String remark=input.next();
		
		AUser us=new AUser();
		us.setName(name);
		us.setDuty(duty);
		us.setRemark(remark);
		
		AUserDao usdao=new AUserDaoImpl();
		int result=usdao.save(us);
		if(result==1){
			System.out.println(">>>����Ǽ���Ա��Ϣ�ɹ�");
		}
		else{
			System.out.println(">>>����Ǽ���Ա��Ϣʧ��");
		}	
	}
	/**
	 * ���µǼ���Ա��Ϣ����
	 */
	public void mupdate(){
		System.out.println("+++���µǼ���Ա��Ϣ����+++");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ���µǼ���Ա��ID>>>");
		System.out.print("ID:");
		int id=input.nextInt();
		System.out.println("������õǼ���Ա������Ϣ>>>");
		System.out.print("�û���:");
		String name=input.next();
		System.out.print("ְ��:");
		String duty=input.next();
		System.out.print("��ע:");
		String remark=input.next();

		AUser us=new AUser();
		us.setId(id);
		us.setName(name);
		us.setDuty(duty);
		us.setRemark(remark);
		
		AUserDao usdao=new AUserDaoImpl();
		
		if(usdao.getByID(id)!=null){
			int result=usdao.update(us);
			if(result==1){
				System.out.println(">>>���µǼ���Ա��Ϣ�ɹ�");
			}
			else{
				System.out.println(">>>���µǼ���Ա��Ϣʧ��");
			}
		}
		else{
			System.out.println("�Ǽ���ԱID���󣬸��µǼ���Ա��Ϣʧ�ܣ�");
		}
	}	
	/**
	 * ɾ���Ǽ���Ա��Ϣ����
	 */
	public void mdel(){
		System.out.println("+++ɾ���Ǽ���Ա��Ϣ����+++");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ���Ǽ���Ա��ID>>>");
		System.out.print("ID:");
		int id=input.nextInt();
		
		AUser us=new AUser();
		us.setId(id);
		
		AUserDao usdao=new AUserDaoImpl();
		
		if(usdao.getByID(id)!=null){
			int result=usdao.del(us);
			if(result==1){
				System.out.println(">>>ɾ���Ǽ���Ա��Ϣ�ɹ�");
			}
			else{
				System.out.println(">>>ɾ���Ǽ���Ա��Ϣʧ��");
			}
		}
		else{
			System.out.println("����ID����ɾ���Ǽ���Ա��Ϣʧ�ܣ�");
		}
	}
	 /**
	  * ��ӡ���еǼ���Ա��Ϣ����
	  */
	 public void usershowall(){
		 System.out.println("+++��ӡ���еǼ���Ա��Ϣ����+++");
		 
		 List<AUser> usershow=new ArrayList();
		 AUserDao usdao=new AUserDaoImpl();
		 usershow=usdao.showall();
		 
		 System.out.println("ID\t����\tְ��\t��ע\t");	
		 if(usershow!=null){
			 Iterator it = usershow.iterator();
			 while(it.hasNext()){
				 AUser use=(AUser)it.next();
				 System.out.println(use.getId()+"\t"+use.getName()+"\t"+use.getDuty()+"\t"+use.getRemark());	
		 		}
				System.out.println(">>>��ӡ���еǼ���Ա��Ϣ�ɹ�");	 
		}
		else{
			System.out.println(">>>��ӡ���еǼ���Ա��Ϣʧ��");	 
		}
	 }


}