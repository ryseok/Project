package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class AddIdPassForm extends JFrame{
	 public Find_idForm find_idForm;				//아이디 찾기폼
	 public Find_passForm find_passForm;	//비밀번호 찾기폼
	public JTabbedPane jtab;
	public AddIdPassForm() {
		setTitle("아이디/비밀번호 찾기");
		find_idForm = new Find_idForm();
		find_passForm = new Find_passForm();
		jtab = new JTabbedPane();
		
		jtab.addTab("아이디 찾기", find_idForm);
		jtab.addTab("비밀번호 찾기", find_passForm);
		
		add(jtab);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setVisible(false);
	}
}