package com.encore.auction.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.encore.auction.view.AddIdPassForm;
import com.encore.auction.view.AddrSearchView;
import com.encore.auction.view.AddrSearchView2;
import com.encore.auction.view.CashView;
import com.encore.auction.view.ChatView;
import com.encore.auction.view.EnrollProduct;
import com.encore.auction.view.EnrollSeller;
import com.encore.auction.view.LoginView;
import com.encore.auction.view.MainView;
import com.encore.auction.view.MyView;
import com.encore.auction.view.SignupView;
import com.encore.auctionServer.model.Member;
import com.encore.auctionServer.model.Stuff;
import com.encore.auction.model.FileReadWriter;

public class Controller extends JFrame{
	Socket socket, socket_ob;
	OutputStream out;
	BufferedReader in;
	ObjectOutputStream out_ob;
	ObjectInputStream in_ob;
	AddIdPassForm addIdPassForm;
	AddrSearchView addrSearchView;
	AddrSearchView2 addrSearchView2;
	LoginView loginView;
	MainView mainView;
	SignupView signupView;
	ChatView chatView;
	CashView cashView;
	//MypageView mypageView;
	MyView myView;
	EnrollProduct enrollProduct;
	EnrollSeller enrollSeller;
	
	FileReadWriter fileReadWriter;
	
	
	static final String SERVER_IP_ADDR = "192.168.0.30";
	static final int SERVER_PORT_NUM = 5000;
	static final int SERVER_OB_PORT_NUM = 5001;
	static final int AUTHORITY_GUEST = 0; //구매자
	static final int AUTHORITY_BUYER = 1; //구매자
	static final int AUTHORITY_SELLER = 2; //판매자
	static final int AUTHORITY_ADMIN = 3; //관리자
	String GUEST_ID = "guest"+new Random().nextInt(10000);
	
	private Date date; //현재 시간
	private int tabIdx; //현재 보고있는 탭  왼쪽부터 0, 1, 2
	private int auctionNum[]; //9개 방에 대한 경매번호
	private Vector<Stuff> stuffList; //9개 방에 대한 정보
	private Room room; //자신이 입장한 경매방
	private int auth; //권한
	private String id; //접속된 아이디
	private String savedPW; //저장된 비밀번호
	private int roomNo; //입장한 경매방
	private int page; //현재보고있는 페이지
	boolean saveFlag; //아이디,비번 저장 유무

	
	/*  
  	C_MSG(client massage) - 클라이언트로부터의 메시지
	S_MSG(server massage) - 서버로부터의 메시지
	REQ(request) - 응답이 필요한 요청
	REG(register) - 응답이 필요하지 않은 요청
	RES(result) - 요청에 대한 응답
	 */
	static final String C_MSG_REQ_LOGIN = "C_MSG_REQ_LOGIN";
	static final String C_MSG_REQ_ID_CHECK = "C_MSG_REQ_ID_CHECK";
	static final String C_MSG_REQ_JOIN = "C_MSG_REQ_JOIN";
	static final String C_MSG_REQ_CHANGE_INFO = "C_MSG_REQ_CHANGE_INFO";
	static final String C_MSG_REQ_REJOIN = "C_MSG_REQ_REJOIN";
	static final String C_MSG_REQ_PAST_LIST = "C_MSG_REQ_PAST_LIST";
	static final String C_MSG_REQ_PRESENT_LIST = "C_MSG_REQ_PRESENT_LIST";
	static final String C_MSG_REQ_FUTURE_LIST = "C_MSG_REQ_FUTURE_LIST";
	static final String C_MSG_REQ_PURCHASED_LIST = "C_MSG_REQ_PURCHASED_LIST";
	static final String C_MSG_REQ_BLACK_LIST = "C_MSG_REQ_BLACK_LIST";
	static final String C_MSG_REQ_SUBSCRIBE_LIST = "C_MSG_REQ_SUBSCRIBE_LIST";
	static final String C_MSG_REQ_ALARM_LIST = "C_MSG_REQ_ALARM_LIST";
	static final String C_MSG_REQ_PRODUCT_INFO = "C_MSG_REQ_PRODUCT_INFO";
	static final String C_MSG_REQ_BALANCE_INFO = "C_MSG_REQ_BALANCE_INFO";
	static final String C_MSG_REQ_BUY = "C_MSG_REQ_BUY";
	static final String C_MSG_REQ_WRITE = "C_MSG_REQ_WRITE";
	static final String C_MSG_REQ_WRITE_NOTICE = "C_MSG_REQ_WRITE_NOTICE";
	static final String C_MSG_REQ_EXPECT = "C_MSG_REQ_EXPECT";
	static final String C_MSG_REQ_CANCEL_REG_STUFF = "C_MSG_REQ_CANCEL_REG_STUFF";
	static final String C_MSG_REQ_ENTER_ROOM = "C_MSG_REQ_ENTER_ROOM";
	static final String C_MSG_REQ_STUFF_IMG = "C_MSG_REQ_STUFF_IMG";
	static final String C_MSG_REQ_ALL_MEMBER = "C_MSG_REQ_ALL_MEMBER";
	static final String C_MSG_REQ_MEMBER = "C_MSG_REQ_MEMBER";
	static final String C_MSG_REG_CHATTING_TEXT = "C_MSG_REG_CHATTING_TEXT";
	static final String C_MSG_REG_KICK = "C_MSG_REG_KICK";
	static final String C_MSG_REG_SUBSCRIBE = "C_MSG_REG_SUBSCRIBE";
	static final String C_MSG_REG_PRODUCT = "C_MSG_REG_PRODUCT";
	static final String C_MSG_REG_LEAVE = "C_MSG_REG_LEAVE";
	static final String C_MSG_REG_SELLER = "C_MSG_REG_SELLER";
	static final String C_MSG_REG_ASKING = "C_MSG_REG_ASKING";
	static final String C_MSG_REG_START_PRICE = "C_MSG_REG_START_PRICE";
	static final String C_MSG_REG_ASKING_UNIT = "C_MSG_REG_ASKING_UNIT";
	static final String C_MSG_REG_AGREE_SELLER = "C_MSG_REG_AGREE_SELLER";
	static final String C_MSG_REG_AGREE_STUFF = "C_MSG_REG_AGREE_STUFF";
	static final String C_MSG_REG_ADJUST_GRADE = "C_MSG_REG_ADJUST_GRADE";
	static final String C_MSG_REG_FREEZE = "C_MSG_REG_FREEZE";
	static final String C_MSG_REG_LEAVE_ROOM = "C_MSG_REG_LEAVE_ROOM";
	static final String C_MSG_REG_ID = "C_MSG_REG_ID";
	static final String C_MSG_REG_STUFF = "C_MSG_REG_STUFF";
	static final String S_MSG_RESULT = "S_MSG_RESULT";
	static final String S_MSG_REG_ASKING_UNIT = "S_MSG_REG_ASKING_UNIT";
	static final String S_MSG_REG_CHANGE_ASKING = "S_MSG_REG_CHANGE_ASKING";
	static final String S_MSG_REG_CHANGE_ASKING_ID = "S_MSG_REG_CHANGE_ASKING_ID";
	static final String S_MSG_REG_CHATTING_TEXT = "S_MSG_REG_CHATTING_TEXT";
	static final String S_MSG_REG_KICK = "S_MSG_REG_KICK";
	static final String S_MSG_REG_FREEZE = "S_MSG_REG_FREEZE";
	static final String S_MSG_REG_ALARM = "S_MSG_REG_ALARM";
	static final String S_MSG_RES_ENTER_ROOM = "S_MSG_RES_ENTER_ROOM";
	static final String S_MSG_RES_ID_CHECK = "S_MSG_RES_ID_CHECK";
	static final String S_MSG_REG_NEW_ENTER = "S_MSG_REG_NEW_ENTER";
	static final String S_MSG_REG_NEW_LEAVE = "S_MSG_REG_NEW_LEAVE";
	static final String S_MSG_RES_LOGIN = "S_MSG_RES_LOGIN";
	static final String S_MSG_RES_JOIN = "S_MSG_RES_JOIN";
	static final String S_MSG_REG_WINNER = "S_MSG_REG_WINNER";
	static final String S_MSG_RES_CHANGE_INFO = "S_MSG_RES_CHANGE_INFO";
	
	static final String NO_CONTENT = "NO_CONTENT";
	
	public Controller() {
		initController();
		eventUp();
		loginView.setVisible(true);
		connectToServer();
	}
	
	private void initController() {
		addIdPassForm = new AddIdPassForm();
		addrSearchView = new AddrSearchView();
		addrSearchView2 = new AddrSearchView2();
		loginView = new LoginView();
		mainView = new MainView();
		mainView.label_id.setText(id);
		signupView = new SignupView();
		chatView = new ChatView();
		cashView = new CashView();
		//mypageView = new MypageView();
		myView = new MyView();
		enrollProduct = new EnrollProduct();
		enrollSeller = new EnrollSeller();
		
		auctionNum = new int[9];
		fileReadWriter = new FileReadWriter();
		try {
			saveFlag = (Boolean)fileReadWriter.fromFile()[0];
			if(saveFlag) {
				id = (String)fileReadWriter.fromFile()[1];
				savedPW = (String)fileReadWriter.fromFile()[2];
				loginView.id_tf.setText(id);
				loginView.id_tf.setEnabled(false);
				loginView.password_pf.setText(savedPW);
				loginView.password_pf.setEnabled(false);
				loginView.chckbxNewCheckBox.setSelected(true);
				
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	class TimeChecker extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					date = new Date();
					sleep(1000);
					for(int i=0; i <stuffList.size(); ++i) {
						Date targetDate = stuffList.get(i).getTimeend();
						long leftTime = (targetDate.getTime() - date.getTime()) / 1000;
						if(leftTime < 60) {
							mainView.nowA.pictures[i].label_leftTime.setForeground(Color.RED);
						} else {
							mainView.nowA.pictures[i].label_leftTime.setForeground(Color.WHITE);
						}
						
						if(leftTime < 0) {
							mainView.nowA.pictures[i].label_leftTime.setText("경매 종료");
						} else {
							mainView.nowA.pictures[i].label_leftTime.setForeground(Color.WHITE);
							long leftHour = leftTime / 3600;
							leftTime -= leftHour*3600;
							long leftMinutes = leftTime / 60;
							leftTime -= leftMinutes*60;
							long leftSeccond = leftTime;
							mainView.nowA.pictures[i].label_leftTime.setText("남은시간 : "+leftHour+"시간 "+leftMinutes+"분 "+leftSeccond+"초");
						}
						chatView.la_date.setText(mainView.nowA.pictures[roomNo].label_leftTime.getText());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class Room { //Room객체 한개 -> 경매방 한개, 클라이언트 여러명
		Vector<String> idList; //경매참여자들(클라이언트들)
		int maxPrice; //최고 금액
		String maxPriceId; //최고금액제시자
		Stuff stuff; //경매물품 
		int roomNo; //방번호
		
		public Room(Stuff stuff) { //생성자
			idList = new Vector<>();
			this.stuff = stuff;
		}
	}
	
	private void eventUp() {
		loginView.signiup_bt.addActionListener(new ActionListener() { //회원가입
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.setVisible(false);
				signupView.setVisible(true);
			}
		});
		
		loginView.guest_bt.addActionListener(new ActionListener() { //게스트 입장
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.setVisible(false);
				mainView.setVisible(true);
				id = GUEST_ID;
				auth = AUTHORITY_GUEST;
				initMainView();
			}
		});
		
		loginView.login_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = loginView.id_tf.getText();
				Controller.this.id = id; 
				String pw = new String(loginView.password_pf.getPassword());
				if("".equals(id)) {
					loginView.showMsg("아이디를 입력하세요");
				} else if("".equals(pw)) {
					loginView.showMsg("비밀번호를 입력하세요");
				} else {
					sendMsg(id+","+pw, C_MSG_REQ_LOGIN);
				}
			}
		});
		
		loginView.id_password_find_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addIdPassForm.setVisible(true);
				loginView.setVisible(false);
			}
		});
		
		loginView.chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!loginView.chckbxNewCheckBox.isSelected() ) {
						fileReadWriter.toFile(false,"","");
						loginView.id_tf.setEnabled(true);
						loginView.password_pf.setEnabled(true);
						saveFlag = false;
					} else {
						loginView.showMsg("개인정보 보호를 위해\n개인 PC에서만 사용해 주세요.");
						String id = loginView.id_tf.getText();
						String pw = new String(loginView.password_pf.getPassword());
						if(!"".equals(id) && !"".equals(pw)) {
							fileReadWriter.toFile(true,id,pw);
							loginView.id_tf.setEnabled(false);
							loginView.password_pf.setEnabled(false);
							saveFlag = true;
						} else {
							loginView.showMsg("아이디와 비밀번호를 입력하세요");
							loginView.chckbxNewCheckBox.setSelected(false);
						}
					}
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
			}
		});
		
		loginView.id_tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				loginView.id_tf.setText("");
			}
		});
		
		loginView.password_pf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				loginView.password_pf.setText("");
			}
		});
		
		addIdPassForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				addIdPassForm.setVisible(false);
				loginView.setVisible(true);
			}
		});
		
		signupView.cancel_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {; 
					signupView.setVisible(false);
					loginView.setVisible(true);
					clearSignUpView();
			}
		});

		signupView.doublecheck_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = signupView.id_tf.getText().trim();
				if("".equals(id)) {
					signupView.showMsg("아이디를 입력하세요");
				} else {
					sendMsg(id, C_MSG_REQ_ID_CHECK);
				}
			}
		});
		
		signupView.sinup_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			 	//유효성검사
		    	String id = signupView.id_tf.getText().trim();
		    	String pw = new String(signupView.password_pf.getPassword()).trim();
		    	String pw_check = new String(signupView.passwordCheck_pf.getPassword()).trim();
		    	String name =  signupView.name_tf.getText().trim();
		    	String jumin = signupView.jumin_tf.getText().trim();
		    	String jumin2 = new String(signupView.jumin_pf.getPassword()).trim();
		    	String tel = signupView.tel_tf_01.getText().trim();
		    	String tel2 = signupView.tel_tf_02.getText().trim();
		    	String tel3 = signupView.tel_tf_03.getText().trim();
		    	String pass = (String)signupView.pass_cb.getSelectedItem();
		    	String passAnswer = signupView.textField.getText().trim();
		    	String genre = (String)signupView.genre_cb.getSelectedItem();
		    	
				 if("".equals(id)) {
						signupView.showMsg("아이디 입력하세요");
						signupView.id_tf.requestFocus();
		    	 }else if(!id.matches("[a-zA-Z0-9]+")) {
		    		 	signupView.showMsg("영어와 숫자로 구성된 아이디를 입력하세요");
		    		 	signupView.password_pf.setText("");
		    		 	signupView.id_tf.requestFocus();
		    	 }else if("".equals(pw)) {
		    		 	signupView.showMsg("비밀번호 입력하세요");
		    		 	signupView.password_pf.setText("");
		    		 	signupView.password_pf.requestFocus();
		    	 }else if("".equals(pw_check)) {
		    		 signupView.showMsg("비밀번호 한번 더 입력하세요");
		    		 signupView.passwordCheck_pf.setText("");
		    		 signupView.passwordCheck_pf.requestFocus();
		    	 }else if(!pw.equals(pw_check)) {
		    		 signupView.showMsg("비밀번호가 일치하지 않습니다");
		    		 signupView.password_pf.setText("");
		    		 signupView.passwordCheck_pf.setText("");
		    		 signupView.password_pf.requestFocus(); 
		    	 }else if("".equals(name)) {
		    		 	signupView.showMsg("이름을 입력하세요");
		    		 	signupView.name_tf.requestFocus();
		    	 }else if(jumin == null || jumin.length()!=6) {
		    		 	signupView.showMsg("주민번호 앞 6자리를 입력하세요");
		    		 	signupView.jumin_tf.requestFocus();
		    	 }else if(jumin2 == null || jumin2.length()!=7) {
		    		 	signupView.showMsg("주민번호 뒷 7자리 입력하세요");
		    		 	signupView.jumin_pf.requestFocus();
		    	 }else if( !jumin.matches("[\\d]{6}") || !jumin2.matches("[\\d]{7}")) {
		    		 	signupView.jumin_tf.setText(""); //숫자아닌값을 초기화
		    		 	signupView.jumin_pf.setText(""); //숫자아닌값을 초기화
		    		 	signupView.jumin_tf.requestFocus();
		    		 	signupView.showMsg("유효한 주민번호를 입력하세요");
		    	 }else if(!tel.matches("[\\d]{2,3}")) {
		    		 	signupView.showMsg("전화번호 앞자리를 확인하세요");
		    		 	signupView.tel_tf_01.setText("");
		    		 	signupView.tel_tf_01.requestFocus();
		    	 }else if(!tel2.matches("[\\d]{3,4}") ) {
		    		 	signupView.showMsg("전화번호 중간자리를 확인하세요");
		    		 	signupView.tel_tf_02.setText("");
		    		 	signupView.tel_tf_02.requestFocus();
		    	 }else if(!tel3.matches("[\\d]{3,4}")) {
		    			signupView.showMsg("전화번호 뒷자리를 확인하세요");
		    			signupView.tel_tf_03.setText("");
		    			signupView.tel_tf_03.requestFocus();
		    	 }else if("==선택==".equals(pass)) {
		    		 	signupView.showMsg("질문을 선택하세요");
		    		 	signupView.pass_cb.requestFocus();
		    	 }else if("".equals(passAnswer) || passAnswer.matches("[\\d]+")) {
		    		 	signupView.showMsg("질문의 답을 입력하세요");
		    		 	signupView.textField.setText("");
		    		 	signupView.textField.requestFocus();
		    	 }else if ("==선택==".equals(genre)){
		    		 	signupView.showMsg("장르를 선택하세요");
		    		 	signupView.genre_cb.requestFocus();
		    	 }else {
		    		 sendMsg(NO_CONTENT, C_MSG_REQ_JOIN);
		    		 try {
						out_ob.writeObject(new Member(id, pw_check, name, "",
													  Integer.parseInt(jumin), Integer.parseInt(jumin2),
													  tel+"-"+tel2+"-"+tel3, "", "", 0, 0,
													  "브론즈", pass, passAnswer));
					} catch (Exception e1) {
						signupView.showMsg("회원가입이 일시적으로 불가능 합니다");
					}
		    	 }			
			}
		});
		
		mainView.main_mypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(auth == AUTHORITY_GUEST) {
					mainView.showMsg("로그인이 필요합니다");
					return;
				}
				try {
					sendMsg(id, C_MSG_REQ_MEMBER);
					Member m = (Member)in_ob.readObject();
					myView.id_tf.setText(m.getId());
					myView.password_pf.setText(m.getPw());
					myView.passwordCheck_pf.setText(m.getPw());
					myView.name_tf.setText(m.getName());
					myView.jumin_tf.setText(m.getSsn1()+"");
					myView.jumin_pf.setText(m.getSsn2()+"");
					myView.tel_tf_01.setText(m.getPhone().split("-")[0]);
					myView.tel_tf_02.setText(m.getPhone().split("-")[1]);
					myView.tel_tf_03.setText(m.getPhone().split("-")[2]);
					myView.pass_cb.setSelectedItem(m.getAsk());
					myView.textField.setText(m.getAnswer());
					myView.setVisible(true);
				} catch (Exception e1) {
					mainView.showMsg("회원 정보 변경이 일시적으로 불가능 합니다");
					e1.printStackTrace();
				}			
			}
		}); //마이페이지 버튼
		
		mainView.main_alarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg(NO_CONTENT, C_MSG_REQ_ALARM_LIST);
				
			}
		});		// 알람 버튼
		
		mainView.main_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainView.setVisible(false);
				loginView.setVisible(true);
				id = GUEST_ID;
			}
		});	// 로그아웃 버튼
		
		mainView.main_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});	// 검색 버튼(이모티콘)
		
		mainView.main_seller.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(auth != AUTHORITY_BUYER) {
					mainView.showMsg("판매자 등록이 필요하지 않습니다");
					return;
				}
				enrollSeller.setVisible(true);
				enrollSeller.la_sellerId.setText(id+"님, 본인인증이 필요합니다");
			}
		});		// 판매자 등록하기 버튼
		
		mainView.bt_product.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(auth == AUTHORITY_SELLER || auth == AUTHORITY_ADMIN) { //판매자 또는 관리자일 경우
					enrollProduct.setVisible(true);
					enrollProduct.tf_id.setText(id);
					enrollProduct.tf_id.setEnabled(false);
				} else {
					mainView.showMsg("판매자 인증이 필요합니다\n 판매자 등록 후 재 로그인이 필요합니다");
				}
			}
		}); //상품 등록하기 버튼
		
		mainView.main_newPro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		}); // 신규등록순 버튼
		
		mainView.main_lastpro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
			}
		});	// 마감임박순 버튼
		
		mainView.main_jtab.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				try {
					tabIdx = mainView.main_jtab.getSelectedIndex();
					if(tabIdx == 1) { //예정경매리스트
						sendMsg(1+","+"desc", C_MSG_REQ_FUTURE_LIST); //최신순, 1페이지
						Vector<Stuff> stuffList = (Vector<Stuff>) in_ob.readObject();
						mainView.nextA.displayTable(stuffList);
					} else if(tabIdx == 2) {//과거경매리스트
						sendMsg(1+","+"desc", C_MSG_REQ_PAST_LIST); //최신순, 1페이지
						Vector<Stuff> stuffList = (Vector<Stuff>) in_ob.readObject();
						mainView.prevA.displayTable(stuffList);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		for(int i = 0; i < 9; ++i) {
			mainView.nowA.pictures[i].label_landscape.addMouseListener(new RoomClickListener(i));
		}
		
		chatView.bt_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = room.stuff.getAuctionno()+"";
				sendMsg(msg, C_MSG_REG_LEAVE_ROOM);
				chatView.setVisible(false);
				chatView.li_inwon.setText("");
				chatView.ta_chat.setText("");
				chatView.ta_record.setText("");		
				mainView.setEnabled(true);
			}
		});
		
		chatView.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String msg = room.stuff.getAuctionno()+"";
				sendMsg(msg, C_MSG_REG_LEAVE_ROOM);
				chatView.setVisible(false);
				chatView.li_inwon.setText("");
				chatView.ta_chat.setText("");
				chatView.ta_record.setText("");
				mainView.setEnabled(true);
			}
		});
		
		chatView.tf_send.addActionListener(new ActionListener() { //자신이 친 채팅내용 보내기
			@Override
			public void actionPerformed(ActionEvent e) {
				String chatText = id + " ▶ "+chatView.tf_send.getText();
				sendMsg(room.stuff.getAuctionno()+","+chatText, C_MSG_REG_CHATTING_TEXT);
				chatView.tf_send.setText("");
			}
		});
		
		chatView.bt_change.addActionListener(new ActionListener() {//입찰하기요청
			@Override
			public void actionPerformed(ActionEvent e) {
				int nAskingPrice;
				String askingPrice = chatView.showInput("입찰 참여 금액을 입력하세요");
				if(askingPrice != null) {
					if(!askingPrice.matches("[0-9]+")) {
						chatView.showMsg("숫자만 입력하세요");
						return;
					} else {
						nAskingPrice = Integer.parseInt(askingPrice);
						if(nAskingPrice < room.stuff.getMinprice()) {
							chatView.showMsg("경매 시작 금액 이상을 입력하세요");
							return;
						}
						if(nAskingPrice <= room.maxPrice) {
							chatView.showMsg("현재 최고 금액보다 높은 금액을 입력하세요");
							return;
						}
						else {
							sendMsg(room.stuff.getAuctionno()+","+askingPrice, C_MSG_REG_ASKING);
						}
					}
					
				}
			}
		});
		
		myView.sinup_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//유효성검사
				String id = myView.id_tf.getText().trim();
				String pw = new String(myView.password_pf.getPassword()).trim();
				String pw_check = new String(myView.passwordCheck_pf.getPassword()).trim();
				String name =  myView.name_tf.getText().trim();
				String jumin = myView.jumin_tf.getText().trim();
				String jumin2 = new String(myView.jumin_pf.getPassword()).trim();
				String tel = myView.tel_tf_01.getText().trim();
				String tel2 = myView.tel_tf_02.getText().trim();
				String tel3 = myView.tel_tf_03.getText().trim();
				String pass = (String)myView.pass_cb.getSelectedItem();
				String passAnswer = myView.textField.getText().trim();
				String genre = (String)myView.genre_cb.getSelectedItem();

				if("".equals(pw)) {
					myView.showMsg("비밀번호 입력하세요");
					myView.password_pf.setText("");
					myView.password_pf.requestFocus();
				}else if("".equals(pw_check)) {
					myView.showMsg("비밀번호 한번 더 입력하세요");
					myView.passwordCheck_pf.setText("");
					myView.passwordCheck_pf.requestFocus();
				}else if(!pw.equals(pw_check)) {
					myView.showMsg("비밀번호가 일치하지 않습니다");
					myView.password_pf.setText("");
					myView.passwordCheck_pf.setText("");
					myView.password_pf.requestFocus(); 
				}else if(!tel.matches("[\\d]{2,3}")) {
					myView.showMsg("전화번호 앞자리를 확인하세요");
					myView.tel_tf_01.setText("");
					myView.tel_tf_01.requestFocus();
				}else if(!tel2.matches("[\\d]{3,4}") ) {
					myView.showMsg("전화번호 중간자리를 확인하세요");
					myView.tel_tf_02.setText("");
					myView.tel_tf_02.requestFocus();
				}else if(!tel3.matches("[\\d]{3,4}")) {
					myView.showMsg("전화번호 뒷자리를 확인하세요");
					myView.tel_tf_03.setText("");
					myView.tel_tf_03.requestFocus();
				}else if("==선택==".equals(pass)) {
					myView.showMsg("질문을 선택하세요");
					myView.pass_cb.requestFocus();
				}else if("".equals(passAnswer) || passAnswer.matches("[\\d]+")) {
					myView.showMsg("질문의 답을 입력하세요");
					myView.textField.setText("");
					myView.textField.requestFocus();
				}else {
					sendMsg(NO_CONTENT, C_MSG_REQ_CHANGE_INFO);
					try {
						out_ob.writeObject(new Member(id, pw_check, name, "",
								Integer.parseInt(jumin), Integer.parseInt(jumin2),
								tel+"-"+tel2+"-"+tel3, "", "", 0, 0,
								"브론즈", pass, passAnswer));
					} catch (Exception e1) {
						myView.showMsg("정보변경이 일시적으로 불가능 합니다");
					}
				}
				
			}
				
		});
		
		myView.cancel_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.setVisible(false);
			}
		});
		
		myView.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				myView.setVisible(false);
			}
		});
		
		mainView.nowA.bt_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mainView.nowA.bt_prev.setEnabled(true);
					++page;
					sendMsg(page+"", C_MSG_REQ_STUFF_IMG);
					Vector<ImageIcon> icList = (Vector<ImageIcon>)in_ob.readObject();
					for(int i = 0; i < icList.size(); ++i) {
						mainView.nowA.pictures[i].label_landscape.setIcon(icList.get(i));
					}
					sendMsg(page+"", C_MSG_REQ_PRESENT_LIST);
					stuffList = (Vector<Stuff>)in_ob.readObject();
					for(int i=0; i <stuffList.size(); ++i) {
						mainView.nowA.pictures[i].label_price.setText("시작 금액 : "+stuffList.get(i).getMinprice());
						auctionNum[i] = stuffList.get(i).getAuctionno();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mainView.nowA.bt_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					--page;
					if(page == 1) mainView.nowA.bt_prev.setEnabled(false);
					sendMsg(page+"", C_MSG_REQ_STUFF_IMG);
					Vector<ImageIcon> icList = (Vector<ImageIcon>)in_ob.readObject();
					for(int i = 0; i < icList.size(); ++i) {
						mainView.nowA.pictures[i].label_landscape.setIcon(icList.get(i));
					}
					sendMsg(page+"", C_MSG_REQ_PRESENT_LIST);
					stuffList = (Vector<Stuff>)in_ob.readObject();
					for(int i=0; i <stuffList.size(); ++i) {
						mainView.nowA.pictures[i].label_price.setText("시작 금액 : "+stuffList.get(i).getMinprice());
						auctionNum[i] = stuffList.get(i).getAuctionno();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		enrollProduct.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				enrollProduct.setVisible(false);
			}
		});
		
		enrollSeller.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				enrollSeller.setVisible(false);
			}
		});
		
		enrollSeller.bt_confirmSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
		        int result = random.nextInt(10000)+1000;
				if(result>10000){
				    result = result - 1000;
				}
				
				boolean flag = false;
				if(!flag) {
					enrollSeller.showCer("인증번호 : "+Integer.toString(result));
					enrollSeller.tf_confirmNum.setText(Integer.toString(result));
					enrollSeller.bt_confirmSend.setEnabled(flag);
					enrollSeller.tf_confirmNum.setEditable(flag);
				}

			}
		});
		
		enrollSeller.bt_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg(id, C_MSG_REG_SELLER);
				enrollSeller.setVisible(false);
				mainView.showMsg("판매자 신청이 완료되었습니다");
				mainView.main_seller.setEnabled(false);
			}
		});
		
		enrollProduct.bt_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enrollProduct.setVisible(false);
			}
		});
		
		enrollProduct.bt_enroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String sellerid = enrollProduct.tf_id.getText();
					String stuffname = enrollProduct.tf_productName.getText();
					
					int minprice = Integer.parseInt(enrollProduct.tf_startPrice.getText());
					String chat = "y";
					int upprice = Integer.parseInt(enrollProduct.tf_priceNow.getText());
					String explain = enrollProduct.ta_explain.getText();
					String stuffkind = enrollProduct.cb_sort.getSelectedItem()+"";
							
					sendMsg(NO_CONTENT, C_MSG_REG_STUFF);
					out_ob.writeObject(new Stuff(0,sellerid,stuffname,minprice,chat,upprice,explain,new Date(), new Date(),stuffkind,"","",0));
					enrollProduct.setVisible(false);
					mainView.showMsg("물품 등록이 완료 되었습니다");
				} catch (Exception e1) {
					enrollProduct.setVisible(false);
					mainView.showMsg("물품 등록이 일시적으로 불가능 합니다");
					//e1.printStackTrace();
				}
					
			}
		});
	}
	
	class RoomClickListener extends MouseAdapter { //경매방 입장
		int i;
		RoomClickListener(int i) {
			this.i = i;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(id.equals(GUEST_ID)) {
				mainView.showMsg("로그인 후에 입장 가능합니다");
			} else {
				sendMsg(auctionNum[i]+"",C_MSG_REQ_ENTER_ROOM);
				roomNo = i;
			}
		}
	}
	
	private void clearSignUpView() {
		signupView.password_pf.setText("");      //비번 * 표시
		signupView.passwordCheck_pf.setText("");  //비번확인 * 표시
		signupView.jumin_pf.setText("");          //주민번호 뒷자리 * 표시

		signupView.id_tf.setText("");               //아이디 작성
		signupView.id_tf.setEditable(true);
		signupView.name_tf.setText("");              //이름 작성  
		signupView.tel_tf_01.setText("");             //전화전호 앞 자리 
		signupView.tel_tf_02.setText("");            //전화번호 중간 자리
		signupView.tel_tf_03.setText("");             //전화전호 뒷 자리
		signupView.jumin_tf.setText("");             //주민번호 앞자리 작성
		signupView.textField.setText("");             //비밀번호 찾기 질문 답 작성
		
		signupView.genre_cb.setSelectedIndex(0);               //장르 선택
		signupView.pass_cb.setSelectedIndex(0);			     //비밀번호 질문 선택

		signupView.doublecheck_bt.setEnabled(true);
	}
	
	@SuppressWarnings("unchecked")
	private void initMainView() {
		try {
			page = 1;
			sendMsg(id, C_MSG_REG_ID);
			sendMsg(page+"", C_MSG_REQ_STUFF_IMG);
			Vector<ImageIcon> icList = (Vector<ImageIcon>)in_ob.readObject();
			for(int i = 0; i < icList.size(); ++i) {
				mainView.nowA.pictures[i].label_landscape.setIcon(icList.get(i));
			}
			sendMsg(page+"", C_MSG_REQ_PRESENT_LIST);
			stuffList = (Vector<Stuff>)in_ob.readObject();
			for(int i=0; i <stuffList.size(); ++i) {
				mainView.nowA.pictures[i].label_price.setText("시작 금액 : "+stuffList.get(i).getMinprice());
				auctionNum[i] = stuffList.get(i).getAuctionno();
			}
 			mainView.nowA.setVisible(true);
 			new TimeChecker().start();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("# 메인뷰 초기화 실패");
		}
	}
	
	private void connectToServer() {
		try {
			socket = new Socket("localhost", SERVER_PORT_NUM);
			socket_ob = new Socket("localhost", SERVER_OB_PORT_NUM);
			out = socket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out_ob = new ObjectOutputStream(socket_ob.getOutputStream());
			in_ob = new ObjectInputStream(socket_ob.getInputStream());
			new Receiver().start();
			loginView.guest_bt.setEnabled(true);
		} catch (Exception e) {
			System.err.println("# 서버 연결 실패");
			loginView.showMsg("서버 점검 중 입니다");
			//e.printStackTrace();
		}	
	}
	
	private void sendMsg(String msg, String type) {
		try {
			out.write((type+":"+msg+"\n").getBytes());
			System.out.println("보낸메시지 : "+type+":"+msg+"\n"); //for test
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("# 서버에 접속되어 있지 않습니다");
		}
	}
	
	private String getType(String msg) {
		return msg.split(":")[0];
	}
	
	private String getMsg(String msg) {
		return msg.split(":")[1];
	}
	
	class Receiver extends Thread {
		@Override
		public void run() {
			try {
				while(true) {
					String msgPack = in.readLine();
					if(msgPack != null) {
						System.out.println("받은메시지 : "+msgPack); //for Test
						String type = getType(msgPack);
						String msg = getMsg(msgPack);
						
						switch(type) {
							case S_MSG_REG_ASKING_UNIT : break;
							case S_MSG_REG_CHANGE_ASKING : {
								int maxPrice = Integer.parseInt(msg.split(",")[0]);
								int auctionNo = Integer.parseInt(msg.split(",")[1]);
								room.maxPrice = maxPrice;
								chatView.la_nowPrice.setText("현재최고금액 : "+maxPrice);
								for(int i = 0; i < 9; ++i) {
									if(auctionNum[i] == auctionNo)
									mainView.nowA.pictures[i].label_price.setText("현재가 : "+maxPrice);
								}
								break;
							}
							case S_MSG_REG_CHANGE_ASKING_ID : {
								room.maxPriceId = msg;
								chatView.ta_record.append(msg+"님이"+room.maxPrice+"를 부르셨습니다"+"\n");
								break;
							}
							case S_MSG_REG_CHATTING_TEXT : {
								chatView.ta_chat.append(msg+"\n");
								break;
							}
							case S_MSG_REG_KICK : break;
							case S_MSG_REG_FREEZE : break;
							case S_MSG_REG_ALARM : break;
							case S_MSG_REG_NEW_ENTER : {
								room.idList.addElement(msg);
								chatView.li_inwon.append(msg+"\n");
								break;
							}
							case S_MSG_RES_ENTER_ROOM : {
								if(msg.equals("true")) {		
									Stuff stuff = (Stuff)in_ob.readObject();
									room = new Room(stuff);
									sendMsg(stuff.getAuctionno()+"", C_MSG_REQ_ALL_MEMBER);
									chatView.la_picture.setIcon(mainView.nowA.pictures[roomNo].label_landscape.getIcon());
									chatView.la_auctionNum.setText("경매번호:"+room.stuff.getAuctionno());
									chatView.la_productName.setText("물품명:"+room.stuff.getStuffname());
									chatView.la_seller.setText("판매자:"+room.stuff.getSellerid());
									chatView.la_sort.setText("물품종류:"+room.stuff.getStuffkind());
									chatView.la_date.setText(mainView.nowA.pictures[roomNo].label_leftTime.getText());
									chatView.la_picture.setText(room.stuff.getExplain());
									mainView.setEnabled(false);
									chatView.setVisible(true);
								} else {
									mainView.showMsg("입장이 불가능합니다");
								}
								break;
							}
							case S_MSG_RES_ID_CHECK : {
								if(msg.equals("true")) {
									signupView.showMsg("중복된 아이디입니다");
									signupView.id_tf.setText("");
								} else{
									if(signupView.showConfirm("사용 가능한 아이디입니다 \n이 아이디를 사용하시겠습니까?")==0) {
										signupView.id_tf.setEditable(false);
										signupView.doublecheck_bt.setEnabled(false);
									} else {
										signupView.id_tf.setText("");
									}
								}
								break;
							}
							case S_MSG_REG_NEW_LEAVE : {
								room.idList.remove(msg);
								chatView.li_inwon.setText("");
								for(int i = 0; i < room.idList.size(); ++i) {
									chatView.li_inwon.append(room.idList.get(i)+"\n");
								}
								break;
							}
							case S_MSG_RES_LOGIN : {
								int nMsg = Integer.parseInt(msg);
								if(nMsg == -1) {
									loginView.showMsg("아이디 또는 비밀번호가 일치하지 않습니다");
								} else if(nMsg == 0) {
									loginView.showMsg("탈퇴한 회원입니다");
								} else { //로그인 성공
									initMainView();
									loginView.setVisible(false);
									mainView.setVisible(true);
									id  = loginView.id_tf.getText(); //로그인한 아이디저장
									auth = nMsg; //권한 저장
								}
								if(!saveFlag) {
									loginView.id_tf.setText("");
									loginView.password_pf.setText("");
								}
								break;
							}
							case S_MSG_RES_JOIN : {
								signupView.setVisible(false);
								loginView.setVisible(true);
								clearSignUpView();
								break;
							}
							case S_MSG_REG_WINNER : {
								mainView.showMsg("축하합니다!!\n 경매번호 "+msg+"의 최종 낙찰자이십니다.");
								break;
							}
							case S_MSG_RES_CHANGE_INFO : {
								if("true".equals(msg)) {
									myView.setVisible(false);
									mainView.showMsg("정보가 성공적으로 수정되었습니다");
								} else {
									myView.setVisible(false);
									mainView.showMsg("정보변경이 실패하였습니다");
								}
							}

							
						}
					}
				
				}
			} catch (Exception e) {
				System.err.println("# Receiver에러 발생");
				e.printStackTrace();
			} 
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
