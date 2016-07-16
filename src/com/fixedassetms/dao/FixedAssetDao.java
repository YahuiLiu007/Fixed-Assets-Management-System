package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.FixedAsset;
/**
 * �̶��ʲ����������ӿ�
 * @author muse
 *create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * ������� ��cnt means Category and Type �����С�ࣩ
	 * @return Ӱ������
	 */
 int cntAdd(Object [] param);
	/**
	 * ɾ���ࣨcnt means Category and Type �����С�ࣩ
	 * @return Ӱ������
	 */
 int cntDel(Object [] param);
	/**
	 * ��ӡ���д����С�༰��ϵ
	 * @return 
	 */
 String cntPrint(Object [] param);
	/**
	 * ���ӹ̶��ʲ���Ϣ
<<<<<<< HEAD
	 * @return Ӱ������
	 */
 
 int fixedAssetAdd(FixedAsset FixedAsset);
	/**
=======
	 * 
>>>>>>> 0c8c4924fd07bab3b5bc36b07c15eb6d7f2e7967
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
 List<FixedAsset> fixedAssetSerByAuser(FixedAsset FixedAsset);

}
