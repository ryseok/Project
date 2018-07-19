drop table member cascade constraints;
drop table member;
create table member(
	id varchar2(20) constraint member_id_pk primary key,
	pw varchar2(20) not null,
	name varchar2(20) not null,
	email varchar2(50),
	ssn1 number(6) not null,
	ssn2 number(7) not null,
	phone varchar2(14), --'010-1234-5678'
	addr varchar2(100),
	seller varchar2(30) default '구매자',
	card number, -- 카드, 계좌
	total number default 0,
	grade varchar2(20) default '브론즈',
	ask varchar2(50),
	answer varchar2(30)
);
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total) values ('admin','1234','관리자','admin@gmail.com',900503,1011543,'010-9999-9999','남터','관리자',121234567, 900000);
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,card,ask,answer) values ('gildong','1234','홍길동','gildong@gmail.com',900203,1012345,'010-1234-5678','남터',123456789, '좋아하는 색깔은?', '노란색');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('lime', '5678', '길라임', 'lime@gmail.com', 920303, 2054321, '010-4321-8765', '고터', '구매자', 987654321, 500000,'좋아하는 색깔은?', '노란색');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('juwon', '8765', '김주원', 'lime@gmail.com', 920403, 1468778, '010-8788-7888', '약수', '구매자', 568421358, 200000,'태어난 달은?', '3');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('gilgil', '6789', '길순이', 'lime@gmail.com', 910603, 2897456, '010-7895-6542', '신림', '판매자', 854231598, 400000,'좋아하는 색깔은?', '파란색');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('limm', '9876', '임길동', 'lime@gmail.com', 940507, 1654782, '010-1569-8974', '노원', '구매자', 123578945, 600000,'당신의 취미는?', '음악감상');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('wons', '5689', '고희동', 'lime@gmail.com', 960603, 2589631, '010-6987-5214', '수유', '구매자', 894563158, 800000,'당신의 취미는?', '영화감상');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('qwer', '9821', '둘리', 'lime@gmail.com', 970803, 2789316, '010-8654-1475', '역삼', '구매자', 512348569, 700000,'태어난 달은?', '초록색');
insert into member(id,pw,name,email,ssn1,ssn2,phone,addr,seller,card,total,ask,answer) values ('asdf', '1289', '영심이', 'lime@gmail.com', 920909, 102456, '010-7897-5612', '서초', '판매자', 258963147, 100000,'좋아하는 색깔은?', '빨간색');

select * from member;
--------------------------------------------
drop table kind;
create table kind(
	stuffno number constraint type_no_pk primary key,
	stuffkind varchar2(20)
);
insert into kind values(2010,'풍경화');
insert into kind values(2011,'인물화');
insert into kind values(2012,'역사화');
insert into kind values(2013,'정물화');
insert into kind values(2014,'유화');

select * from kind;
--------------------------------------

drop table gradelist;
create table gradelist(
	grade varchar2(20),
	lototal number,
	hitotal number,
	comm number
);

insert into gradelist values ('vvip', 30000001, 50000000, 10);
insert into gradelist values ('vip', 10000001, 30000000, 7);
insert into gradelist values ('골드', 500001, 10000000, 5);
insert into gradelist values ('실버', 310000, 500000, 3);
insert into gradelist values ('브론즈', 0, 300000, 1);

select * from gradelist;
-------------------------------------------------------
drop table commlist;
create table commlist(
	minprice number,
	maxprice number,
	comm number
);

insert into commlist values (0, 300000, 1);
insert into commlist values (310000, 500000, 3);
insert into commlist values (510000, 1000000, 5);
insert into commlist values (1000001, 3000000, 7);
insert into commlist values (3000001, 5000000, 10);

select * from commlist;
---------------------------------------------------------
drop table buy;
create table buy(
	id varchar2(20),
	auctionno number,
	stuffname varchar2(30),
	price number,
	buydate date
);
insert into buy values ('gildong',1,'별',2000000,'18/03/24');
insert into buy values ('lime',2,'바람',3000000,'18/03/28');
insert into buy values ('juwon',3,'구름',4000000,'18/02/25');
insert into buy values ('lime',4,'하늘',5000000,'18/06/29');
insert into buy values ('gildong',5,'우주',6000000,'18/05/12');
-------------------------------------------------------------
drop table bookmark;
create table bookmark(
	id varchar2(20),
	sellerid varchar2(20)
);
insert into bookmark values ('gildong','gilgil');
insert into bookmark values ('gildong','asdf');
-----------------------------------------------------------
drop table basket;
create table basket(
	id varchar2(20),
	auctionno number
);
insert into basket values ('gildong',9);
insert into basket values ('gildong',10);
insert into basket values ('gildong',11);
insert into basket values ('lime',12);
---------------------------------------------------------
drop table standby;
create table standby(
	id varchar2(20) constraint standby_id_pk primary key,
	applydate date
);
insert into standby values ('limm',sysdate);
----------------------------------------------------------
drop table seller;
create table seller(
	sellerid varchar2(20) constraint seller_id_pk primary key references member(id),
	total number
	-- confirm varchar2(20)
);
insert into seller values ('gilgil',200000);
----------------------------------------------------------
drop table noticelist;
create table noticelist(
	no number constraint noticelist_no_pk primary key,
	content varchar2(500),
	post varchar2(20) not null,
	day date not null, -- sysdate
	notice varchar2(20) check (notice in ('게시글','공지사항'))
);

drop sequence notice_seq;
create sequence notice_seq
		start with 1
		increment by 1
		nocycle
		nocache;

insert into noticelist values (1, '안녕하세요', 'admin', '18/02/02', '공지사항');
insert into noticelist values (notice_seq.nextval, '반갑습니다', 'admin', '18/03/03', '공지사항');
insert into noticelist values (notice_seq.nextval, '감사합니다', 'admin', '18/04/05', '공지사항');
insert into noticelist values (notice_seq.nextval, '우와', 'gildong', sysdate, '게시글');
insert into noticelist values (notice_seq.nextval, '게시판이다', 'gildong', sysdate, '게시글');
insert into noticelist values (notice_seq.nextval, '어떻게 사용하나요?', 'lime', sysdate, '게시글');
insert into noticelist values (notice_seq.nextval, '경매 좋아요', 'juwon', sysdate, '게시글');
insert into noticelist values (notice_seq.nextval, '경매사이트네요', 'limm', sysdate, '게시글');
insert into noticelist values (notice_seq.nextval, '와우', 'lime', sysdate, '게시글');
insert into noticelist values (notice_seq.nextval, '경매사이트군요', 'juwon', sysdate, '게시글');

-----------------------------
drop table report;
create table report(
	-- memno number,
	id varchar2(20)
);
--------------------------------
drop table daystotal;
create table daystotal(
	total number,
	days date
);
insert into daystotal values (2000000,'18/03/05');
insert into daystotal values (3000000,'18/04/06');
insert into daystotal values (4000000,'18/05/07');
insert into daystotal values (2000000,'18/06/08');
insert into daystotal values (3000000,'18/07/09');
--insert into daystotal values (3000000,sysdate);
-------------------------------
drop table total;
create table total(
	total number
);
insert into total values (1400000);
------------------------------
drop table alarm;
create table alarm(
	id varchar2(20),
	alarm varchar2(100)
);


		
drop table request;

CREATE TABLE REQUEST (
	AUCTIONNO NUMBER NOT NULL, /* AUCTIONNO */
	SELLERID VARCHAR2(20), /* SELLERID */
	STUFFNAME VARCHAR2(50), /* STUFFNAME */
	MINPRICE NUMBER, /* MINPRICE */
	CHAT VARCHAR2(4), /* CHAT */
	UPPRICE NUMBER, /* UPPRICE */
	EXPLAIN VARCHAR2(100), /* EXPLAIN */
	TIMESTART DATE, /* TIMESTART */
	TIMEEND DATE, /* TIMEEND */
	STUFFKIND VARCHAR2(20), /* STUFFKIND */
	GRADE VARCHAR2(20),
	SUCCESS VARCHAR2(10), /* SUCCESS */
	PRICE NUMBER /* PRICE */
);

CREATE UNIQUE INDEX REQUEST_NO_PK
   ON REQUEST (
      AUCTIONNO ASC
   );

ALTER TABLE REQUEST
   ADD
      CONSTRAINT REQUEST_NO_PK
      PRIMARY KEY (
         AUCTIONNO
      );

ALTER TABLE REQUEST
   ADD
      CONSTRAINT SYS_C007168
      CHECK (chat in ('y','n'));

drop sequence request_seq;
create sequence request_seq
		start with 1
		increment by 1
		nocycle
		nocache;

insert into alarm values ('gildong','알람입니다');

insert into request values (request_seq.nextval, 'qwer', '가을색', 30000,'y',25000, '이 그림은 아름다운 가을색작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'suwon', '청명하고아름다운기운', 550000,'n',250000, '이 그림은 아름다운 청명하고아름다운기운작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'jamsil', '밝혀지지않은신비', 22000,'n',250000, '이 그림은 아름다운 밝혀지지않은신비작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'gosok', '마우스인셉션', 160000,'y',25000, '이 그림은 아름다운 마우스인셉션작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '인물화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'sokcho', '아메리카노', 180000,'n',25000, '이 그림은 아름다운아메리카노작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'daegu', '장이안좋아보이는노파', 120000,'y',25000, '이 그림은 아름다운 장이안좋아보이는노파작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'sumi', '인생사', 1000,'y',25000, '이 그림은 아름다운 인생사작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'kimgi', '아무도찾아오지않는밤', 10000,'y',250000, '이 그림은 아름다운 아무도찾아오지않는밤작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'cola', '아침햇살', 12000,'y',25000, '이 그림은 아름다운 아침햇살작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '인물화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'cider', '가을공기', 3000,'y',25000, '이 그림은 아름다운 가을공기작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'red', '저녁노을', 441000,'y',250000, '이 그림은 아름다운 저녁노을작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '인물화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'blue', '텁텁한맛', 5100000,'y',2500000, '이 그림은 아름다운 텁텁한맛작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'dkqmfk', '이목구비', 610000,'y',2500000, '이 그림은 아름다운 이목구비작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'mouse', '가을하늘아래', 71000,'y',2500, '이 그림은 아름다운 가을하늘아래작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'black', '여름바닷가', 81000,'y',25000, '이 그림은 아름다운 여름바닷가작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'blue', '파란하늘위에는', 1000,'y',25000, '이 그림은 아름다운 파란하늘위에는작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'green', '비행기', 2000,'y',2580000, '이 그림은 아름다운 비행기작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'awesome', '제주도돼지', 10000,'y',285000, '이 그림은 아름다운 제주도돼지작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'super', '꽃돼지는무엇일까', 10000,'y',2850000, '이 그림은 아름다운 꽃돼지는무엇일까작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '인물화','3','0'  , 0 );
insert into request values (request_seq.nextval, 'lips', '밀리는어디에', 100000,'y',2800, '이 그림은 아름다운 밀리는어디에작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '풍경화', '1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'nose', '그곳으로가요', 1000,'y',28000, '이 그림은 아름다운 그곳으로가요작품입니다', to_date(to_char(sysdate + (1/24/60*300), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '', '역사화','1' ,'0'  , 0 );

insert into request values (request_seq.nextval, 'movie', '떠나가려는자',1500,'y',25000, '이 그림은 아름다운 떠나가려는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'theater', '떠나는걸막으려는자',10000,'y',25000, '이 그림은 아름다운 떠나는걸막으려는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'tough', '떠나지못하는자',15600,'y',25000, '이 그림은 아름다운 떠나지못하는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '풍경화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'hard', '떠나고싶은자',5000,'y',750000, '이 그림은 아름다운 떠나고싶은자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '종교화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'harsh', '떠나는사람을방관하는자',8000,'y',950000, '이 그림은 아름다운 떠나는사람을방관하는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'spector', '떠나면서빵을먹는자',550000,'y',2200, '이 그림은 아름다운 떠나면서빵을먹는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'flower', '보내려는자',8000000,'y',25000000, '이 그림은 아름다운 보내려는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'love', '보내는걸지켜보는자',100000,'y',850000, '이 그림은 아름다운 보내는걸지켜보는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'play', '보내는어머니를바라보는손자',100000,'y',750000, '이 그림은 아름다운 보내는어머니를바라보는손자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '종교화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'data', '보내려는자',100000,'y',65050000, '이 그림은 아름다운 보내려는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'imitation', '보내려고하는자',100000,'y',55250000, '이 그림은 아름다운 보내려고하는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '풍경화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'collaborate', '보내고싶지않은자',100000,'y',8000, '이 그림은 아름다운 보내고싶지않은자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'image', '보내봤던자',100000,'y',4000, '이 그림은 아름다운 보내봤던자자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'special', '보내야하는자',100000,'y',33000, '이 그림은 아름다운 보내야하는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '풍경화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'dream', '보내고후회하는자',100000,'y',22250000, '이 그림은 아름다운 보내고후회하는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'comic', '보고싶은자',100000,'y',2000, '이 그림은 아름다운 보고싶은자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'bookshelf', '벌써보고싶은자',100000,'y',28000, '이 그림은 아름다운 벌써보고싶은자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '종교화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'flylife', '보고싶지않은자',100000,'y',2500000, '이 그림은 아름다운 보고싶지않은자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'underneath', '이별을마주하는자',100000,'y',1000, '이 그림은 아름다운 이별을마주하는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '종교화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'skypass', '이별을마주하지않는자',100000,'y',15000, '이 그림은 아름다운 이별을마주하지않는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),to_date(to_char(sysdate + (1/24/60*6), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '풍경화','2' ,'0'  , 0 );

insert into request values (request_seq.nextval, 'limm', '스티브잡스',15000,'y',20000, '이 그림은 아름다운 스티브잡스작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'gildong','유아인',50000,'y',7500, '이 그림은 아름다운 유아인작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'lime', '지드래곤',10000,'y',2300000, '이 그림은 아름다운 지드래곤작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '인물화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'asdf', '나폴레옹',10000,'y',250000, '이 그림은 아름다운 나폴레옹작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'asdf', '떠나려는자',10000,'y',25000, '이 그림은 아름다운 떠나려는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'qwer', '막아서는자',10000,'y',250000, '이 그림은 아름다운 막아서는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'wons', '추위를모르는자',1000,'y',250000, '이 그림은 아름다운 추위를모르는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'wons', '피흘리는자',1000,'y',2000, '이 그림은 아름다운 피흘리는자작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '역사화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'gilgil', '강아지를품은소녀',300000,'y',6000, '이 그림은 아름다운 작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'juwon','꽃잎',250000,'n',300000, '이 그림은 아름다운 작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','1' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'juwon','말타기',33000,'y',550000, '이 그림은 아름다운 작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'limm','물속에서',100000,'y',950000, '이 그림은 아름다운 작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'limm','반고흐',100000,'y',650000, '이 그림은 아름다운 작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'lime', '조커',30000,'y',450000, '이 그림은 아름다운 작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'), '유화','3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'wons', '눈온뒤어두운날',10000,'y',25000, '이 그림은 아름다운 눈온뒤어두운날작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss')
, '풍경화', '2' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'gilgil', '비오는다리',6000,'y',9900, '이 그림은 아름다운 비오는다리작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss')
, '풍경화', '3' ,'0'  , 0 );
insert into request values (request_seq.nextval, 'gilgil', '어느바닷가',3000,'y',6000, '이 그림은 아름다운 어느바닷가작품입니다', to_date(to_char(sysdate + (1/24/60*3), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss'),
to_date(to_char(sysdate + (1/24/60*600), 'yyyy/mm/dd hh24:mi:"00"'),'yyyy/mm/dd hh24:mi:ss')
, '풍경화', '2' ,'0'  , 0 );
