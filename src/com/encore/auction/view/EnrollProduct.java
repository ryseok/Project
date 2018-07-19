package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class EnrollProduct extends JFrame {
	public JLabel la_id;                    				//아이디 라벨
	public JLabel la_productName;              //작품명 라벨
	public JLabel la_startPrice;         				//경매시작가 라벨
	public JLabel la_priceNow;                  	//즉시판매가 라벨
	public JLabel la_explain;                   		//설명 라벨
	public JButton bt_enroll;         				//등록 버튼
	public JButton bt_cancel;        				//취소 버튼

	public JTextField tf_id;                			//아이디 작성
	public JTextField tf_priceNow;              	//즉시판매가 작성  
	public JTextArea ta_explain;					//작품설명 ta
	public JScrollPane sp_explain;				//작품설명 sp
	public JLabel la_sort;								//작품종류 라벨
	public JComboBox cb_sort;					//작품종류 콤보박스
	public JTextField tf_productName;		//작품이름 tf
	public JTextField tf_startPrice;				//경매시작가 tf
	JRadioButton rb_open; 							//공개입찰 라디오버튼
	JRadioButton rb_close;							//비공개입찰 라디오버튼
	public EnrollProduct() {				
		setTitle("물품등록");
		rb_open = new JRadioButton("공개입찰");
		rb_close = new JRadioButton("비공개입찰");
		la_id = new JLabel("판매자아이디");
		la_id.setBounds(38, 30, 98, 18);
		la_productName = new JLabel("경매물품명");
		la_productName.setBounds(38, 63, 98, 18);
		la_startPrice = new JLabel("경매시작가");
		la_startPrice.setBounds(38, 99, 98, 18);
		la_priceNow = new JLabel("즉시판매가");
		la_priceNow.setBounds(38, 132, 98, 18);
		la_explain = new JLabel("설명");		
		la_explain.setBounds(38, 204, 98, 18);
		bt_enroll = new JButton("등록");
		bt_enroll.setBounds(111, 422, 105, 27);
		bt_cancel = new JButton("취소");				
		bt_cancel.setBounds(230, 422, 105, 27);
		
		tf_id = new JTextField();
		tf_id.setBounds(139, 27, 116, 24);
		tf_priceNow = new JTextField();
		tf_priceNow.setBounds(139, 129, 116, 24);

		
		tf_id.setFont(new Font("굴림", Font.PLAIN, 15));
		

		tf_id.setColumns(10);
		tf_priceNow.setColumns(10);
	

		getContentPane().setLayout(null);
		getContentPane().add(la_id);
		getContentPane().add(la_priceNow);
		getContentPane().add(la_productName);
		getContentPane().add(la_startPrice);
		getContentPane().add(la_explain);
		
		
		getContentPane().add(bt_enroll);
		getContentPane().add(bt_cancel);
		
		getContentPane().add(tf_id);
		getContentPane().add(tf_priceNow);
		
	
		rb_open.setBounds(146, 167, 139, 27);
		getContentPane().add(rb_open);
		
		rb_close.setBounds(297, 167, 139, 27);
		getContentPane().add(rb_close);
		
		sp_explain = new JScrollPane();
		sp_explain.setBounds(139, 201, 258, 121);
		getContentPane().add(sp_explain);
		
		ta_explain = new JTextArea();
		sp_explain.setViewportView(ta_explain);
		
		la_sort = new JLabel("종류");
		la_sort.setBounds(38, 352, 98, 18);
		getContentPane().add(la_sort);
		
		cb_sort = new JComboBox();
		cb_sort.setModel(new DefaultComboBoxModel(new String[] {"풍경화", "정물화", "인물화", "역사화", "유화"}));
		cb_sort.setBounds(139, 348, 105, 27);
		getContentPane().add(cb_sort);
		
		tf_productName = new JTextField();
		tf_productName.setFont(new Font("굴림", Font.PLAIN, 15));
		tf_productName.setColumns(10);
		tf_productName.setBounds(139, 60, 116, 24);
		getContentPane().add(tf_productName);
		
		tf_startPrice = new JTextField();
		tf_startPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		tf_startPrice.setColumns(10);
		tf_startPrice.setBounds(139, 96, 116, 24);
		getContentPane().add(tf_startPrice);

		
		setBounds(300, 200, 490, 508);
		setVisible(false);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg
	public void confirmMsg(String msg) {
		JOptionPane.showConfirmDialog(this, msg);
	}
}// class End
