package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.FixedAsset;
/**
 * �̶��ʲ����������ӿ�
 * @author muse and zhaohui
 * create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * ���Ӵ��ࣨcnt means Category and Type �����С�ࣩ 
	 * @param category �ʲ�����
	 * @return Ӱ������
	 */
	int cntAddC(String category);
	/**
	 * ����С��(insert)��cnt means Category and Type �����С�ࣩ 
	 * @param type �ʲ�С��
	 * @return Ӱ������
	 */
	int cntAddTi(String category,String type);
	/**
	 * ����С��(update)��cnt means Category and Type �����С�ࣩ 
	 * @param type �ʲ�С��
	 * @return Ӱ������
	 */
	int cntAddTu(String category,String type);
	/**
	 * ɾ�����ࣨcnt means Category and Type �����С�ࣩ
	 * @param category �ʲ�����
	 * @return Ӱ������
	 */
	int cntDelC(String category);
	/**
	 * ɾ��С�ࣨcnt means Category and Type �����С�ࣩ
	 * @param type �ʲ�С��
	 * @return Ӱ������
	 */
	int cntDelT(String type);
	/**
	 * ��ӡĳ�����µ�����С�ࣨcnt means Category and Type �����С�ࣩ
	 * @param category ĳ�ʲ�����
	 * @return �ʲ�С������
	 */
	List<String> cntShowTuC(String category);
	/**
	 * ��ӡ���д��ࣨcnt means Category and Type �����С�ࣩ
	 * @return �ʲ���������
	 */
	List<String> cntShowT();
	/**
	 * ��ӡ����С�ࣨcnt means Category and Type �����С�ࣩ
	 * @return �ʲ�С������
	 */
	List<String> cntShowC();

	
	
	/**
	 * ���ӹ̶��ʲ���Ϣ
	 * 
	 * @param �̶��ʲ�����
	 * 
	 * @return Ӱ������
	 */
	int fixedAssetAdd(FixedAsset fixedAsset);
	/**
	 * ɾ���̶��ʲ���Ϣ
	 * 
	 * @param �̶��ʲ�����
	 * 
	 * @return Ӱ������
	 */
	int fixedAssetDel(FixedAsset fixedAsset);
	/**
	 * �޸Ĺ̶��ʲ���Ϣ
	 * 
	 * @param �̶��ʲ�����
	 * 
	 * @return Ӱ������
	 */
	int fixedAssetUpDate(FixedAsset fixedAsset);
	/** 
	 * ���ʲ���Ų�ѯ��ȷ����
	 * 
	 * @param �̶��ʲ�����
	 *
	 *  @return ���ʲ���Ų�ѯ��ȷ�������ù̶��ʲ�
	 */
	FixedAsset fixedAssetSerById(int id);
	/**
	 * �������ѯ���и������ȫ���̶��ʲ�
	 * 
	 * @param String ����
	 * 
	 * @return ���ʲ�����ѯ���и������ȫ���̶��ʲ�����
	 */
	List<FixedAsset>  fixedAssetSerByC(String category);
	/**
	 * ��С���ѯ���и������ȫ���̶��ʲ�
	 * 
	 * @param String С��
	 * 
	 * @return ���ʲ�����ѯ���и������ȫ���̶��ʲ�����
	 */
	List<FixedAsset>  fixedAssetSerByT(String type);
	/**
	 * ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�
	 * 
	 * @param �̶��ʲ�����
	 * 
	 * @return ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�����
	 */
	List<FixedAsset> fixedAssetSerByAuser(String Auser);

}
