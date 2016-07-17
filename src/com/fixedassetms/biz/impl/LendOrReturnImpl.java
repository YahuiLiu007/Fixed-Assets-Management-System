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
 * �̶��ʲ�������黹ʵ��
 * @author zhaohui
 *	create on 2016-7-15
 */
public class LendOrReturnImpl implements LendOrReturn{
	/**
	 * �̶��ʲ����÷���ʵ��
	 * @param manager ��¼���ò����Ĺ���Ա
	 */
	public void aLend(Manager manager) {
		System.out.println("********�̶��ʲ����ý���********");
		Scanner input=new Scanner(System.in);
		System.out.println("������������Ա��ţ�");
		int aUserId=input.nextInt();
		System.out.println("������̶��ʲ���ţ�");
		int fAssetId=input.nextInt();
		System.out.println("������̶��ʲ���;��");
		String purpose=input.next();
		System.out.println("�����뱸ע��");
		String remark=input.next();
		
		/**
		 * �жϸ�������Ա�Ƿ��ѵǼ�
		 */
		AUser aUser=null;
		AUserDao aUserDao=new AUserDaoImpl();
		aUser=aUserDao.getByID(aUserId);
		if(aUser==null){
			System.out.println(">>>��������Աδ�Ǽǣ�����޷����ã�");
			return;
		}
		/**
		 * �жϸù̶��ʲ��Ƿ����
		 */
		FixedAsset fAsset=null;
		FixedAssetDao fAssetDao=new FixedAssetDaoImpl();
		fAsset=fAssetDao.fixedAssetSerById(fAssetId);
		if(fAsset==null){
			System.out.println(">>>�ù̶��ʲ������ڣ�����޷����ã�");
			return;
		}
		/**
		 * �жϸù̶��ʲ�״̬�Ƿ�����
		 */
		if(fAsset.getStatus().equals("����")){
			System.out.println(">>>�ù̶��ʲ����ڱ���״̬������޷����ã�");
			return;
		}else if(fAsset.getStatus().equals("ά��")){
			System.out.println(">>>�ù̶��ʲ�����ά��״̬������޷����ã�");
			return;
		}
		/**
		 * �жϸù̶��ʲ��Ƿ��ѱ�����
		 */
		if(fAsset.getAuser()!=null){
			if(fAsset.getAuser()==aUser.getName()){
				System.out.println(">>>�ù̶��ʲ��ѱ���������Ա���ã�����޷��ٴ����ã�");
				return;
			}else{
			System.out.println(">>>�ù̶��ʲ��ѱ��������ã�����޷��ٴ����ã�");
			return;
			}
		}
		/**
		 * ����������Ա�ѵǼǣ��ù̶��ʲ����ڣ�״̬������δ�����ã���ִ������
		 */
		Date ldate=new Date();
		System.out.println("ִ�й̶��ʲ�����...");
		LendOrReturnDao lorDao=new LendOrReturnDaoImpl();
		Object[] param={fAsset.getId(),aUser.getId(),ldate,purpose,manager.getId(),remark};
		int flag=lorDao.lendAdd(param);
		/**
		 * �ж��Ƿ����óɹ�,�����óɹ�������ʲ���Ϣ
		 */
		if(flag==1){
			System.out.println(">>>�̶��ʲ����óɹ���");
			fAsset.setAuser(aUser.getName());
			fAssetDao.fixedAssetUpdate(fAsset);	
		}else{
			System.out.println(">>>�̶��ʲ�����ʧ�ܣ����ٴγ���");
		}	
	}

	/**
	 * �̶��ʲ��黹����ʵ��
	 * @param manager ��¼�黹�����Ĺ���Ա
	 */
	public void aRet(Manager manager) {
		System.out.println("********�̶��ʲ����ý���********");
		Scanner input=new Scanner(System.in);
		System.out.println("������黹��Ա��ţ�");
		int aUserId=input.nextInt();
		System.out.println("������̶��ʲ���ţ�");
		int fAssetId=input.nextInt();	
		System.out.println("��ѡ��黹ʱ�̶��ʲ�״̬�� 1.���� 2.ά�� 3.����");
		int rStatusT=input.nextInt();
		String rStatus="";
		System.out.println("�����뱸ע��");
		String remark=input.next();
		
		/**
		 * �жϸù黹��Ա�Ƿ��ѵǼ�
		 */
		AUser aUser=null;
		AUserDao aUserDao=new AUserDaoImpl();
		aUser=aUserDao.getByID(aUserId);
		if(aUser==null){
			System.out.println(">>>�ù黹��Աδ�Ǽǣ�����޷��黹��");
			return;
		}
		/**
		 * �жϸù̶��ʲ��Ƿ����
		 */
		FixedAsset fAsset=null;
		FixedAssetDao fAssetDao=new FixedAssetDaoImpl();
		fAsset=fAssetDao.fixedAssetSerById(fAssetId);
		if(fAsset==null){
			System.out.println(">>>�ù̶��ʲ������ڣ�����޷��黹��");
			return;
		}
		/**
		 * �жϸù̶��ʲ��Ƿ�����
		 */
		if(fAsset.getAuser()==null){
			System.out.println(">>>�ù̶��ʲ���δ���κ������ã�����޷��黹��");
			return;
		}else if(!fAsset.getAuser().equals(aUser.getName())){
			System.out.println(">>>�ù̶��ʲ�δ���ù黹��Ա���ã�����޷��黹��");
			return;
		}
		/**
		 * �жϹ黹ʱ�ù̶��ʲ�״̬�Ƿ�����
		 */
		if(rStatusT==3){
			rStatus="����";
			fAsset.setStatus("����");
			System.out.println(">>>�ù̶��ʲ��黹ʱ���ڱ���״̬���ɼ����黹�����谴ԭ�۵�100%�⳥ "+fAsset.getPrice()+" Ԫ��");
		}else if(rStatusT==2){
			rStatus="ά��";
			fAsset.setStatus("ά��");
			System.out.println(">>>�ù̶��ʲ��黹ʱ����ά��״̬���ɼ����黹�����谴ԭ�۵�50%�⳥ "+fAsset.getPrice()/2+" Ԫ��");			
		}
		else{
			rStatus="����";
		}
		/**
		 * ���ù黹��Ա�ѵǼǣ��ù̶��ʲ������ұ��ù黹��Ա���ã���ִ�й黹
		 */
		Date rdate=new Date();
		System.out.println("ִ�й̶��ʲ��黹...");
		LendOrReturnDao lorDao=new LendOrReturnDaoImpl();
		Object[] param={fAsset.getId(),aUser.getId(),rdate,rStatus,manager.getId(),remark};
		int flag=lorDao.retAdd(param);
		/**
		 * �ж��Ƿ�黹�ɹ�,���黹�ɹ�������ʲ���Ϣ
		 */
		if(flag==1){
			System.out.println(">>>�̶��ʲ��黹�ɹ���");
			fAsset.setAuser(null);
			fAssetDao.fixedAssetUpdate(fAsset);	
		}else{
			System.out.println(">>>�̶��ʲ��黹ʧ�ܣ����ٴγ���");
		}	
		
	}

}
