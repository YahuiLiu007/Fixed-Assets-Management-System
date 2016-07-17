package com.fixedassetms.biz;
/**
 * 固定资产管理操作接口
 * @author muse and zhaohui
 *create on 2016-7-16 14:54:42
 *
 */

public interface FixedAssetManage {
	/**
	 * 固定资产添加类别
	 */
	void famAddCT();
	/**
	 * 固定资产删除类别
	 */
	void famDelCT();
	/**
	 * 打印所有类别
	 */
	void famShowCT();
	/**
	 * 固定资产按类别浏览
	 */
	void famShowByCT();
	

	
	
	/**
	 * 固定资产增加界面
	 */
	void famAdd();
	/**
	 * 固定资产删除界面
	 */
	void famDel();
	/**
	 * 固定资产修改界面
	 */
	void famUpdate();
	/**
	 * 按资产编号查询精确查找界面
	 */
	void famSerById();
	/**
	 * 按类别（大类和小类）查询罗列资产
	 */
	void famSerByCT();
	/**
	 * 按使用者查询界面
	 */
	void famSerByAuser();
	
	

}
