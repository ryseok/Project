package com.encore.auction.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class LoginView extends JFrame {
	/*
		JTextField id_tf 		   : ID 작성 하는곳 
		JPasswordField password_pf : 비밀번호 작성 하는곳

		JButton login_bt 			: 로그인 버튼 
		JButton guest_bt 			: 게스트 버튼 JButton
		JButton button 	 			: 회원가입 버튼
		JButton id_password_find_bt : 아이디 및 비밀번호 찾기 버튼 
	 */

	public JTextField id_tf;
	public JPasswordField password_pf;

	public JButton login_bt;
	public JButton guest_bt;
	public JButton signiup_bt;
	public JButton id_password_find_bt;
	public JCheckBox chckbxNewCheckBox;
	
	JLabel logo_Lb;
	public LoginView() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("로그인");
		
		//new 연산자
		chckbxNewCheckBox = new JCheckBox("아이디/비밀번호 저장");
		logo_Lb = new JLabel();
		password_pf = new JPasswordField();
		login_bt = new JButton("Login");
		guest_bt = new JButton("Guest");
		guest_bt.setEnabled(false);
		signiup_bt = new JButton("SignUp");
		id_password_find_bt = new JButton("아이디 및 비밀번호 찾기");
		id_tf = new JTextField();
		
		
		//setFont
		id_tf.setFont(new Font("굴림", Font.PLAIN, 20));
		password_pf.setFont(new Font("굴림", Font.PLAIN, 20));
		chckbxNewCheckBox.setFont(new Font("굴림", Font.PLAIN, 15));
		login_bt.setFont(new Font("굴림", Font.BOLD, 17));
		guest_bt.setFont(new Font("굴림", Font.BOLD, 17));
		signiup_bt.setFont(new Font("굴림", Font.BOLD, 17));
		
		//setBackground
		chckbxNewCheckBox.setBackground(Color.WHITE);
		login_bt.setBackground(SystemColor.inactiveCaptionBorder);
		guest_bt.setBackground(SystemColor.inactiveCaptionBorder);
		id_password_find_bt.setBackground(SystemColor.inactiveCaptionBorder);
		signiup_bt.setBackground(SystemColor.inactiveCaptionBorder);
		
		//setIcon
		logo_Lb.setIcon(new ImageIcon("image/logo.png"));
		
		//setBounds
		id_tf.setBounds(91, 278, 277, 54);
		password_pf.setBounds(91, 344, 277, 54);
		login_bt.setBounds(91, 456, 277, 36);
		guest_bt.setBounds(91, 504, 277, 36);
		id_password_find_bt.setBounds(91, 735, 277, 27);
		chckbxNewCheckBox.setBounds(101, 406, 267, 27);
		signiup_bt.setBounds(91, 552, 277, 36);
		logo_Lb.setBounds(91, 116, 277, 91);
		
		//JFrame 붙이기
		getContentPane().setLayout(null);
		getContentPane().add(id_tf);
		getContentPane().add(password_pf);
		getContentPane().add(login_bt);
		getContentPane().add(guest_bt);
		getContentPane().add(id_password_find_bt);
		getContentPane().add(signiup_bt);
		getContentPane().add(logo_Lb);
		getContentPane().add(chckbxNewCheckBox);



		setBounds(300, 200, 490, 821);
//		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

//	public static void main(String[] args) {
//		new LoginView();
//	}// main End
}// class End