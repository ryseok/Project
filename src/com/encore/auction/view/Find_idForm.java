package com.encore.auction.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Find_idForm extends JPanel{
	public JButton find_idSubmit; 	//아이디 찾기 확인 버튼
	public JTextField tf_findName;	//이메일주소찾기_이름 
	public JTextField tf_findJumin;		//이메일주소찾기_전화번호
	public JLabel la_name;
	public JLabel la_jumin;
	public Find_idForm() {
		find_idSubmit = new JButton("확인");
		tf_findName = new JTextField();
		tf_findJumin = new JTextField();
		
		setLayout(null);
		find_idSubmit.setBounds(172, 265, 130, 44);
		tf_findName.setBounds(216, 74, 162, 50);
		tf_findJumin.setBounds(216, 158, 162, 50);
		add(find_idSubmit);
		add(tf_findName);
		add(tf_findJumin);
		
		setBounds(0, 0, 495, 365);
		
		la_name = new JLabel("이름");
		la_name.setBounds(69, 86, 72, 26);
		add(la_name);
		
		la_jumin = new JLabel("주민번호 앞자리");
		la_jumin.setBounds(69, 170, 103, 26);
		add(la_jumin);
		setVisible(true);
	}
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	public static void main(String[] args) {
		new Find_idForm();
	}
}