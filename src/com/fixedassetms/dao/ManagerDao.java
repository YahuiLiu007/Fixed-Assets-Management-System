package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.Manager;;

public interface ManagerDao {
	int save(Manager manager);//增添管理员信息
	int del(Manager manager);//删除管理员信息
	int update(Manager manager);//更新管理员信息
	Manager findManager(Manager manager);//精确查询管理员
	Manager getByID(int ID);//根据ID查询
	List<Manager> showall();//打印所有管理员信息
}
