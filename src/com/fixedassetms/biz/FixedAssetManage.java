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
	void famUpDate();
	/**
	 * 按资产编号查询精确查找界面
	 */
	void famSerById();
	/**
	 * 按大类查询罗列界面
	 */
	void famSerByC();
	/**
	 * 按小类查询罗列该类别下全部固定资产界面
	 */
	void famSerByT();

	/**
	 * 按大类别浏览界面
	 */
	void famReadByC();
	/**
	 * 按小类浏览界面
	 */
	void famReadByT();
	/**
	 * 按使用者查询界面
	 */
	void famSerByAuser();
	
	

}
