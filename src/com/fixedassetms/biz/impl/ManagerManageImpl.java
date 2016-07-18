/**
	 * ���������Ա��Ϣ����ʵ��
	 * @author wenxing
	 *create on 2016-7-16 16:45:20
	 */
package com.fixedassetms.biz.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.fixedassetms.biz.ManagerManage;
import com.fixedassetms.dao.ManagerDao;
import com.fixedassetms.dao.impl.ManagerDaoImpl;
import com.fixedassetms.entity.Manager;

public class ManagerManageImpl implements ManagerManage{
	/**
	 * ���������Ա��Ϣ����ʵ��
	 * @author wenxing
	 */
	public void msave(){
		//�������Ա��Ϣ����
		System.out.println("********�������Ա��Ϣ����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�������Ա�������Ϣ>>>");
		System.out.print("����Ա��:");
		String name=input.next();
		System.out.print("����:");
		String password=input.next();
		
		Manager man=new Manager();
		man.setName(name);
		man.setPassword(password);
		/**
		 * �ж��Ƿ��������
		 */
		ManagerDao mandao0=new ManagerDaoImpl();
		if(mandao0.findManByName(name)){
			System.out.println("�Բ��𣬸ù���Ա���Ѵ��ڣ�");
			return;
		}
		
		ManagerDao mandao=new ManagerDaoImpl();
		int result=mandao.save(man);
		if(result==1){
			System.out.println(">>>�������Ա��Ϣ�ɹ���");
		}
		else{
			System.out.println(">>>�������Ա��Ϣʧ�ܣ�");
		}	
	}
	/**
	 * �޸Ĺ���Ա�������ʵ��
	 * @author wenxing
	 */
	public void mupdate(Manager manager){
		
		System.out.println("********�޸Ĺ���Ա�������********");
		Scanner input=new Scanner(System.in);
		System.out.println("��������ĺ������Ϣ>>>");
		System.out.print("�������޸ĺ�����:");
		String password=input.next();
		
		int id=manager.getId();
		String name=manager.getName();
		

		Manager man=new Manager();
		man.setId(id);
		man.setName(name);
		man.setPassword(password);
		
		ManagerDao mandao=new ManagerDaoImpl();
		
		if(mandao.getByID(id)!=null){
			int result=mandao.update(man);
			if(result==1){
				System.out.println(">>>���¹���Ա��Ϣ�ɹ���");
			}
			else{
				System.out.println(">>>���¹���Ա��Ϣʧ�ܣ�");
			}
		}
		else{
			System.out.println(">>>����ԱID���󣬸��¹���Ա��Ϣʧ�ܣ�");
		}
	}	
	/**
	 * ɾ��������Ա��Ϣ����ʵ��
	 * @author wenxing
	 * modify by zhaohui 2016-7-18
	 */
	public void mdel(Manager manager){
		//ɾ������Ա��Ϣ����
		System.out.println("********ɾ������Ա��Ϣ����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ������Ա��ID>>>");
		System.out.print("ID:");
		int id=input.nextInt();
		
		/**
		 * �ж��Ƿ�Ϊ�Լ�
		 */
		if(id==manager.getId()){
			System.out.println("�Բ��𣬲�����ɾ���Լ���");
			return;
		}
		
		Manager man=new Manager();
		man.setId(id);
		
		ManagerDao mandao=new ManagerDaoImpl();
		
		if(mandao.getByID(id)!=null){
			int result=mandao.del(man);
			if(result==1){
				System.out.println(">>>ɾ������Ա��Ϣ�ɹ���");
			}
			else{
				System.out.println(">>>ɾ������Ա��Ϣʧ�ܣ�");
			}
		}
		else{
			System.out.println(">>>����ԱID����ɾ������Ա��Ϣʧ�ܣ�");
		}
	}
	/**
	 * ��ӡ������Ա��Ϣ����ʵ��
	 * @author wenxing
	 */
	public void managershowall(){
		 System.out.println("********��ӡ���й���Ա��Ϣ����********");
		 
		 List<Manager> masl=new ArrayList();
		 ManagerDao mandao=new ManagerDaoImpl();
		 masl=mandao.showall();
		 
		 System.out.println("ID\t����");	
		 if(masl!=null){
			 Iterator it = masl.iterator();
			 while(it.hasNext()){
				 Manager mast=(Manager)it.next();
				 System.out.println(mast.getId()+"\t"+mast.getName());	
		 		}
				System.out.println(">>>��ӡ���й���Ա��Ϣ�ɹ���");	 
		}
		else{
			System.out.println(">>>��ӡ���й���Ա��Ϣʧ�ܣ�");	 
		}
	 }
	/**
	 * ������Ա��¼����ʵ��
	 * @author wenxing
	 * modify by zhaohui 2016-7-18
	 */ 
	public Manager Login(){
		//��¼����
		System.out.println("********����Ա��¼����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������>>>");
		System.out.print("����Ա����");
		String name=input.next();
		System.out.print("���룺");
		String password=input.next();
		
		Manager man=new Manager();
		man.setName(name);
		man.setPassword(password);
		ManagerDao managerdao=new ManagerDaoImpl();
		Manager mana=managerdao.findManager(man);
		if(mana!=null){
			System.out.println(">>>��¼�ɹ���");
			return mana;
		}
		else{
			System.out.println(">>>��¼ʧ�ܣ�");
			return null;
		}
	}
}
