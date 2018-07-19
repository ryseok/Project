package com.encore.auction.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CashView extends JFrame{
	public JLabel la_msg, la_nowcash, la_aftercash;
	public JButton bt_card1;
	private JLabel la_productName;
	private JLabel la_productPrice;
	private JLabel la_pay;
	
	public CashView() {
		setTitle("결제창");
		getContentPane().setLayout(null);
		la_msg = new JLabel("안전하고 편리한 결제 시스템 입니다.");
		la_msg.setHorizontalAlignment(SwingConstants.CENTER);
		la_msg.setFont(new Font("굴림", Font.BOLD, 15));
		la_nowcash = new JLabel("이용약관");
		la_nowcash.setHorizontalAlignment(SwingConstants.CENTER);
		la_aftercash = new JLabel("전자금융거래 이용약관\r\n\r\n");
		bt_card1 = new JButton("현대카드");
		
		la_msg.setBounds(154, 27, 411, 30);
		la_nowcash.setBounds(81, 78, 150, 30);
		la_aftercash.setBounds(127,140,199,68);
		bt_card1.setBounds(137, 231, 199, 51);
		
		getContentPane().add(la_msg);
		getContentPane().add(la_nowcash);
		getContentPane().add(la_aftercash);
		getContentPane().add(bt_card1);
		
		JCheckBox checkbox1 = new JCheckBox("동의");
		checkbox1.setBounds(423, 80, 131, 27);
		getContentPane().add(checkbox1);
		
		JCheckBox checkBox2 = new JCheckBox("동의");
		checkBox2.setBounds(423, 161, 131, 27);
		getContentPane().add(checkBox2);
		
		JButton bt_card2 = new JButton("삼성카드");
		bt_card2.setBounds(355, 231, 199, 51);
		getContentPane().add(bt_card2);
		
		JButton bt_card3 = new JButton("비씨카드");
		bt_card3.setBounds(137, 308, 199, 51);
		getContentPane().add(bt_card3);
		
		JButton bt_card4 = new JButton("KB국민");
		bt_card4.setBounds(355, 308, 199, 51);
		getContentPane().add(bt_card4);
		
		JButton bt_card5 = new JButton("롯데카드");
		bt_card5.setBounds(137, 384, 199, 51);
		getContentPane().add(bt_card5);
		
		JButton bt_card6 = new JButton("하나카드");
		bt_card6.setBounds(355, 384, 199, 51);
		getContentPane().add(bt_card6);
		
		JPanel p_info = new JPanel();
		p_info.setBounds(577, 0, 205, 539);
		getContentPane().add(p_info);
		p_info.setLayout(null);
		
		la_productName = new JLabel("상품명");
		la_productName.setBounds(0, 41, 62, 18);
		p_info.add(la_productName);
		
		la_productPrice = new JLabel("상품가격");
		la_productPrice.setBounds(0, 89, 62, 18);
		p_info.add(la_productPrice);
		
		la_pay = new JLabel("결제금액");
		la_pay.setBounds(0, 137, 62, 18);
		p_info.add(la_pay);
		
		JButton bt_pay = new JButton("결제");
		bt_pay.setBounds(0, 476, 199, 51);
		p_info.add(bt_pay);
		
		setVisible(false);
		setSize(800,586);
	}
}
