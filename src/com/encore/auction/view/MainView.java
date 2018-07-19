package com.encore.auction.view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class MainView extends JFrame{
   public JTextField main_searchBar;//검색창
   public JButton main_alarm;      // 알람 버튼
   public JButton main_mypage; // 마이페이지 버튼
   public JButton main_logout;   // 로그아웃 버튼
   public JButton main_search;   // 검색 버튼(이모티콘)
   public JButton main_seller;      // 판매자 등록하기 버튼
   public JButton main_newPro; // 신규등록순 버튼
   public JButton main_lastpro;   // 마감임박순 버튼
   public JLabel main_point;      // 검색 텍스트 옆 로고
   public NowAuction nowA;      // 현재 경매상품 리스트 
   public PrevAuction prevA;      // 과거 경매상품 리스트
   public NextAuction nextA;      //예정 경매상품 리스트
   public JTabbedPane main_jtab; // 탭
   public JLabel label_id;            //사용자아이디
   public JComboBox<String> cb_sort; // 종류선택
   public JButton bt_refresh;      //새로고침
   public ImageIcon ig_auction; //경매이미지
   public JButton bt_product;
   public MainView() {
	  getContentPane().setBackground(Color.DARK_GRAY);
      setTitle("그림경매");
      ig_auction = new ImageIcon();
      nowA = new NowAuction();
      nowA.pn_stuff.setSize(839, 700);
      nowA.bt_prev.setLocation(14, 349);
      nowA.bt_next.setLocation(931, 349);
      nowA.pn_stuff.setLocation(78, 33);
      prevA = new PrevAuction();
      nextA = new NextAuction();
      main_searchBar = new JTextField();
      main_alarm = new JButton("알람");
      
      main_mypage = new JButton("정보변경");
      main_logout = new JButton("로그아웃");
      main_search = new JButton("검색");
      main_seller = new JButton("판매자 등록하기");
      main_newPro = new JButton("신규등록순");
      main_lastpro = new JButton("마감임박순");
      main_point = new JLabel(new ImageIcon("image/auction.png"));
      main_jtab = new JTabbedPane();
      main_searchBar.setBounds(177, 63, 133, 27);
      main_alarm.setBounds(433, 10, 105, 27);
      main_mypage.setBounds(539, 10, 105, 27);
      main_logout.setBounds(931, 10, 105, 27);
      main_seller.setBounds(646, 10, 140, 27);
      main_search.setBounds(324, 63, 146, 27);
      main_newPro.setBounds(659, 63, 146, 27);
      main_lastpro.setBounds(824, 63, 146, 27);
      main_point.setBounds(14, 10, 180, 91);
      main_jtab.setBounds(47, 115, 1000, 811);
      
   
      main_jtab.setFont(new Font("굴림", Font.PLAIN, 23));
      main_jtab.addTab("현재경매리스트", nowA);
      main_jtab.addTab("예정경매리스트", nextA);
      main_jtab.addTab("과거경매리스트", prevA);
     
      getContentPane().setLayout(null);
      getContentPane().add(main_searchBar);
      getContentPane().add(main_alarm);
      getContentPane().add(main_mypage);
      getContentPane().add(main_logout);
      getContentPane().add(main_search);
      getContentPane().add(main_seller);
      getContentPane().add(main_newPro);
      getContentPane().add(main_lastpro);
      getContentPane().add(main_point);
      getContentPane().add(main_jtab);
      
       label_id = new JLabel("guest");
       cb_sort = new JComboBox();
       bt_refresh = new JButton("새로고침");
      cb_sort.addItem("풍경화");
      cb_sort.addItem("정물화");
      cb_sort.addItem("인물화");
      cb_sort.addItem("역사화");
      cb_sort.addItem("유화");
      
      
      label_id.setBounds(368, 14, 62, 18);
      cb_sort.setBounds(484, 63, 146, 27);
      bt_refresh.setBounds(1106, 61, 146, 33);
      
      getContentPane().add(label_id);
      getContentPane().add(cb_sort);
      getContentPane().add(bt_refresh);
      
      bt_product = new JButton("판매상품 등록");
      bt_product.setBounds(790, 10, 140, 27);
      getContentPane().add(bt_product);
      
      
      setSize(1100,1000);
      setVisible(false);
      setResizable(false);
   }
   public void showMsg(String msg) {
	   JOptionPane.showMessageDialog(this, msg);
   }
}