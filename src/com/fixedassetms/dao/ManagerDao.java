package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.Manager;;

public interface ManagerDao {
	int save(Manager manager);//�������Ա��Ϣ
	int del(Manager manager);//ɾ������Ա��Ϣ
	int update(Manager manager);//���¹���Ա��Ϣ
	Manager findManager(Manager manager);//��ȷ��ѯ����Ա
	Manager getByID(int ID);//����ID��ѯ
	List<Manager> showall();//��ӡ���й���Ա��Ϣ
}
