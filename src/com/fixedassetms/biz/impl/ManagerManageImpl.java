/**
	 * 管理管理人员信息操作实现
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
	 * 增添管理人员信息操作实现
	 * @author wenxing
	 */
	public void msave(){
		//增添管理员信息界面
		System.out.println("********增添管理员信息界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要增添管理员的相关信息>>>");
		System.out.print("管理员名:");
		String name=input.next();
		System.out.print("密码:");
		String password=input.next();
		
		Manager man=new Manager();
		man.setName(name);
		man.setPassword(password);
		/**
		 * 判断是否存在重名
		 */
		ManagerDao mandao0=new ManagerDaoImpl();
		if(mandao0.findManByName(name)){
			System.out.println("对不起，该管理员名已存在！");
			return;
		}
		
		ManagerDao mandao=new ManagerDaoImpl();
		int result=mandao.save(man);
		if(result==1){
			System.out.println(">>>增添管理员信息成功！");
		}
		else{
			System.out.println(">>>增添管理员信息失败！");
		}	
	}
	/**
	 * 修改管理员密码操作实现
	 * @author wenxing
	 */
	public void mupdate(Manager manager){
		
		System.out.println("********修改管理员密码界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入更改后的新信息>>>");
		System.out.print("请输入修改后密码:");
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
				System.out.println(">>>更新管理员信息成功！");
			}
			else{
				System.out.println(">>>更新管理员信息失败！");
			}
		}
		else{
			System.out.println(">>>管理员ID错误，更新管理员信息失败！");
		}
	}	
	/**
	 * 删除管理人员信息操作实现
	 * @author wenxing
	 * modify by zhaohui 2016-7-18
	 */
	public void mdel(Manager manager){
		//删除管理员信息界面
		System.out.println("********删除管理员信息界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除管理员的ID>>>");
		System.out.print("ID:");
		int id=input.nextInt();
		
		/**
		 * 判断是否为自己
		 */
		if(id==manager.getId()){
			System.out.println("对不起，不允许删除自己！");
			return;
		}
		
		Manager man=new Manager();
		man.setId(id);
		
		ManagerDao mandao=new ManagerDaoImpl();
		
		if(mandao.getByID(id)!=null){
			int result=mandao.del(man);
			if(result==1){
				System.out.println(">>>删除管理员信息成功！");
			}
			else{
				System.out.println(">>>删除管理员信息失败！");
			}
		}
		else{
			System.out.println(">>>管理员ID错误，删除管理员信息失败！");
		}
	}
	/**
	 * 打印管理人员信息操作实现
	 * @author wenxing
	 */
	public void managershowall(){
		 System.out.println("********打印所有管理员信息界面********");
		 
		 List<Manager> masl=new ArrayList();
		 ManagerDao mandao=new ManagerDaoImpl();
		 masl=mandao.showall();
		 
		 System.out.println("ID\t名字");	
		 if(masl!=null){
			 Iterator it = masl.iterator();
			 while(it.hasNext()){
				 Manager mast=(Manager)it.next();
				 System.out.println(mast.getId()+"\t"+mast.getName());	
		 		}
				System.out.println(">>>打印所有管理员信息成功！");	 
		}
		else{
			System.out.println(">>>打印所有管理员信息失败！");	 
		}
	 }
	/**
	 * 管理人员登录操作实现
	 * @author wenxing
	 * modify by zhaohui 2016-7-18
	 */ 
	public Manager Login(){
		//登录界面
		System.out.println("********管理员登录界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入>>>");
		System.out.print("管理员名：");
		String name=input.next();
		System.out.print("密码：");
		String password=input.next();
		
		Manager man=new Manager();
		man.setName(name);
		man.setPassword(password);
		ManagerDao managerdao=new ManagerDaoImpl();
		Manager mana=managerdao.findManager(man);
		if(mana!=null){
			System.out.println(">>>登录成功！");
			return mana;
		}
		else{
			System.out.println(">>>登录失败！");
			return null;
		}
	}
}
