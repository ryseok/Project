package com.encore.funshop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.encore.funshop.vo.UserInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class UserInfoDAO {
	SqlMapClient smc;
	
	public UserInfoDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean insert(UserInfo user) {//ȸ������
		try {
			smc.insert("user.insert",user);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//insert
	
	public boolean idCheck(String id) {//id �ߺ�Ȯ��
		try {
			//Object ob = smc.queryForObject("user.idCheck",id);
			//if(ob!=null)return true;
			Integer cnt = (Integer) smc.queryForObject("user.idCheck",id);
			if(cnt==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//idCheck
	
	public boolean selectLogin(Map<String, String> map) {//�α���
		try {
			Object ob = smc.queryForObject("user.selectLogin",map);
			if(ob!=null) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//selectLogin
	
	public String selectId(Map<String, String> map) {//idã��
		String id = null;
		try {
			id = (String) smc.queryForObject("user.selectId", map);
			if(id!=null) return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}//selectId
	
	public String selectPw(Map<String, String> map) {//pwã��
		String pw = null;
		try {
			pw = (String) smc.queryForObject("user.selectPw", map);
			if(pw!=null) return pw;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}//selectPw
}
