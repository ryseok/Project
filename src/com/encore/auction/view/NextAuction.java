package com.encore.auction.view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.encore.auctionServer.model.Stuff;

@SuppressWarnings("serial")
public
class NextAuction extends JPanel {
	JTable table;
	JScrollPane scroll_table;
	DefaultTableModel dtm;

	public NextAuction() {
		this.setLayout(new BorderLayout());
		Object [][]rowData = new Object[0][6];
		String []columnNames = {"경매번호","물품명","물품종류","경매시작가","경매시작일시","판매자"};
		dtm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dtm) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll_table = new JScrollPane(table);
		
		/*테이블 가운데 정렬*/
		DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
		tableCell.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel cellModel = table.getColumnModel();
		for(int i = 0; i < cellModel.getColumnCount(); ++i) {
			cellModel.getColumn(i).setCellRenderer(tableCell);
		}
		setSize(1000,700);
		this.add(scroll_table);
		setVisible(true);
		
		
	}
	
	public void displayTable(Vector<Stuff> stuffList) {
		dtm.setRowCount(0);//출력될 포인트 행을 0으로 셋팅
			  
		//dtm.addRow(Object[] rowData);
		for(int i=0; i<stuffList.size(); i++) {
			 Stuff stuff = stuffList.elementAt(i);
			 Object[] rowData = new Object[6];
			 rowData[0] = stuff.getAuctionno();
			 rowData[1] = stuff.getStuffname();
			 rowData[2] = stuff.getStuffkind();
			 rowData[3] = stuff.getMinprice();
			 rowData[4] = stuff.getTimestart();
			 rowData[5] = stuff.getSellerid();
			 dtm.addRow(rowData);
	    }
	}//displayTable
}