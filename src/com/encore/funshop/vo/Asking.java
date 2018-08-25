package com.encore.funshop.vo;

import java.util.Date;

public class Asking {
	private int asking_no; //���ǹ�ȣ
	private Date asking_date; //���� ��¥
	private String member_id_from; //�������̵�
	private String member_id_to; //�޴¾��̵�
	private String asking_content; //���ǳ���
	private String asking_check; //Ȯ�ο���
	
	public Asking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asking(int asking_no, Date asking_date, String member_id_from, String member_id_to, String asking_content,
			String asking_check) {
		super();
		this.asking_no = asking_no;
		this.asking_date = asking_date;
		this.member_id_from = member_id_from;
		this.member_id_to = member_id_to;
		this.asking_content = asking_content;
		this.asking_check = asking_check;
	}
	
	public int getAsking_no() {
		return asking_no;
	}
	public void setAsking_no(int asking_no) {
		this.asking_no = asking_no;
	}
	public Date getAsking_date() {
		return asking_date;
	}
	public void setAsking_date(Date asking_date) {
		this.asking_date = asking_date;
	}
	public String getMember_id_from() {
		return member_id_from;
	}
	public void setMember_id_from(String member_id_from) {
		this.member_id_from = member_id_from;
	}
	public String getMember_id_to() {
		return member_id_to;
	}
	public void setMember_id_to(String member_id_to) {
		this.member_id_to = member_id_to;
	}
	public String getAsking_content() {
		return asking_content;
	}
	public void setAsking_content(String asking_content) {
		this.asking_content = asking_content;
	}
	public String getAsking_check() {
		return asking_check;
	}
	public void setAsking_check(String asking_check) {
		this.asking_check = asking_check;
	}
	
	@Override
	public String toString() {
		return "Asking [asking_no=" + asking_no + ", asking_date=" + asking_date + ", member_id_from=" + member_id_from
				+ ", member_id_to=" + member_id_to + ", asking_content=" + asking_content + ", asking_check="
				+ asking_check + "]";
	}
}
