/**
 * 登记人员信息管理功能界面接口的实现方法
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
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.dao.impl.AUserDaoImpl;
import com.fixedassetms.dao.impl.FixedAssetDaoImpl;
import com.fixedassetms.entity.AUser;

public class AUserManageImpl implements AUserManage{
	/**
	 * 增添登记人员信息界面
	 */
	public void msave(){
		System.out.println("********增添登记人员信息界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要增添登记人员的相关信息>>>");
		System.out.print("用户名:");
		String name=input.next();
		System.out.print("职务:");
		String duty=input.next();
		System.out.print("备注:");
		String remark=input.next();
		
		AUser us=new AUser();
		us.setName(name);
		us.setDuty(duty);
		us.setRemark(remark);
		
		AUserDao usdao=new AUserDaoImpl();
		int result=usdao.save(us);
		if(result==1){
			System.out.println(">>>增添登记人员信息成功！");
		}
		else{
			System.out.println(">>>增添登记人员信息失败！");
		}	
	}
	/**
	 * 更新登记人员信息界面
	 */
	public void mupdate(){
		System.out.println("********修改登记人员信息界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要修改登记人员的ID>>>");
		System.out.print("ID:");
		int id=input.nextInt();
		System.out.println("请输入修改后的新信息>>>");
		System.out.print("用户名:");
		String name=input.next();
		System.out.print("职务:");
		String duty=input.next();
		System.out.print("备注:");
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
				System.out.println(">>>更新登记人员信息成功！");
			}
			else{
				System.out.println(">>>更新登记人员信息失败！");
			}
		}
		else{
			System.out.println(">>>登记人员ID错误，更新登记人员信息失败！");
		}
	}	
	/**
	 * 删除登记人员信息界面
	 */
	public void mdel(){
		System.out.println("********删除登记人员信息界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除登记人员的ID>>>");
		System.out.print("ID:");
		int id=input.nextInt();
		
		AUser us=new AUser();
		us.setId(id);

		AUserDao usdao=new AUserDaoImpl();	
		AUser au=usdao.getByID(id);
		if(au!=null){
			/**
			 * 判断该人员是否已领用资产
			 */
			FixedAssetDao faDao=new FixedAssetDaoImpl();
			if(faDao.fixedAssetSerByAuser(au.getName())!=null){
				System.out.println("对不起，该人员已领用固定资产，不允许删除！");
				return;
			}
			AUserDao usdao2=new AUserDaoImpl();	
			int result=usdao2.del(us);
			if(result==1){
				System.out.println(">>>删除登记人员信息成功！");
			}
			else{
				System.out.println(">>>删除登记人员信息失败！");
			}
		}
		else{
			System.out.println(">>>登记人员ID错误，删除登记人员信息失败！");
		}
	}
	 /**
	  * 打印所有登记人员信息界面
	  */
	 public void usershowall(){
		 System.out.println("********打印所有登记人员信息界面********");
		 
		 List<AUser> usershow=new ArrayList();
		 AUserDao usdao=new AUserDaoImpl();
		 usershow=usdao.showall();
		 
		 System.out.println("ID\t名字\t职务\t备注\t");	
		 if(usershow!=null){
			 Iterator it = usershow.iterator();
			 while(it.hasNext()){
				 AUser use=(AUser)it.next();
				 System.out.println(use.getId()+"\t"+use.getName()+use.getDuty()+"\t"+use.getRemark());	
		 		}
				System.out.println(">>>打印所有登记人员信息成功！");	 
		}
		else{
			System.out.println(">>>打印所有登记人员信息失败！");	 
		}
	 }


}