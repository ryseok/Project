package com.encore.auction.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MypageView extends JFrame{
	public JScrollPane sp_tp;
	public JButton bt_submit1, bt_exit1;
	public JPanel p_second;
	public JPanel p_first;
	public JTabbedPane tp_mypage;
	MypageView2 mv2;
	public MypageView() {
	setTitle("마이페이지");
	mv2 = new MypageView2();
	tp_mypage = new JTabbedPane();
	getContentPane().add(tp_mypage);
	p_first = new JPanel();
	p_first.setBackground(Color.PINK);
	tp_mypage.add("알림", p_first);
	p_first.setLayout(null);
	
	JPanel p_first_1 = new JPanel();
	p_first_1.setLayout(null);
	p_first_1.setBounds(28, 36, 1087, 142);
	p_first.add(p_first_1);
	
	JButton bt_alarm_cancel1 = new JButton("알림취소");
	bt_alarm_cancel1.setBounds(941, 56, 120, 30);
	p_first_1.add(bt_alarm_cancel1);
	
	JLabel la_first_p1 = new JLabel("그림");
	la_first_p1.setBounds(14, 12, 218, 118);
	p_first_1.add(la_first_p1);
	
	JLabel la_first_p_name1 = new JLabel("그림이름");
	la_first_p_name1.setBounds(246, 32, 143, 18);
	p_first_1.add(la_first_p_name1);
	
	JLabel la_first_left1 = new JLabel("남은 시간");
	la_first_left1.setBounds(246, 80, 143, 18);
	p_first_1.add(la_first_left1);
	
	JLabel la_first_name1 = new JLabel("작가");
	la_first_name1.setBounds(521, 32, 143, 18);
	p_first_1.add(la_first_name1);
	
	JButton bt_first_sub1 = new JButton("구독하기");
	bt_first_sub1.setBounds(514, 74, 120, 30);
	p_first_1.add(bt_first_sub1);
	
	JPanel p_first_2 = new JPanel();
	p_first_2.setLayout(null);
	p_first_2.setBounds(28, 230, 1087, 142);
	p_first.add(p_first_2);
	
	JButton bt_alarm_cancel2 = new JButton("알림취소");
	bt_alarm_cancel2.setBounds(941, 56, 120, 30);
	p_first_2.add(bt_alarm_cancel2);
	
	JLabel la_first_p2 = new JLabel("그림");
	la_first_p2.setBounds(14, 12, 218, 118);
	p_first_2.add(la_first_p2);
	
	JLabel la_first_p_name2 = new JLabel("그림이름");
	la_first_p_name2.setBounds(246, 32, 143, 18);
	p_first_2.add(la_first_p_name2);
	
	JLabel la_first_left2 = new JLabel("남은 시간");
	la_first_left2.setBounds(246, 80, 143, 18);
	p_first_2.add(la_first_left2);
	
	JLabel la_first_name2 = new JLabel("작가");
	la_first_name2.setBounds(521, 32, 143, 18);
	p_first_2.add(la_first_name2);
	
	JButton bt_first_sub2 = new JButton("구독하기");
	bt_first_sub2.setBounds(514, 74, 120, 30);
	p_first_2.add(bt_first_sub2);
	
	JPanel p_first_3 = new JPanel();
	p_first_3.setLayout(null);
	p_first_3.setBounds(28, 415, 1087, 142);
	p_first.add(p_first_3);
	
	JButton bt_alarm_cancel3 = new JButton("알림취소");
	bt_alarm_cancel3.setBounds(941, 56, 120, 30);
	p_first_3.add(bt_alarm_cancel3);
	
	JLabel la_first_p3 = new JLabel("그림");
	la_first_p3.setBounds(14, 12, 218, 118);
	p_first_3.add(la_first_p3);
	
	JLabel la_first_p_name3 = new JLabel("그림이름");
	la_first_p_name3.setBounds(246, 32, 143, 18);
	p_first_3.add(la_first_p_name3);
	
	JLabel la_first_left3 = new JLabel("남은 시간");
	la_first_left3.setBounds(246, 80, 143, 18);
	p_first_3.add(la_first_left3);
	
	JLabel la_first_name3 = new JLabel("작가");
	la_first_name3.setBounds(521, 32, 143, 18);
	p_first_3.add(la_first_name3);
	
	JButton bt_first_sub3 = new JButton("구독하기");
	bt_first_sub3.setBounds(514, 74, 120, 30);
	p_first_3.add(bt_first_sub3);
	p_second = new JPanel();
	tp_mypage.add("입찰", p_second);
	tp_mypage.add("개인정보", mv2);
	
	p_second.setLayout(null);
	p_second.setBackground(Color.PINK);
	
	JPanel p_second_1 = new JPanel();
	p_second_1.setBounds(31, 26, 1100, 142);
	p_second.add(p_second_1);
	p_second_1.setLayout(null);
	bt_exit1 = new JButton("입찰취소");
	bt_exit1.setBounds(940, 79, 120, 30);
	p_second_1.add(bt_exit1);
	bt_submit1 = new JButton("입찰하기");
	bt_submit1.setBounds(940, 38, 120, 30);
	p_second_1.add(bt_submit1);
	
	JLabel la_picture1 = new JLabel("그림");
	la_picture1.setBounds(14, 12, 218, 118);
	p_second_1.add(la_picture1);
	
	JLabel la_pictureName1 = new JLabel("그림이름");
	la_pictureName1.setBounds(246, 12, 143, 18);
	p_second_1.add(la_pictureName1);
	
	JLabel la_nowPrice1 = new JLabel("현재 입찰가");
	la_nowPrice1.setBounds(246, 44, 143, 18);
	p_second_1.add(la_nowPrice1);
	
	JLabel la_nowNum1 = new JLabel("입찰자수");
	la_nowNum1.setBounds(246, 85, 143, 18);
	p_second_1.add(la_nowNum1);
	
	JLabel la_people1 = new JLabel("작가");
	la_people1.setBounds(520, 12, 143, 18);
	p_second_1.add(la_people1);
	
	JButton bt_sub1 = new JButton("구독하기");
	bt_sub1.setBounds(479, 56, 120, 30);
	p_second_1.add(bt_sub1);
	
	JPanel p_second_2 = new JPanel();
	p_second_2.setLayout(null);
	p_second_2.setBounds(31, 224, 1100, 142);
	p_second.add(p_second_2);
	
	JButton bt_exit2 = new JButton("입찰취소");
	bt_exit2.setBounds(940, 79, 120, 30);
	p_second_2.add(bt_exit2);
	
	JButton bt_submit2 = new JButton("입찰하기");
	bt_submit2.setBounds(940, 38, 120, 30);
	p_second_2.add(bt_submit2);
	
	JLabel la_picture2 = new JLabel("그림");
	la_picture2.setBounds(14, 12, 218, 118);
	p_second_2.add(la_picture2);
	
	JLabel la_pictureName2 = new JLabel("그림이름");
	la_pictureName2.setBounds(246, 12, 143, 18);
	p_second_2.add(la_pictureName2);
	
	JLabel la_nowPrice2 = new JLabel("현재 입찰가");
	la_nowPrice2.setBounds(246, 44, 143, 18);
	p_second_2.add(la_nowPrice2);
	
	JLabel la_nowNum2 = new JLabel("입찰자수");
	la_nowNum2.setBounds(246, 85, 143, 18);
	p_second_2.add(la_nowNum2);
	
	JLabel la_people2 = new JLabel("작가");
	la_people2.setBounds(520, 12, 143, 18);
	p_second_2.add(la_people2);
	
	JButton bt_sub2 = new JButton("구독하기");
	bt_sub2.setBounds(479, 56, 120, 30);
	p_second_2.add(bt_sub2);
	
	JPanel p_second_3 = new JPanel();
	p_second_3.setLayout(null);
	p_second_3.setBounds(31, 407, 1100, 142);
	p_second.add(p_second_3);
	
	JButton bt_exit3 = new JButton("입찰취소");
	bt_exit3.setBounds(940, 79, 120, 30);
	p_second_3.add(bt_exit3);
	
	JButton bt_submit3 = new JButton("입찰하기");
	bt_submit3.setBounds(940, 38, 120, 30);
	p_second_3.add(bt_submit3);
	
	JLabel la_picture3 = new JLabel("그림");
	la_picture3.setBounds(14, 12, 218, 118);
	p_second_3.add(la_picture3);
	
	JLabel la_pictureName3 = new JLabel("그림이름");
	la_pictureName3.setBounds(246, 12, 143, 18);
	p_second_3.add(la_pictureName3);
	
	JLabel la_nowPrice3 = new JLabel("현재 입찰가");
	la_nowPrice3.setBounds(246, 44, 143, 18);
	p_second_3.add(la_nowPrice3);
	
	JLabel la_nowNum3 = new JLabel("입찰자수");
	la_nowNum3.setBounds(246, 85, 143, 18);
	p_second_3.add(la_nowNum3);
	
	JLabel la_people3 = new JLabel("작가");
	la_people3.setBounds(520, 12, 143, 18);
	p_second_3.add(la_people3);
	
	JButton bt_sub3 = new JButton("구독하기");
	bt_sub3.setBounds(479, 56, 120, 30);
	p_second_3.add(bt_sub3);
	setBounds(300,200,1168,665);
	setVisible(false);
	}// 생성자
}// ChatClient
