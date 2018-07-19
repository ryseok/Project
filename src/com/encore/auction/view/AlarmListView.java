package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlarmListView extends JFrame{
	JTable alarmTable;
	DefaultTableModel dtm;
	
	@SuppressWarnings("serial")
	public AlarmListView() {
		Object [][]rowData = new Object[0][2];
		String []columnNames = {"일시","내용"};
		dtm = new DefaultTableModel(rowData, columnNames);
		alarmTable = new JTable(dtm) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}
