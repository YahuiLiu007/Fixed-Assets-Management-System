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
 * �̶��ʲ��������ʵ��
 * @author muse and zhaohui
 *create on 2016-7-16
 *modified by muse on 2016-7-17 
 *modified by zhaohui on 2016-7-17 
 */
public class FixedAssetManageImpl implements FixedAssetManage{
	/**
	 * �̶��ʲ�������ʵ��
	 */
	public void famAddCT() {
		System.out.println("********�̶��ʲ����༰С����ӽ���********");
		Scanner input=new Scanner(System.in);
		System.out.println("��������ࣺ");
		String category=input.next();//�������
		System.out.println("����������С�ࣺ");
		String type=input.next();
		
		/**
		 * �жϸ�С���Ƿ����
		 */
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		if(faDao1.cntSerCT(category,type)){
			System.out.println(">>>�������𣨴��༰С�ࣩ�Ѵ��ڣ��޷��ٴ���ӣ�");
			return;
		}
		/**
		 * ���������𣨴����С�ࣩΪ�£���ִ�����
		 */
		System.out.println("ִ���ʲ�������...");
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		int flag=faDao2.cntAddCT(category, type);
		if(flag==1){
			System.out.println(">>>�̶��ʲ������ӳɹ���");
		}else{
			System.out.println(">>>�̶��ʲ�������ʧ�ܣ����ٴγ���");
		}	
	}
	/**
	 * �̶��ʲ�ɾ������ʵ��
	 */
	public void famDelC() {
		System.out.println("********�̶��ʲ�����ɾ������********");
		Scanner input=new Scanner(System.in);
		/**
		 * ���й̶��ʲ����������д����Թ�ѡ��
		 */
		System.out.println("��ѡ����ࣺ");
		List<FixedAsset> fList=new ArrayList();
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>���κ�����޷�ִ��ɾ����");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ci=0;
		boolean flagc=false;
		do{
			ci=input.nextInt();
			flagc=((ci>=1)&&(ci<=cList.size()));
			if(!flagc){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagc);
		
		String category=cList.get(ci-1);
		/**
		 * ���иô���������С���Թ�ѡ��
		 */
		List<String> tList=new ArrayList();
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		tList=faDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>�ô��������κ�С�࣬�ɼ���ɾ��");
		}

		System.out.println("ִ���ʲ�����ɾ��...");
		for(int j=0;j<tList.size();j++){
			String type=tList.get(j);
			/**
			 * �жϹ̶��ʲ���������Ƿ���ڸ�����ʲ�
			 */		
			FixedAssetDao faDao3=new FixedAssetDaoImpl();
			fList=faDao3.fixedAssetSerByCT(category, type);
			/**
			 * ִ�й̶��ʲ�ɾ��
			 */
			if(!fList.isEmpty()){
				for(int k=0;k<fList.size();k++){
					FixedAssetDao fixedAssetDao4=new FixedAssetDaoImpl();
					FixedAsset fa=fixedAssetDao4.fixedAssetSerById(fList.get(k).getId());
					if(fa.getAuser_id()!=0){
						System.out.println("�ù̶��ʲ�"+fList.get(k).getId()+"�ѱ����ã�������ɾ����");
						return;
					}
					FixedAssetDao faDao5=new FixedAssetDaoImpl();
					faDao5.fixedAssetDel(fList.get(k));
				}
				fList.clear();
			}
			/**
			 * ִ�й̶��ʲ����ɾ��
			 */
			FixedAssetDao faDao5=new FixedAssetDaoImpl();
			faDao5.cntDelCT(category, type);
		}			
		if(fList.isEmpty()){
			System.out.println(">>>�̶��ʲ����ɾ���ɹ���");
		}else{
			System.out.println(">>>�̶��ʲ����ɾ��ʧ�ܣ����ٴγ���");
		}	
	}
	/**
	 * �̶��ʲ�ɾ��С��ʵ��
	 */
	public void famDelT() {
		System.out.println("********�̶��ʲ�С��ɾ������********");
		Scanner input=new Scanner(System.in);
		/**
		 * ���й̶��ʲ����������д����Թ�ѡ��
		 */
		System.out.println("��ѡ����ࣺ");
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>���κ�����޷�ִ��ɾ����");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ci=0;
		boolean flagc=false;
		do{
			ci=input.nextInt();
			flagc=((ci>=1)&&(ci<=cList.size()));
			if(!flagc){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagc);
		
		String category=cList.get(ci-1);
		/**
		 * ���иô���������С���Թ�ѡ��
		 */
		System.out.println("��ѡ������С�ࣺ");
		List<String> tList=new ArrayList();
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		tList=faDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>�ô��������κ�С�࣬�޷�ִ��ɾ����");
			return;
		}
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ti=0;
		boolean flagt=false;
		do{
			ti=input.nextInt();
			flagt=((ti>=1)&&(ti<=tList.size()));
			if(!flagt){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagt);

		String type=tList.get(ti-1);
		/**
		 * �жϹ̶��ʲ���������Ƿ���ڸ�����ʲ�
		 */		
		FixedAssetDao faDao3=new FixedAssetDaoImpl();
		List<FixedAsset> fList=new ArrayList();
		fList=faDao3.fixedAssetSerByCT(category, type);
		/**
		 * ִ�й̶��ʲ����ɾ��
		 */
		System.out.println("ִ���ʲ�С��ɾ��...");
		if(!fList.isEmpty()){
			for(int i=0;i<fList.size();i++){
				FixedAssetDao fixedAssetDao4=new FixedAssetDaoImpl();
				FixedAsset fa=fixedAssetDao4.fixedAssetSerById(fList.get(i).getId());
				if(fa.getAuser_id()!=0){
					System.out.println("�ù̶��ʲ�"+fList.get(i).getId()+"�ѱ����ã�������ɾ����");
					return;
				}
				FixedAssetDao faDao5=new FixedAssetDaoImpl();
				faDao5.fixedAssetDel(fList.get(i));
			}
			fList.clear();
		}
		FixedAssetDao faDao5=new FixedAssetDaoImpl();
		int flag1=faDao5.cntDelCT(category, type);
		
		if(flag1==1 && fList.isEmpty()){
			System.out.println(">>>�̶��ʲ����ɾ���ɹ���");
		}else{
			System.out.println(">>>�̶��ʲ����ɾ��ʧ�ܣ����ٴγ���");
		}	
		
	}
	/**
	 * ��ӡ�������
	 */
	public void famShowCT(){
		System.out.println("********��ӡ����������********");
		System.out.println("ִ�д�ӡ�������...");
		/**
		 * ���д���
		 */
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>���κ�����޷�ִ�д�ӡ��");
			return;
		}
		for(int i=0;i<cList.size();i++){
			String category=cList.get(i);
			System.out.println("���ࣺ"+category);
			/**
			 * ���иô�������С��
			 */
			List<String> tList=new ArrayList();
			FixedAssetDao faDao2=new FixedAssetDaoImpl();
			tList=faDao2.cntShowTuC(category);
			if(tList.isEmpty()){
				System.out.println(">>>�ô��������κ�С�࣡�ɼ�����ӡ");
				continue;
			}
			for(int j=0;j<tList.size();j++){
				String type=tList.get(j);
				System.out.println("\t����С�ࣺ"+type);
			}
		}
		System.out.println(">>>��ӡ�������ɹ���");
	}
	/**
	 * 	�̶��ʲ���������ʵ��
	 */
	public void famShowByCT() {
		System.out.println("********�̶��ʲ�������������********");
		System.out.println("ִ���ʲ���������...");
		/**
		 * ���д���
		 */
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>���κ�����޷�ִ�������");
			return;
		}
		for(int i=0;i<cList.size();i++){
			String category=cList.get(i);
			System.out.println("���ࣺ"+category);
			/**
			 * ���иô�������С��
			 */
			List<String> tList=new ArrayList();
			FixedAssetDao faDao2=new FixedAssetDaoImpl();
			tList=faDao2.cntShowTuC(category);
			if(tList.isEmpty()){
				System.out.println(">>>�ô��������κ�С�࣡�ɼ������");
				continue;
			}
			for(int j=0;j<tList.size();j++){
				String type=tList.get(j);
				System.out.println("\t����С�ࣺ"+type);
				/**
				 * ���и�С���¹̶��ʲ�
				 */
				System.out.println("\t��С���¹̶��ʲ���");
				List<FixedAsset> faList=new ArrayList();
				FixedAssetDao faDao3=new FixedAssetDaoImpl();
				faList=faDao3.fixedAssetSerByCT(category, type);
				System.out.println("\t\t���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����Id\t��ע");
				Iterator it = faList.iterator();
				while(it.hasNext()){
					FixedAsset fa=(FixedAsset)it.next();
					System.out.println("\t\t"+fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
					+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser_id()+"\t"+fa.getRemark());	
				 }
			}
		}
		System.out.println(">>>�̶��ʲ����������ɹ���");
	}


	
	
	
	/**
	 * �̶��ʲ����ӽ���ʵ��
	 */  
	public void famAdd() {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//���� ��ʽת��
		Scanner input=new Scanner(System.in);
		
		System.out.println("********�̶��ʲ����ӽ���********");
		System.out.println("������Ҫ����̶��ʲ��������Ϣ>>>");
		System.out.print("�������ʲ�����");
		String name=input.next();
		System.out.println("��������б���ѡ���ʲ����>>>");
		
		/**
		 * ���й̶��ʲ����������д����Թ�ѡ��
		 */
		System.out.println("��ѡ����ࣺ");
		List<String> cList=new ArrayList();
		FixedAssetDao fixedAssetDao1=new FixedAssetDaoImpl();
		cList=fixedAssetDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>���κ�����޷�ִ������");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ci=0;
		boolean flagc=false;
		do{
			ci=input.nextInt();
			flagc=((ci>=1)&&(ci<=cList.size()));
			if(!flagc){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagc);
		
		String category=cList.get(ci-1);
		/**
		 * ���иô���������С���Թ�ѡ��
		 */
	
		System.out.print("��������б���ѡ���ʲ��ͺ�>>>");
		
		System.out.println("��ѡ������С�ࣺ");
		List<String> tList=new ArrayList();
		FixedAssetDao fixedAssetDao2=new FixedAssetDaoImpl();
		tList=fixedAssetDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>�ô��������κ�С��,�޷�ִ������");
			return;
		}
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ti=0;
		boolean flagt=false;
		do{
			ti=input.nextInt();
			flagt=((ti>=1)&&(ti<=tList.size()));
			if(!flagt){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagt);
		
		String type=tList.get(ti-1);
		
		System.out.print("�������ֵ:");
		int price=input.nextInt();
		System.out.print("�����빺�����ڣ�xxxx-xx-xx��:");
		String sindate=input.next();
		Date indate=null;
		try {//���ڸ�ʽת��
			indate = sd.parse(sindate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String status=null;
		boolean flag1=true;
		do{
		System.out.println("�����������ѡ����ѡ���豸״̬:");
		System.out.println("1.����");
		System.out.println("2.ά��");
		System.out.println("3.����");
		int choice1=input.nextInt();
		switch(choice1)
		{
		case 1:
			 status="����";
			 flag1=false;
			break;
		case 2:
			 status="ά��";
			 flag1=false;
			 break;
		case 3:
			 status="����";
			 flag1=false;
			break;
		default :
			 System.out.println(">>>��Ч������������룡");
			  break;
			
		}
		}while(flag1==true);
		int auser_id=0;//��¼��ʱΪ0
		System.out.print("�����뱸ע:");
		String remark=input.next();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setName(name);
		fixedAsset.setCategory(category);
		fixedAsset.setType(type);
		fixedAsset.setPrice(price);
		fixedAsset.setIndate(indate);
		fixedAsset.setStatus(status);
		fixedAsset.setAuser_id(auser_id);
		fixedAsset.setRemark(remark);
		
		FixedAssetDao fixedAssetDao3=new FixedAssetDaoImpl();
		int result=fixedAssetDao3.fixedAssetAdd(fixedAsset);
		if(result==1){
			System.out.println(">>>����̶��ʲ���Ϣ�ɹ���");
			return ;
		}
		else{
			System.out.println(">>>����̶��ʲ���Ϣʧ�ܣ�");
			return ;
		}	
	
		
	}

	/**
	 * �̶��ʲ�ɾ������
	 */
	public void famDel() {
		System.out.println("********�̶��ʲ�ɾ������********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ���̶��ʲ���ID>>>");
		System.out.print("������ID:");
		int id=input.nextInt();
		
		FixedAsset fixedAsset=new FixedAsset();
		fixedAsset.setId(id);
		
		FixedAssetDao fixedAssetDao1=new FixedAssetDaoImpl();
		FixedAsset fa=fixedAssetDao1.fixedAssetSerById(id);
		if(fa!=null){
			if(fa.getAuser_id()!=0){
				System.out.println("�ù̶��ʲ�"+id+"�ѱ����ã�������ɾ����");
				return;
			}
			FixedAssetDao fixedAssetDao2=new FixedAssetDaoImpl();
			int result=fixedAssetDao2.fixedAssetDel(fixedAsset);
			if(result==1){
				System.out.println(">>>ɾ���̶��β���Ϣ�ɹ���");
			}
			else{
				System.out.println("ɾ���̶��ʲ���Ϣʧ�ܣ�");
			}
		}
		else{
			System.out.println(">>>�ʲ�ID����ɾ����Ϣʧ�ܣ�");
		}
	
	}
	/**
	 * �̶��ʲ��޸Ľ���
	 */
	public void famUpdate() {
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//���� ��ʽת��
		boolean flag=true;
		System.out.println("********�̶��ʲ��޸Ľ���********");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�޸Ĺ̶��ʲ���ID>>>");
		
		int id=input.nextInt();
		FixedAssetDao fixedAssetDao1=new FixedAssetDaoImpl();
		if(fixedAssetDao1.fixedAssetSerById(id)==null)
		{
			System.out.println("���󣺲��޴�ID");
			return;
		}else
		{
			FixedAssetDao fixedAssetDao2=new FixedAssetDaoImpl();
			FixedAsset fixedAsset= fixedAssetDao2.fixedAssetSerById(id);
		do{
			System.out.println("��������б���ѡ��Ҫ�޸���Ŀ>>>");
			System.out.println("1.�޸�����");
			System.out.println("2.�޸����");
			System.out.println("3.�޸ļ�ֵ");
			System.out.println("4.�޸Ĺ�������");
			System.out.println("5.�޸��豸״̬");
			System.out.println("6.�޸ı�ע");
			System.out.println("7.�޸���ɣ��˳��޸�");
			int choice=input.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("�޸�ǰ����Ϊ:"+fixedAsset.getName());
				System.out.println("�������޸ĺ�����:");
				String name=input.next();
				fixedAsset.setName(name);
				break;
			case 2:
				System.out.println("�޸�ǰ���Ϊ:"+fixedAsset.getCategory());
				System.out.println("�ͺ�Ϊ:"+fixedAsset.getType());
				System.out.println("��ѡ���޸ĺ�����");
				/**
				 * ���й̶��ʲ����������д����Թ�ѡ��
				 */
				System.out.println("��ѡ����ࣺ");
				List<String> cList=new ArrayList();
				FixedAssetDao fixedAssetDao3=new FixedAssetDaoImpl();
				cList=fixedAssetDao3.cntShowC();
				if(cList.isEmpty()){
					System.out.println(">>>���κ�����޷�ִ���޸ģ�");
					return;
				}
				for(int i=1;i<=cList.size();i++){
					System.out.println(i+"."+cList.get(i-1));
				}
				/**
				 * �ж������Ƿ���Ч
				 */
				int ci=0;
				boolean flagc=false;
				do{
					ci=input.nextInt();
					flagc=((ci>=1)&&(ci<=cList.size()));
					if(!flagc){
						System.out.println("������Ч�����������룡");
					}
				}while(!flagc);
				
				String category=cList.get(ci-1);
				/**
				 * ���иô���������С���Թ�ѡ��
				 */
			
				System.out.print("��������б���ѡ���ʲ��ͺ�>>>");
				
				System.out.println("��ѡ������С�ࣺ");
				List<String> tList=new ArrayList();
				FixedAssetDao fixedAssetDao4=new FixedAssetDaoImpl();
				tList=fixedAssetDao4.cntShowTuC(category);
				if(tList.isEmpty()){
					System.out.println(">>>�ô��������κ�С��,�޷�ִ���޸ģ�");
					return;
				}
				for(int i=1;i<=tList.size();i++){
					System.out.println(i+"."+tList.get(i-1));
				}
				/**
				 * �ж������Ƿ���Ч
				 */
				int ti=0;
				boolean flagt=false;
				do{
					ti=input.nextInt();
					flagt=((ti>=1)&&(ti<=tList.size()));
					if(!flagt){
						System.out.println("������Ч�����������룡");
					}
				}while(!flagt);
				
				String type=tList.get(ti-1);
				
				fixedAsset.setCategory(category);
				fixedAsset.setType(type);
				break;
			case 3:
				System.out.println("�޸�ǰ��ֵΪ:"+fixedAsset.getPrice());
				System.out.println("�������޸ĺ��ֵ:");
				int price=input.nextInt();
				fixedAsset.setPrice(price);
				break;
			case 4:
				System.out.println("�޸�ǰ��������Ϊ:"+fixedAsset.getIndate());
				System.out.println("�������޸ĺ�������(YYYY-MM-DD):");
				String sindate=input.next();
				Date indate=null;
				try {
					indate = sd.parse(sindate);
				} catch (ParseException e) {
					e.printStackTrace();
				}//���ڸ�ʽת��
				if(indate==null)
				{
					System.out.println(">>>����δ���޸ĳɹ�");
					break;
				}else{
				fixedAsset.setIndate(indate);
				break;
				}
				
				
			case 5:
				boolean flag1=true;
				System.out.println("�޸�ǰ�豸״̬Ϊ:"+fixedAsset.getStatus());
				do{
				System.out.println("�������޸ĺ��豸״̬:");
				System.out.println("1.����");
				System.out.println("2.ά��");
				System.out.println("3.����");
				
				int choice1=input.nextInt();
				switch(choice1)
				{
				case 1:
					fixedAsset.setStatus("����");
					 flag1=false;
					break;
				case 2:
					 fixedAsset.setStatus("ά��");
					 flag1=false;
					 break;
				case 3:
					 fixedAsset.setStatus("����");
					 flag1=false;
					break;
				default :
					 System.out.println("��Ч������������룡");
					  break;
					
				}
				}while(flag1==true);
				
				break;
			case 6:
				System.out.println("�޸�ǰ��עΪ:"+fixedAsset.getRemark());
				System.out.println("�������޸ĺ�ע:");
				String remark=input.next();
				fixedAsset.setRemark(remark);
				break;
			case 7:
				flag=false;
				System.out.println("���˳��޸Ľ���");
				break;
			default:
				System.out.println("��Ч�������������룡");
				break;
				
			}
			
			
		}while(flag==true);
		

		//�ж��Ƿ��޸ĳɹ�
		FixedAssetDao fixedAssetDao5=new FixedAssetDaoImpl();
			int result=fixedAssetDao5.fixedAssetUpdate(fixedAsset);
			if(result==1){
				System.out.println(">>>�޸Ĺ̶��β���Ϣ�ɹ���");
				
			}
			else{
				System.out.println(">>>�޸Ĺ̶��ʲ���Ϣʧ�ܣ�");
				
			}
		}
	}
	/**
	 * ���ʲ���Ų�ѯʵ��
	 */
	public void famSerById() {
		System.out.println("********�̶��ʲ����ʲ���Ų�ѯ����********");
		Scanner input=new Scanner(System.in);
		System.out.println("�������ʲ���ţ�");
		int auId=input.nextInt();
		/**
		 * ִ�й̶��ʲ����ʲ���Ų�ѯ
		 */
		System.out.println("ִ�й̶��ʲ����ʲ���Ų�ѯ...");
		FixedAsset fa=new FixedAsset();
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		fa=faDao.fixedAssetSerById(auId);
		if(fa==null){
			System.out.println(">>>�̶��ʲ����ʲ���Ų�ѯʧ�ܣ������³���"); 		
		}else{
			System.out.println(">>>�̶��ʲ����ʲ���Ų�ѯ�ɹ���");
			System.out.println("���\t����\t\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����Id\t\t��ע");
			System.out.println(fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
			+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser_id()+"\t"+fa.getRemark());	
		}	
	}

	/**
	 * ����𣨴����С�ࣩ��ѯ�����ʲ�ʵ��
	 */
	public void famSerByCT() {
		System.out.println("********�̶��ʲ�������ѯ����********");
		Scanner input=new Scanner(System.in);
		/**
		 * ���й̶��ʲ����������д����Թ�ѡ��
		 */
		System.out.println("��ѡ����ࣺ");
		List<String> cList=new ArrayList();
		FixedAssetDao faDao1=new FixedAssetDaoImpl();
		cList=faDao1.cntShowC();
		if(cList.isEmpty()){
			System.out.println(">>>���κ�����޷�ִ�в�ѯ��");
			return;
		}
		for(int i=1;i<=cList.size();i++){
			System.out.println(i+"."+cList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ci=0;
		boolean flagc=false;
		do{
			ci=input.nextInt();
			flagc=((ci>=1)&&(ci<=cList.size()));
			if(!flagc){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagc);
		
		String category=cList.get(ci-1);
		/**
		 * ���иô���������С���Թ�ѡ��
		 */
		System.out.println("��ѡ������С�ࣺ");
		List<String> tList=new ArrayList();
		FixedAssetDao faDao2=new FixedAssetDaoImpl();
		tList=faDao2.cntShowTuC(category);
		if(tList.isEmpty()){
			System.out.println(">>>�ô��������κ�С�࣬�޷�ִ�в�ѯ��");
			return;
		}
		for(int i=1;i<=tList.size();i++){
			System.out.println(i+"."+tList.get(i-1));
		}
		/**
		 * �ж������Ƿ���Ч
		 */
		int ti=0;
		boolean flagt=false;
		do{
			ti=input.nextInt();
			flagt=((ti>=1)&&(ti<=tList.size()));
			if(!flagt){
				System.out.println("������Ч�����������룡");
			}
		}while(!flagt);
		
		String type=tList.get(ti-1);
		/**
		 * ִ�й̶��ʲ�������ѯ
		 */
		System.out.println("ִ�й̶��ʲ�������ѯ...");
		List<FixedAsset> faList=new ArrayList();
		FixedAssetDao faDao3=new FixedAssetDaoImpl();
		faList=faDao3.fixedAssetSerByCT(category, type);
		if(faList==null){
			System.out.println(">>>�̶��ʲ�������ѯʧ�ܣ������³���"); 		
		}else{
			System.out.println(">>>�̶��ʲ�������ѯ�ɹ���");
			System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����Id\t��ע");
			Iterator it = faList.iterator();
			while(it.hasNext()){
				FixedAsset fa=(FixedAsset)it.next();
				System.out.println(fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
				+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser_id()+"\t"+fa.getRemark());	
		 	}
		}	
	}
	/**
	 * ��ʹ���߲�ѯʵ��
	 */
	public void famSerByAuser() {
		System.out.println("********�̶��ʲ���ʹ���߲�ѯ����********");
		Scanner input=new Scanner(System.in);
		System.out.println("������ʹ����Id��");
		int aUser_id=input.nextInt();
		/**
		 * ִ�й̶��ʲ���ʹ���߲�ѯ
		 */
		System.out.println("ִ�й̶��ʲ���ʹ���߲�ѯ...");
		List<FixedAsset> faList=new ArrayList();
		FixedAssetDao faDao=new FixedAssetDaoImpl();
		faList=faDao.fixedAssetSerByAuser(aUser_id);
		if(faList==null){
			System.out.println(">>>�̶��ʲ���ʹ���߲�ѯʧ�ܣ������³���"); 		
		}else{
			System.out.println(">>>�̶��ʲ���ʹ���߲�ѯ�ɹ���");
			System.out.println("���\t����\t\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����Id\t\t��ע");
			Iterator it = faList.iterator();
			while(it.hasNext()){
				FixedAsset fa=(FixedAsset)it.next();
				System.out.println(fa.getId()+"\t"+fa.getName()+"\t"+fa.getCategory()+"\t"+fa.getType()
				+"\t"+fa.getPrice()+"\t"+fa.getIndate()+"\t"+fa.getStatus()+"\t"+fa.getAuser_id()+"\t"+fa.getRemark());	
		 	}
		}	
	}
	

}
