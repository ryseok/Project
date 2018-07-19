package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EnrollSeller extends JFrame{
	public JTextField tf_confirmNum;
	public JLabel la_sellerId;
	public JButton bt_confirmSend;
	public JLabel la_cellPhone;
	//public JLabel la_phone;
	public JButton bt_submit;
	public EnrollSeller() {
		tf_confirmNum = new JTextField();
		la_sellerId= new JLabel("판매자 ID");
		bt_confirmSend = new JButton("인증번호 발송");
		 la_cellPhone = new JLabel("회원가입시 입력한 번호");
		// la_phone = new JLabel("전화번호");
		 bt_submit = new JButton("인증");
		
		getContentPane().setLayout(null);
		
		la_sellerId.setBounds(111, 48, 300, 18);
		tf_confirmNum.setBounds(111, 152, 146, 27);
		bt_confirmSend.setBounds(271, 105, 147, 27);
		la_cellPhone.setBounds(111, 109, 300, 18);
		//la_phone.setBounds(35, 109, 62, 18);
		bt_submit.setBounds(271, 152, 147, 27);
		
		tf_confirmNum.setColumns(10);
		getContentPane().add(tf_confirmNum);
		getContentPane().add(la_sellerId);
		getContentPane().add(bt_confirmSend);
		getContentPane().add(la_cellPhone);
		getContentPane().add(bt_submit);
		//getContentPane().add(la_phone);
		
		setBounds(300, 200, 490, 308);
	}
	
	public void showCer(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
