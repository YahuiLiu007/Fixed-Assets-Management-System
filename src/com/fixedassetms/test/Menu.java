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
 * 系统菜单实现
 * @author yuanyuan
 * create on 2016-7-16
 * modify by zhaohui on 2016-7-17
 * modify by muse on 2016-7-17
 */
public class Menu {
	/**
	 * 全局变量，标志管理员是否登录系统
	 */
	boolean loginflag=false;
	/**
	 * 全局变量，代表已登录系统管理员
	 */
	Manager manager=null;
	/**
	 * 初始界面
	 */
	public void initMenu(){
		int choice;
		do{
		//初始界面
		System.out.println("********系统初始界面********");
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
		ManagerManage mManage=new ManagerManageImpl();   
		manager=mManage.Login();
		while(manager==null && flag){
			System.out.println("是否继续尝试登录？\t1.是，继续尝试登录\t2.否，返回初始界面");
			Scanner input=new Scanner(System.in);
			int ch=input.nextInt();
			switch(ch){
				case 1:
					//继续尝试登录
					manager=mManage.Login();
					break;
				case 2:
					//返回初始界面
					manager=null;
					flag=false;
					break;
				default:
					//命令无效
					System.out.println("命令无效!");
			}
		}
		if(manager!=null){
			//标志已有管理员登录系统
			loginflag=true;
			//进入主界面
			mainMenu();	
		}
	}
	/**
	 * 系统主界面
	 */
	public void mainMenu(){
		if(loginflag==true){
			boolean flag=true;    
			do{
				//主界面
				System.out.println("********系统主界面********");
				System.out.println("1. 管理员管理");
	 			System.out.println("2. 人员管理");  
				System.out.println("3. 固定资产管理");
	 			System.out.println("4. 资产领用与归还");            
	            System.out.println("5. 退出登录");
				System.out.print("请选择命令:");
	 			Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				case 1:
					//进入管理员管理界面
					managerManage();
	 				break;
				case 2:
					//进入人员管理界面
					auserManage();
					break;
				case 3:
					//进入固定资产管理界面
					faManage();
					break;
				case 4:
					//进入资产领用与归还界面
					ReLendManage();
					break;
				case 5:
					flag=false;
					//标志管理员已退出登录
					loginflag=false;
					//返回初始界面
					break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);
		}
		else{
			System.out.println("你尚未登录，请登录！");
		}
	}
	/**
	 * 管理员管理界面
	 */
	public void managerManage(){
		boolean flag=true;
		ManagerManage mManage=new ManagerManageImpl();
 		do{
			//管理员管理界面
 			System.out.println("********管理员管理界面********");
			System.out.println("1. 修改密码");
			System.out.println("2. 添加新管理员");
 			System.out.println("3. 删除已有管理员"); 	
 			System.out.println("4. 打印所有管理员"); 
            System.out.println("5. 返回主界面");
			System.out.print("请选择命令:");
 			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//进入修改密码界面
				mManage.mupdate(manager);
				break;
			case 2:
				//进入添加新管理员
				mManage.msave();
 				break;
			case 3:
				//进入删除已有管理员界面
				mManage.mdel();
				break;
			case 4:
				//进入打印所有管理员界面
				mManage.managershowall();
				break;
			case 5:
				//返回主界面
				flag=false;
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);
	}
	/**
	 * 人员管理界面
	 */
	 public void auserManage(){
		boolean flag=true;
		do{
			//人员管理界面
			System.out.println("********人员信息管理界面********");
			System.out.println("1. 增添人员信息");
			System.out.println("2. 修改人员信息");
			System.out.println("3. 删除人员信息");
			System.out.println("4. 打印所有人员信息");
			System.out.println("5. 返回主界面");
			
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			AUserManage auManage=new AUserManageImpl();
			switch(choice){
			case 1:
				//进入增添人员信息界面
				auManage.msave();
 				break;
			case 2:
				//进入修改人员信息界面
				auManage.mupdate();
 				break;
			case 3:
				//进入删除人员信息界面
				auManage.mdel();
 				break;
			case 4:
				//进入打印所有人员信息界面
				auManage.usershowall();
 				break;
			case 5:
				//返回主界面
				flag=false;
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);
	}
	 /**
	  * 固定资产管理界面
	  */
	 public void faManage(){
			boolean flag=true;
			do{
			//管理资产界面
			System.out.println("********固定资产管理界面********");		
			System.out.println("1. 固定资产类别管理");
			System.out.println("2. 固定资产信息管理");		
 			System.out.println("3. 返回主界面");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//进入固定资产类别管理界面
				faClassManage();
				break;
			case 2:
				//进入固定资产信息管理界面
				faMesManage();
				break;
			case 3:
				//返回主界面
				flag=false;
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
				}
			}while(flag);	
	}
	 /**
	  * 固定资产类别管理界面
	  */
	 public void faClassManage(){
			boolean flag=true;
			do{
			//固定资产类别管理界面
			System.out.println("********固定资产类别管理界面********");				
			System.out.println("1. 增加固定资产类别");
			System.out.println("2. 删除固定资产类别");	
			System.out.println("3. 打印所有固定资产类别");	
			System.out.println("4. 返回资产管理界面");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			FixedAssetManage faManage=new FixedAssetManageImpl();
			switch(choice){
			case 1:
				//进入增加固定资产类别界面
				faManage.famAddCT();
				break;
			case 2:
				//进入删除固定资产类别界面
				faManage.famDelCT();
				break;
			case 3:
				//进入打印所有固定资产类别界面
				faManage.famShowCT();
				break;
			case 4:
				//返回固定资产管理界面
				flag=false;
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}
 	/**
 	 * 固定资产信息管理界面
 	 */
	 public void faMesManage(){
			boolean flag=true;
			do{
			//固定资产信息管理界面
			System.out.println("********固定资产信息管理界面********");			
			System.out.println("1. 增添固定资产信息");
			System.out.println("2. 修改固定资产信息");		
			System.out.println("3. 删除固定资产信息");
			System.out.println("4. 查询固定资产信息");
			System.out.println("5. 按类别浏览固定资产信息");
			System.out.println("6. 返回资产管理界面");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			FixedAssetManage faManage=new FixedAssetManageImpl();
			switch(choice){
			case 1:
				//进入增添资产信息界面
				faManage.famAdd();
 				break;
			case 2:
				//进入修改资产信息界面
				faManage.famUpdate();
 				break;
			case 3:
				//进入删除已有资产界面
				faManage.famDel();
				break;
			case 4:
				//进入查询资产信息界面
				faSerMenu();
				break;
			case 5:
				//进入按类别浏览资产信息
				faManage.famShowByCT();
				break;
			case 6:
				//返回资产信息管理界面
				flag=false;
                break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}
	 /**
	  * 查询固定资产信息界面
	  */
	 public void faSerMenu(){
		boolean flag=true;
		do{
		//查询资产信息界面
		System.out.println("********查询固定资产信息界面********");	
		System.out.println("1. 根据编号查询");		
		System.out.println("2. 根据类别查询");
		System.out.println("3. 根据使用者查询");
		System.out.println("4. 返回固定资产信息管理界面");
		System.out.print("请选择命令:");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		FixedAssetManage faManage=new FixedAssetManageImpl();
		switch(choice){
			case 1:
				//根据编号查询
				faManage.famSerById();
				break;
			case 2:
				//根据类别查询   显示大类和小类下面的资产情况、资产状况
				faManage.famSerByCT();
				break;
			case 3:
				//根据使用者查询  显示该人员领用的所有资产
				faManage.famSerByAuser();
				break;
			case 4:
				//返回资产信息管理界面
				flag=false;
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}
	 /**
	  * 固定资产领用与归还界面
	  */
	 public void ReLendManage(){
			boolean flag=true;
			do{
				//资产领用与归还界面
				System.out.println("********固定资产领用与归还界面********");
	 			System.out.println("1. 领用资产");
	 			System.out.println("2. 打印资产领用情况");
				System.out.println("3. 归还资产");
				System.out.println("4. 打印资产归还情况");
				System.out.println("5. 返回主界面");
				System.out.print("请选择命令:");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				LendOrReturn lor=new LendOrReturnImpl();
				switch(choice){
				case 1:
					//进入领用资产界面
					lor.aLend(manager);
	 				break;
				case 2:
					//进入打印资产领用情况
					lor.sLend();
	 				break;
				case 3:
					//进入归还资产界面
					lor.aRet(manager);
	 				break;
				case 4:
					//进入打印资产归还情况
					lor.sRet();
	 				break;
				case 5:
					//返回主界面
					flag=false;
					break;
				default:
					//命令无效
					System.out.println("命令无效!");
				}
			}while(flag);
		}
}
