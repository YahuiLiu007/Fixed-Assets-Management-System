package com.fixedassetms.dao;
import java.util.Date;
import java.util.List;

import com.fixedassetms.entity.FixedAsset;
/**
 * 
 * @author muse
 *create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * ������� ��CNT means Category and Type �����С�ࣩ
	 */
	public int CNTAdd(Object [] param);
	/**
	 * ɾ���ࣨCNT means Category and Type �����С�ࣩ
	 */
	public int CNTDel(Object [] param);
	/**
	 * ��ӡ���д����С�༰��ϵ
	 */
	public String CNTPrint(Object [] param);
	/**
	 * ���ӹ̶��ʲ���Ϣ
	 */
	public int FixedAssetAdd(FixedAsset FixedAsset);
	/**
	 * ɾ���̶��ʲ���Ϣ
	 */
	public int FixedAssetDel(FixedAsset FixedAsset);
	/**
	 * ����������̶��ʲ���Ϣ
	 */
	public List<FixedAsset> FixedAssetReadByC(FixedAsset FixedAsset);
	/**
	 * ��С������̶��ʲ���Ϣ
	 */
	public List<FixedAsset>  FixedAssetReadByT(FixedAsset FixedAsset);
	/**
	 * ���ʲ���Ų�ѯ��ȷ����
	 */
	public List<FixedAsset>  FixedAssetSerById(FixedAsset FixedAsset);
	/**
	 * ���ʲ�����ѯ���и������ȫ���̶��ʲ�
	 */
	public List<FixedAsset>  FixedAssetSerByCNT(FixedAsset FixedAsset);
	/**
	 * ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�
	 */

}
