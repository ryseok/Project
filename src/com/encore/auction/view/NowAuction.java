package com.encore.auction.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class NowAuction extends JPanel{
	public Picture[] pictures;
	public JButton bt_prev;
	public JButton bt_next;
	public JPanel pn_stuff;
	
public NowAuction() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		pn_stuff = new JPanel(new GridLayout(3, 3, 10, 10));
		pn_stuff.setBackground(Color.GRAY);
		pictures = new Picture[9];
		for(int i = 0; i < 9; ++i) {
			pictures[i] = new Picture();
			pn_stuff.add(pictures[i]);
		}
		bt_prev = new JButton("<");
		bt_next = new JButton(">");
		bt_prev.setBounds(30,330,50,50);
		bt_next.setBounds(930,330,50,50);
		bt_prev.setEnabled(false);
		pn_stuff.setBounds(95, 10, 820, 680);
		
		add(bt_prev);
		add(bt_next);
		add(pn_stuff);
		setSize(1000,700);
	}
}
