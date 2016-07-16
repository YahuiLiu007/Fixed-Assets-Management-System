package com.fixedassetms.biz.impl;

import java.util.Scanner;

import com.fixedassetms.biz.LendOrReturn;
/**
 * 固定资产领用与归还实现
 * @author zhaohui
 *	create 2016-7-15
 */
public class LendOrReturnImpl implements LendOrReturn{
	/**
	 * 固定资产领用方法实现
	 */
	public boolean aLend() {
		System.out.println("********固定资产领用********");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入领用人员ID：");
		int aUserId=input.nextInt();
		System.out.println("请输入领用资产ID：");
		int fAssetId=input.nextInt();
		
		/**
		 * 判断该领用人员是否已登记
		 */
		
		return false;
	}

	/**
	 * 固定资产归还方法实现
	 */
	public boolean aReturn() {
		System.out.println("固定资产领用");
		
		return false;
	}

}
