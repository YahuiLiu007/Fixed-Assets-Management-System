package com.fixedassetms.test;

import java.util.Scanner;

import com.fixedassetms.biz.AUserManage;
import com.fixedassetms.biz.FixedAssetManage;
import com.fixedassetms.biz.LendOrReturn;
import com.fixedassetms.biz.ManagerManage;
import com.fixedassetms.biz.impl.AUserManageImpl;
import com.fixedassetms.biz.impl.FixedAssetManageImpl;
import com.fixedassetms.biz.impl.LendOrReturnImpl;
import com.fixedassetms.biz.impl.ManagerManageImpl;
import com.fixedassetms.entity.Manager;
/**
 * ϵͳ�˵�ʵ��
 * @author yuanyuan
 * create on 2016-7-16
 * modify by zhaohui on 2016-7-17
 * modify by muse on 2016-7-17
 */
public class Menu {
	/**
	 * ȫ�ֱ�������־����Ա�Ƿ��¼ϵͳ
	 */
	boolean loginflag=false;
	/**
	 * ȫ�ֱ����������ѵ�¼ϵͳ����Ա
	 */
	Manager manager=null;
	/**
	 * ��ʼ����
	 */
	public void initMenu(){
		int choice;
		do{
		//��ʼ����
		System.out.println("********ϵͳ��ʼ����********");
		System.out.println("1. ����Ա��¼");
		System.out.println("2. �˳�ϵͳ");
		System.out.print("��ѡ������:");
		Scanner input=new Scanner(System.in);
		choice=input.nextInt();
		switch(choice){
		case 1:
			//�������Ա��¼����
			manageLog();
			break;
		case 2:
			//�˳�ϵͳ
			System.out.println("********�ɹ��˳�ϵͳ********");
			break;
		default:
			//������Ч
			System.out.println("������Ч!");
		}
		}while(choice!=2);
	}
	
	/**
	 * ����Ա��¼����
	 */
	public void manageLog(){
		boolean flag=true;
		ManagerManage mManage=new ManagerManageImpl();   
		manager=mManage.Login();
		while(manager==null && flag){
			System.out.println("�Ƿ�������Ե�¼��\t1.�ǣ��������Ե�¼\t2.�񣬷��س�ʼ����");
			Scanner input=new Scanner(System.in);
			int ch=input.nextInt();
			switch(ch){
				case 1:
					//�������Ե�¼
					manager=mManage.Login();
					break;
				case 2:
					//���س�ʼ����
					manager=null;
					flag=false;
					break;
				default:
					//������Ч
					System.out.println("������Ч!");
			}
		}
		if(manager!=null){
			//��־���й���Ա��¼ϵͳ
			loginflag=true;
			//����������
			mainMenu();	
		}
	}
	/**
	 * ϵͳ������
	 */
	public void mainMenu(){
		if(loginflag==true){
			boolean flag=true;    
			do{
				//������
				System.out.println("********ϵͳ������********");
				System.out.println("1. ����Ա����");
	 			System.out.println("2. ��Ա����");  
				System.out.println("3. �̶��ʲ�����");
	 			System.out.println("4. �ʲ�������黹");            
	            System.out.println("5. �˳���¼");
				System.out.print("��ѡ������:");
	 			Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				case 1:
					//�������Ա�������
					managerManage();
	 				break;
				case 2:
					//������Ա�������
					auserManage();
					break;
				case 3:
					//����̶��ʲ��������
					faManage();
					break;
				case 4:
					//�����ʲ�������黹����
					ReLendManage();
					break;
				case 5:
					flag=false;
					//��־����Ա���˳���¼
					loginflag=false;
					//���س�ʼ����
					break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);
		}
		else{
			System.out.println("����δ��¼�����¼��");
		}
	}
	/**
	 * ����Ա�������
	 */
	public void managerManage(){
		boolean flag=true;
		ManagerManage mManage=new ManagerManageImpl();
 		do{
			//����Ա�������
 			System.out.println("********����Ա�������********");
			System.out.println("1. �޸�����");
			System.out.println("2. ����¹���Ա");
 			System.out.println("3. ɾ�����й���Ա"); 	
 			System.out.println("4. ��ӡ���й���Ա"); 
            System.out.println("5. ����������");
			System.out.print("��ѡ������:");
 			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//�����޸��������
				mManage.mupdate(manager);
				break;
			case 2:
				//��������¹���Ա
				mManage.msave();
 				break;
			case 3:
				//����ɾ�����й���Ա����
				mManage.mdel();
				break;
			case 4:
				//�����ӡ���й���Ա����
				mManage.managershowall();
				break;
			case 5:
				//����������
				flag=false;
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);
	}
	/**
	 * ��Ա�������
	 */
	 public void auserManage(){
		boolean flag=true;
		do{
			//��Ա�������
			System.out.println("********��Ա��Ϣ�������********");
			System.out.println("1. ������Ա��Ϣ");
			System.out.println("2. �޸���Ա��Ϣ");
			System.out.println("3. ɾ����Ա��Ϣ");
			System.out.println("4. ��ӡ������Ա��Ϣ");
			System.out.println("5. ����������");
			
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			AUserManage auManage=new AUserManageImpl();
			switch(choice){
			case 1:
				//����������Ա��Ϣ����
				auManage.msave();
 				break;
			case 2:
				//�����޸���Ա��Ϣ����
				auManage.mupdate();
 				break;
			case 3:
				//����ɾ����Ա��Ϣ����
				auManage.mdel();
 				break;
			case 4:
				//�����ӡ������Ա��Ϣ����
				auManage.usershowall();
 				break;
			case 5:
				//����������
				flag=false;
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);
	}
	 /**
	  * �̶��ʲ��������
	  */
	 public void faManage(){
			boolean flag=true;
			do{
			//�����ʲ�����
			System.out.println("********�̶��ʲ��������********");		
			System.out.println("1. �̶��ʲ�������");
			System.out.println("2. �̶��ʲ���Ϣ����");		
 			System.out.println("3. ����������");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//����̶��ʲ����������
				faClassManage();
				break;
			case 2:
				//����̶��ʲ���Ϣ�������
				faMesManage();
				break;
			case 3:
				//����������
				flag=false;
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
				}
			}while(flag);	
	}
	 /**
	  * �̶��ʲ����������
	  */
	 public void faClassManage(){
			boolean flag=true;
			do{
			//�̶��ʲ����������
			System.out.println("********�̶��ʲ����������********");				
			System.out.println("1. ���ӹ̶��ʲ����");
			System.out.println("2. ɾ���̶��ʲ����");	
			System.out.println("3. ��ӡ���й̶��ʲ����");	
			System.out.println("4. �����ʲ��������");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			FixedAssetManage faManage=new FixedAssetManageImpl();
			switch(choice){
			case 1:
				//�������ӹ̶��ʲ�������
				faManage.famAddCT();
				break;
			case 2:
				//����ɾ���̶��ʲ�������
				faManage.famDelCT();
				break;
			case 3:
				//�����ӡ���й̶��ʲ�������
				faManage.famShowCT();
				break;
			case 4:
				//���ع̶��ʲ��������
				flag=false;
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}
 	/**
 	 * �̶��ʲ���Ϣ�������
 	 */
	 public void faMesManage(){
			boolean flag=true;
			do{
			//�̶��ʲ���Ϣ�������
			System.out.println("********�̶��ʲ���Ϣ�������********");			
			System.out.println("1. ����̶��ʲ���Ϣ");
			System.out.println("2. �޸Ĺ̶��ʲ���Ϣ");		
			System.out.println("3. ɾ���̶��ʲ���Ϣ");
			System.out.println("4. ��ѯ�̶��ʲ���Ϣ");
			System.out.println("5. ���������̶��ʲ���Ϣ");
			System.out.println("6. �����ʲ��������");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			FixedAssetManage faManage=new FixedAssetManageImpl();
			switch(choice){
			case 1:
				//���������ʲ���Ϣ����
				faManage.famAdd();
 				break;
			case 2:
				//�����޸��ʲ���Ϣ����
				faManage.famUpdate();
 				break;
			case 3:
				//����ɾ�������ʲ�����
				faManage.famDel();
				break;
			case 4:
				//�����ѯ�ʲ���Ϣ����
				faSerMenu();
				break;
			case 5:
				//���밴�������ʲ���Ϣ
				faManage.famShowByCT();
				break;
			case 6:
				//�����ʲ���Ϣ�������
				flag=false;
                break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}
	 /**
	  * ��ѯ�̶��ʲ���Ϣ����
	  */
	 public void faSerMenu(){
		boolean flag=true;
		do{
		//��ѯ�ʲ���Ϣ����
		System.out.println("********��ѯ�̶��ʲ���Ϣ����********");	
		System.out.println("1. ���ݱ�Ų�ѯ");		
		System.out.println("2. ��������ѯ");
		System.out.println("3. ����ʹ���߲�ѯ");
		System.out.println("4. ���ع̶��ʲ���Ϣ�������");
		System.out.print("��ѡ������:");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		FixedAssetManage faManage=new FixedAssetManageImpl();
		switch(choice){
			case 1:
				//���ݱ�Ų�ѯ
				faManage.famSerById();
				break;
			case 2:
				//��������ѯ   ��ʾ�����С��������ʲ�������ʲ�״��
				faManage.famSerByCT();
				break;
			case 3:
				//����ʹ���߲�ѯ  ��ʾ����Ա���õ������ʲ�
				faManage.famSerByAuser();
				break;
			case 4:
				//�����ʲ���Ϣ�������
				flag=false;
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}
	 /**
	  * �̶��ʲ�������黹����
	  */
	 public void ReLendManage(){
			boolean flag=true;
			do{
				//�ʲ�������黹����
				System.out.println("********�̶��ʲ�������黹����********");
	 			System.out.println("1. �����ʲ�");
	 			System.out.println("2. ��ӡ�ʲ��������");
				System.out.println("3. �黹�ʲ�");
				System.out.println("4. ��ӡ�ʲ��黹���");
				System.out.println("5. ����������");
				System.out.print("��ѡ������:");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				LendOrReturn lor=new LendOrReturnImpl();
				switch(choice){
				case 1:
					//���������ʲ�����
					lor.aLend(manager);
	 				break;
				case 2:
					//�����ӡ�ʲ��������
					lor.sLend();
	 				break;
				case 3:
					//����黹�ʲ�����
					lor.aRet(manager);
	 				break;
				case 4:
					//�����ӡ�ʲ��黹���
					lor.sRet();
	 				break;
				case 5:
					//����������
					flag=false;
					break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);
		}
}
