package com.encore.auction.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MypageView2 extends JPanel {
	public JLabel la_msg, la_grade;
	public JButton  bt_update, bt_history, bt_logout;
	public MypageView2() {
		setLayout(null);
		la_msg = new JLabel("id님 환영합니다.");
		la_grade = new JLabel("등급: VIP");
		
		bt_update = new JButton("비밀번호 수정");
		bt_history = new JButton("이용 내역");
		bt_logout = new JButton("로그아웃");
		la_msg.setBounds(50, 83, 150, 30);
		la_grade.setBounds(50, 139, 150, 30);
		
		bt_update.setBounds(66, 260, 150, 30);
		bt_history.setBounds(66, 322, 150, 30);
		bt_logout.setBounds(66, 380, 150, 30);
		
		add(la_msg);
		add(la_grade);
		
		add(bt_update);
		add(bt_history);
		add(bt_logout);
		
		setSize(300,500);
		setVisible(false);
	}
}

