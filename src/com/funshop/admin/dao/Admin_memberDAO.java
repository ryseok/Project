package com.funshop.admin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funshop.admin.vo.Admin_memberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class Admin_memberDAO {
	SqlMapClient sqlMap;
	
	public Admin_memberDAO() {
		sqlMap = MySqlMapClient.getSqlMapInstance();
	}//생성자
	
	public List<Admin_memberVO> selectAll(Map<String, Object> map) throws SQLException {
		return sqlMap.queryForList("memberAdmin.selectAll",map);
	}//selectAll
}//main
