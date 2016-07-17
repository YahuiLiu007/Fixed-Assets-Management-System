package com.fixedassetms.biz.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fixedassetms.biz.FixedAssetManage;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.dao.impl.FixedAssetDaoImpl;

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

	
	
	@Override
	public void famAdd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famDel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void famUpDate() {
		// TODO Auto-generated method stub
		
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
