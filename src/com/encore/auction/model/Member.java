package com.encore.auction.model;

import java.util.Date;
import java.util.HashMap;

public class Member {
	//member
	private String id; //아이디
	private String pw; //패스워드
	private String name; //이름
	private String email; //이메일
	private int ssn1; //주민번호1
	private int ssn2; //주민번호2
	private String phone; //전화번호
	private String addr; //주소
	private String seller; //판매자,구매자 구분
	private int card; //계좌 번호 or 카드 번호
	private int total; //총구입 가격
	private String grade; //회원 등급
	private String ask; //패스워드 찾기 질문
	private String answer; //패스워드 찾기 답변

	//standby
	private Date applydate; //판매자 인증 신청 날짜

	//seller
	private String sellerid; //판매자 아이디

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pw, String name, String email, int ssn1, int ssn2, String phone, String addr,
			String seller, int card, int total, String grade, String ask, String answer) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.ssn1 = ssn1;
		this.ssn2 = ssn2;
		this.phone = phone;
		this.addr = addr;
		this.seller = seller;
		this.card = card;
		this.total = total;
		this.grade = grade;
		this.ask = ask;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSsn1() {
		return ssn1;
	}

	public void setSsn1(int ssn1) {
		this.ssn1 = ssn1;
	}

	public int getSsn2() {
		return ssn2;
	}

	public void setSsn2(int ssn2) {
		this.ssn2 = ssn2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getSellerid() {
		return sellerid;
	}

	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}

	public HashMap<String, String> convertBtoH() {
		HashMap<String, String> map = new HashMap<>();
		map.put("아이디", id);
		map.put("패스워드", pw);
		map.put("이름", name);
		map.put("이메일", email);
		map.put("주민번호1", ssn1+"");
		map.put("주민번호2", ssn2+"");
		map.put("전화번호", phone);
		map.put("주소", addr);
		map.put("판매자구매자구분", seller);
		map.put("계좌번호(카드번호)", card+"");
		map.put("총구입가격", total+"");
		map.put("회원등급", grade);
		map.put("패스워드찾기질문", ask);
		map.put("패스워드찾기답변", answer);

		return map;
	}

	public static Member convertHtoB(HashMap<String, String> map) {

		Member b = new Member(map.get("아이디"), 
				map.get("패스워드"), 
				map.get("이름"), 
				map.get("이메일"), 
				Integer.parseInt(map.get("주민번호1")), 
				Integer.parseInt(map.get("주민번호2")), 
				map.get("전화번호"), 
				map.get("주소"), 
				map.get("판매자구매자구분"), 
				Integer.parseInt(map.get("계좌번호(카드번호)")), 
				Integer.parseInt(map.get("총구입가격")), 
				map.get("회원등급"), 
				map.get("패스워드찾기질문"), 
				map.get("패스워드찾기답변"));
		return b;
	}
}