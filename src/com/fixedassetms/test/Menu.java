package com.fixedassetms.test;

import java.util.Scanner;
/**
 * ϵͳ�˵�ʵ��
 * @author yuanyuan
 * create on 2016-7-16
 * modify by zhaohui on 2016-7-17
 */
public class Menu {
	/**
	 * ϵͳ���˵�
	 */
	public void mainMenu(){
		int choice;
		do{
		//������
		System.out.println("********ϵͳ������********");
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
		//�ȵ�¼   
		
		if (flag)
		manageMenu();	
	}
	public void manageMenu(){
		boolean flag=true;
		//�ȵ�¼    
		do{
			//����Ա��������
			System.out.println("1. ְ������");// workerManage
 			System.out.println("2. ����Ա����");//managerManage  
			System.out.println("3. �̶��ʲ�����");// proManage
 			System.out.println("4. �ʲ�������黹");//ReLendManage            
            System.out.println("5. ����������");
			System.out.print("��ѡ������:");
 			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			
			case 1:
				//ְ������
				workerManage();
 				break;
			case 2:
				//����Ա����
				managerManage();
				break;
			case 3:
				//����̶��ʲ��������
				proManage();
				break;
			case 4:
				//�����ʲ�������黹����
				ReLendManage();
				break;
			case 5:
				//����������
				flag=false;
				mainMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);
	}
	
	 public void 	workerManage(){
			boolean flag=true;
			do{
				//ְ���������
				System.out.println("----��Ա�������----");
				System.out.println("1. ����ְ����Ϣ");
				System.out.println("2. �޸�ְ����Ϣ");
				System.out.println("3. ɾ��ְ����Ϣ");
				System.out.println("4. ���ع���Ա��������");
				
				System.out.print("��ѡ������:");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				case 1:
					//������ְ����Ϣ����
	 				break;
				case 2:
					//�����޸�ְ����Ϣ����
	 				break;
				case 3:
					//����ɾ��ְ����Ϣ����
	 				break;
				case 4:
					//���ع���Ա��������
					flag=false;
					manageMenu();
					break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);
		}


	
	public void managerManage(){
		boolean flag=true;
 		do{
			//����Ա�������
			System.out.println("1. �޸�����");
			System.out.println("2. ����¹���Ա");
 			System.out.println("3. ɾ�����й���Ա");            
            System.out.println("4. ���ع���Ա��������");
			System.out.print("��ѡ������:");
 			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//�޸�����
				break;
			case 2:
				//����¹���Ա
 				break;
			case 3:
				//ɾ�����й���Ա
				break;
			case 4:
				//���ع���Ա��������
				flag=false;
				manageMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);
	}
	

	 public void proManage(){
			boolean flag=true;
			do{
			//�����ʲ�����
			System.out.println("+++�ʲ��������+++");		
			System.out.println("1. �̶��ʲ�������");
			System.out.println("2. �̶��ʲ���Ϣ����");		
 			System.out.println("3. ���ع���Ա��������");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//�̶��ʲ����������
				proClassManage();
				break;
			case 2:
				//�̶��ʲ���Ϣ�������
				proMesManage();
				break;
			case 3:
				//���ع���Ա��������
				manageMenu();
				break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);	
		}

	 public void proClassManage(){
			boolean flag=true;
			do{
			//�̶��ʲ����������
			System.out.println("+++�̶��ʲ����������+++");		
			System.out.println("1. ���ӹ̶��ʲ����");
			System.out.println("2. ɾ���̶��ʲ����");		
			System.out.println("3. �����ʲ��������");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//���ӹ̶��ʲ����
				proClassManage();
				break;
			case 2:
				//ɾ���̶��ʲ����
				proMesManage();
				break;
			case 3:
				//�����ʲ���Ϣ�������
				proManage();
				break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);	
		}
 	
	 public void proMesManage(){
			boolean flag=true;
			do{
			//�̶��ʲ���Ϣ�������
			System.out.println("+++�̶��ʲ���Ϣ�������+++");		
			System.out.println("1. ����̶��ʲ���Ϣ");
			System.out.println("2. �޸Ĺ̶��ʲ���Ϣ");		
			System.out.println("3. ɾ���̶��ʲ���Ϣ");
			System.out.println("4. ��ѯ�̶��ʲ���Ϣ");
			System.out.println("5. �����ʲ��������");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//�����ʲ���Ϣ
 				break;
			case 2:
				//�޸��ʲ���Ϣ
 				break;
			case 3:
				//ɾ�������ʲ�
				break;
			case 4:
				//��ѯ�ʲ���Ϣ
				mfindMenu();
			case 5:
				//�����ʲ���Ϣ�������
				proManage();
                break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);	
		}

	 public void mfindMenu(){
		boolean flag=true;
		do{
		//��ѯ�ʲ���Ϣ����
		System.out.println("+++��ѯ�̶��ʲ���Ϣ����+++");		
		System.out.println("1. ���ݱ�ž�ȷ��ѯ");
		System.out.println("2. ��������ģ����ѯ");		
		System.out.println("3. ��������ѯ");
		System.out.println("4. ����ʹ���߲�ѯ");
		System.out.println("5. ���ع̶��ʲ���Ϣ�������");
		System.out.print("��ѡ������:");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		switch(choice){
			case 1:
				//���ݱ�ž�ȷ��ѯ
				break;
			case 2:
				//��������ģ����ѯ
				break;
			case 3:
				//��������ѯ   ��ʾ�����С��������ʲ�������ʲ�״��
				break;
			case 4:
				//����ʹ���߲�ѯ  ��ʾ����Ա���õ������ʲ�
				break;
			case 5:
				//�����ʲ��������
				flag=false;
				proMesManage();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}
	 
	 public void 	ReLendManage(){
			boolean flag=true;
			do{
				//�ʲ�������黹����
				System.out.println("���ʲ�������黹���桪��");
	 			System.out.println("1. �����ʲ�");
				System.out.println("2. �黹�ʲ�");
				System.out.println("3. ���ع���Ա��������");
				System.out.print("��ѡ������:");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				case 1:
					//���������ʲ�����
	 				break;
				case 2:
					//����黹�ʲ�����
	 				break;
				case 3:
					//���ع���Ա��������
					flag=false;
					manageMenu();
					break;
				default:
					//������Ч
					System.out.println("������Ч!");
				}
			}while(flag);
		}


}
