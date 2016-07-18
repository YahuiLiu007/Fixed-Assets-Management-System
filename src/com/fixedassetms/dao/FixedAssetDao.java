package com.fixedassetms.dao;

import java.util.List;
import com.fixedassetms.entity.FixedAsset;
/**
 * �̶��ʲ������͹̶��ʲ���������ӿ�
 * @author muse and zhaohui
 * create on 2016-7-15
 * modified by muse on 2016-7-17
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
	 * �̶��ʲ����ѯ��𣨴����С�ࣩ
	 * @param category �ʲ����࣬type �ʲ�С��
	 * @return Ӱ������
	 */
	boolean cntSerCT(String category,String type);
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
	int fixedAssetUpdate(FixedAsset fixedAsset);
	/** 
	 * ���ʲ���Ų�ѯ��ȷ����
	 * 
	 * @param �̶��ʲ�����
	 *
	 *  @return ���ʲ���Ų�ѯ��ȷ�������ù̶��ʲ�
	 */
	FixedAsset fixedAssetSerById(int id);
	/**
	 * ������ѯ���и������ȫ���̶��ʲ�
	 * 
	 * @param categoty ���࣬type С�� 
	 * 
	 * @return ���ʲ�����ѯ���и������ȫ���̶��ʲ�����
	 */
	List<FixedAsset>  fixedAssetSerByCT(String category,String type);
	/**
	 * ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�
	 * 
	 * @param �̶��ʲ�����
	 * 
	 * @return ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�����
	 */
	List<FixedAsset> fixedAssetSerByAuser(int Auser_id);

}
