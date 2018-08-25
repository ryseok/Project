package com.funshop.admin.dao;

import java.sql.SQLException;

import org.apache.struts.action.Action;

import com.funshop.admin.vo.Pdetail;
import com.funshop.admin.vo.Product;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class AdminPageDAO extends Action {
	SqlMapClient smc;

	public AdminPageDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean insertProduct(Product product) {
		try {
			smc.insert("adminPage.insertProduct", product);
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertPdetail(Pdetail pdetail) {
		try {
			smc.insert("adminPage.insertPdetail", pdetail);
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
}