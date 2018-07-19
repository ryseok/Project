package com.encore.auction.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Find_passForm extends JPanel{
	public JLabel la_find_passAlert; 		//비밀번호 찾기_아이디안내
	public JLabel la_find_passMethod; 	//비밀번호 찾기_방법안내
	public JTextField tf_find_passName;	//비밀번호 찾기_아이디입력 
	public JButton bt_find_passIdConfirm;//비밀번호 찾기_아이디확인
	public JComboBox cb_q;
	public JLabel la_q;
	public JTextField tf_answer;
	public JLabel la_answer;
	public JButton bt_last;
	public Find_passForm() {
		la_find_passAlert = new JLabel("비밀번호 찾기 할 아이디를 입력해주세요.");
		la_find_passMethod = new JLabel("질문을 선택하고 답을 입력해주세요.");
		tf_find_passName = new JTextField();
		bt_find_passIdConfirm = new JButton("확인");
		
		setLayout(null);
		la_find_passAlert.setFont(new Font("굴림", Font.BOLD, 15));
		la_find_passMethod.setFont(new Font("굴림", Font.BOLD, 15));
		la_find_passAlert.setBounds(97, 57, 345, 26);
		la_find_passMethod.setBounds(97, 209, 333, 26);
		tf_find_passName.setBounds(57, 106, 257, 44);
		bt_find_passIdConfirm.setBounds(328, 106, 102, 44);
		
		add(la_find_passAlert);
		add(la_find_passMethod);
		add(tf_find_passName);
		add(bt_find_passIdConfirm);
		
		setBounds(0, 0, 503, 440);
		
		cb_q = new JComboBox();
		cb_q.setModel(new DefaultComboBoxModel(new String[] {"어머니의 성함은?", "어릴 적 살던 고향은?", "나의 어릴 적 별명은?"}));
		cb_q.setBounds(143, 263, 287, 32);
		add(cb_q);
		
		la_q = new JLabel("질문");
		la_q.setBounds(67, 270, 62, 18);
		add(la_q);
		
		tf_answer = new JTextField();
		tf_answer.setBounds(143, 333, 257, 26);
		add(tf_answer);
		
		la_answer = new JLabel("답");
		la_answer.setBounds(67, 337, 62, 18);
		add(la_answer);
		
		bt_last = new JButton("확인");
		bt_last.setBounds(198, 371, 102, 44);
		add(bt_last);
		setVisible(false);
	}
}