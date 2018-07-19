package com.encore.auction.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Picture extends JPanel{
	 public JLabel label_landscape;
	 public JLabel label_price;
	 public JLabel label_leftTime;
	 public Picture() {
		 setBackground(Color.GRAY);
		 label_price = new JLabel("현재가");
		 label_price.setFont(new Font("돋움", Font.BOLD, 15));
		 label_price.setForeground(Color.WHITE);
		 label_leftTime = new JLabel("남은시간");
		 label_leftTime.setFont(new Font("돋움", Font.BOLD, 15));
		 label_leftTime.setForeground(Color.WHITE);
		 label_landscape = new JLabel();
		 	
		 this.setLayout(new BorderLayout());
		
		 setSize(220, 220);
		 add(label_landscape);
		 add("South",label_price);
		 add("North",label_leftTime);
		 setVisible(true);
	 }
}

