package com.encore.auction.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;

public class ChatView extends JFrame {
	public JTextField tf_send;
	public JLabel la_msg;
	public JTextArea ta_chat;
	public JScrollPane sp_ta_chat, sp_list;
	public JTextArea li_inwon;
	public JButton bt_change, bt_exit;
	public JPanel p;
	public JTextArea ta_record;
	public JLabel la_ad;
	public JPanel p_main;
	public JLabel la_nowP;
	public JScrollPane scrollPane;
	public JLabel la_picture;
	public JLabel la_productName;
	public JLabel la_auctionNum ;
	public JLabel la_seller; 
	public JLabel la_sort;
	public JLabel la_date;
	public JLabel la_nowPrice;
	public ChatView() {
		 la_picture = new JLabel("그림");
		 la_productName = new JLabel("경매물품명");
		 la_auctionNum = new JLabel("경매번호");
		 la_seller = new JLabel("판매자");
		 la_sort = new JLabel("물품종류");
		 la_date = new JLabel("남은시간");
		 la_nowPrice = new JLabel("현재최고금액");
	setTitle("경매방");
	tf_send = new JTextField(15);
	ta_record = new JTextArea();
	 la_ad = new JLabel(new ImageIcon("image/ad.gif"));
	JPanel p_main = new JPanel();
	JScrollPane scrollPane = new JScrollPane((Component) null);
	tf_send.setBounds(520, 608, 320, 30);
	la_msg = new JLabel("Message");
	la_msg.setBounds(460, 608, 60, 30);
	ta_chat = new JTextArea();
	ta_chat.setLineWrap(true);//TextArea 가로길이를 벗어나는 text발생시 자동
	li_inwon = new JTextArea();
	sp_ta_chat = new JScrollPane(ta_chat);
	sp_ta_chat.setBounds(460, 206, 380, 390);
	sp_list = new JScrollPane(li_inwon);
	sp_list.setBounds(850, 206, 120, 350);
	bt_change = new JButton("입찰하기");
	bt_change.setBounds(850, 568, 120, 30);
	bt_exit = new JButton("나가기");
	bt_exit.setBounds(850, 608, 120, 30);
	p = new JPanel();
	p.setBackground(Color.PINK);
	p.setLayout(null);
	p.add(sp_ta_chat);
	p.add(la_msg);
	p.add(tf_send);
	p.add(sp_list);
	p.add(bt_change);
	p.add(bt_exit);
	getContentPane().add(p);
	
	p_main.setBounds(14, 29, 432, 325);
	p.add(p_main);
	p_main.setLayout(null);
	
	la_picture.setBounds(24, 12, 394, 182);
	p_main.add(la_picture);
	
	la_productName.setBounds(243, 204, 175, 26);
	p_main.add(la_productName);
	
	la_auctionNum.setBounds(34, 206, 175, 26);
	p_main.add(la_auctionNum);
	
	la_seller.setBounds(34, 244, 175, 26);
	p_main.add(la_seller);
	
	la_sort.setBounds(243, 244, 175, 26);
	p_main.add(la_sort);
	
	
	la_date.setBounds(34, 282, 175, 26);
	p_main.add(la_date);
	
	la_nowPrice.setBounds(243, 282, 175, 26);
	p_main.add(la_nowPrice);
	
	scrollPane.setBounds(14, 371, 432, 279);
	p.add(scrollPane);
	
	ta_record.setLineWrap(true);
	scrollPane.setViewportView(ta_record);
	
	la_ad.setBounds(460, 29, 499, 162);
	p.add(la_ad);
	setBounds(300,200,1002,709);
	tf_send.requestFocus();
	setVisible(false);
	}// 생성자
	
	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this, msg);
	}
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}// CharView


