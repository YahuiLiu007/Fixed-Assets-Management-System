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
	 * @return Ӱ������
	 */
 int fixedAssetAdd(FixedAsset FixedAsset);
	/**
	 * @param �̶��ʲ�����
	 * ɾ���̶��ʲ���Ϣ
	 * @return Ӱ������
	 */
 int fixedAssetDel(FixedAsset FixedAsset);
	/**
	 * @param �̶��ʲ�����
	 * �޸Ĺ̶��ʲ���Ϣ
	 * @return Ӱ������
	 */
 int fixedAssetUpDate();
	/**
	 * @param �̶��ʲ�����
	 * ����������̶��ʲ���Ϣ
	 * @return ���������̶��ʲ�����
	 */
 List<FixedAsset> fixedAssetReadByC(FixedAsset FixedAsset);
	/**
	 * @param �̶��ʲ�����
	 * ��С������̶��ʲ���Ϣ
	 *  @return ��С�����̶��ʲ�����
	 */
 List<FixedAsset>  fixedAssetReadByT(FixedAsset FixedAsset);
	/**
	 * @param �̶��ʲ�����
	 * ���ʲ���Ų�ѯ��ȷ����
	 *  @return ���ʲ���Ų�ѯ��ȷ�������ù̶��ʲ�
	 */
 FixedAsset fixedAssetSerById(FixedAsset FixedAsset);
	/**
	 * @param �̶��ʲ�����
	 * ���ʲ�����ѯ���и������ȫ���̶��ʲ�
	 * @return ���ʲ�����ѯ���и������ȫ���̶��ʲ�����
	 */
 List<FixedAsset>  fixedAssetSerByCNT(FixedAsset FixedAsset);
	/**
	 * @param �̶��ʲ�����
	 * ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�
	 * @return ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�����
	 */
 List<FixedAsset> fixedAssetSerByAuser(FixedAsset FixedAsset);

}
