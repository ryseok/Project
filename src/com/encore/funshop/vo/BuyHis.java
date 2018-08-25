package com.encore.funshop.vo;

import java.util.Date;

public class BuyHis {
	private int buyHis_no; //�ֹ���ȣ
	private Date buyHis_date; //��¥
	private String member_id; //�����ھ��̵�
	private int pdetail_no; //�ɼǹ�ȣ
	private int product_no; //��ǰ��ȣ
	private int buyHis_num; //�ֹ�����
	private String buyHis_addr; //������ּ�
	private int buyHis_payment; //�����ݾ�
	private String buyHis_payType; //��������
	private String buyHis_payInfo; //��������
	private int buyHis_discount; //���αݾ�
	private String buyHis_cond; //����
	
	private String pdetail_name; //�ɼ��̸� 
	private String product_name; //��ǰ�̸� 
	private String product_mainimg; //��ǰ�̹��� 
	
	public BuyHis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyHis(int buyHis_no, Date buyHis_date, String member_id, int pdetail_no, int product_no, int buyHis_num,
			String buyHis_addr, int buyHis_payment, String buyHis_payType, String buyHis_payInfo, int buyHis_discount,
			String buyHis_cond, String pdetail_name, String product_name, String product_mainimg) {
		super();
		this.buyHis_no = buyHis_no;
		this.buyHis_date = buyHis_date;
		this.member_id = member_id;
		this.pdetail_no = pdetail_no;
		this.product_no = product_no;
		this.buyHis_num = buyHis_num;
		this.buyHis_addr = buyHis_addr;
		this.buyHis_payment = buyHis_payment;
		this.buyHis_payType = buyHis_payType;
		this.buyHis_payInfo = buyHis_payInfo;
		this.buyHis_discount = buyHis_discount;
		this.buyHis_cond = buyHis_cond;
		this.pdetail_name = pdetail_name;
		this.product_name = product_name;
		this.product_mainimg = product_mainimg;
	}
	
	public int getBuyHis_no() {
		return buyHis_no;
	}
	public void setBuyHis_no(int buyHis_no) {
		this.buyHis_no = buyHis_no;
	}
	public Date getBuyHis_date() {
		return buyHis_date;
	}
	public void setBuyHis_date(Date buyHis_date) {
		this.buyHis_date = buyHis_date;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getPdetail_no() {
		return pdetail_no;
	}
	public void setPdetail_no(int pdetail_no) {
		this.pdetail_no = pdetail_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getBuyHis_num() {
		return buyHis_num;
	}
	public void setBuyHis_num(int buyHis_num) {
		this.buyHis_num = buyHis_num;
	}
	public String getBuyHis_addr() {
		return buyHis_addr;
	}
	public void setBuyHis_addr(String buyHis_addr) {
		this.buyHis_addr = buyHis_addr;
	}
	public int getBuyHis_payment() {
		return buyHis_payment;
	}
	public void setBuyHis_payment(int buyHis_payment) {
		this.buyHis_payment = buyHis_payment;
	}
	public String getBuyHis_payType() {
		return buyHis_payType;
	}
	public void setBuyHis_payType(String buyHis_payType) {
		this.buyHis_payType = buyHis_payType;
	}
	public String getBuyHis_payInfo() {
		return buyHis_payInfo;
	}
	public void setBuyHis_payInfo(String buyHis_payInfo) {
		this.buyHis_payInfo = buyHis_payInfo;
	}
	public int getBuyHis_discount() {
		return buyHis_discount;
	}
	public void setBuyHis_discount(int buyHis_discount) {
		this.buyHis_discount = buyHis_discount;
	}
	public String getBuyHis_cond() {
		return buyHis_cond;
	}
	public void setBuyHis_cond(String buyHis_cond) {
		this.buyHis_cond = buyHis_cond;
	}
	public String getPdetail_name() {
		return pdetail_name;
	}
	public void setPdetail_name(String pdetail_name) {
		this.pdetail_name = pdetail_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_mainimg() {
		return product_mainimg;
	}
	public void setProduct_mainimg(String product_mainimg) {
		this.product_mainimg = product_mainimg;
	}
	
	@Override
	public String toString() {
		return "BuyHis [buyHis_no=" + buyHis_no + ", buyHis_date=" + buyHis_date + ", member_id=" + member_id
				+ ", pdetail_no=" + pdetail_no + ", product_no=" + product_no + ", buyHis_num=" + buyHis_num
				+ ", buyHis_addr=" + buyHis_addr + ", buyHis_payment=" + buyHis_payment + ", buyHis_payType="
				+ buyHis_payType + ", buyHis_payInfo=" + buyHis_payInfo + ", buyHis_discount=" + buyHis_discount
				+ ", buyHis_cond=" + buyHis_cond + ", pdetail_name=" + pdetail_name + ", product_name=" + product_name
				+ ", product_mainimg=" + product_mainimg + "]";
	}
}
