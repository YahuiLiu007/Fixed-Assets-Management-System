package com.fixedassetms.dao;

import java.util.List;
import java.util.Set;

import com.fixedassetms.entity.FixedAsset;
/**
 * �̶��ʲ������͹̶��ʲ���������ӿ�
 * @author muse and zhaohui
 * create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * �̶��ʲ��������𣨴����С�ࣩ
	 * @param category �ʲ����࣬type �ʲ�С��
	 * @return Ӱ������
	 */
	int cntAddCT(String category,String type);
	/**
	 * �̶��ʲ���ɾ����𣨴����С�ࣩ
	 * @param category �ʲ����࣬type �ʲ�С��
	 * @return Ӱ������
	 */
	int cntDelCT(String category,String type);
	/**
	 * �̶��ʲ����ѯС��
	 * @param type �ʲ�С��
	 * @return Ӱ������
	 */
	boolean cntSerT(String type);
	/**
	 * �̶��ʲ����ӡĳ�����µ�����С��
	 * @param category ĳ�ʲ�����
	 * @return �ʲ�С������
	 */
	List<String> cntShowTuC(String category);
	/**
	 * �̶��ʲ����ӡ���д���
	 * @return �ʲ���������
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
