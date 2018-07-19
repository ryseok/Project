package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JTabbedPane;
import java.awt.Font;


public class AddrSearchView2 extends JFrame{
	JTabbedPane addrSearch_tb;
	JPanel addrSearch_p;
	JPanel addrSearch_p2;
	
	JScrollPane addrSearch_sp;
	JScrollPane addrSearch_sp2;
	
	JTable addrSearch_table;
	JTable addrSearch_table2;
	
	public AddrSearchView2() {
		setTitle("도로명/ 지번명 검색");
		
		addrSearch_tb = new JTabbedPane(JTabbedPane.TOP);
		addrSearch_p = new JPanel(null);
		addrSearch_p2 = new JPanel(null);
		
		addrSearch_sp = new JScrollPane();
		addrSearch_sp2 = new JScrollPane();
		
		addrSearch_table = new JTable();
		addrSearch_table2 = new JTable();
		
		addrSearch_table.setModel(new DefaultTableModel(
				
				new Object[][] {
					{"서울시 서초구", 12345},
				},
				new String[] {
						"도로주소", "우편번호"
				}
				));

		addrSearch_table2.setModel(new DefaultTableModel(
				new Object[][] {
					{"서울시 강남구", 5678},
				},
				new String[] {
						"지번주소", "우편번호"
				}
				));
		
		
		
		addrSearch_tb.setFont(new Font("굴림", Font.PLAIN, 20));
		
		

		
		addrSearch_tb.setBounds(14, 12, 798, 302);
		addrSearch_sp.setBounds(0, 0, 794, 264);
		addrSearch_sp2.setBounds(0, 0, 794, 263);
		
		addrSearch_p.add(addrSearch_sp);
		addrSearch_p2.add(addrSearch_sp2);
		
		addrSearch_sp2.setViewportView(addrSearch_table2);
		addrSearch_sp.setViewportView(addrSearch_table);

		getContentPane().setLayout(null);
		addrSearch_tb.addTab("도로명", null, addrSearch_p, null);
		addrSearch_tb.addTab("지번명", null, addrSearch_p2, null);
		getContentPane().add(addrSearch_tb);
		
		
		
		setBounds(300,200, 842, 373);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}//생성자 End
	
//	public static void main(String[] args) {
//		new AddrSearchView2();
//
//	}//main End
}//class End
