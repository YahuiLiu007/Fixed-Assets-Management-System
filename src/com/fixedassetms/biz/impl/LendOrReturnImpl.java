package com.fixedassetms.biz.impl;

import java.util.Date;
import java.util.Scanner;

import com.fixedassetms.biz.LendOrReturn;
import com.fixedassetms.dao.AUserDao;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.dao.LendOrReturnDao;
import com.fixedassetms.dao.impl.AUserDaoImpl;
import com.fixedassetms.dao.impl.FixedAssetDaoImpl;
import com.fixedassetms.dao.impl.LendOrReturnDaoImpl;
import com.fixedassetms.entity.AUser;
import com.fixedassetms.entity.FixedAsset;
import com.fixedassetms.entity.Manager;
/**
 * 固定资产领用与归还实现
 * @author zhaohui
 *	create on 2016-7-15
 */
public class LendOrReturnImpl implements LendOrReturn{
	/**
	 * 固定资产领用方法实现
	 * @param manager 记录领用操作的管理员
	 */
	public void aLend(Manager manager) {
		System.out.println("********固定资产领用界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入领用人员编号：");
		int aUserId=input.nextInt();
		System.out.println("请输入固定资产编号：");
		int fAssetId=input.nextInt();
		System.out.println("请输入固定资产用途：");
		String purpose=input.next();
		System.out.println("请输入备注：");
		String remark=input.next();
		
		/**
		 * 判断该领用人员是否已登记
		 */
		AUser aUser=null;
		AUserDao aUserDao=new AUserDaoImpl();
		aUser=aUserDao.getByID(aUserId);
		if(aUser==null){
			System.out.println(">>>该领用人员未登记，因此无法领用！");
			return;
		}
		/**
		 * 判断该固定资产是否存在
		 */
		FixedAsset fAsset=null;
		FixedAssetDao fAssetDao=new FixedAssetDaoImpl();
		fAsset=fAssetDao.fixedAssetSerById(fAssetId);
		if(fAsset==null){
			System.out.println(">>>该固定资产不存在，因此无法领用！");
			return;
		}
		/**
		 * 判断该固定资产状态是否正常
		 */
		if(fAsset.getStatus().equals("报废")){
			System.out.println(">>>该固定资产处于报废状态，因此无法领用！");
			return;
		}else if(fAsset.getStatus().equals("维修")){
			System.out.println(">>>该固定资产处于维修状态，因此无法领用！");
			return;
		}
		/**
		 * 判断该固定资产是否已被领用
		 */
		if(fAsset.getAuser()!=null){
			if(fAsset.getAuser()==aUser.getName()){
				System.out.println(">>>该固定资产已被该领用人员领用，因此无法再次领用！");
				return;
			}else{
			System.out.println(">>>该固定资产已被他人领用，因此无法再次领用！");
			return;
			}
		}
		/**
		 * 若该领用人员已登记，该固定资产存在，状态正常且未被领用，则执行领用
		 */
		Date ldate=new Date();
		System.out.println("执行固定资产领用...");
		LendOrReturnDao lorDao=new LendOrReturnDaoImpl();
		Object[] param={fAsset.getId(),aUser.getId(),ldate,purpose,manager.getId(),remark};
		int flag=lorDao.lendAdd(param);
		/**
		 * 判断是否领用成功,若领用成功则更新资产信息
		 */
		if(flag==1){
			System.out.println(">>>固定资产领用成功！");
			fAsset.setAuser(aUser.getName());
			fAssetDao.fixedAssetUpdate(fAsset);	
		}else{
			System.out.println(">>>固定资产领用失败！请再次尝试");
		}	
	}

	/**
	 * 固定资产归还方法实现
	 * @param manager 记录归还操作的管理员
	 */
	public void aRet(Manager manager) {
		System.out.println("********固定资产领用界面********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入归还人员编号：");
		int aUserId=input.nextInt();
		System.out.println("请输入固定资产编号：");
		int fAssetId=input.nextInt();	
		System.out.println("请选择归还时固定资产状态： 1.正常 2.维修 3.报废");
		int rStatusT=input.nextInt();
		String rStatus="";
		System.out.println("请输入备注：");
		String remark=input.next();
		
		/**
		 * 判断该归还人员是否已登记
		 */
		AUser aUser=null;
		AUserDao aUserDao=new AUserDaoImpl();
		aUser=aUserDao.getByID(aUserId);
		if(aUser==null){
			System.out.println(">>>该归还人员未登记，因此无法归还！");
			return;
		}
		/**
		 * 判断该固定资产是否存在
		 */
		FixedAsset fAsset=null;
		FixedAssetDao fAssetDao=new FixedAssetDaoImpl();
		fAsset=fAssetDao.fixedAssetSerById(fAssetId);
		if(fAsset==null){
			System.out.println(">>>该固定资产不存在，因此无法归还！");
			return;
		}
		/**
		 * 判断该固定资产是否被领用
		 */
		if(fAsset.getAuser()==null){
			System.out.println(">>>该固定资产尚未被任何人领用，因此无法归还！");
			return;
		}else if(!fAsset.getAuser().equals(aUser.getName())){
			System.out.println(">>>该固定资产未被该归还人员领用，因此无法归还！");
			return;
		}
		/**
		 * 判断归还时该固定资产状态是否正常
		 */
		if(rStatusT==3){
			rStatus="报废";
			fAsset.setStatus("报废");
			System.out.println(">>>该固定资产归还时处于报废状态，可继续归还，但需按原价的100%赔偿 "+fAsset.getPrice()+" 元！");
		}else if(rStatusT==2){
			rStatus="维修";
			fAsset.setStatus("维修");
			System.out.println(">>>该固定资产归还时处于维修状态，可继续归还，但需按原价的50%赔偿 "+fAsset.getPrice()/2+" 元！");			
		}
		else{
			rStatus="正常";
		}
		/**
		 * 若该归还人员已登记，该固定资产存在且被该归还人员领用，则执行归还
		 */
		Date rdate=new Date();
		System.out.println("执行固定资产归还...");
		LendOrReturnDao lorDao=new LendOrReturnDaoImpl();
		Object[] param={fAsset.getId(),aUser.getId(),rdate,rStatus,manager.getId(),remark};
		int flag=lorDao.retAdd(param);
		/**
		 * 判断是否归还成功,若归还成功则更新资产信息
		 */
		if(flag==1){
			System.out.println(">>>固定资产归还成功！");
			fAsset.setAuser(null);
			fAssetDao.fixedAssetUpdate(fAsset);	
		}else{
			System.out.println(">>>固定资产归还失败！请再次尝试");
		}	
		
	}

}
