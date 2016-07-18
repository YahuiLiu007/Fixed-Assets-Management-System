package com.fixedassetms.biz.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 *create on 2016-7-16
 *modified by muse on 2016-7-17 
 *modified by zhaohui on 2016-7-17 
 */
public class FixedAssetManageImpl implements FixedAssetManage{
	/**
	 * 固定资产添加类别实现
	 */
	public void famAddCT() {
		System.out.println("********固定资产类别添加界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入大类：");
		String category=input.next();//输入类别
		System.out.println("请输入下属小类：");
		String type=input.next();
		
		/**
		 * 判断该小类是否存在
		 */
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		if(faDao1.cntSerCT(category,type)){
			System.out.println(">>>所添加类别（大类及小类）已存在，无法再次添加！");
			return;
		}
		/**
		 * 若所添加类别（大类和小类）为新，则执行添加
		 */
		System.out.println("执行资产类别添加...");
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		int flag=faDao2.cntAddCT(category, type);
		if(flag==1){
			System.out.println(">>>固定资产类别添加成功！");
		}else{
			System.out.println(">>>固定资产类别添加失败！请再次尝试");
		}	
	}
	/**
	 * 固定资产删除类别实现
	 */
	public void famDelCT() {
		System.out.println("********固定资产类别删除界面********");
		Scanner input=new Scanner(System.in);
		/**
		 * 罗列固定资产类别表里所有大类以供选择
		 */
		System.out.println("请选择大类：");
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>无任何类别，无法执行删除！");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		int ci=input.nextInt();
		String category=cList.get(ci-1);
		/**
		 * 罗列该大类下所有小类以供选择
		 */
		System.out.println("请选择下属小类：");
		List<String> tList=new ArrayList();
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		tList=faDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>该大类下无任何小类，无法执行删除！");
			return;
		}
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		int ti=input.nextInt();
		String type=tList.get(ti-1);
		/**
		 * 判断固定资产管理表中是否存在该类别资产
		 */		
		FixedAssetDao faDao3=new FixedAssetDaoImpl();
		List<FixedAsset> fList=new ArrayList();
		fList=faDao3.fixedAssetSerByCT(category, type);
		/**
		 * 执行固定资产类别删除
		 */
		System.out.println("执行资产类别删除...");
		if(!fList.isEmpty()){
			for(int i=0;i<fList.size();i++){
				FixedAssetDao faDao4=new FixedAssetDaoImpl();
				faDao4.fixedAssetDel(fList.get(i));
			}
			fList.clear();
		}
		FixedAssetDao faDao5=new FixedAssetDaoImpl();
		int flag1=faDao5.cntDelCT(category, type);
		
		if(flag1==1 && fList.isEmpty()){
			System.out.println(">>>固定资产类别删除成功！");
		}else{
			System.out.println(">>>固定资产类别删除失败！请再次尝试");
		}	
		
	}
	/**
	 * 打印所有类别
	 */
	public void famShowCT(){
		System.out.println("********打印所有类别界面********");
		System.out.println("执行打印所有类别...");
		/**
		 * 罗列大类
		 */
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>无任何类别，无法执行打印！");
			return;
		}
		for(int i=0;i<cList.size();i++){
			String category=cList.get(i);
			System.out.println("大类："+category);
			/**
			 * 罗列该大类下属小类
			 */
			List<String> tList=new ArrayList();
			FixedAssetDao faDao2=new FixedAssetDaoImpl();
			tList=faDao2.cntShowTuC(category);
			if(tList.isEmpty()){
				System.out.println(">>>该大类下无任何小类！可继续打印");
				continue;
			}
			for(int j=0;j<tList.size();j++){
				String type=tList.get(j);
				System.out.println("\t下属小类："+type);
			}
		}
		System.out.println(">>>打印所有类别成功！");
	}
	/**
	 * 	固定资产按类别浏览实现
	 */
	public void famShowByCT() {
		System.out.println("********固定资产按类别浏览界面********");
		System.out.println("执行资产按类别浏览...");
		/**
		 * 罗列大类
		 */
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>无任何类别，无法执行浏览！");
			return;
		}
		for(int i=0;i<cList.size();i++){
			String category=cList.get(i);
			System.out.println("大类："+category);
			/**
			 * 罗列该大类下属小类
			 */
			List<String> tList=new ArrayList();
			FixedAssetDao faDao2=new FixedAssetDaoImpl();
			tList=faDao2.cntShowTuC(category);
			if(tList.isEmpty()){
				System.out.println(">>>该大类下无任何小类！可继续浏览");
				continue;
			}
			for(int j=0;j<tList.size();j++){
				String type=tList.get(j);
				System.out.println("\t下属小类："+type);
				/**
				 * 罗列该小类下固定资产
				 */
				System.out.println("\t该小类下固定资产：");
				List<FixedAsset> faList=new ArrayList();
				FixedAssetDao faDao3=new FixedAssetDaoImpl();
				faList=faDao3.fixedAssetSerByCT(category, type);
				System.out.println("\t\t编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
				Iterator it = faList.iterator();
				while(it.hasNext()){
					FixedAsset fa=(FixedAsset)it.next();
					System.out.println("\t\t"+fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
					+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser()+"\t"+fa.getRemark());	
				 }
			}
		}
		System.out.println(">>>固定资产按类别浏览成功！");
	}


	
	
	
	/**
	 * 固定资产增加界面实现
	 */  
	public void famAdd() {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//日期 格式转化
		Scanner input=new Scanner(System.in);
		
		System.out.println("********固定资产增加界面********");
		System.out.println("请输入要增添固定资产的相关信息>>>");
		System.out.print("请输入资产名称");
		String name=input.next();
		System.out.println("请从以下列表中选择资产类别>>>");
		
		/**
		 * 罗列固定资产类别表里所有大类以供选择
		 */
		System.out.println("请选择大类：");
		List<String> cList=new ArrayList();
		FixedAssetDao fixedAssetDao1=new FixedAssetDaoImpl();
		cList=fixedAssetDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>无任何类别，无法执行增添！");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		int ci=input.nextInt();
		String category=cList.get(ci-1);
		/**
		 * 罗列该大类下所有小类以供选择
		 */
	
		System.out.print("请从以下列表中选择资产型号>>>");
		
		System.out.println("请选择下属小类：");
		List<String> tList=new ArrayList();
		FixedAssetDao fixedAssetDao2=new FixedAssetDaoImpl();
		tList=fixedAssetDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>该大类下无任何小类,无法执行增添！");
			return;
		}
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		int ti=input.nextInt();
		String type=tList.get(ti-1);
		
		System.out.print("请输入价值:");
		int price=input.nextInt();
		System.out.print("请输入购买日期（xxxx-xx-xx）:");
		String sindate=input.next();
		Date indate=null;
		try {//日期格式转换
			indate = sd.parse(sindate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String status=null;
		boolean flag1=true;
		do{
		System.out.println("请输入从以下选项中选择设备状态:");
		System.out.println("1.正常");
		System.out.println("2.维修");
		System.out.println("3.报废");
		int choice1=input.nextInt();
		switch(choice1)
		{
		case 1:
			 status="正常";
			 flag1=false;
			break;
		case 2:
			 status="维修";
			 flag1=false;
			 break;
		case 3:
			 status="报废";
			 flag1=false;
			break;
		default :
			 System.out.println(">>>无效命令！请重新输入！");
			  break;
			
		}
		}while(flag1==true);
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
		
		FixedAssetDao fixedAssetDao3=new FixedAssetDaoImpl();
		int result=fixedAssetDao3.fixedAssetAdd(fixedAsset);
		if(result==1){
			System.out.println(">>>增添固定资产信息成功！");
			return ;
		}
		else{
			System.out.println(">>>增添固定资产信息失败！");
			return ;
		}	
	
		
	}

	/**
	 * 固定资产删除界面
	 */
	public void famDel() {
		System.out.println("********固定资产删除界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除固定资产的ID>>>");
		System.out.print("请输入ID:");
		int id=input.nextInt();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setId(id);
		
		FixedAssetDao fixedAssetDao1=new FixedAssetDaoImpl();
		if(fixedAssetDao1.fixedAssetSerById(id)!=null){
			FixedAssetDao fixedAssetDao2=new FixedAssetDaoImpl();
			int result=fixedAssetDao2.fixedAssetDel(fixedAsset);
			if(result==1){
				System.out.println(">>>删除固定次产信息成功！");
				return ;
			}
			else{
				System.out.println("删除固定资产信息失败！");
				return ;
			}
		}
		else{
			System.out.println(">>>资产ID错误，删除信息失败！");
			return ;
		}
	
	}
	public void famUpdate() {
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//日期 格式转化
		boolean flag=true;
		System.out.println("********固定资产修改界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要修改固定资产的ID>>>");
		
		int id=input.nextInt();
		FixedAssetDao fixedAssetDao1=new FixedAssetDaoImpl();
		if(fixedAssetDao1.fixedAssetSerById(id)==null)
		{
			System.out.println("错误：查无此ID");
			return;
		}else
		{
			FixedAssetDao fixedAssetDao2=new FixedAssetDaoImpl();
			FixedAsset fixedAsset= fixedAssetDao2.fixedAssetSerById(id);
		do{
			System.out.println("请从以下列表中选择要修改项目>>>");
			System.out.println("1.修改名称");
			System.out.println("2.修改类别");
			System.out.println("3.修改价值");
			System.out.println("4.修改购入日期");
			System.out.println("5.修改设备状态");
			System.out.println("6.修改备注");
			System.out.println("7.修改完成，退出修改");
			int choice=input.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("修改前名称为:"+fixedAsset.getName());
				System.out.println("请输入修改后名称:");
				String name=input.next();
				fixedAsset.setName(name);
				break;
			case 2:
				System.out.println("修改前类别为:"+fixedAsset.getCategory());
				System.out.println("型号为:"+fixedAsset.getType());
				System.out.println("请选择修改后的类别");
				/**
				 * 罗列固定资产类别表里所有大类以供选择
				 */
				System.out.println("请选择大类：");
				List<String> cList=new ArrayList();
				FixedAssetDao fixedAssetDao3=new FixedAssetDaoImpl();
				cList=fixedAssetDao3.cntShowC();
				if(cList.isEmpty()){
					System.out.println(">>>无任何类别，无法执行修改！");
					return;
				}
				for(int i=1;i<=cList.size();i++){
					System.out.println(i+"."+cList.get(i-1));
				}
				int ci=input.nextInt();
				String category=cList.get(ci-1);
				/**
				 * 罗列该大类下所有小类以供选择
				 */
			
				System.out.print("请从以下列表中选择资产型号>>>");
				
				System.out.println("请选择下属小类：");
				List<String> tList=new ArrayList();
				FixedAssetDao fixedAssetDao4=new FixedAssetDaoImpl();
				tList=fixedAssetDao4.cntShowTuC(category);
				if(tList.isEmpty()){
					System.out.println(">>>该大类下无任何小类,无法执行修改！");
					return;
				}
				for(int i=1;i<=tList.size();i++){
					System.out.println(i+"."+tList.get(i-1));
				}
				int ti=input.nextInt();
				String type=tList.get(ti-1);
				
				fixedAsset.setCategory(category);
				fixedAsset.setType(type);
				break;
			case 3:
				System.out.println("修改前价值为:"+fixedAsset.getPrice());
				System.out.println("请输入修改后价值:");
				int price=input.nextInt();
				fixedAsset.setPrice(price);
				break;
			case 4:
				System.out.println("修改前购入日期为:"+fixedAsset.getIndate());
				System.out.println("请输入修改后购入日期(YYYY-MM-DD):");
				String sindate=input.next();
				Date indate=null;
				try {
					indate = sd.parse(sindate);
				} catch (ParseException e) {
					e.printStackTrace();
				}//日期格式转换
				if(indate==null)
				{
					System.out.println(">>>日期未能修改成功");
					break;
				}else{
				fixedAsset.setIndate(indate);
				break;
				}
				
				
			case 5:
				boolean flag1=true;
				System.out.println("修改前设备状态为:"+fixedAsset.getStatus());
				do{
				System.out.println("请输入修改后设备状态:");
				System.out.println("1.正常");
				System.out.println("2.维修");
				System.out.println("3.报废");
				
				int choice1=input.nextInt();
				switch(choice1)
				{
				case 1:
					fixedAsset.setStatus("正常");
					 flag1=false;
					break;
				case 2:
					 fixedAsset.setStatus("维修");
					 flag1=false;
					 break;
				case 3:
					 fixedAsset.setStatus("报废");
					 flag1=false;
					break;
				default :
					 System.out.println("无效命令！请重新输入！");
					  break;
					
				}
				}while(flag1==true);
				
				break;
			case 6:
				System.out.println("修改前备注为:"+fixedAsset.getRemark());
				System.out.println("请输入修改后备注:");
				String remark=input.next();
				fixedAsset.setRemark(remark);
				break;
			case 7:
				flag=false;
				System.out.println("已退出修改界面");
				break;
			default:
				System.out.println("无效命令请重新输入！");
				break;
				
			}
			
			
		}while(flag==true);
		

		//判断是否修改成功
		FixedAssetDao fixedAssetDao5=new FixedAssetDaoImpl();
			int result=fixedAssetDao5.fixedAssetUpdate(fixedAsset);
			if(result==1){
				System.out.println(">>>修改固定次产信息成功！");
				
			}
			else{
				System.out.println(">>>修改固定资产信息失败！");
				
			}
		}
	}
	/**
	 * 按资产编号查询实现
	 */
	public void famSerById() {
		System.out.println("********固定资产按资产编号查询界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入资产编号：");
		int auId=input.nextInt();
		/**
		 * 执行固定资产按资产编号查询
		 */
		System.out.println("执行固定资产按资产编号查询...");
		FixedAsset fa=new FixedAsset();
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		fa=faDao.fixedAssetSerById(auId);
		if(fa==null){
			System.out.println(">>>固定资产按资产编号查询失败！请重新尝试"); 		
		}else{
			System.out.println(">>>固定资产按资产编号查询成功！");
			System.out.println("编号\t名称\t\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t\t备注");
			System.out.println(fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
			+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser()+"\t"+fa.getRemark());	
		}	
	}

	/**
	 * 按类别（大类和小类）查询罗列资产实现
	 */
	public void famSerByCT() {
		System.out.println("********固定资产按类别查询界面********");
		Scanner input=new Scanner(System.in);
		/**
		 * 罗列固定资产类别表里所有大类以供选择
		 */
		System.out.println("请选择大类：");
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>无任何类别，无法执行查询！");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		int ci=input.nextInt();
		String category=cList.get(ci-1);
		/**
		 * 罗列该大类下所有小类以供选择
		 */
		System.out.println("请选择下属小类：");
		List<String> tList=new ArrayList();
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		tList=faDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>该大类下无任何小类，无法执行查询！");
			return;
		}
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		int ti=input.nextInt();
		String type=tList.get(ti-1);
		/**
		 * 执行固定资产按类别查询
		 */
		System.out.println("执行固定资产按类别查询...");
		List<FixedAsset> faList=new ArrayList();
		FixedAssetDao faDao3=new FixedAssetDaoImpl();
		faList=faDao3.fixedAssetSerByCT(category, type);
		if(faList==null){
			System.out.println(">>>固定资产按类别查询失败！请重新尝试"); 		
		}else{
			System.out.println(">>>固定资产按类别查询成功！");
			System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
			Iterator it = faList.iterator();
			while(it.hasNext()){
				FixedAsset fa=(FixedAsset)it.next();
				System.out.println(fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
				+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser()+"\t"+fa.getRemark());	
		 	}
		}	
	}
	/**
	 * 按使用者查询实现
	 */
	public void famSerByAuser() {
		System.out.println("********固定资产按使用者查询界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入使用者姓名：");
		String aUser=input.next();
		/**
		 * 执行固定资产按使用者查询
		 */
		System.out.println("执行固定资产按使用者查询...");
		List<FixedAsset> faList=new ArrayList();
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		faList=faDao.fixedAssetSerByAuser(aUser);
		if(faList==null){
			System.out.println(">>>固定资产按使用者查询失败！请重新尝试"); 		
		}else{
			System.out.println(">>>固定资产按使用者查询成功！");
			System.out.println("编号\t名称\t\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t\t备注");
			Iterator it = faList.iterator();
			while(it.hasNext()){
				FixedAsset fa=(FixedAsset)it.next();
				System.out.println(fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
				+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser()+"\t"+fa.getRemark());	
		 	}
		}	
	}
	

}
