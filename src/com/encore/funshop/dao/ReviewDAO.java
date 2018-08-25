package com.encore.funshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.encore.funshop.vo.Review;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class ReviewDAO {
	SqlMapClient smc;
	
	public ReviewDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<Review> selectReviewList() {
		try {
			return smc.queryForList("selectReviewList");
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public Review selectReview(int review_no) {
		try {
			return (Review) smc.queryForObject("selectReview", review_no);
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertReview(Review review) {
		try {
			smc.insert("insertReview", review);
			return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteReview(int review_no) {
		try {
			if(smc.delete("deleteReview", review_no) > 0) return true;
			else return false;
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}
}
