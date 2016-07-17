package com.fixedassetms.test;

import java.util.Scanner;
/**
 * 系统菜单实现
 * @author yuanyuan
 * create on 2016-7-16
 * modify by zhaohui on 2016-7-17
 */
public class Menu {
	/**
	 * 系统主菜单
	 */
	public void mainMenu(){
		int choice;
		do{
		//主界面
		System.out.println("********系统主界面********");
		System.out.println("1. 管理员登录");
		System.out.println("2. 退出系统");
		System.out.print("请选择命令:");
		Scanner input=new Scanner(System.in);
		choice=input.nextInt();
		switch(choice){
		case 1:
			//进入管理员登录界面
			manageLog();
			break;
		case 2:
			//退出系统
			System.out.println("********成功退出系统********");
			break;
		default:
			//命令无效
			System.out.println("命令无效!");
		}
		}while(choice!=2);
	}
	/**
	 * 管理员登录界面
	 */
	public void manageLog(){
		boolean flag=true;
		//先登录   
		
		if (flag)
		manageMenu();	
	}
	public void manageMenu(){
		boolean flag=true;
		//先登录    
		do{
			//管理员操作界面
			System.out.println("1. 职工管理");// workerManage
 			System.out.println("2. 管理员管理");//managerManage  
			System.out.println("3. 固定资产管理");// proManage
 			System.out.println("4. 资产领用与归还");//ReLendManage            
            System.out.println("5. 返回主界面");
			System.out.print("请选择命令:");
 			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			
			case 1:
				//职工管理
				workerManage();
 				break;
			case 2:
				//管理员管理
				managerManage();
				break;
			case 3:
				//进入固定资产管理界面
				proManage();
				break;
			case 4:
				//进入资产领用与归还界面
				ReLendManage();
				break;
			case 5:
				//返回主界面
				flag=false;
				mainMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);
	}
	
	 public void 	workerManage(){
			boolean flag=true;
			do{
				//职工管理界面
				System.out.println("----人员管理界面----");
				System.out.println("1. 增添职工信息");
				System.out.println("2. 修改职工信息");
				System.out.println("3. 删除职工信息");
				System.out.println("4. 返回管理员操作界面");
				
				System.out.print("请选择命令:");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				case 1:
					//进入添职工信息界面
	 				break;
				case 2:
					//进入修改职工信息界面
	 				break;
				case 3:
					//进入删除职工信息界面
	 				break;
				case 4:
					//返回管理员操作界面
					flag=false;
					manageMenu();
					break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);
		}


	
	public void managerManage(){
		boolean flag=true;
 		do{
			//管理员管理界面
			System.out.println("1. 修改密码");
			System.out.println("2. 添加新管理员");
 			System.out.println("3. 删除已有管理员");            
            System.out.println("4. 返回管理员操作界面");
			System.out.print("请选择命令:");
 			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//修改密码
				break;
			case 2:
				//添加新管理员
 				break;
			case 3:
				//删除已有管理员
				break;
			case 4:
				//返回管理员操作界面
				flag=false;
				manageMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);
	}
	

	 public void proManage(){
			boolean flag=true;
			do{
			//管理资产界面
			System.out.println("+++资产管理界面+++");		
			System.out.println("1. 固定资产类别管理");
			System.out.println("2. 固定资产信息管理");		
 			System.out.println("3. 返回管理员操作界面");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//固定资产类别管理界面
				proClassManage();
				break;
			case 2:
				//固定资产信息管理界面
				proMesManage();
				break;
			case 3:
				//返回管理员操作界面
				manageMenu();
				break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);	
		}

	 public void proClassManage(){
			boolean flag=true;
			do{
			//固定资产类别管理界面
			System.out.println("+++固定资产类别管理界面+++");		
			System.out.println("1. 增加固定资产类别");
			System.out.println("2. 删除固定资产类别");		
			System.out.println("3. 返回资产管理界面");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//增加固定资产类别
				proClassManage();
				break;
			case 2:
				//删除固定资产类别
				proMesManage();
				break;
			case 3:
				//返回资产信息管理界面
				proManage();
				break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);	
		}
 	
	 public void proMesManage(){
			boolean flag=true;
			do{
			//固定资产信息管理界面
			System.out.println("+++固定资产信息管理界面+++");		
			System.out.println("1. 增添固定资产信息");
			System.out.println("2. 修改固定资产信息");		
			System.out.println("3. 删除固定资产信息");
			System.out.println("4. 查询固定资产信息");
			System.out.println("5. 返回资产管理界面");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//增添资产信息
 				break;
			case 2:
				//修改资产信息
 				break;
			case 3:
				//删除已有资产
				break;
			case 4:
				//查询资产信息
				mfindMenu();
			case 5:
				//返回资产信息管理界面
				proManage();
                break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);	
		}

	 public void mfindMenu(){
		boolean flag=true;
		do{
		//查询资产信息界面
		System.out.println("+++查询固定资产信息界面+++");		
		System.out.println("1. 根据编号精确查询");
		System.out.println("2. 根据名称模糊查询");		
		System.out.println("3. 根据类别查询");
		System.out.println("4. 根据使用者查询");
		System.out.println("5. 返回固定资产信息管理界面");
		System.out.print("请选择命令:");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		switch(choice){
			case 1:
				//根据编号精确查询
				break;
			case 2:
				//根据名称模糊查询
				break;
			case 3:
				//根据类别查询   显示大类和小类下面的资产情况、资产状况
				break;
			case 4:
				//根据使用者查询  显示该人员领用的所有资产
				break;
			case 5:
				//返回资产管理界面
				flag=false;
				proMesManage();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}
	 
	 public void 	ReLendManage(){
			boolean flag=true;
			do{
				//资产领用与归还界面
				System.out.println("—资产领用与归还界面——");
	 			System.out.println("1. 领用资产");
				System.out.println("2. 归还资产");
				System.out.println("3. 返回管理员操作界面");
				System.out.print("请选择命令:");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				case 1:
					//进入领用资产界面
	 				break;
				case 2:
					//进入归还资产界面
	 				break;
				case 3:
					//返回管理员操作界面
					flag=false;
					manageMenu();
					break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);
		}


}
