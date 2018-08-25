package com.funshop.admin.vo;

public class UserInfo {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String addr;
	private String question;
	private String answer;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	/*
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", addr=" + addr + "]";
	}
	*/
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", addr=" + addr + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
