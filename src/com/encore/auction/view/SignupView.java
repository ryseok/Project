package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;

public class SignupView extends JFrame {
	private JLabel id_Lb;                    //아이디 라벨
	private JLabel Password_Lb;              //비번 라벨
	private JLabel passwordCheck_Lb;         //비번확인 라벨
	private JLabel name_Lb;                  //이름 라벨
	private JLabel jumin_Lb;                 //주민번호 라벨
	private JLabel juminHyphen_Lb;           //주민번호 하아픈 라벨
	private JLabel tel_Lb;                   //전화번호 라벨
	private JLabel telHyphen_Lb;             //전화번호 하이픈 라벨
	private JLabel telHyphen2_Lb;            //전화번호 하이픈 라벨
	private JLabel genre_Lb;                 //장르 라벨
	private JLabel la_question;				 //비밀번호 찾기 질문 라벨
	private JLabel la_answer;			     //비밀번호 찾기 질문 답 라벨
	
	public JButton doublecheck_bt;           //중복확인 버튼
	public JButton sinup_bt;                 //가입 버튼
	public JButton cancel_bt;                //취소 버튼
	
	public JPasswordField password_pf;       //비번 * 표시
	public JPasswordField passwordCheck_pf;  //비번확인 * 표시
	public JPasswordField jumin_pf;          //주민번호 뒷자리 * 표시

	public JTextField id_tf;                 //아이디 작성
	public JTextField name_tf;               //이름 작성  
	public JTextField tel_tf_01;             //전화전호 앞 자리 
	public JTextField tel_tf_02;             //전화번호 중간 자리
	public JTextField tel_tf_03;             //전화전호 뒷 자리
	public JTextField jumin_tf;              //주민번호 앞자리 작성
	public JTextField textField;             //비밀번호 찾기 질문 답 작성
	
	public JComboBox genre_cb;               //장르 선택
	public JComboBox pass_cb;			     //비밀번호 질문 선택

	

	
	public SignupView() {
		setTitle("회원가입");

		//new 연산자
		name_tf = new JTextField();
		tel_tf_01=new JTextField();
		tel_tf_02=new JTextField();
		tel_tf_03=new JTextField();
		jumin_tf=new JTextField();
		password_pf=new JPasswordField();
		passwordCheck_pf=new JPasswordField();
		jumin_pf=new JPasswordField();		
		id_tf = new JTextField();
		pass_cb = new JComboBox();
		la_question = new JLabel("질문");
		la_answer = new JLabel("답");
		textField = new JTextField();
		id_Lb = new JLabel("아이디");
		Password_Lb = new JLabel("비밀번호 ");
		passwordCheck_Lb = new JLabel("비밀번호 확인");
		name_Lb = new JLabel("이름");
		jumin_Lb = new JLabel("주민번호");
		tel_Lb = new JLabel("전화번호");		
		juminHyphen_Lb = new JLabel("ㅡ");
		telHyphen_Lb = new JLabel("-");
		telHyphen2_Lb = new JLabel("-");
		genre_Lb = new JLabel("장르");				
		doublecheck_bt = new JButton("중복확인");
		sinup_bt = new JButton("가입");
		cancel_bt = new JButton("취소");	
		genre_cb = new JComboBox();				

		
		
		//setBounds
		id_Lb.setBounds(38, 30, 98, 18);
		Password_Lb.setBounds(38, 63, 98, 18);
		passwordCheck_Lb.setBounds(38, 99, 98, 18);
		name_Lb.setBounds(38, 132, 98, 18);
		jumin_Lb.setBounds(38, 171, 98, 18);
		juminHyphen_Lb.setBounds(204, 165, 25, 18);
		tel_Lb.setBounds(38, 204, 98, 18);
		telHyphen_Lb.setBounds(185, 203, 17, 21);
		telHyphen2_Lb.setBounds(259, 203, 17, 21);
		genre_Lb.setBounds(38, 318, 57, 18);
		doublecheck_bt.setBounds(269, 26, 105, 27);
		sinup_bt.setBounds(109, 381, 105, 27);
		cancel_bt.setBounds(228, 381, 105, 27);
		password_pf.setBounds(139, 60, 116, 24);
		passwordCheck_pf.setBounds(139, 93, 116, 24);
		jumin_pf.setBounds(221, 165, 107, 24);
		id_tf.setBounds(139, 27, 116, 24);
		name_tf.setBounds(139, 129, 116, 24);
		tel_tf_01.setBounds(139, 201, 45, 24);
		tel_tf_02.setBounds(198, 201, 57, 24);
		tel_tf_03.setBounds(271, 201, 57, 24);
		jumin_tf.setBounds(139, 165, 63, 24);
		genre_cb.setBounds(139, 317, 235, 21);
		pass_cb.setBounds(139, 234, 235, 24);
		la_question.setBounds(38, 237, 98, 18);
		la_answer.setBounds(38, 277, 98, 18);
		textField.setBounds(139, 274, 116, 24);
		

		

		
		//setFont
		id_tf.setFont(new Font("굴림", Font.PLAIN, 15));
		juminHyphen_Lb.setFont(new Font("굴림", Font.BOLD, 15));
		telHyphen_Lb.setFont(new Font("굴림", Font.BOLD, 15));
		telHyphen2_Lb.setFont(new Font("굴림", Font.BOLD, 15));
		

		//setColumns
		id_tf.setColumns(10);
		name_tf.setColumns(10);
		jumin_tf.setColumns(10);
		tel_tf_01.setColumns(10);	
		tel_tf_02.setColumns(10);
		tel_tf_03.setColumns(10);
		textField.setColumns(10);
		
		//setModel
		genre_cb.setModel(new DefaultComboBoxModel(new String[] {"==선택==","풍경화", "정물화", "인물화", "종교화", "역사화", "유화"}));
		pass_cb.setModel(new DefaultComboBoxModel(new String[] {"==선택==","어머니의 성함은?", "어릴 적 살던 고향은?", "나의 어릴 적 별명은?", "좋아하는 색깔은?"}));
		
		//setBackground
		getContentPane().setBackground(Color.WHITE);
		doublecheck_bt.setBackground(SystemColor.inactiveCaptionBorder);
		sinup_bt.setBackground(SystemColor.inactiveCaptionBorder);
		cancel_bt.setBackground(SystemColor.inactiveCaptionBorder);
		genre_cb.setBackground(SystemColor.inactiveCaptionBorder);
		pass_cb.setBackground(SystemColor.inactiveCaptionBorder);
		
		//JFrame에 붙이기
		getContentPane().setLayout(null); 
		getContentPane().add(id_Lb);
		getContentPane().add(name_Lb);
		getContentPane().add(jumin_Lb);
		getContentPane().add(Password_Lb);
		getContentPane().add(passwordCheck_Lb);
		getContentPane().add(juminHyphen_Lb);
		getContentPane().add(tel_Lb);
		getContentPane().add(telHyphen_Lb);
		getContentPane().add(telHyphen2_Lb);
		getContentPane().add(genre_Lb);
		getContentPane().add(la_question);
		getContentPane().add(la_answer);
			
		getContentPane().add(sinup_bt);
		getContentPane().add(cancel_bt);
		getContentPane().add(doublecheck_bt);
		
		getContentPane().add(id_tf);
		getContentPane().add(name_tf);
		getContentPane().add(jumin_tf);
		getContentPane().add(tel_tf_01);	
		getContentPane().add(tel_tf_02);
		getContentPane().add(tel_tf_03);
		getContentPane().add(textField);

		getContentPane().add(password_pf);
		getContentPane().add(passwordCheck_pf);
		getContentPane().add(jumin_pf);
	
		getContentPane().add(genre_cb);
		getContentPane().add(pass_cb);
		
		
		
		
		
		
		
		

		
		//마무리
		setBounds(300, 200, 490, 481);
//		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg
	
	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}
	
//	public static void main(String[] args) {
//		new SignupView();
//	}
	
}// class End


