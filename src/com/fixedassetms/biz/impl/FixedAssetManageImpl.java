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
 * 固定资产管理操作实现
 * @author muse and zhaohui
 *create on 2016-7-16 16:41:20
 */
public class FixedAssetManageImpl implements FixedAssetManage{
	/**
	 * 固定资产添加类别实现
	 */
	public void famAddCT() {
		System.out.println("********固定资产类别添加********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入大类：");
		String category=input.next();
		System.out.println("请输入下属小类：");
		String type=input.next();
		
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		/**
		 * 判断该小类是否存在（小类唯一）
		 */
		if(faDao.cntSerT(type)){
			System.out.println("所添加类别（大类及小类）已存在，无法再次添加！");
			return;
		}
		/**
		 * 若所添加类别（大类和小类）为新，则执行添加
		 */
		System.out.println("执行资产类别添加...");
		int flag=faDao.cntAddCT(category, type);
		if(flag==1){
			System.out.println("固定资产类别添加成功！");
		}else{
			System.out.println("固定资产类别添加失败！请再次尝试");
		}	
	}
	/**
	 * 固定资产删除类别实现
	 */
	public void famDelCT() {
		System.out.println("********固定资产类别删除********");
		Scanner input=new Scanner(System.in);
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		/**
		 * 罗列固定资产类别表里所有大类以供选择
		 */
		System.out.println("请选择大类：");
		List<String> cList=null;
		cList=faDao.cntShowC();
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		int ci=input.nextInt();
		String category=cList.get(ci-1);
		/**
		 * 罗列该大类下所有小类以供选择
		 */
		System.out.println("请选择下属小类：");
		List<String> tList=null;
		tList=faDao.cntShowTuC(category);
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		int ti=input.nextInt();
		String type=tList.get(ti-1);
		/**
		 * 执行固定资产类别删除
		 */
		System.out.println("执行资产类别删除...");
		int flag=faDao.cntDelCT(category, type);
		if(flag==1){
			System.out.println("固定资产类别删除成功！");
		}else{
			System.out.println("固定资产类别删除失败！请再次尝试");
		}	
		
	}

	/**
	 * 固定资产增加界面实现
	 */
	public void famAdd() {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//日期 格式转化
		
		System.out.println("********固定资产增加********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要增添固定资产的相关信息>>>");
		System.out.print("请输入资产名称");
		String name=input.next();
		System.out.println("请从以下列表中选择资产类别:");
		/**
		 * 此处是实现代码
		 * @return category
		 */
		System.out.print("请从以下列表中选择资产型号:");
		/**
		 * 此处是实现代码
		 * @return type
		 */
		System.out.print("请输入价值:");
		int price=input.nextInt();
		System.out.print("请输入购买日期（xxxx-xx-xx）:");
		String sindate=input.next();
		Date indate=sd.parse(sindate);//日期格式转换
		System.out.println("请从以下选项中选择新设备状态:");
		System.out.println("1.正常");
		System.out.println("2.维修");
		System.out.println("3.报废");
		int choice1=input.nextInt();
		String status=null;
		switch(choice1)
		{
		case 1:
			 status="正常";
			break;
		case 2:
			 status="维修";
			 break;
		case 3:
			 status="报废";
			break;
		default :
			 System.out.println("无效命令！");
			 return ;
			
		}
		String auser=null;//刚录入时为空
		System.out.print("请输入备注:");
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
			System.out.println(">>>增添固定资产信息成功");
			return ;
		}
		else{
			System.out.println(">>>增添主人信息失败");
			return ;
		}	
	
		
	}

	/**
	 * 固定资产删除界面
	 */
	public void famDel() {
		System.out.println("********固定资产增加********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除固定资产的ID>>>");
		System.out.print("请输入ID:");
		int id=input.nextInt();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setId(id);
		
		FixedAssetDao fixedAssetDao=new FixedAssetDaoImpl();
		
		if(fixedAssetDao.fixedAssetSerById(id)!=null){
			int result=fixedAssetDao.fixedAssetDel(fixedAsset);
			if(result==1){
				System.out.println(">>>删除固定次产信息成功");
				return ;
			}
			else{
				System.out.println(">>>删除固定资产信息失败");
				return ;
			}
		}
		else{
			System.out.println("资产ID错误，删除信息失败！");
			return ;
		}
		

		
	}


	public void famUpDate() {
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//日期 格式转化
		
		System.out.println("********固定资产修改********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要修改固定资产的ID>>>");
		int id=input.nextInt();
		System.out.println("请输入修改后内容>>>");
		System.out.print("请输入资产名称");
		String name=input.next();
		System.out.println("请从以下列表中选择资产类别:");
		/**
		 * 此处是实现代码
		 * @return category
		 */
		System.out.print("请从以下列表中选择资产型号:");
		/**
		 * 此处是实现代码
		 * @return type
		 */
		System.out.print("请输入价值:");
		int price=input.nextInt();
		System.out.print("请输入购买日期（xxxx-xx-xx）:");
		String sindate=input.next();
		Date indate=sd.parse(sindate);//日期格式转换
		System.out.println("请从以下选项中选择新设备状态:");
		System.out.println("1.正常");
		System.out.println("2.维修");
		System.out.println("3.报废");
		int choice1=input.nextInt();
		String status=null;
		switch(choice1)
		{
		case 1:
			 status="正常";
			break;
		case 2:
			 status="维修";
			 break;
		case 3:
			 status="报废";
			break;
		default :
			 System.out.println("无效命令！");
			 return ;
			
		}
		System.out.print("请输入使用者:");
		String auser=input.next();
		System.out.print("请输入备注:");
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
				System.out.println(">>>修改固定次产信息成功");
				return ;
			}
			else{
				System.out.println(">>>修改固定资产信息失败");
				return ;
			}
		}
		else{
			System.out.println("资产ID错误，删除信息失败！");
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
